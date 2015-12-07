package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class RootController {

    @RequestMapping("/")
    public String root(Map<String, Object> model) {
        return "root";
    }

    @RequestMapping("/login")
    public String login(Map<String, Object> model) {
        return "login";
    }
}
