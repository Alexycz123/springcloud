package com.ycz.springcloud.config;/*
 @author ycz
 @date 2021-08-14-20:51  
*/

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //配置负载均衡实现RestTemplate
    //IRule
    // RoundRobinRule 轮询 默认
    // RandomRule 随机
    // AvailAbilityFilteringRule ： 会先过滤掉，跳闸，访问故障的服务，对剩下的进行轮询
    // RetryRule ： 会先按照轮询获得服务，如果服务获取失败，则会在指定的时间内进行，重试

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
