package com.shengsiyuan.jvm.classloader;

import java.io.*;

/**
 * @Classname MyTest16
 * @Description TODO
 * @Date 2019/7/31 23:40
 * @Created by Zhangyichao
 */
public class MyTest16 extends ClassLoader{
    private  String classLoaderName;
    private  final String fileExtension=".class";

    public MyTest16(String classLoaderName){
        super(); // 默认将系统类加载器当做该类加载器的父类加载器
        this.classLoaderName=classLoaderName;
    }

    public MyTest16(ClassLoader parent,String classLoaderName){
        super(parent); // 显示指定该类加载器的父类加载器
        this.classLoaderName=classLoaderName;
    }

     @Override
     public String toString(){
        return  "["+this.classLoaderName+"]";
     }

     @Override
     public Class<?> findClass(String className){
        byte[] data=this.loadClassData(className);
        return  this.defineClass(className,data,0,data.length);
     }

     private byte[] loadClassData(String name){
         InputStream is=null;
         byte[] data=null;
         ByteArrayOutputStream baos=null;
         try {
            this.classLoaderName=this.classLoaderName.replace(".",File.separator);

            is =new FileInputStream(new File(name+this.classLoaderName));
            baos=new ByteArrayOutputStream();

            int ch=0;

            while (-1!=(ch=is.read())){
                baos.write(ch);
            }
            data =baos.toByteArray();

         }catch (Exception ex)
         {
             ex.printStackTrace();
         }
         finally{
            try {
                is.close();
                baos.close();
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
         }
         return  data;
     }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyTest16 loader1=new MyTest16("loader1");
        test(loader1);
    }
    public  static  void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz=classLoader.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("------------------");
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());

        System.out.println("------------------");
        Object object=clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
    }

}
