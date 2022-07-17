package com.ycz.springcloud;/*
 @author ycz
 @date 2021-08-14-20:31  
*/

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient //在服务启动后自动注册到Eureka中
@EnableDiscoveryClient
@EnableCircuitBreaker //添加熔断的服务
public class SpringCloudMain_Feign_8001 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMain_Feign_8001.class,args);
    }
    //添加了一个servlet
    @Bean
    public ServletRegistrationBean hystrixServletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        //地址在http://localhost:9001/hystrix找
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        return servletRegistrationBean;
    }
}
