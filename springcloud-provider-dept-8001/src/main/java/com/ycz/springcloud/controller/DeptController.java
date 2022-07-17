package com.ycz.springcloud.controller;/*
 @author ycz
 @date 2021-08-14-20:24  
*/

import com.ycz.springcloud.pojo.Dept;
import com.ycz.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/dept/add")
    public boolean add(Dept dept){

        return deptService.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept getDeptById(@PathVariable("id")Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> getList(){
        return deptService.list();
    }

    /**
     * 注册进来的信息 获取一些信息
     * @return
     */
    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> services=client.getServices();
        System.out.println("discovery=>services"+services);
        List<ServiceInstance> instances=client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"/t"
                    +instance.getPort()+"/t" +
                            instance.getUri()+"/t"+
                            instance.getServiceId()+"/t"

            );
        }
        return this.client;

    }



}
