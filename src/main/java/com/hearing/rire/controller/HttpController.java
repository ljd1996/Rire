package com.hearing.rire.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by hearing on 19-4-8
 */
@RestController
public class HttpController {

    @GetMapping("/")
    public String index() {
        return "rire";
    }
}
