package com.wp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 数据访问层，通过编写一个继承自 JpaRepository 的接口就能完成数据访问,其中包含了几本的单表查询的方法，
 * 非常的方便。值得注意的是，这个Account 对象名，而不是具体的表名，另外Interger是主键的类型，
 * 一般为Integer或者Long
 *
 *
 * @description: 账户DAO层
 * @author: wangping
 * @create: 2019-03-28 14:13
 **/
@Repository
public interface AccountDAO extends JpaRepository<Account,Long> {
}
