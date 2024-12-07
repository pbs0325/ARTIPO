package com.artipo.artipo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home/home")
    public String home() {
        return "home";
    }
}
