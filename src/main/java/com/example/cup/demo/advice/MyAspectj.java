package com.example.cup.demo.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 *     <!--扫描含com.mengma包下的所有注解-->
 *     <context:component-scan base-package="com.example"/>
 *     <!-- 使切面开启自动代理 -->
 *     <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 */

@Aspect
public class MyAspectj {

    //配置切入点
    @Pointcut("execution(* com.example.cup.demo.service.*.*(..))")
    private void pointCut(){}

    //前置
    @Before("pointCut()")
    public void before(){
        System.out.println("before...");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after...");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            before();
            proceedingJoinPoint.proceed();
            after();
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void myException(JoinPoint joinPoint,Throwable e){
        System.out.println("处理异常："+e.getMessage());
    }


}
