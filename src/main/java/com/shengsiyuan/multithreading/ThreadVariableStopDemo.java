package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

/**
 * 停止线程
 *  终止正在运行的线程方法有三种：
 *   1)使用退出标志,使线程正常的执行完run方法终止。
 *   2)使用interrupt方法,使线程异常，线程进行捕获或抛异常，正常执行完run方法终止。
 *   3)使用stop方法强制退出。
 *  这里主要说明前两种方法；
 *  1.使用退出标志方法
 *
 * @author by Zhangyichao
 * @date 2019/10/31 13:54
 * @see ThreadVariableStopDemo
 */
public class ThreadVariableStopDemo {

    public static void main(String[] args) throws InterruptedException {
        VariableStopThread thread = new VariableStopThread("");
        thread.start();
        Thread.sleep(10);
        thread.Stop();
    }
}

class VariableStopThread extends Thread {
    private boolean interrupt = true;
    private Logger logger = Logger.getLogger(VariableStopThread.class);

    public VariableStopThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        // super.run();
        logger.info(Thread.currentThread().getName() + "：线程开始运行！");
        Integer i = 0;
        while (interrupt) {
            logger.info(" " + (i++));
        }
        logger.info("我停止了！timer：" + System.currentTimeMillis());
    }

    public void Stop() {
        logger.info(Thread.currentThread().getName() + "：线程设置了停止！timer:" + System.currentTimeMillis());
        interrupt = false;
    }

}
















