package com.shengsiyuan.jvm.memory;

/**
 * @Classname MyTest1
 * @Description
 * 虚拟机栈：Stack Frame 栈帧
 * 程序计数器（Program Counter）:
 * 本地方法栈：主要用于处理本地方法
 * 堆（Heap）：JVM管理的最大一块内存空间
 * 方法去（Method Area）：存储元信息。永久代（Permanent Generation）,从JDK1.8开始，已经彻底废弃了永久代，
 * 使用元空间（meta space）
 * 运行时常量池：方法区的一部分内容。
 * 直接内存：DIrect Memory
 *
 * @Date 2019/9/1 21:08
 * @Created by Zhangyichao
 */
public class MyTest1 {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];  // 出现一次Minor GC
    }
    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];  //直接分配在老年代中
    }


    public static void main(String[] args) throws InterruptedException {
        testPretenureSizeThreshold();
        Thread.sleep(60000);
    }


}
