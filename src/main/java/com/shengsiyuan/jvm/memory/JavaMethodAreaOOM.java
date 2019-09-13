package com.shengsiyuan.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname JavaMethodAreaOOM
 * @Description VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M
 * @Date 2019/9/13 22:30
 * @Created by Zhangyichao
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        do {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        } while (true);
    }

    static class OOMObject {

    }
}
