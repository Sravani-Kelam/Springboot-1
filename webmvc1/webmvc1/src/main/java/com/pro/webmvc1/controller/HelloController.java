package com.pro.webmvc1.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HelloController {
    @RequestMapping( "/index")
    String getIndexPage(Model model){
        String message="Welcome to Spring Boot!";
        System.out.println("test case 123");
        return "index";
    }
    String getAdminPage(){
        return "Admin";
    }
    String getUserPage(){
        return "User";
    }
}
