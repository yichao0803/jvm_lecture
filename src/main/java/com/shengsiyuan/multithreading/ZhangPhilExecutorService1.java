package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 简单的Java线程池可以从Executors.newFixedThreadPool( int n)获得。
 * 此方法返回一个线程容量为n的线程池。
 * 然后ExecutorService的execute执行之。
 * https://blog.csdn.net/zhangphil/article/details/43898637
 *
 * @author by Zhangyichao
 * @date 2019/11/3 22:58
 * @see ZhangPhilExecutorService1
 */
public class ZhangPhilExecutorService1 {
    // 为了容易理解线程池的概念，假设容量只有2的线程池。
    // 实际使用过程中当然可以更多！
    private final int NUMBER = 2;
    private static Logger logger = Logger.getLogger(ZhangPhilExecutorService1.class);

    public ZhangPhilExecutorService1() {
        // 创建容量为2的线程池。
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER);

        for (int i = 0; i < 10; i++) {
            Thread t = new TestThread(i);
            logger.info("线程池执行线程id:" + i);
            pool.execute(t);
        }
        // 关闭线程池。
        pool.shutdown();
    }

    public static void main(String[] args) {
        new ZhangPhilExecutorService1();
    }

}

class TestThread extends Thread {
    private static Logger logger = Logger.getLogger(TestThread.class);

    private int id;

    public TestThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        logger.info("线程:" + id + " -> 运行...");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("线程:" + id + " -> 结束!");
    }
}
