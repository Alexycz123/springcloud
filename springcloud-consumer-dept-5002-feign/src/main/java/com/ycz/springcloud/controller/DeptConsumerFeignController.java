package com.ycz.springcloud.controller;/*
 @author ycz
 @date 2021-08-14-20:50  
*/


import com.ycz.springcloud.pojo.Dept;
import com.ycz.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerFeignController {

    @Autowired
    private DeptClientService service=null;

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return this.service.list();
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return this.service.add(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept getDeptById(@PathVariable("id")Long id){
        return this.service.queryById(id);
    }

}
