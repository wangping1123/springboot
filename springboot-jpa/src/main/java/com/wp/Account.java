package com.wp;

import lombok.Data;

import javax.persistence.*;

/**
 * @Entity 是一个必选的注解，表明是一个映射的实体类
 * @Table 是可选的注释，声明数据库表的表信息、表名、索引信息等。如果没有指定表名则和实体类名一致
 *
 * @description: 账户实体类，对应表由jpa自动创建
 * @author: wangping
 * @create: 2019-03-28 14:08
 **/
@Entity
@Data
@Table(name = "t_account")
public class Account {

    /**
     * @id 唯一表识
     * @GeneratedValue 值自动生成
     * @Column 默认的实体每个属性都对应了表的一个字段。字段的名称默认和属性名称保持一致（并不一定相等）。
     *         字段的类型根据实体属性类型自动推断。这里主要是声明了字符字段的长度。如果不这么声明，
     *         则系统会采用 255 作为该字段的长度
     *
     *
     *
     */



    @Id
    @GeneratedValue()
    private Long id;

    @Column(length = 32)
    private String name;

    private double money;

    public Account() {
    }

    public Account(String name, double money) {
        this.name = name;
        this.money = money;
    }
}
