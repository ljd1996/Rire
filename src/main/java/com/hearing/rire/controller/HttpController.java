package com.hearing.rire.controller;

import com.hearing.rire.bean.Order;
import com.hearing.rire.bean.Product;
import com.hearing.rire.bean.User;
import com.hearing.rire.service.BidListServices;
import com.hearing.rire.service.OrderServices;
import com.hearing.rire.service.ProductServices;
import com.hearing.rire.service.UserServices;
import com.hearing.rire.util.Constant;
import com.hearing.rire.util.Msg;
import com.hearing.rire.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Create by hearing on 19-4-8
 */
@Controller
public class HttpController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private ProductServices productServices;

    @Autowired
    private BidListServices bidListServices;

    @Autowired
    private OrderServices orderServices;


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/myself")
    public String myself(Map<String, User> map) {
        map.put("user", userServices.getCurrentUser());
        return "myself";
    }

    @GetMapping("/product")
    public String product(Map<String, Object> map,
                          @RequestParam("type") Integer type, @RequestParam("proType") String proType) {
        switch (proType) {
            case Constant.TYPE_GOODS:
                map.put("product", productServices.getAllGoods());
                break;
            case Constant.TYPE_DEMAND:
                map.put("product", productServices.getAllDemand());
                break;
            case Constant.TYPE_MY_GOODS:
                map.put("product", productServices.getMyGoods(userServices.getCurrentUser().getId(), false));
                break;
            case Constant.TYPE_MY_Demand:
                map.put("product", productServices.getMyDemand(userServices.getCurrentUser().getId(), false));
                break;
            default:
                map.put("product", type == 0 ? productServices.getGoodsByType(proType) : productServices.getDemandByType(proType));
                break;
        }
        // 用来标识处于哪一页面
        map.put("type", proType + type);
        return "product";
    }

    @GetMapping("/product_details")
    public String productDetails(Map<String, Object> map, @RequestParam("productId") Integer productId) {
        Product product = productServices.getProduct(productId);
        map.put("product", product);
        map.put("time", new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(product.getTime()));
        User user = userServices.getCurrentUser();
        boolean owner = false;
        if (user != null) {
            if (user.getId().equals(product.getUserId())) {
                owner = true;
            } else {
                map.put("myGoods", productServices.getMyGoods(user.getId(), true));
            }
        }
        map.put("owner", owner);
        map.put("user", userServices.getUserById(product.getUserId()).getName());
        map.put("bidProducts", bidListServices.getBidProductByMainId(productId));
        return "product_details";
    }

    @GetMapping("/delete_product")
    public void deleteProduct(HttpServletResponse response, @RequestParam("id") Integer id) {
        Product product = productServices.getProduct(id);
        productServices.deleteProduct(id);
        try {
            response.sendRedirect("product?type=" + product.getType() + "&proType=" +
                    (product.getType() == Constant.PRO_TYPE_GOODS ? Constant.TYPE_MY_GOODS : Constant.TYPE_MY_Demand));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/updateUser")
    public void updateUser(HttpServletResponse response, Map<String, String> map, User user) {
        if (user.getPassword().isEmpty()) {
            user.setPassword(userServices.getCurrentUser().getPassword());
        } else {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }
        userServices.update(user);
        SecurityContextHolder.getContext().setAuthentication(null);
        try {
            response.sendRedirect("myself");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/register")
    public String register(Map<String, String> map, User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        boolean success = false;
        try {
            if (userServices.register(user).getCode() == Msg.CODE_SUCCESS) {
                success = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!success) {
            map.put("msg", "该账户或手机号已被注册！");
            return "register";
        } else {
            map.put("msg", "注册成功，请登录!");
            return "login";
        }
    }

    @GetMapping("/register_page")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/release")
    public String release(Map<String, Product> map, @RequestParam("productId") Integer productId) {
        if (productId != -1) {
            map.put("product", productServices.getProduct(productId));
        }
        return "release";
    }

    @PostMapping("/releaseAction")
    public void uploadArticle(HttpServletResponse response, Product product,
                              @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            String filePath = Utils.getImgPath(file);
            if (filePath != null) {
                product.setImage(filePath);
            }

            product.setStatus(Constant.PRO_STATUS_ON);
            product.setTime(new Date().getTime());
            product.setUserId(userServices.getCurrentUser().getId());

            Msg msg = productServices.addProduct(product);
            response.sendRedirect("product_details?productId=" + msg.getExtend().get("productId"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/updateProduct")
    public void updateProduct(HttpServletResponse response, Product product,
                              @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            String filePath = Utils.getImgPath(file);
            if (filePath != null) {
                product.setImage(filePath);
            }

            product.setStatus(Constant.PRO_STATUS_ON);
            product.setTime(new Date().getTime());
            product.setUserId(userServices.getCurrentUser().getId());

            productServices.updateProduct(product);

            response.sendRedirect("product_details?productId=" + product.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/upload_contract")
    public void uploadContract(HttpServletResponse response, Map<String, String> map,
                               @RequestParam("productId") Integer productId,
                               @RequestParam("contract") MultipartFile contract) {
        try {
            String filePath = Utils.getImgPath(contract);
            if (filePath != null) {
                Product product = productServices.getProduct(productId);

                Order order = new Order();
                order.setLocation(filePath);
                order.setOrderTime(new Date().getTime());
                order.setPayTime(0L);
                order.setFinishTime(0L);
                order.setStatus(Constant.ORDER_STATUS_CONTRACT_NOT_CONFIRM);
                order.setProSupplierId(productId);
                order.setUserSupplierId(product.getUserId());
                order.setUserBuyerId(userServices.getCurrentUser().getId());

                Msg msg = orderServices.addOrder(order);

                product.setStatus(Constant.PRO_STATUS_LOCKED);
                productServices.updateProductStatus(productId, Constant.PRO_STATUS_LOCKED);

                response.sendRedirect("order_details?orderId=" + msg.getExtend().get("orderId"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/my_order")
    public String myOrder(Map<String, Object> map) {
        List<Order> orders = orderServices.getMyOrder(userServices.getCurrentUser().getId());
        map.put("orders", orders);
        map.put("products", orderServices.getProductsByOrders(orders));
        map.put("user", userServices.getCurrentUser());
        return "order";
    }

    @GetMapping("/order_details")
    public String orderDetails(Map<String, Object> map, @RequestParam("orderId") Integer orderId) {
        Order order = orderServices.getOrder(orderId);
        map.put("order", order);
        map.put("product", productServices.getProduct(order.getProSupplierId()));
        map.put("supplyUser", userServices.getUserById(order.getUserSupplierId()));
        map.put("buyUser", userServices.getUserById(order.getUserBuyerId()));
        map.put("user", userServices.getCurrentUser());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
        map.put("orderTime", format.format(order.getOrderTime()));
        map.put("payTime", order.getPayTime() == 0 ? "0" : format.format(order.getPayTime()));
        map.put("finishTime", order.getFinishTime() == 0 ? "0" : format.format(order.getFinishTime()));
        return "order_details";
    }

    @GetMapping("/delete_order")
    public void deleteOrder(HttpServletResponse response, @RequestParam("id") Integer id) {
        orderServices.deleteOrder(id);
        try {
            response.sendRedirect("my_order");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/my_contract")
    public String myContract(Map<String, Object> map) {
        List<Order> orders = orderServices.getMyOrder(userServices.getCurrentUser().getId());
        map.put("orders", orders);
        map.put("products", orderServices.getProductsByOrders(orders));
        map.put("user", userServices.getCurrentUser());
        return "my_contract";
    }
}
