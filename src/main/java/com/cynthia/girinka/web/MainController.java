package com.cynthia.girinka.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login") //just calls login
    public String login() {
        return "login";
    }
    @GetMapping("/") //just calls index
    public String home() {
        return "homePage";
    }
}
