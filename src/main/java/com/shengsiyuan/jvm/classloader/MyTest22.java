package com.shengsiyuan.jvm.classloader;

/**
 * @Classname MyTest22
 * @Description 扩展类加载器（sun.misc.Launcher$ExtClassLoader），只能加载jar包内class文件
 * 在编译输出目录Class下执行以下命令
 * 首先执行：java -Djava.ext.dirs=./ com.shengsiyuan.jvm.classloader.MyTest22
 * 打包class文件：jar cvf test.jar com\shengsiyuan\jvm\classloader\MyTest1.class
 * 再执行命令：java -Djava.ext.dirs=./ com.shengsiyuan.jvm.classloader.MyTest22
 * 首次执行后 没有使用扩展类加载MyTest1， 打包后使用了扩展类加载器加载MyTest1
 * @Date 2019/8/4 23:08
 * @Created by Zhangyichao
 */
public class MyTest22 {
    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }
}
