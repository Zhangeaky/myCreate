package com.zhangeaky.mycreate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCTest {


    public static void main(String[] args) {

        try {

            // 将mysql的驱动类注册到 DriverManager 的静态变量中。
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/zhangeaky?characterEncoding=utf-8",
                            "root",
                            "a1234567");

            Statement statement = connection.createStatement();

            boolean execute = statement.execute("insert into user values(894, 'yi', 38, 'asd')");

        } catch (Exception e) {
            e.printStackTrace();

        }



    }
}
