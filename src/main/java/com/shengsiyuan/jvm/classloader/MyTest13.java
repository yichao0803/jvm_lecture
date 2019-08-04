package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MyTest13
 * @Description MyTest13
 * @Date 2019/7/31 23:22
 * @Created by Zhangyichao
 */
public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);

        while (null!=classLoader){
            classLoader=classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
