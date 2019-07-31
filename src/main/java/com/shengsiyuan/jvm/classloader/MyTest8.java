package com.shengsiyuan.jvm.classloader;

import java.util.Random;
/**
 * @Classname MyTest8
 * @Description
 * 复习
 * 2 类的【连接】阶段中【准备】阶段
 * 准备：为类的静态变量分配内存，并将其初始化为默认值
 * 知识点③
 * 如果类字段的字段属性表中存在ConstantValue属性，即同时被final和static修饰，
 * 那么在准备阶段变量value就会被初始化为ConstantValue属性所指定的值。
 * 假设上面的类变量value被定义为： public static final int value = 3；
 * 编译时Javac将会为value生成ConstantValue属性，在准备阶段虚拟机就会根据ConstantValue的设置将value赋值为3。
 * 我们可以理解为static final常量在编译期就将其结果放入了调用它的类的常量池中
 *
 * 如果类的静态常量是不变值，则在编译期，会被编译到使用类的常量池中，本类不会做加载；运行时才能确定的静态常量，本类会被加载和初始化
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
