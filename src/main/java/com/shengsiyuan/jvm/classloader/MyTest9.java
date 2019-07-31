package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MyTest9
 * @Description
 * 复习：使用类的静态变量时，该类会初始化，其父类也会被初始化
 * 3、类的初始化中类的主动初始化时机
 * ②、访问某个类或接口的静态变量， 或者对该静态变量赋值
 * ⑤、初始化某个类的子类，则父类也会被初始化
 * @Date 2019/7/31 22:35
 * @Created by Zhangyichao
 */

class Parent {
    static  int a=3;
    static  {
        System.out.println("Parent static block");
    }
}
class Child extends Parent{
    static int b =4;
    static {
        System.out.println("Child staitc block");
    }
}
public class MyTest9 {
    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}
