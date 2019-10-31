package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

/**
 * 一、创建线程-2.实现Runnable接口
 *
 * @author by Zhangyichao
 * @date 2019/10/31 11:22
 * @see ThreadCreateDemo2
 */

public class ThreadCreateDemo2 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

class MyRunnable implements Runnable {
    private Logger logger =Logger.getLogger(MyRunnable.class);

    public void run() {
        logger.info("通过Runnable创建的线程");
    }
}