package com.shengsiyuan.jvm.classloader;


/**
 *  @Classname MyTest1
 *  @Description
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化；
 * 对一个类在初始化时，要求其父类全部都已经初始化完毕了
 * -XX:+TraceClassLoading，用于追踪类的加载信息并打印出来
 * -XX:+<option>，表示开启option开关
 * -XX:-<option>，表示关闭option开关
 * -XX:<option>=<value>，表示将option选项的值设置为value
 * @Date 2019/7/25 13:08
 * @Created by Zhangyichao
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
        // System.out.println(MyChild1.str2);
    }
}
class MyPatient1{
    public static String str="Hello World";

    static {
        System.out.println("MyPatient1 static block");
    }
}

class MyChild1 extends  MyPatient1{
    public static String str2="welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}
