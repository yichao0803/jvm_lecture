package com.shengsiyuan.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Classname DynamicSubjec
 * @Description TODO
 * @Date 2019/9/1 13:41
 * @Created by Zhangyichao
 */
public class DynamicSubject implements InvocationHandler {

    private Object sub;

    public DynamicSubject(Object sub) {
        this.sub = sub;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling：" + method);

        method.invoke(this.sub, args);

        System.out.println("after calling：" + method);
        return null;
    }
}
