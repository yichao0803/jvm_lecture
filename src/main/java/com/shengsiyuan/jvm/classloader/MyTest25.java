package com.shengsiyuan.jvm.classloader;

import java.security.PublicKey;

/**
 * @Classname MyTest25
 * @Description MyTest25
 * @Date 2019/8/7 8:35
 * @Created by Zhangyichao
 */
public class MyTest25 implements Runnable{

    private  Thread thread;

    public  MyTest25(){
        thread=new Thread(this);
        thread.start();
    }

    public void run() {
        ClassLoader classLoader=thread.getContextClassLoader();

        thread.setContextClassLoader(classLoader);

        System.out.println("Class："+classLoader.getClass());
        System.out.println("Parent："+classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
