package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

import java.text.MessageFormat;

/**
 * TODO
 *
 * @author by Zhangyichao
 * @date 2019/11/1 14:03
 * @see ThreadPrivateNumDemo2
 */
public class ThreadPrivateNumDemo2 {

    public static void main(String[] args) {
        PrintPrivateNum2 privateNum = new PrintPrivateNum2();
        Thread thread_1 = new Thread("thread_0") {
            public void run() {
                privateNum.printNum(Thread.currentThread().getName());
            }
        };

        Thread thread_2 = new Thread("thread_1") {
            public void run() {
                privateNum.printNum(Thread.currentThread().getName());
            }
        };

        thread_1.start();
        thread_2.start();
        System.out.println();
    }
}

class PrintPrivateNum2 {
    private Logger logger = Logger.getLogger(PrintPrivateNum.class);
    private int num = 0;
    public synchronized void printNum(String name) {
        if ("thread_0".equals(name)) {
            num += 300;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if ("thread_1".equals(name)) {
            num -= 100;
        }
        logger.info(MessageFormat.format("{0},num：{1}",
                Thread.currentThread().getName(), num));
    }
}
