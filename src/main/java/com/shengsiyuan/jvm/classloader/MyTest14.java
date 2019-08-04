package com.shengsiyuan.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @Classname MyTest14
 * @Description MyTest14
 * @Date 2019/7/31 23:16
 * @Created by Zhangyichao
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

        String resourceName="com/shengsiyuan/jvm/classloader/MyTest10.class";

        Enumeration<URL> urlEnumeration=classLoader.getResources(resourceName);

        while (urlEnumeration.hasMoreElements()){
            URL url=urlEnumeration.nextElement();
            System.out.println(url);
        }

    }
}
