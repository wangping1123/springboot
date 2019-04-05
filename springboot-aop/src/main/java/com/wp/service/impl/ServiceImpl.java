package com.wp.service.impl;

import com.wp.Annotation;
import com.wp.service.Service;

/**
 * @description: 业务实现类
 * @author: wangping
 * @create: 2019-04-05 13:27
 **/
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Annotation("annotation注解")
    @Override
    public void add() {
        System.out.println("调用add方法");
    }

    @Override
    public void del() {
        System.out.println("调用del方法");

    }

    @Override
    public void upd() {
        System.out.println("调用upd方法");

    }
}
