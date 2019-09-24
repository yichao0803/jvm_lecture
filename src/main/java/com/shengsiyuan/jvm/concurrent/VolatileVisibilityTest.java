package com.shengsiyuan.jvm.concurrent;

/**
 * @Classname VokatileVisibilityTest
 * @Description VolatileVisibilityTest
 * @Date 2019/9/10 12:42
 * @Created by Zhangyichao
 */
public class VolatileVisibilityTest {
    private static volatile boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("等待准备数据..");
                do {
                } while (!initFlag);
                System.out.println("获取到数据，开始业务代码");
            }
        }).start();
        Thread.sleep(2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始准备数据");
                initFlag = true;
                System.out.println("完成准备数据");
            }
        }).start();
    }
}
