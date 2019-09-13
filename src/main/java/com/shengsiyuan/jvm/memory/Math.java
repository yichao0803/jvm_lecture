package com.shengsiyuan.jvm.memory;

/**
 * @Classname Math
 * @Description TODO
 * @Date 2019/9/10 10:36
 * @Created by Zhangyichao
 */
public class Math {
    public static final Integer CONSTANT=666;
    public int math(){
        int a = 1;
        int b = 2;
        int c = (a+b)*10;
        return c;
    }

    public static void main(String[] args) {
        Math math=new Math();
        math.math();
    }
}
