package com.ycz.springcloud;/*
 @author ycz
 @date 2021-08-18-15:13  
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启网关代理
public class ZuulMain_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulMain_9527.class,args);
    }

}
