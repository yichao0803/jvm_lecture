package com.shengsiyuan.jvm.memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Classname DirectMemoryOOM
 * @Description VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 * @Date 2019/9/13 22:31
 * @Created by Zhangyichao
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        do {
            unsafe.allocateMemory(_1MB);
        } while (true);
    }

}
