package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

/**
 * 一、创建线程-1.继承Thread类
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