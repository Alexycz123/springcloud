package com.ycz.springcloud;/*
 @author ycz
 @date 2021-08-14-20:56  
*/


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

// Ribbon 和 Eureka 整合之和，客户端可直接调用，不用关心Ip地址和端口号
@SpringBootApplication
@EnableEurekaClient //
@ComponentScan("com.ycz.springcloud")
@EnableFeignClients(basePackages = {"com.ycz.springcloud"})
public class SpringbootApplication_5002 {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication_5002.class,args);
    }
}
