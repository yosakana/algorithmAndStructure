package JDBC.JDBC工具类;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class util {
    /**
     * 静态代码块:随着类的加载而加载，而执行，只会执行一次
     */
    private static String url;
    private static String user;
    private static String password;
    static{
        //读取资源文件，获取值
        //1.Properties集合类
        try {
            Properties pro = new Properties();

            //获取src文件路径下的文件的方式 ClassLoader类加载器
            ClassLoader classLoader = util.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();

            //读取properties文件的路径
            pro.load(new FileReader(path));

            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");

            try {
                Class.forName(pro.getProperty("drive"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(String url , String user , String password) throws SQLException {
        return DriverManager.getConnection(url , user , password);
    }

    //关闭流的实现类
    public static void close(Connection conn, Statement stmt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //重载实现查询流的关闭
    public static void close(ResultSet rs , Connection conn, Statement stmt) {
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
