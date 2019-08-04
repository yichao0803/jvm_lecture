package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MyTest10
 * @Description MyTest10
 * @Date 2019/7/31 22:59
 * @Created by Zhangyichao
 */

class Parent2{
    static  int a=3;
    static {
        System.out.println("Parent2 static block");
    }
}

class  Child2 extends Parent2{
    static int b =4;
    static {
        System.out.println("Child2 static block");
    }
}

public class MyTest10 {
    public static void main(String[] args) {
        Parent2 parent2;
        String str="--------------";
        System.out.println(str);
        parent2=new Parent2();
        System.out.println(str);
        System.out.println(Parent2.a);
        System.out.println(str);
        System.out.println(Child2.b);
    }
}
