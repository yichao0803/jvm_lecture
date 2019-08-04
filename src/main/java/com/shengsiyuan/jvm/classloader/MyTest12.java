package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MyTest12
 * @Description MyTest12
 * @Date 2019/7/31 23:24
 * @Created by Zhangyichao
 */
class CL{
    static {
        System.out.println("CL static block");
    }
}

public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        System.out.println("-------------------");
        Class<?> clazz=classLoader.loadClass("com.shengsiyuan.jvm.classloader.CL");
        System.out.println(clazz);
        System.out.println("-------------------");
        clazz=Class.forName("com.shengsiyuan.jvm.classloader.CL");
        System.out.println(clazz);

    }
}
