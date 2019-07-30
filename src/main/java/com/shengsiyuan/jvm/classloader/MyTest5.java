package com.shengsiyuan.jvm.classloader;

import javax.sound.midi.Soundbank;

/**
 * @Classname MyTest5
 * @Description
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有在真正使用到父类接口的时候（如引用接口所定义的常量是），才会初始化
 * @Date 2019/7/27 10:06
 * @Created by Zhangyichao
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }

}

interface MyGrandpa{
    public static Thread thread =new Thread(){
        {
            System.out.println("MyGrandpa invoked");
        }
    };
}

interface  MyParent5 {
    public static Thread thread=new Thread(){
        {
            System.out.println("MyParent5 invoked");
        }
    };
}
class  MyChild5 implements MyParent5{
    public static final  int b=5;
}
