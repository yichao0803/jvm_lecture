package com.shengsiyuan.jvm.classloader;


/**
 *  @Classname MyTest1
 *  @Description
 *  3、初始化
 *  类初始化时机：只有当对类的主动使用的时候才会导致类的初始化，类的主动使用包括以下六种：
 * ① 创建类的实例，也就是new的方式
 * ② 访问某个类或接口的静态变量，或者对该静态变量赋值
 * ③ 调用类的静态方法
 * ④ 反射（如Class.forName(“com.shengsiyuan.Test”)）
 * ⑤ 初始化某个类的子类，则其父类也会被初始化
 * ⑥ Java虚拟机启动时被标明为启动类的类（Java Test），直接使用java.exe命令来运行某个主类
 *
 * 本示例演示了类初始化时机中②：访问某个类或接口的静态变量，或者对改静态变量赋值；
 * ⑤：初始化某个的子类，则其父类也会被初始化
 * **********************************************************************
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
