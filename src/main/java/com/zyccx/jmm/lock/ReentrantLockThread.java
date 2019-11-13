package com.zyccx.jmm.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author by Zhangyichao
 * @date 2019/11/13 14:29
 * @see ReentrantLockThread
 */
public class ReentrantLockThread implements Runnable{

    ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lock();

            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "输出了：  " + i);
            }
        }finally {
            lock.unlock();
        }
    }
}