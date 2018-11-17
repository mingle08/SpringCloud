package com.sxt.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sxt.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {

            @Override
            public boolean add(Dept dept) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public Dept get(Long id) {
                Dept dept = new Dept();
                dept.setDeptno(id);
                dept.setDname("This ID does not have data, hystrix service provided by consumer");
                dept.setDb_source("no this data in MySQL");
                
                return dept;
            }

            @Override
            public List<Dept> list() {
                // TODO Auto-generated method stub
                return null;
            }
            
        };
    }

}
