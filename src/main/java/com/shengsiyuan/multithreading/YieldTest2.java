package com.shengsiyuan.multithreading;

/**
 * @Classname YieldTest2
 * @Description YieldTest
 * @Date 2019/9/22 22:51
 * @Created by Zhangyichao
 */

public class YieldTest2 extends Thread {

    public YieldTest2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                this.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldTest2 yt1 = new YieldTest2("张三");
        YieldTest2 yt2 = new YieldTest2("李四");
        yt1.start();
        yt2.start();
    }
}