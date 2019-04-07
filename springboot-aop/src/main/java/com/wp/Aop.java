package com.wp;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用户请求切面
 *
 * @author wangping
 */
// 定义切面
@Aspect
// 加入到ioc容器中
@Component
@Log4j2
public class Aop {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();


    /**
     * execution:匹配表达式
     * *：匹配任意字符
     * +：匹配指定类及其子类
     * ..：匹配任意数的子包及参数
     * <p>
     * 匹配com.wp.*Controller类的方法，返回类型任意，方法参数任意
     */
    @Pointcut("execution(public * com.wp.service.impl..*(..))")
    public void point1() {
    }

    /**
     * 用于匹配指定的包或者类下所有的方法
     */
    @Pointcut("within(com.wp.service.impl.ServiceImpl)")
    public void point2() {
    }

    /**
     * 匹配所有使用了 @Annotation的注解方法,仅能拦截方法
     *
     * @param annotation
     */
    @Pointcut("@annotation(annotation)")
    public void point3(Annotation annotation) {
    }

    /**
     * 匹配对象
     * this：匹配AOP对象的目标对象为指定类型的方法，可以拦截动态生成的方法
     * 这里指匹配com.wp.service.Service的代理对象方法
     */
    @Pointcut("this(com.wp.service.Service)")
    public void point4() {
    }

    /**
     * 匹配实现接口的目标方法
     * 这里指实现了com.wp.service.Service的方法
     */
    @Pointcut("target(com.wp.service.Service)")
    public void point5() {
    }

    /**
     * 匹配所有以Service结尾的bean里头的方法
     */
    @Pointcut("bean(*Service)")
    public void point6() {
    }

    @Pointcut("args(Long) && within(com.wp.service.impl.*)")
    public void point7(){
    }


    /**
     * 前置通知
     *
     * @param
     */
    @Before("point7()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("前置通知");
        //System.out.println(annotation.value());
    }

   /* *//**
     * 后置通知，方法执行之后
     * @param joinpoint
     *//*
    @After("point5()")
    public void deAfter(JoinPoint joinpoint) {
        System.out.println("后置通知");
    }

    *//**
     * 被拦截的方法成功执行之后，后置返回增强处理
     *
     * @param joinPoint
     * @param returnMsg
     *//*
    @AfterReturning(pointcut = "point5()", returning = "returnMsg")
    public void doAfterReturn(JoinPoint joinPoint, Object returnMsg) {
        System.out.println("后置返回增强处理");
    }*/

}
