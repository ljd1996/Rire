package com.hearing.rire.controller;

import com.hearing.rire.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Create by hearing on 19-4-12
 */
@RestController
public class JsonController {

    @GetMapping("/current_user")
    public User getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal instanceof UserDetails ? (User) principal : null;
    }
}
