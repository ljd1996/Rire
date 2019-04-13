package com.hearing.rire.controller;

import com.hearing.rire.bean.User;
import com.hearing.rire.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * Create by hearing on 19-4-12
 */
@RestController
public class JsonController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/current_user")
    public User getUser() {
        return userServices.getCurrentUser();
    }

}
