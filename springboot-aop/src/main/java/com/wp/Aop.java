package com.wp;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
     *   *：匹配任意字符
     *   +：匹配指定类及其子类
     *   ..：匹配任意数的子包及参数
     *
     * 匹配com.wp.*Controller类的方法，返回类型任意，方法参数任意
     */
    @Pointcut("execution(public * com.wp.service.impl..*(..))")
    public void point1() {}

    /**
     * 用于匹配指定的包或者类下所有的方法
     */
    @Pointcut("within(com.wp.service.impl.ServiceImpl)")
    public void point2() {}

    /**
     * 匹配所有使用了 @Annotation的注解方法
     * @param annotation
     */
    @Pointcut("@annotation(annotation)")
    public void point3(Annotation annotation) { }

    /**
     * 前置通知
     * @param
     */
    @Before("point3(annotation)")
    public void doBefore(JoinPoint joinPoint, Annotation annotation) {
        System.out.println("前置通知");
        System.out.println(annotation.value());
    }

    /**
     * 后置返回增强处理
     *
     * @param joinPoint
     * @param returnMsg
     */
    @AfterReturning(pointcut = "point2()", returning = "returnMsg")
    public void doAfterReturn(JoinPoint joinPoint, Object returnMsg) {
        System.out.println("后置返回增强处理");
    }
}
