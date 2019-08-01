package com.shengsiyuan.jvm.classloader;

import java.io.*;

/**
 * @Classname MyTest16
 * @Description TODO
 * @Date 2019/7/31 23:40
 * @Created by Zhangyichao
 */
public class MyTest16 extends ClassLoader {
    private String classLoaderName;
    private final String fileExtension = ".class";
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16(String classLoaderName) {
        super(); // 默认将系统类加载器当做该类加载器的父类加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent); // 显示指定该类加载器的父类加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    public Class<?> findClass(String className) {
        System.out.println("findClass invoked:" + className);
        System.out.println("class load name:"+this.classLoaderName);

        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            name = name.replace(".", File.separator);

            is = new FileInputStream(new File(this.path+name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyTest16 loader1 = new MyTest16("loader1");
        //loader1.setPath("E:\\Git\\yichao0803\\jvm_lecture\\target\\classes");
        loader1.setPath("C:\\Users\\Administrator\\Desktop\\");

        Class<?> clazz=loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println(clazz);
        System.out.println("clazz："+clazz.hashCode());
        Object object =clazz.newInstance();
        System.out.println(object);
        System.out.println();

        MyTest16 loader2=new MyTest16("loader2");
        loader2.setPath("C:\\Users\\Administrator\\Desktop\\");

        Class<?> clazz2=loader2.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println(clazz2);
        System.out.println("clazz2:"+clazz2.hashCode());
        Object object2=clazz2.newInstance();
        System.out.println(object2);
        System.out.println();
    }

    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = classLoader.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("------------------");
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());

        System.out.println("------------------");
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());

        /*增加 类加载器的命名空间概念
        1、每个类加载器都有自己的命名空间。
        2、同一个命名空间内的类是相互可见的，命名空间由该加载器及所有父加载器所加载的类组成。
        3、在同一个命名空间中，不会出现类的完整名字（包括类的包名）相同的两个类；在不同的命名空间中，有可能会出现类的完整名字（包括类的包名）相同的两个类。
        */

    }


}
