package com.ycz.springcloud;/*
 @author ycz
 @date 2021-08-17-19:24  
*/


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;



@SpringBootApplication
@EnableHystrixDashboard //开启监控
public class DashBoard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashBoard_9001.class,args);
    }
}
