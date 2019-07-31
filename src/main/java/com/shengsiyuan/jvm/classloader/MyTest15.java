package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MyTest15
 * @Description 类的加载器
 * （1）、启动类加载器：启动类加载器：Bootstrap ClassLoader，负责加载存放在JDK\jre\lib(JDK代表JDK的安装目录，下同)下，
 *      或被-Xbootclasspath参数指定的路径中的，并且能被虚拟机识别的类库（如rt.jar，所有的java.* 开头的类均被Bootstrap ClassLoader加载）。
 *      启动类加载器是无法被Java程序直接引用的。
 * （2）、扩展类加载器：Extension ClassLoader，该加载器由sun.misc.Launcher$ExtClassLoader实现，它负责加载DK\jre\lib\ext目录中，
 *      或者由java.ext.dirs系统变量指定的路径中的所有类库（如javax.* 开头的类），开发者可以直接使用扩展类加载器。
 * （3）、应用程序类加载器：Application ClassLoader，该类加载器由sun.misc.Launcher$AppClassLoader来实现，
 *      它负责加载用户类路径（ClassPath）所指定的类，开发者可以直接使用该类加载器，如果应用程序中没有自定义过自己的类加载器，
 *       一般情况下这个就是程序中默认的类加载器。
 * @Date 2019/7/31 23:07
 * @Created by Zhangyichao
 */
public class MyTest15 {
    public static void main(String[] args) {

        String[] strings=new String[2];
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("---------------");
        MyTest15[] myTest15s=new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());

        System.out.println("---------------");
        int[] ints=new int[2];
        System.out.println(ints.getClass().getClassLoader());
    }
}
