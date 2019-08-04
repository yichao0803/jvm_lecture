package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MyTest11
 * @Description MyTest11
 * @Date 2019/7/31 23:32
 * @Created by Zhangyichao
 */
class Parent3{
    static int a=3;
    static {
        System.out.println("Parent3 static block");
    }
    static void doSomething(){
        System.out.println("Parent3 doSomething");
    }
}
class Child3 extends Parent3{
    static {
        System.out.println("Child3 static block");
    }
}
public class MyTest11 {
    public static void main(String[] args) {
        System.out.println(Child3.a);
        Child3.doSomething();

    }
}
