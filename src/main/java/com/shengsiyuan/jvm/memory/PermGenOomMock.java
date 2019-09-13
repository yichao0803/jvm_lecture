package com.shengsiyuan.jvm.memory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PermGenOomMock
 * @Description
 * 2、方法区
 * 方法区主要是存储类的元数据的，如虚拟机加载的类信息、编译后的代码等。JDK8之前方法区的实现是被称为一种“永久代”的区域，
 * 这部分区域使用JVM内存，但是JDK8的时候便移除了“永久代（Per Gen）”，转而使用“元空间（MetaSpace）”的实现，而且很大的
 * 不同就是元空间不在共用JVM内存，而是使用的系统内存，有个测试可以很容易的证明这一点——我们现在通过动态生成类来模
 * 拟 “PermGen space”的内存溢出：
 * 假设我们有这段程序：
 * jdk1.7
 * java -XX:PermSize=8m -XX:MaxPermSize=8m com.shengsiyuan.jvm.memory.PermGenOomMock
 * jdk1.8
 * java -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m com.shengsiyuan.jvm.memory.PermGenOomMock
 *
 * @Date 2019/9/1 22:06
 * @Created by Zhangyichao
 */
public class PermGenOomMock {
    public static void main(String[] args) {
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            do {
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("com.shengsiyuan.jvm.memory.MyTest1");
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
