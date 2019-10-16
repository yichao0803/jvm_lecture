package com.shengsiyuan.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname ThreadTest3
 * @Description
 * @Date 2019/9/24 16:13
 * @Created by Zhangyichao
 */
class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println( Thread.currentThread().getName()+" 开始运行");
        int i = 0;
        while (i < 100) {
           // System.out.println(Thread.currentThread().getName() + " i 的值:"+i);
            i++;
        }
        return i;
    }
}

public class ThreadTest3 {

    public static void main(String[] args) {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> ft = new FutureTask<Integer>(callableDemo);
        int i = 0;
        while (i < 100) {
            System.out.println(Thread.currentThread().getName() + "的循环变量 i 的值" + i);
            if(i>10){
                System.out.println("调用线程创建方法 "+ i);
                new Thread(ft,"有返回值的线程"+i).start();
            }
            i++;
        }
        try{
            System.out.println("子线程的返回值："+ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
