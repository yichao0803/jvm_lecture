package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

/**
 2.return法
 *
 * @author by Zhangyichao
 * @date 2019/10/31 15:21
 * @see ThreadInterruptDemo3
 */
public class ThreadInterruptDemo3 {
    private static Logger logger = Logger.getLogger(ThreadInterruptDemo2.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new InterruptThread3("thread-1");
        thread.start();
        Thread.sleep(9);
        logger.info(thread.getName() + "：线程设置：interreput！");
        thread.interrupt();
    }
}


class InterruptThread3 extends Thread {
    private Logger logger = Logger.getLogger(InterruptThread3.class);

    public InterruptThread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        logger.info(Thread.currentThread().getName() + "：线程开始！");
        try {
            for (int i = 0; i < 1000; i++) {
                Thread.sleep(0);
                logger.info(""+(i+1));
            }
        }catch (InterruptedException e){
            logger.error(Thread.currentThread().getName() + "：线程捕获异常，退出循环 isInterrupted："+isInterrupted());
            e.printStackTrace();
            return;
        }
        logger.info(Thread.currentThread().getName() + "：线程结束！");
    }
}
