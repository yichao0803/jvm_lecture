package com.zyccx.jmm;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Atomic变量自增运算测试
 *
 * @author by Zhangyichao
 * @date 2019/11/12 10:47
 * @see AtomicTest
 */
public class AtomicTest {

    public static AtomicInteger race = new AtomicInteger(0);

    public static void increaseA() {
        race.incrementAndGet();
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increaseA();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1)
            Thread.yield();

        System.out.println(race);
    }
}

