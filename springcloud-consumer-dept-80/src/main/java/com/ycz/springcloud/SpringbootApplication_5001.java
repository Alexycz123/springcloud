package com.ycz.springcloud;/*
 @author ycz
 @date 2021-08-14-20:56  
*/

import com.ycz.myrule.yczRule;
import com.ycz.myrule.yczRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

// Ribbon 和 Eureka 整合之和，客户端可直接调用，不用关心Ip地址和端口号
@SpringBootApplication
@EnableEurekaClient //
@RibbonClient(name="SPRINGCLOUD-PROVIDER-DEPT",configuration = yczRuleConfig.class)
public class SpringbootApplication_5001 {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication_5001.class,args);
    }
}
