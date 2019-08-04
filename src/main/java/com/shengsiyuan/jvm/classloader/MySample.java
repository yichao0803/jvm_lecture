package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MySample
 * @Description MySample
 * @Date 2019/8/4 13:09
 * @Created by Zhangyichao
 */
public class MySample {
    public  MySample(){
        System.out.println("MySamlple is loader by ："+this.getClass().getClassLoader());

        new MyCat();

        System.out.println("from MySample ："+MyCat.class);
        System.out.println("from MySample ："+MyCat.class.hashCode());

    }
}
