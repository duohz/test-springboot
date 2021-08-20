package com.example.demo.service;

import com.example.demo.entity.CommonLog;
import com.example.demo.mapper.CommonLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc
 * @Author zhoud
 * @Date 2021/8/4 20:25
 **/
@Service
public class CommonLogService {
    @Autowired
    private CommonLogMapper commonLogMapper;

    public void saveCommonLog(CommonLog commonLog) {
        commonLogMapper.saveCommonLog(commonLog);
    }

    public List<CommonLog> queryAll() {
        return commonLogMapper.queryAll();
    }
}
