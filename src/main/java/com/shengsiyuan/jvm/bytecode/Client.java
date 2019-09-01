package com.shengsiyuan.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Classname Client
 * @Description TODO
 * @Date 2019/9/1 13:44
 * @Created by Zhangyichao
 */
public class Client {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSubject(rs);
        Class<?> clazz = rs.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), ds);

        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
