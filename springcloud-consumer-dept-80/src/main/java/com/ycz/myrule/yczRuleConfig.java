package com.ycz.myrule;/*
 @author ycz
 @date 2021-08-16-20:43  
*/

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class yczRuleConfig {
    @Bean
    public IRule myYczRule(){
        return new yczRule();//自己配置的
    }
}
