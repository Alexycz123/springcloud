package com.ycz.springcloud.mapper;/*
 @author ycz
 @date 2021-08-14-20:05  
*/

import com.ycz.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    public boolean add(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> list();

}
