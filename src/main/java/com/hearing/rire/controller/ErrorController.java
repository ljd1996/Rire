package com.hearing.rire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by hearing on 19-4-14
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping(value = "/404")
    public String error_404() {
        return "error-404";
    }

    @GetMapping(value = "/500")
    public String error_500() {
        return "error-500";
    }
}
