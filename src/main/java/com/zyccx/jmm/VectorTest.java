package com.zyccx.jmm;

import java.util.Vector;

/**
 * VectorTest
 *
 * @author by Zhangyichao
 * @date 2019/11/11 15:44
 * @see VectorTest
 */
public class VectorTest {
    private static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {
        do {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println((vector.get(i)));
                    }
                }
            });

            removeThread.start();
            printThread.start();

            //不要同时产生过多的线程，否则会导致操作系统假死
           // while () ;
        } while (Thread.activeCount() > 20);
    }
}
