package com.shengsiyuan.multithreading;

import sun.awt.windows.ThemeReader;

/**
 * @Classname ThreadTest2
 * @Description 通过继承Thread来实现创建线程
 * @Date 2019/9/24 15:38
 * @Created by Zhangyichao
 */
class ThreadDemo extends Thread {

    private Thread t;
    private String threadName;

    ThreadDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + this.threadName);
    }

    @Override
    public void run() {
        System.out.println(this.threadName + " running.");
        super.run();
        int i = 5;
        while (i > 0) {
            System.out.println("Thread " + this.threadName + "：" + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(this.threadName + " interrupted.");
                e.printStackTrace();
            }
            i--;
        }

        System.out.println(this.threadName + " exiting.");
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        ThreadDemo threadDemo1=new ThreadDemo("Thread-1");
        threadDemo1.start();

        ThreadDemo threadDemo2=new ThreadDemo("Thread-2");
        threadDemo2.start();
    }
}
