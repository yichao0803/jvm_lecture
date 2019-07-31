package com.shengsiyuan.jvm.classloader;

import java.util.Random;
/**
 * @Classname MyTest8
 * @Description
 * 复习
 * 3、类的初始化
 * 知识点③静态常量
 * 在编译期已经被赋值静态常量，会被编译到使用类的常量池中，本类不会做加载；运行时才能确定的常量，本类会被加载和初始化
 *
 * @Date 2019/7/31 7:50
 * @Created by Zhangyichao
 */
class  FinalTest{
    public  static  final int x=1;
    static {
        System.out.println("FinalTest static block");
    }
}

public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}
