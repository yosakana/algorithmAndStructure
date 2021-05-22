package JDBC.JDBCdemo;

import java.sql.*;

public class JDBCdemo4 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "";
            conn = DriverManager.getConnection("jdbc:mysql:///db3");
            stmt = conn.createStatement();

            //查询出的结果集
            rs = stmt.executeQuery(sql);
            //本质上是一个游标依次遍历每一行
            while (rs.next()) {

                /**
                 * 从每一行获取属性的值
                 *      1.可以通过属性的下标进行取值(**从1开始**)
                 *      2.也可以通过属性名
                 */
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balacne = rs.getDouble(3);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (rs != null) {
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

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
