package com.shengsiyuan.multithreading;

/**
 * @Classname ThreadTest1
 * @Description 通过实现Runnable接口实现创建线程
 * @Date 2019/9/24 14:58
 * @Created by Zhangyichao
 */
class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Createing " + this.threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        int i = 4;
        while (i >= 0) {
            System.out.println(threadName + "：" + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(threadName + " is interrupted.");
                e.printStackTrace();
            }
            i--;
        }
        System.out.println(threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        RunnableDemo runnableDemo1=new RunnableDemo("Thead-1");
        runnableDemo1.start();

        RunnableDemo runnableDemo2=new RunnableDemo("Thead-2");
        runnableDemo2.start();
    }
}
