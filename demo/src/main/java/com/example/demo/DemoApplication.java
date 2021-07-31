package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//  @SpringBootApplication集成@component默认只扫描启动类所在的包，需要扫描其他包时，要单独配置，使用scanBasePackages = {"com.example.demo", "utils"}
@SpringBootApplication(scanBasePackages = {"com.example.demo", "utils"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
