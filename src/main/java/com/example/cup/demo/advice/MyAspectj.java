package com.example.cup.demo.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

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
