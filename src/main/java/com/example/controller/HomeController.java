package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/thymeleaf")
    public String thymeleaf(){
        return "thymeleaf";
    }
}
