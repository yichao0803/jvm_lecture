package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 一、简介
 * 线程池类为 java.util.concurrent.ThreadPoolExecutor，常用构造方法为：
 * ThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
 * long keepAliveTime, TimeUnit unit,
 * BlockingQueue workQueue,
 * RejectedExecutionHandler handler)
 * corePoolSize： 线程池维护线程的最少数量
 * maximumPoolSize：线程池维护线程的最大数量
 * keepAliveTime： 线程池维护线程所允许的空闲时间
 * unit： 线程池维护线程所允许的空闲时间的单位
 * workQueue： 线程池所使用的缓冲队列handler： 线程池对拒绝任务的处理策略
 * <p>
 * <p>
 * 一个任务通过 execute(Runnable)方法被添加到线程池，任务就是一个 Runnable类型的对象，任务的执行方法就是 Runnable类型对象的run()方法。
 * <p>
 * 当一个任务通过execute(Runnable)方法欲添加到线程池时：
 * <p>
 * 如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
 * 如果此时线程池中的数量等于corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。
 * 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理被添加的任务。
 * 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。
 * <p>
 * 也就是：处理任务的优先级为：
 * 核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
 * <p>
 * 当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。
 * <p>
 * unit可选的参数为java.util.concurrent.TimeUnit中的几个静态属性：
 * NANOSECONDS、MICROSECONDS、MILLISECONDS、SECONDS。
 * <p>
 * workQueue我常用的是：java.util.concurrent.ArrayBlockingQueue
 * <p>
 * handler有四个选择：
 * ThreadPoolExecutor.AbortPolicy()
 * 抛出java.util.concurrent.RejectedExecutionException异常
 * ThreadPoolExecutor.CallerRunsPolicy()
 * 重试添加当前的任务，他会自动重复调用execute()方法
 * ThreadPoolExecutor.DiscardOldestPolicy()
 * 抛弃旧的任务
 * ThreadPoolExecutor.DiscardPolicy()
 * 抛弃当前的任务
 * <p>
 * <p>
 * 说明：
 * 1、在这段程序中，一个任务就是一个Runnable类型的对象，也就是一个ThreadPoolTask类型的对象。
 * 2、一般来说任务除了处理方式外，还需要处理的数据，处理的数据通过构造方法传给任务。
 * 3、在这段程序中，main()方法相当于一个残忍的领导，他派发出许多任务，丢给一个叫 threadPool的任劳任怨的小组来做。
 * 这个小组里面队员至少有两个，如果他们两个忙不过来，任务就被放到任务列表里面。
 * 如果积压的任务过多，多到任务列表都装不下(超过3个)的时候，就雇佣新的队员来帮忙。但是基于成本的考虑，不能雇佣太多的队员，
 * 至多只能雇佣 4个。
 * 如果四个队员都在忙时，再有新的任务，这个小组就处理不了了，任务就会被通过一种策略来处理，我们的处理方式是不停的派发，
 * 直到接受这个任务为止(更残忍！呵呵)。
 * 因为队员工作是需要成本的，如果工作很闲，闲到 3SECONDS都没有新的任务了，那么有的队员就会被解雇了，
 * 但是，为了小组的正常运转，即使工作再闲，小组的队员也不能少于两个。
 * 4、通过调整 produceTaskSleepTime和 consumeTaskSleepTime的大小来实现对派发任务和处理任务的速度的控制，
 * 改变这两个值就可以观察不同速率下程序的工作情况。
 * 5、通过调整4中所指的数据，再加上调整任务丢弃策略，换上其他三种策略，就可以看出不同策略下的不同处理方式。
 * 6、对于其他的使用方法，参看jdk的帮助，很容易理解和使用。
 * <p>
 *
 * 在本例子中，有部分任务被丢弃的可能；当线程池的线程数达到了最大线程数[maximumPoolSize]且缓冲队列[WorkQueue]已满时，再进来新的任务时，根据丢弃策略丢弃任务
 * 在 ThreadPoolExecutorTest2 通过判断队列是否已满，达到了不丢弃任务
 *
 * @author by Zhangyichao
 * @date 2019/11/1 15:40
 * @see ThreadPoolExecutorTest1
 */

public class ThreadPoolExecutorTest1 {
    private static Logger logger = Logger.getLogger(ThreadPoolExecutorTest1.class);
    private static int produceTaskSleepTime = 2;
    private static int produceTaskMaxNumber = 10;

    public static void main(String[] args) {
        logger.info("程序开始运行！");
        // 构造一个线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 1; i <= produceTaskMaxNumber; i++) {
            try {
                // 产生一个任务，并将其加入到线程池
                String task = "task@ " + i;
                logger.info("put " + task);
                threadPool.execute(new TaskThreadPool1(task));

                // 便于观察，等待一段时间
                Thread.sleep(produceTaskSleepTime);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("dd");
            }
        }
        logger.info("程序运行结束！");
    }
}

/**
 * 线程池执行的任务
 */
class TaskThreadPool1 implements Runnable, Serializable {
    private Logger logger = Logger.getLogger(TaskThreadPool1.class);
    private static final long serialVersionUID = 0;
    private static int consumeTaskSleepTime = 2000;
    // 保存任务所需要的数据
    private Object threadPoolTaskData;

    TaskThreadPool1(Object tasks) {
        this.threadPoolTaskData = tasks;
    }

    public void run() {
        // 处理一个任务，这里的处理方式太简单了，仅仅是一个打印语句
        logger.info(MessageFormat.format("线程 {0} 开始运行", Thread.currentThread().getName()));
        logger.info(MessageFormat.format("start ..{0}", threadPoolTaskData));
        try {
            // //便于观察，等待一段时间
            Thread.sleep(consumeTaskSleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        threadPoolTaskData = null;
        logger.info(MessageFormat.format("线程 {0} 运行结束", Thread.currentThread().getName()));

    }

    public Object getTask() {
        return this.threadPoolTaskData;
    }
}
