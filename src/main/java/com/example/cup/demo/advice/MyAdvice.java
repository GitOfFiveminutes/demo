package com.example.cup.demo.advice;

import com.example.cup.demo.service.DreamManager;
import org.hibernate.query.criteria.internal.expression.function.AbsFunction;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyAdvice {

    public void before(){
        System.out.println("before....");
    }

    public void after(){
        System.out.println("after....");
    }

    public static void main(String[] args) {
        DreamManager dreamManager = new DreamManager();
        MyAdvice myAdvice = new MyAdvice();
        //cglib增强器 代理类
        Enhancer enhancer = new Enhancer();
        //增加类
        enhancer.setSuperclass(dreamManager.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                myAdvice.before();
                Object invoke = null;
                try {
                    invoke = method.invoke(dreamManager, args);
                }catch (Exception e){
                    System.out.println("已处理。。。");
                }
                myAdvice.after();
                return invoke;
            }
        });
        DreamManager o =(DreamManager) enhancer.create();
        o.find();

        //JDK代理 必须是接口
        DreamManager instance = (DreamManager) Proxy.newProxyInstance(MyAdvice.class.getClassLoader(), new Class[]{DreamManager.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAdvice.before();
                        Object invoke = null;
                        try {
                            invoke = method.invoke(dreamManager.find(), args);
                        } catch (Exception e) {

                        }
                        myAdvice.after();
                        return invoke;
                    }
                });
        instance.find();

    }
}
