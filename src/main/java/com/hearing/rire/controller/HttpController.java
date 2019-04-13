package com.hearing.rire.controller;

import com.hearing.rire.bean.Product;
import com.hearing.rire.bean.User;
import com.hearing.rire.service.ProductServices;
import com.hearing.rire.service.UserServices;
import com.hearing.rire.util.Constant;
import com.hearing.rire.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
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
                map.put("product", productServices.getMyGoods(userServices.getCurrentUser().getId()));
                break;
            case Constant.TYPE_MY_Demand:
                map.put("product", productServices.getMyDemand(userServices.getCurrentUser().getId()));
                break;
            default:
                map.put("product", type==0?productServices.getGoodsByType(proType):productServices.getDemandByType(proType));
                break;
        }
        return "product";
    }

    @GetMapping("/product-details")
    public String productDetails() {
        return "product-details";
    }

    @PostMapping("/register")
    public String register(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userServices.register(user);
        return "index";
    }

    @GetMapping("/release")
    public String release() {
        return "release";
    }

    @PostMapping("/releaseAction")
    public String uploadArticle(Product product,
                                @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            String name = file.getOriginalFilename();
            String preffix = name.substring(0, name.lastIndexOf("."));
            String subffix = name.substring(name.lastIndexOf("."), name.length());
            long time = new Date().getTime();
            String fileName = preffix + new SimpleDateFormat("yyyyMMddHHmmss").format(time) + subffix;
            String filepath = Utils.getResPath();

            File f = new File(filepath);
            if (!f.exists()) {
                f.mkdirs();
            }
            f = new File(filepath + fileName);
            f.createNewFile();
            file.transferTo(f);

            product.setImage(filepath + fileName);
            product.setTime(time);
            product.setUserId(userServices.getCurrentUser().getId());

            productServices.addProduct(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
