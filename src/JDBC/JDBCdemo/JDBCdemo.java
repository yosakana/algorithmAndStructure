package JDBC.JDBCdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //首先需要加载驱动进内存 5之后的版本可以不必加载进内存
        Class.forName("com.mysql.jdbc.Driver");

        //获取数据库的连接对象                                                           /数据库名
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "111111");
        //如果是默认端口和地址的话可以省略只写数据库
        Connection conntTest = DriverManager.getConnection("jdbc:mysql///db3", "root", "111111");

        //定义sql语句
        String sql = "update account set balance = 500 where id = 1";

        //获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        /**
         * 执行sql:
         *      1. boolean execute(String sql):可以执行任意的SQL
         *      2. int executeUpdate(String sql):执行DDL、DML语句
         *      3. ResultSet executeQuery(String sql):执行DQL
         */

        int count = stmt.executeUpdate(sql);
        //大于0则执行成功
        System.out.println(count);

        //释放资源
        stmt.close();
        conn.close();
    }
}
