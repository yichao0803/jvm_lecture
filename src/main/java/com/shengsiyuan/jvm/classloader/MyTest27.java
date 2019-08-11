package com.shengsiyuan.jvm.classloader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Classname MyTest27
 * @Description TODO
 * @Date 2019/8/10 20:48
 * @Created by Zhangyichao
 */
public class MyTest27 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb","username","password");
    }
}
