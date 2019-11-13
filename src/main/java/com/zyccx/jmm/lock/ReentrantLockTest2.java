package com.zyccx.jmm.lock;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试可重入锁的重入特性。
 *
 * @author by Zhangyichao
 * @date 2019/11/13 14:40
 * @see ReentrantLockTest2
 */
public class ReentrantLockTest2 {
    private ReentrantLock lock=null;
    public ReentrantLockTest2(){
        // 创建一个自由竞争的可重入锁
        lock=new ReentrantLock();
    }

    public ReentrantLock getLock(){
        return lock;
    }

    public void testReetrantLock(){
        lock.lock();
        Calendar now =Calendar.getInstance();
        System.out.println(MessageFormat.format("{0} {1} get lock",now.getTime(),Thread.currentThread().getName()));
    }

    public static void main(String[] args) {
        ReentrantLockTest2 reentrantLockTest2=new ReentrantLockTest2();
        try {
            // 测试可重入，方法testReentry() 在同一线程中,可重复获取锁,执行获取锁后，显示信息的功能
            reentrantLockTest2.testReetrantLock();
            // 能执行到这里而不阻塞，表示锁可重入
            reentrantLockTest2.testReetrantLock();
            // 再次重入
            reentrantLockTest2.testReetrantLock();
        }finally {
            reentrantLockTest2.getLock().unlock();
            reentrantLockTest2.getLock().unlock();
            reentrantLockTest2.getLock().unlock();
        }

    }
}
