package com.ycz.springcloud;/*
 @author ycz
 @date 2021-08-14-20:31  
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient //在服务启动后自动注册到Eureka中
@EnableDiscoveryClient
public class SpringCloudMain_8002 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMain_8002.class,args);
    }
}
