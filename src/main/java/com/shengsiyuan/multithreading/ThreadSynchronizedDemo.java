package com.shengsiyuan.multithreading;

/**
 * 对象锁与静态锁
 *
 * @author by Zhangyichao
 * @date 2019/11/1 14:12
 * @see ThreadSynchronizedDemo
 */
public class ThreadSynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        final ThreadSynchronizedObject object = new ThreadSynchronizedObject();
        Thread thread_1 = new Thread("thread_1") {
            public void run() {
                try{
                    object.threadMethodA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        };
        Thread  thread_2 = new Thread("thread_2") {
            public void run() {
                try{
                    object.threadMethodB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        };
        thread_1.start();
        thread_2.start();
        Thread.sleep(3000);
        long start_time = (ThreadSynchronizedTimeUtils.mMethodAIntoTime - ThreadSynchronizedTimeUtils.mMethodBIntoTime) > 0 ? ThreadSynchronizedTimeUtils.mMethodAIntoTime
                : ThreadSynchronizedTimeUtils.mMethodBIntoTime;
        long end_time = (ThreadSynchronizedTimeUtils.mMethodAOutTime - ThreadSynchronizedTimeUtils.mMethodBOutTime) > 0 ? ThreadSynchronizedTimeUtils.mMethodAOutTime
                : ThreadSynchronizedTimeUtils.mMethodBOutTime;
        System.out.println("总耗时:" + (end_time - start_time));
    }
}

class ThreadSynchronizedObject {
    private Object object  = new Object();
    public synchronized void threadMethodA() throws InterruptedException {
        ThreadSynchronizedTimeUtils.setMethodAIntoTime();
        System.out.println(Thread.currentThread().getName() + ",进入threadMethodA");
        Thread.sleep(1000); ///<模拟方法请求耗时
        System.out.println(Thread.currentThread().getName() + ",退出threadMethodA");
        ThreadSynchronizedTimeUtils.setMethodAOutTime();
    }

    public void threadMethodB() throws InterruptedException {
        synchronized (this) {
            ThreadSynchronizedTimeUtils.setMethodBIntoTime();
            System.out.println(Thread.currentThread().getName() + ",进入threadMethodB");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ",退出threadMethodB");
            ThreadSynchronizedTimeUtils.setMethodBOutTime();
        }
    }
}

class ThreadSynchronizedTimeUtils {

    public static long mMethodAIntoTime;
    public static long mMethodAOutTime;
    public static long mMethodBIntoTime;
    public static long mMethodBOutTime;

    public static void setMethodAIntoTime() {
        mMethodAIntoTime = System.currentTimeMillis();
    }

    public static void setMethodAOutTime() {
        mMethodAOutTime = System.currentTimeMillis();
    }

    public static void setMethodBIntoTime() {
        mMethodBIntoTime = System.currentTimeMillis();
    }

    public static void setMethodBOutTime() {
        mMethodBOutTime = System.currentTimeMillis();
    }
}
