package com.logistics_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.logistics_management.dao")
public class LogisticsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticsManagementApplication.class, args);
    }

}
