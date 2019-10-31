package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

/**
 * 一、创建线程-1.继承Thread类
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
 *
 * @author by Zhangyichao
 * @date 2019/10/31 11:16
 * @see ThreadCreateDemo1
 */
public class ThreadCreateDemo1 {
    private static Logger loger=Logger.getLogger(ThreadCreateDemo1.class);
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); //该方法调用多次,出现IllegalThreadStateException
    }
}

class MyThread extends Thread {
    private Logger logger =Logger.getLogger(MyThread.class);

    @Override
    public void run() {
        super.run();
        logger.info("hello world !");
     }
}