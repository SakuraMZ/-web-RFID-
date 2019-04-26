package Bean;
import Servlet.*;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeLogin {
    public String select(Users user) {
        try{
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String id = user.getUsername();
            String pass = user.getMypassword();
            String sql = "select * from users where Username ='" + id + "'";
            rs = st.executeQuery(sql);
            while ((rs.next())) {    //与数据库的内容进行对比
                if (id.equals(rs.getString(1)) && pass.equals(rs.getString(3))) {
                    return "true";
                } else {
                    return "false";
                }
            }
            return "false";
        } catch (SQLException e) {
            e.printStackTrace();
            return "false";
        }
    }
    public static  ArrayList<Message>  select_all_status(String  id) {
        ArrayList<Message> a1 = new ArrayList<Message>();
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = " select MMeeting_num,Meeting_time,Meeting_message,status from meeting_record,meeting where MMeeting_num=Meeting_Num  and M_Username ='"+ id + "'"  ;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Message temp = new Message();
                temp.setMeeting_num(rs.getString(1));
                temp.setMeeting_time(rs.getString(2));
                temp.setMeeting_desc(rs.getString(3));
                temp.setStatus(rs.getString(4));
                a1.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a1;
    }
    public static  Users  select_users(String id ) {
        Users temp = new Users();
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = "select Username,Name,Password,Department  from users where Username ='" + id + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                temp.setUsername(rs.getString(1));
                temp.setName(rs.getString(2));
                temp.setMypassword(rs.getString(3));
                temp.setDepartment(rs.getString(4));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }
    public String alter(Users user){            //允许修改密码

        try{
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String id = user.getUsername();
            String password = user.getMypassword();
            String depart = user.getDepartment();
            String sql="UPDATE users set Password=? ,Department=?  WHERE  Username='" +id+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setString(2,depart);
            ps.executeUpdate();
            System.out.println("修改成功");
            ps.close();
            conn.close();
            System.out.println("数据修改成功");
            return "true";
                }catch (SQLException e){
            e.printStackTrace();
            return  "false";
        }
    }

}
