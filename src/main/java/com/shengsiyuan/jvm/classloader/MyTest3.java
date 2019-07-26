package com.shengsiyuan.jvm.classloader;

import java.util.UUID;

/**
 * @Classname MyTest4
 * @Description
 * 当一个常量的值并非编译期间可以确定，那么其值就不会被放到调用类的常量池中
 * 这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化
 * @Date 2019/7/25 13:08
 * @Created by Zhangyichao
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyPatient3.str);
    }
}

class MyPatient3{
    public static final String str=UUID.randomUUID().toString();
    static {
        System.out.println("MyPatient3 static bolck");
    }
}
