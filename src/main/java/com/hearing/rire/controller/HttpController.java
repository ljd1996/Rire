package com.hearing.rire.controller;

import com.hearing.rire.bean.BidList;
import com.hearing.rire.bean.Order;
import com.hearing.rire.bean.Product;
import com.hearing.rire.bean.User;
import com.hearing.rire.service.BidListServices;
import com.hearing.rire.service.OrderServices;
import com.hearing.rire.service.ProductServices;
import com.hearing.rire.service.UserServices;
import com.hearing.rire.util.Constant;
import com.hearing.rire.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    public String product(Map<String, List<Product>> map,
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
    public String deleteProduct(@RequestParam("id") Integer id) {
        productServices.deleteProduct(id);
        return "index";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user) {
        if (user.getPassword().isEmpty()) {
            user.setPassword(userServices.getCurrentUser().getPassword());
        } else {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }
        userServices.update(user);
        SecurityContextHolder.getContext().setAuthentication(null);
        return "index";
    }

    @PostMapping("/register")
    public String register(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userServices.register(user);
        return "index";
    }

    @GetMapping("/release")
    public String release(Map<String, Product> map, @RequestParam("productId") Integer productId) {
        if (productId != -1) {
            map.put("product", productServices.getProduct(productId));
        }
        return "release";
    }

    @PostMapping("/releaseAction")
    public String uploadArticle(Product product,
                                @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            String filePath = Utils.getImgPath(file);
            if (filePath != null) {
                product.setImage(filePath);
            }

            product.setStatus(Constant.PRO_STATUS_ON);
            product.setTime(new Date().getTime());
            product.setUserId(userServices.getCurrentUser().getId());

            productServices.addProduct(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(Product product,
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @PostMapping("/upload_contract")
    public String uploadContract(@RequestParam("productId") Integer productId,
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

                orderServices.addOrder(order);

                product.setStatus(Constant.PRO_STATUS_LOCKED);
                productServices.updateProductStatus(productId, Constant.PRO_STATUS_LOCKED);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
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
}
