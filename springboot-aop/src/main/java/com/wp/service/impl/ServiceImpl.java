package com.wp.service.impl;

import com.wp.Annotation;
import com.wp.service.Service;

/**
 * @description: 业务实现类
 * @author: wangping
 * @create: 2019-04-05 13:27
 **/
@org.springframework.stereotype.Service("1Service")
public class ServiceImpl implements Service {

    @Annotation("annotation注解")
    @Override
    public void add(Long o) {
        System.out.println("ServiceImpl add method");
    }

    @Override
    public void del() {
        System.out.println("ServiceImpl del method");

    }

    @Override
    public void upd() {
        System.out.println("ServiceImpl upd method");

    }
}
