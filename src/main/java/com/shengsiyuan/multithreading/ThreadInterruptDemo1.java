package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

/**
 * 2.使用interrupt方法
 *
 * @author by Zhangyichao
 * @date 2019/10/31 14:56
 * @see ThreadInterruptDemo1
 */
public class ThreadInterruptDemo1 {
    private static Logger logger = Logger.getLogger(ThreadInterruptDemo1.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new InterruptThread1("thread-1");
        thread.start();
        Thread.sleep(10);
        logger.info(thread.getName() + "：线程设置：interreput！");
        thread.interrupt();
    }
}

class InterruptThread1 extends Thread {
    private Logger logger = Logger.getLogger(InterruptThread1.class);

    public InterruptThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        logger.info(Thread.currentThread().getName() + "：线程开始！");
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(0);
                logger.info(i + 1);
            } catch (InterruptedException e) {
                logger.error(Thread.currentThread().getName() + "：线程捕获异常，退出循环");
                break;
            }
        }
        logger.info(Thread.currentThread().getName() + "：线程结束！");
    }
}
