package com.shengsiyuan.multithreading;

import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import java.text.MessageFormat;

/**
 * 守护线程
 *
 * @author by Zhangyichao
 * @date 2019/11/1 9:40
 * @see DaemonThreadDemo
 */
public class DaemonThreadDemo {
    private static Logger logger=Logger.getLogger(DaemonThreadDemo.class);
    public static void main(String[] args) {
        DaemonThread thread=new DaemonThread();
        thread.setName("thread-0");
        thread.setDaemon(true);
        thread.start();

        logger.info(MessageFormat.format("{0}：停止运行！",Thread.currentThread().getName()));
    }

}
class DaemonThread extends Thread{

    private Logger logger=Logger.getLogger(DaemonThread.class);

    @Override
    public void  run(){
        while (true){
            logger.info(MessageFormat.format("线程 {0} 正在运行！",
                    Thread.currentThread().getName()));
        }
    }
}
