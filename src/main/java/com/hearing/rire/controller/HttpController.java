package com.hearing.rire.controller;

import com.hearing.rire.bean.User;
import com.hearing.rire.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Create by hearing on 19-4-8
 */
@Controller
public class HttpController {

    @Autowired
    private UserServices userServices;

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

    @GetMapping("/product1")
    public String product1() {
        return "product1";
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
}
