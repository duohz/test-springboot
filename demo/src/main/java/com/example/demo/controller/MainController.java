package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.CommonLog;
import com.example.demo.exam.SpringRollBack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc
 * @Author zhoud
 * @Date 2021/7/31 22:03
 **/
@Slf4j
@RestController
@RequestMapping("main")
public class MainController {

    private static ConcurrentHashMap<String, Integer> hanldeMap = new ConcurrentHashMap<>(2);

    private static final String KEY_1 = "key_1";
    private static final String KEY_2 = "key_2";

    private static final int FACTOR = 2;

    static {
        hanldeMap.put(KEY_1, 0);
        hanldeMap.put(KEY_2, 0);
    }

    @Autowired
    private SpringRollBack springRollBack;

    @GetMapping("/login")
    @ResponseBody
    public String login(@RequestParam String userId, @RequestParam String userName) throws Exception {
        CommonLog commonLog = CommonLog.builder().userId(userId).userName(userName).build();
        springRollBack.testA(commonLog);
        return "login in!";
    }

    @GetMapping("/queryLog")
    @ResponseBody
    public String queryLog() {
        List<CommonLog> commonLogList = springRollBack.queryLogs();
        return JSON.toJSONString(commonLogList);
    }

    @GetMapping("/loginWithLimit")
    @ResponseBody
    @Transactional(rollbackOn = Throwable.class)
    public String loginWithLimit(@RequestParam String userId, @RequestParam String userName) throws Exception {
        log.info("请求访问的id:" + userId);

        if (Integer.valueOf(userId) % FACTOR != 0) {
            throw new Exception("非目标id，禁止访问！");
        }

        Integer handleCount = hanldeMap.get(KEY_1);

        if (handleCount > 100) {
            throw new Exception("超出访问限制！");
//            return "超出访问限制！";
        }

        log.info("接受访问的id:" + userId);

        hanldeMap.put(KEY_1, ++handleCount);

        CommonLog commonLog = CommonLog.builder().userId(userId).userName(userName).build();
        springRollBack.saveCommonLog(commonLog);

        hanldeMap.put(KEY_1, --handleCount);
        return "login in with limit!";
    }

    @GetMapping("/loginwithOutLimit")
    @ResponseBody
    @Transactional(rollbackOn = Throwable.class)
    public String loginWithOutLimit(@RequestParam String userId, @RequestParam String userName) {
        CommonLog commonLog = CommonLog.builder().userId(userId).userName(userName).build();
        springRollBack.saveCommonLog(commonLog);
        return "login in with out limit!";
    }
}
