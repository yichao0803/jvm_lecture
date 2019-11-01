package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

import java.awt.*;
import java.text.MessageFormat;

/**
 * 线程优先级
 *   线程优先级范围为1-10，API提供等级分为：低（MIN_PRIORITY = 1)，中（NORM_PRIORITY=5），高（MAX_PRIORITY=10）。
 *  线程优先级有以下特点：
 *   1)继承特性【线程A中启动线程B，线程B继承了A的优先级】；
 *   2)随机性【线程调度的顺序不一定是根据优先级，具有随机性】；
 *
 * @author by Zhangyichao
 * @date 2019/10/31 16:49
 * @see ThreadPriorityDemo
 */
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        Thread thread0 = new ThreadPriority("thread_1<<<<");
        Thread thread1 = new ThreadPriority(">>>thread_2");
        thread0.setPriority(Thread.MAX_PRIORITY);
        // thread1.setPriority(Thread.MIN_PRIORITY);
        thread0.start();
        thread1.start();
    }
}

class ThreadPriority extends Thread {
    private Logger logger = Logger.getLogger(ThreadPriority.class);

    public ThreadPriority(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            logger.info(MessageFormat.format("threa：{0}，number：{1}，priorty：{2}",
                    Thread.currentThread().getName(), i, Thread.currentThread().getPriority()));
        }
    }
}
