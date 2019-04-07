package com.wp;

import com.wp.service.Service;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: wangping
 * @create: 2019-04-05 13:17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class Test {

    @Qualifier("1Service")
    @Autowired
    private Service service;

    @Qualifier("2Service")
    @Autowired
    private Service service2;

    @org.junit.Test
    public void test() {
        service.add(12L);
        System.out.println("\n");
        service2.del();
    }
}
