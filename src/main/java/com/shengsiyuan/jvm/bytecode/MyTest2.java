package com.shengsiyuan.jvm.bytecode;

import com.shengsiyuan.jvm.classloader.MyTest3;

/**
 * @Classname MyTest2
 * @Description TODO
 * @Date 2019/8/31 13:23
 * @Created by Zhangyichao
 */
public class MyTest2 {
    String str="Welcome";
    private int x=5;
    public static  Integer in =10;
    public MyTest2(){

    }

    public static void main(String[] args) {
        MyTest2 myTest2=new MyTest2();
        myTest2.setX(8);

        in=20;
    }
    public synchronized void setX(int x) {
        this.x = x;
    }

    public  void Test(){
        synchronized (str){
            System.out.println("hello world");
        }
    }
}
