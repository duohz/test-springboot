package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc
 * @Author zhoud
 * @Date 2021/7/31 22:03
 **/
@RestController
@RequestMapping("main")
public class MainController {

    @GetMapping("/login")
    @ResponseBody
    public String login() {
        return "login in!";
    }
}
