package com.wp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * javabean
 * @author wangping
 */
@Data
@ApiModel(description = "JavaBean")
public class JavaBean {

    public JavaBean(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @ApiModelProperty(value = "用户名",name = "name",required = true)
    private String name;

    @ApiModelProperty(value = "年龄",name = "age",required = true)
    private Integer age;

    @ApiModelProperty(value = "性别",name = "gender",required = true)
    private String gender;


}
