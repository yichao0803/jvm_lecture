package com.shengsiyuan.jvm.bytecode;

import java.awt.*;
import java.security.PublicKey;

/**
 * @Classname MyTest6
 * @Description
 * 方法的动态分派
 * 方法的动态分派涉及到一个重要概念：方法接受者。
 * invokevirtual字节码指令的多态查找流程
 * 方法重载（overload）与方法重写（voerwrite）,我们可以得到这样的结论：
 * 方法重载是静态的，是编译期行为：方法重写是动态的，是运行期行为。
 *
 * @Date 2019/8/31 14:10
 * @Created by Zhangyichao
 */
public class MyTest6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit {
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {

    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}













