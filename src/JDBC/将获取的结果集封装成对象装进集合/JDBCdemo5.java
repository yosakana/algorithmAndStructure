package JDBC.将获取的结果集封装成对象装进集合;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询所有Emp对象
 */
public class JDBCdemo5 {
    public static void main(String[] args) {
        List<Emp> list = new ArrayList<>();
        System.out.println(list);
    }

    public static List<Emp> findAll(){
        //先按照步骤写查询的语句块
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> emps = new ArrayList<Emp>();
        try{
            String sql = "select * from 表";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "111111");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            Emp EmpObj = null;

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");

                //因为每次循环都new了一块新的内存，所以即使名字相同，内存地址也不同，是不同的对象
                EmpObj = new Emp();

                EmpObj.setId(id);
                EmpObj.setName(name);
                rs.next();
                emps.add(EmpObj);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return emps;
    }
}
