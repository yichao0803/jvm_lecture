package com.shengsiyuan.jvm.memory;

import java.util.ArrayList;

/**
 * @Classname HeapTest
 * @Description TODO
 * @Date 2019/9/10 10:38
 * @Created by Zhangyichao
 */
public class HeapTest {
    byte[] a = new byte[1024 * 100];// 100KB

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests=new ArrayList<>();
        do {
            heapTests.add(new HeapTest());
            Thread.sleep(100);
        } while (true);
    }
}
