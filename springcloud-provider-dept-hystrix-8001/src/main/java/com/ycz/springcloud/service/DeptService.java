package com.ycz.springcloud.service;/*
 @author ycz
 @date 2021-08-14-20:05  
*/

import com.ycz.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    public boolean add(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> list();
}
