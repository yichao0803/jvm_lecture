package com.shengsiyuan.multithreading;


import org.apache.log4j.Logger;

/**
 * 2、线程运行结果与执行顺序无关
 *
 * @author by Zhangyichao
 * @date 2019/10/31 11:24
 * @see ThreadRandomDemo1
 */

public class ThreadRandomDemo1 {

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new RandomThread("RandomThread-" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class RandomThread extends Thread {
    private Logger logger = Logger.getLogger(RandomThread.class);

    public RandomThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(1000);
            logger.info(Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}