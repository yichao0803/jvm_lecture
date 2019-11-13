package com.zyccx.jmm.lock;

/**
 * ReentrantLockTest
 *
 * @author by Zhangyichao
 * @date 2019/11/13 14:28
 * @see ReentrantLockTest
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        Runnable runnable=new ReentrantLockThread();
        new Thread(runnable,"thread-1").start();
        new Thread(runnable,"thread-2").start();
    }
}
