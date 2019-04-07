package com.wp.service.impl;

import com.wp.service.Service;

/**
 * @description:
 * @author: wangping
 * @create: 2019-04-07 11:15
 **/
@org.springframework.stereotype.Service("2Service")
public class ServiceImpl2 implements Service {

    @Override
    public void add(Long  o) {
        System.out.println("ServiceImpl2 add method");
    }

    @Override
    public void del() {
        System.out.println("ServiceImpl2 del method");

    }

    @Override
    public void upd() {
        System.out.println("ServiceImpl2 upd method");
    }
}
