package com.chileroomie.chileroomieapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controladores {

    @GetMapping("/")
    public String getMethodName() {
        return "index.jsp";
    }
}
