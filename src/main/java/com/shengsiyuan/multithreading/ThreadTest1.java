package com.shengsiyuan.multithreading;

/**
 * Java 提供了三种创建线程的方法：
 * <p>
 * 通过实现 Runnable 接口；
 * 通过继承 Thread 类本身；
 * 通过 Callable 和 Future 创建线程。
 * <p>
 * 创建线程的三种方式的对比
 * 1. 采用实现 Runnable、Callable 接口的方式创建多线程时，线程类只是实现了 Runnable 接口或 Callable 接口，还可以继承其他类。
 * 2. 使用继承 Thread 类的方式创建多线程时，编写简单，如果需要访问当前线程，则无需使用 Thread.currentThread() 方法，直接使用 this 即可获得当前线程。
 * <p>
 * 本 demo 为第一种：通过实现Runnable接口实现创建线程
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
                Thread.sleep((int)Math.random()*1000);
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
        RunnableDemo runnableDemo1 = new RunnableDemo("Thead-1");
        runnableDemo1.start();

        RunnableDemo runnableDemo2 = new RunnableDemo("Thead-2");
        runnableDemo2.start();
    }
}
