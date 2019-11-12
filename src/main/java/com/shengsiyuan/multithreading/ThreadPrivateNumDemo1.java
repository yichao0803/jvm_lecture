package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

import java.text.MessageFormat;

/**
 * -synchronized同步锁
 *  1.同步锁使用范围
 *   同步锁使用场景：多个线程对同一个对象中的实例变量进行并发访问。
 *   方法体中声明的局部变量不需要同步处理。
 *
 * @author by Zhangyichao
 * @date 2019/11/1 13:37
 * @see ThreadPrivateNumDemo1
 */
public class ThreadPrivateNumDemo1 {

    public static void main(String[] args) {
        PrintPrivateNum privateNum = new PrintPrivateNum();
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
    }
}

class PrintPrivateNum {
    Logger logger = Logger.getLogger(PrintPrivateNum.class);

    public void printNum(String name) {
        int num = 0;
        if ("thread_0".equals(name)) {
            num += 300;
            try {
                Thread.sleep(1000);
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
