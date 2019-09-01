package com.shengsiyuan.jvm.bytecode;

/**
 * @Classname RealSubject
 * @Description TODO
 * @Date 2019/9/1 13:40
 * @Created by Zhangyichao
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("From real subject");
    }
}