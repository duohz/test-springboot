package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Desc 通用日志
 * @Author zhoud
 * @Date 2021/8/4 20:27
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonLog {
    private int logId;
    private String userName;
    private String userId;
    private String operation;
    private String result;
    private Date createdDate;
}
