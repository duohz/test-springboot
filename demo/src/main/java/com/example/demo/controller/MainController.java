package com.example.demo.controller;

import com.example.demo.entity.CommonLog;
import com.example.demo.exam.SpringRollBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

/**
 * @Desc
 * @Author zhoud
 * @Date 2021/7/31 22:03
 **/
@RestController
@RequestMapping("main")
public class MainController {

    @Autowired
    private SpringRollBack springRollBack;

    @GetMapping("/login")
    @ResponseBody
    @Transactional(rollbackOn = Throwable.class)
    public String login(@RequestParam String userId, @RequestParam String userName) throws Exception {
        CommonLog commonLog = CommonLog.builder().userId(userId).userName(userName).build();
        springRollBack.testA(commonLog);
        return "login in!";
    }
}
