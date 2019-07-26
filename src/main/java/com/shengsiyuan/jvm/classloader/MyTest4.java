package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MyTest4
 * @Description
 * 对于数组实例来说，其类型是由JVM在运行期间动态生成的，表示[
 * 这种形式，动态生成的类型，其父类型就是Object。
 *
 * 对于数组来说，JavaDoc经常将构成数组的元素为Component，实际上就是将数组降低一个维度后的类型。
 *
 * 助记符：
 * anewarray：表示创建一个引用类型（如类，接口，数组）的数组，并将其引用值压入栈顶
 * newarray：表示创建一个指定的原始类型（如int，float,char）的数组，并将其引用值压入栈顶
 * @Date 2019/7/25 13:08
 * @Created by Zhangyichao
 */
public class MyTest4 {
    private static String str="******";
    public static void main(String[] args) {
        MyPatient4[] myPatient4s=new MyPatient4[1];
        System.out.println(myPatient4s.getClass());
        System.out.println(myPatient4s.getClass().getSuperclass());

        MyPatient4[][] myPatient4s1=new MyPatient4[2][2];
        System.out.println(myPatient4s1.getClass());
        System.out.println(myPatient4s1.getClass().getSuperclass());

        MyPatient4[][] myPatient4s2=new MyPatient4[1][1];
        System.out.println(myPatient4s2.getClass());
        System.out.println(myPatient4s2.getClass().getSuperclass());

        System.out.println(str);
        int[] ints=new int[2];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        System.out.println(str);
    }
}

class  MyPatient4{
    static {
        System.out.println("MyPatient4 static bolck");
    }
}