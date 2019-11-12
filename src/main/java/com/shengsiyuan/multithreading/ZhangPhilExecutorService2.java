package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * TODO
 *
 * @author by Zhangyichao
 * @date 2019/11/3 23:03
 * @see ZhangPhilExecutorService2
 */
public class ZhangPhilExecutorService2 {
    private final int NUMBER = 3;
    private static Logger logger = Logger.getLogger(ZhangPhilExecutorService2.class);

    public ZhangPhilExecutorService2() {

        // 创建容量为NUMBER的线程池。
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER);

        ArrayList<Future<String>> futures = new ArrayList<Future<String>>();

        for (int i = 0; i < 10; i++) {

            AThread t = new AThread(i);

            Future<String> f = pool.submit(t);
            futures.add(f);
        }

        logger.info("获取结果中...");
        for (Future<String> f : futures) {
            try {
                // if(f.isDone())
                logger.info(f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logger.info("得到结果.");

        // 关闭线程池。
        pool.shutdown();
    }


    class AThread implements Callable<String> {
        private Logger logger = Logger.getLogger(AThread.class);

        private int id;

        public AThread(int id) {
            this.id = id;
        }

        @Override
        public String call() {
            logger.info("线程:" + id + " -> 运行...");

            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            logger.info("线程:" + id + " -> 结束.");

            return "返回的字符串" + id;
        }
    }

    public static void main(String[] args) {
        new ZhangPhilExecutorService2();
    }
}
