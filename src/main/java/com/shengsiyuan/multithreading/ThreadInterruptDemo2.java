package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

/**
 *  1.异常法
 *    代码有两个关键点：
 *   1)for循环外捕获异常【这是程序的关键点】
 *   2)判断设置了interrupted标志则抛出异常。
 *
 * @author by Zhangyichao
 * @date 2019/10/31 15:08
 * @see ThreadInterruptDemo2
 */
public class ThreadInterruptDemo2 {

    private static Logger logger = Logger.getLogger(ThreadInterruptDemo2.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new InterruptThread2("thread-1");
        thread.start();
        Thread.sleep(10);
        logger.info(thread.getName() + "：线程设置：interreput！");
        thread.interrupt();
    }
}

class InterruptThread2 extends Thread {
    private Logger logger = Logger.getLogger(InterruptThread1.class);

    public InterruptThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        logger.info(Thread.currentThread().getName() + "：线程开始！");
        try {
            for (int i = 0; i < 1000; i++) {
               if(Thread.currentThread().isInterrupted()){
                   logger.info(Thread.currentThread().getName()+"：线程停止状态");
                   throw new InterruptedException();
               }
               Thread.sleep(0);
               logger.info(""+(i+1));
            }
            logger.info(Thread.currentThread().getName() + "：线程结束！");
        }catch (InterruptedException e){
            logger.error(Thread.currentThread().getName() + "：线程捕获异常，退出循环 isInterrupted："+isInterrupted());
            e.printStackTrace();
        }

    }
}
