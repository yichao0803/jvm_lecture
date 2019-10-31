package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

import java.text.MessageFormat;

/**
 * 三、线程实例变量与安全问题
 *  1.共享数据情况
 *
 * @author by Zhangyichao
 * @date 2019/10/31 13:19
 * @see ThreadShareVariableDemo
 */
public class ThreadShareVariableDemo {
    public static void main(String[] args) {
        ShareVariableRunnable shareVariableRunnable = new ShareVariableRunnable();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(shareVariableRunnable, "svr-" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class ShareVariableRunnable implements Runnable {
    private Logger logger = Logger.getLogger(ShareVariableRunnable.class);
    private Integer count = 5;

    @Override
    public void run() {
        logger.info(MessageFormat.format("{0} count：{1} ", Thread.currentThread().getName(), count--));
    }
}
