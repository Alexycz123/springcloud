package com.ycz.springcloud.service.impl;/*
 @author ycz
 @date 2021-08-14-20:06  
*/

import com.ycz.springcloud.pojo.Dept;
import com.ycz.springcloud.mapper.DeptMapper;
import com.ycz.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public boolean add(Dept dept) {
        return deptMapper.add(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptMapper.queryById(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
}
