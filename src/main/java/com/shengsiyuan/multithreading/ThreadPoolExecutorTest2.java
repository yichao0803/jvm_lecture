package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

import java.text.MessageFormat;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author by Zhangyichao
 * @date 2019/11/3 20:48
 * @see ThreadPoolExecutorTest2
 */
public class ThreadPoolExecutorTest2 {
    private static Logger logger = Logger.getLogger(ThreadPoolExecutorTest2.class);
    private static int queueDeep = 4;
    private static int corePoolSize=2;
    private static int maximunPoolSize=4;

    private synchronized int getQueueSize(Queue queue) {
        return queue.size();
    }

    public void createThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueDeep),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        // 向线程池中添加10个任务
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info(MessageFormat.format("i：{0},QueueSize：{1}", i,getQueueSize(threadPoolExecutor.getQueue())));
            while (getQueueSize(threadPoolExecutor.getQueue()) >= queueDeep) {
                logger.info("队列已满，等3秒再添加任务");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            TaskThread2 taskThread2 = new TaskThread2(i);
            logger.info("put i：" + i);
            threadPoolExecutor.execute(taskThread2);
        }
        //
        logger.info("任务已分配全部分配，等待执行完成");
        threadPoolExecutor.shutdown();
        logger.info("退出程序");
    }

    public static void main(String[] args) {
        ThreadPoolExecutorTest2 threadPoolExecutorTest2 = new ThreadPoolExecutorTest2();
        threadPoolExecutorTest2.createThreadPool();
    }

}

class TaskThread2 implements Runnable {
    private Logger logger = Logger.getLogger(TaskThread2.class);
    private int index;

    public TaskThread2(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        logger.info(MessageFormat.format("{0} index：{1}",
                Thread.currentThread().getName(), index));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

