package com.example.demo.mapper;

import com.example.demo.entity.CommonLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Desc
 * @Author zhoud
 * @Date 2021/8/4 20:26
 **/
@Mapper
public interface CommonLogMapper {
    void saveCommonLog(CommonLog commonLog);
}
