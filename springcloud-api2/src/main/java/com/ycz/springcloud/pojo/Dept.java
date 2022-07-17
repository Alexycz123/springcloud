package com.ycz.springcloud.pojo;/*
 @author ycz
 @date 2021-08-15-18:45  
*/


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    private String db_source;

    public Dept(String dname){
        this.dname=dname;
    }

}
