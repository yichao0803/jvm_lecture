package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

import java.text.MessageFormat;

/**
 * 线程让步【yield方法】让当前线程释放CPU资源，让其他线程抢占。
 * 使用Thread.yield(); 需要100多毫秒，未使用时在10毫秒左右
 *
 * @author by Zhangyichao
 * @date 2019/11/1 9:55
 * @see ThreadYieldDemo
 */
public class ThreadYieldDemo {
    private  static  Logger logger=Logger.getLogger(ThreadYieldDemo.class);

    public static void main(String[] args) {
        logger.info(MessageFormat.format("线程：{0} 开始运行！",Thread.currentThread().getName()));
        Thread thread=new ThreadYield();
        thread.start();
        logger.info(MessageFormat.format("线程：{0} 线程执行完成！",Thread.currentThread().getName()));
    }

}

class ThreadYield extends Thread{

    private Logger logger=Logger.getLogger(ThreadYield.class);

    @Override
    public void run() {
        super.run();
        long time_start=System.currentTimeMillis();

        for (int i = 0; i < 500000; i++) {
            Math.random();
            // logger.info(MessageFormat.format("i：{0}",i));
            //Thread.yield();
        }

        long time_end=System.currentTimeMillis();

        logger.info(MessageFormat.format("用时：{0} ms",time_end-time_start));

    }
}

