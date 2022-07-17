package com.ycz.springcloud.controller;/*
 @author ycz
 @date 2021-08-14-20:50  
*/


import com.ycz.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    @Autowired
    private RestTemplate restTemplate;

//    private static final String REST_URL="http://localhost:8001";
    //Ribbon 我们这里地址是一个变量，通过服务名访问
    private static final String REST_URL="http://SPRINGCLOUD-PROVIDER-DEPT";
    /**
     * URI url, Class<T> responseType
     * @return
     */
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL+"/dept/list",List.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL+"/dept/add",dept,boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept getDeptById(@PathVariable("id")Long id){
        return restTemplate.getForObject(REST_URL+"/dept/get/"+id,Dept.class);
    }

}
