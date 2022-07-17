package com.ycz.myrule;/*
 @author ycz
 @date 2021-08-16-20:32  
*/

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class yczRule extends AbstractLoadBalancerRule {

    //每个服务，被调用五次之和，就下一个服务

    private  int total=0;//被调用的次数
    private int currentIndex=0;//当前是谁在服务
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers(); //获得活着的服务
            List<Server> allList = lb.getAllServers();//获得全部服务

            int serverCount = allList.size();
            if (serverCount == 0) {

                return null;
            }

//            int index = chooseRandomInt(serverCount); // 生成区间的随机数
//            server = upList.get(index); // 从活着的服务，随机获取一个

            if (total<5){ //如果次数小于五
                server=upList.get(currentIndex); //就调用同一个服务
                total++;
            }else {//
                total=0;//重新变为0
                currentIndex++;
                if (currentIndex>=upList.size()){
                    currentIndex=0;
                }
                server= upList.get(currentIndex);//变0后继续调用
            }
            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }


}
