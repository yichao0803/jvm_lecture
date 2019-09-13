package com.shengsiyuan.jvm.memory;

/**
 * @Classname RuntimeConstantPoolOOM
 * @Description TODO
 * @Date 2019/9/13 22:28
 * @Created by Zhangyichao
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
