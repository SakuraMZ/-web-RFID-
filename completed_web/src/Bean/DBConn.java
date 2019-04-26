package Bean;

import java.sql.*;

public class DBConn {
        Connection Conn;

    public Connection getConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/web?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT%2B8";
            Conn = DriverManager.getConnection(url,"root","123456");

            System.out.println("数据库连接成功");
        }catch (ClassNotFoundException e){
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }catch (SQLException e){
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
        return  Conn;
    }
}
