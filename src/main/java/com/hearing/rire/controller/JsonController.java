package com.hearing.rire.controller;

import com.hearing.rire.bean.Product;
import com.hearing.rire.bean.User;
import com.hearing.rire.service.ProductServices;
import com.hearing.rire.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Create by hearing on 19-4-12
 */
@RestController
public class JsonController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private ProductServices productServices;


    @GetMapping("/current_user")
    public User getUser() {
        return userServices.getCurrentUser();
    }

    @GetMapping("/my_goods")
    public List<Product> getMyGoods(Integer id) {
        return productServices.getMyGoods(id, true);
    }
}
