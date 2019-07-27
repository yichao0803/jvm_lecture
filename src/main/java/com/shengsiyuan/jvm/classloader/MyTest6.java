package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MyTest6
 * @Description
 * 3、初始化
 * JVM初始化步骤
 * ① 假如这个类还没有被加载和连接，则程序先加载并连接该类
 * ② 假如该类的直接父类还没有被初始化，则先初始化其直接父类
 * ③ 假如类中有初始化语句，则系统依次执行这些初始化语句
 *
 * 本示例演示了类的初始化步骤中③：假如类中有初始化语句，则系统依次执行这些初始化语句
 *
 * @Date 2019/7/27 10:07
 * @Created by Zhangyichao
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton=Singleton.getInstance();
        System.out.println("Singleton.counter1："+Singleton.counter1);
        System.out.println("Singleton.counter2："+Singleton.counter2);
    }
}

class Singleton{
    public static int counter1=1;
    public static Singleton singleton=new Singleton();
    public static int counter2=0;
    private Singleton(){
        counter1++;
        counter2++;
        System.out.println("counter1："+counter1);
        System.out.println("counter2："+counter2);
        System.out.println("*********");
    }

    public static  Singleton getInstance(){
        return  singleton;
    }

}
