package com.wp;

import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @description: 测试类
 * @author: wangping
 * @create: 2019-03-28 14:41
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class TestJpa {

    @Autowired
    private AccountDAO accountDAO;

    /*@Before
    public void before() {
        log.info("=================开始添加=====================");
        Account account = new Account("zhangsan", 100.10);
        Account account2 = new Account("lisi", 1000.00);
        Account account3 = new Account("wangwu", 88.88);
        accountDAO.save(account);
        accountDAO.save(account2);
        accountDAO.save(account3);
    }*/

    @Test
    public void test() {
        log.info("=================分页查询=====================");
        Pageable pageable = new PageRequest(0, 2);
        Page<Account> all = accountDAO.findAll(pageable);
        Object o = JSON.toJSON(all);
        log.info(o);

        log.info("=================排序查询=====================");
        Sort sort = new Sort(Sort.Direction.DESC,"money");
        List<Account> accounts = accountDAO.findAll(sort);
        log.info(accounts);
    }
}
