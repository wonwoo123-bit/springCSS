package com.spring.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/common")
public class CommonController {
    @GetMapping("loginForm")
    public void getMethodName() {}
    

}
