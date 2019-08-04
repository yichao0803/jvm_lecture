package com.shengsiyuan.jvm.classloader;

import  com.sun.crypto.provider.AESKeyGenerator;
/**
 * @Classname MyTest19
 * @Description MyTest19
 * 更改 扩展类加载器 加载目录，执行MyTest19
 * cd E:\Git\yichao0803\jvm_lecture\target\classes
 * java -Djava.ext.dirs=./ com.shengsiyuan.jvm.classloader.MyTest19
 * @Date 2019/8/4 14:27
 * @Created by Zhangyichao
 */
public class MyTest19 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator=new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());

    }

}
