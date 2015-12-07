package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class RootController {

    @RequestMapping("/")
    public ModelAndView root() {
        return new ModelAndView("root", "messages", "test");
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login", "messages", "test");
    }
}
