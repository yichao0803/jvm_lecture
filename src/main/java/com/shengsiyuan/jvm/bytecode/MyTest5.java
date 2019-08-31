package com.shengsiyuan.jvm.bytecode;

/**
 * @Classname MyTest5
 * @Description
 * 方法的静态分派
 * Grandpa g1 = new Father();
 * 以上代码，g1的静态类型是Grandpa，而g1的实际类型（真正指向的类型）是Father.
 * 我们可以得到结论：变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的（多态的一种体现），
 * 实际类型是在运行期才能确定。
 *
 * @Date 2019/8/31 14:01
 * @Created by Zhangyichao
 */
public class MyTest5 {
    // 方法重载，是一种静态的行为，编译期就可以完全确定。
    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }

    public void test(Son son){
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1=new Father();
        Grandpa g2=new Son();

        MyTest5 myTest5=new MyTest5();
        myTest5.test(g1);
        myTest5.test(g2);
    }
}

class  Grandpa{

}
class  Father extends Grandpa{

}

class  Son extends Father{

}

















