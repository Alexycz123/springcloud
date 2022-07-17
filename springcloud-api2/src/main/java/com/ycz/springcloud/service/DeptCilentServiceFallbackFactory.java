package com.ycz.springcloud.service;/*
 @author ycz
 @date 2021-08-17-18:09  
*/

import com.ycz.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
//降级
@Component
public class DeptCilentServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id).
                        setDname("id=>"+id+"没有对应的信息，客户端提供了降级的服务，这个服务器已经关闭").
                        setDb_source("没有数据");
            }

            @Override
            public List<Dept> list() {
               return null;
            }
        };
    }
}
