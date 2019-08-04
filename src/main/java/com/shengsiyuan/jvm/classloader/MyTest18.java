package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MyTest18
 * @Description TODO
 * @Date 2019/8/4 14:05
 * @Created by Zhangyichao
 */
public class MyTest18 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
