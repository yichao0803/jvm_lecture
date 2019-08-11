package com.shengsiyuan.jvm.classloader;

/**
 * @Classname DumpWhileDemo
 * @Description
 * @Date 2019/8/8 0:23
 * @Created by Zhangyichao
 */
public class DumpWhileDemo {
    public static void main(String[] args) {
        new Thread(new WhileThread()).start();
        System.out.println();
    }
}
class WhileThread implements Runnable {
    @Override
    public void run() {
        boolean b=true;
        while (b) {
            System.out.println("Thread");
        }
    }
}