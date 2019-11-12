package com.zyccx.jmm.lock;

import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * TODO
 *
 * @author by Zhangyichao
 * @date 2019/11/11 22:01
 * @see Test
 */
public class Test {
    static L l = new L();

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(Integer.toHexString(l.hashCode()));
        countHash(l);
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
        //lockTest();
    }

    static void lockTest() {
        synchronized (l) {
            System.out.println("test");
        }
    }

    static void countHash(Object object) throws
            IllegalAccessException, NoSuchFieldException {

        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Object object1 = field.get(null);
        Unsafe unsafe = (Unsafe) object1;

        long hashCode = 0;
        //  获取 Mark Word 中的每一个Byte进行计算
        for (long index = 7; index > 0; index--) {
            hashCode |= (unsafe.getByte(object, index) & 0xFF) << ((index - 1) * 8);
        }
        String code = Long.toHexString(hashCode);
        System.out.println("util--------------0x" + code);
    }
}
