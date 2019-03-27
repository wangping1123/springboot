package com.wp;

import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器
 *
 * @author wangping
 */
@RestController()
@RequestMapping(value = "/user")
@Api(tags = {"用户操作接口"}, value = "用户Controller")
@Log4j2
public class UserController {

    /**
     * @ApiOperation()用于方法；表示一个http请求 value用于方法的描述
     * notes用于提示内容
     * tags可以重新分组
     * @ApiParma()用于参数，字段说明；表示对参数的添加元数据 name：参数名
     * value：参数说明
     * required：是否必填
     */


    @ApiOperation(value = "获取用户信息", notes = "注意问题点")
    @GetMapping("/get")
    public JavaBean get() {
        return new JavaBean("张三", 18, "男");
    }


    @ApiOperation(value = "添加用户信息", notes = "注意问题点")
    @PostMapping("/post")
    public String post(@ApiParam(name = "user", value = "用户实体", required = true) JavaBean bean) {
        log.info(bean.toString());
        return "调用了post方法";
    }


    @ApiOperation(value = "修改用户信息", notes = "注意问题点")
    @PutMapping("/put")
    public String put(@ApiParam(name = "user", value = "JavaBean类", required = true) JavaBean bean) {
        log.info(bean.toString());
        return "调用了put方法";
    }


    @ApiOperation(value = "删除用户信息", notes = "注意问题点")
    @DeleteMapping("/del")
    @ApiImplicitParam(name = "id",value = "用户id")
    public String del(Integer id) {
        log.info(id);
        return "调用了del方法";
    }
}
