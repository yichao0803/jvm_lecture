package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MyTest2
 * @Description
 * 本示例演示了
 * 2、连接
 * （2）准备 为类的静态变量分配内存，并将其初始化为默认值
 * 注意事项第三条
 * ③ 如果类字段的字段属性表中存在ConstantValue属性，即同时被final和static修饰，
 * 那么在准备阶段变量value就会被初始化为ConstantValue属性所指定的值。
 * 假设上面的类变量value被定义为： public static final int value = 3；
 * 编译时Javac将会为value生成ConstantValue属性，在准备阶段虚拟机就会根据ConstantValue的设置将value赋值为3。
 * 我们可以理解为static final常量在编译期就将其结果放入了调用它的类的常量池中
 * **********************************************************************
 *  常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中。
 *  本质上，调用类并并没有直接引用到定义常量的类，因此不会触发
 *  定义常量的类的初始化
 *  注意：这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与MyParent2就没有任何关系了
 *  甚至，我们可以将MyParent2的class文件删除
 *
 *  助记符：
 *  ldc表示将int,float或是String类型的常量值从常量池中推送至栈顶
 *  bipush表示将单字节（-128 ~127）的常量值推送至栈顶
 *  sipush表示将一个短整型常量值（-32768~32767）推送至栈顶
 *  iconst_1 表示将int类型1推送至栈顶（icont_m1~iconts_5）
 * @Date 2019/7/25 13:08
 * @Created by Zhangyichao
 */
public class MyTest2 {
    private static final String str1="********";
    public static void main(String[] args) {
        System.out.println(MyPatient2.str);
        System.out.println(str1);
        System.out.println(MyPatient2.i);
        System.out.println(str1);
        System.out.println(MyPatient2.ii);
        System.out.println(str1);
        System.out.println(MyPatient2.iii);
    }
}

class  MyPatient2{
    public static final String str="Hello World";
    public static final int i=127;
    public static final int ii=128;
    public static final int iii=1;
    static {
        System.out.println("MyPatient2 static bolck");
    }
}
