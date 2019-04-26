package Bean;
import Servlet.Meeting;
import Servlet.Message;
import Servlet.Users;
import Servlet.Admin;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class AdminLogin {
    public static String select(Users user) {
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String id = user.getUsername();
            String pass = user.getMypassword();
            String sql = "select * from admini where Admin_id ='" + id + "'";
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
    public static String select_meeting(String id) {
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = "select * from meeting where Meeting_num ='" + id + "'";
            rs = st.executeQuery(sql);
            while ((rs.next())) {    //与数据库的内容进行对比
                if (id.equals(rs.getString(1)) ) {
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

    public static Admin select_own(String id) {
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            Admin user=new Admin();
            String sql = "select * from admini where Admin_id ='" + id + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {

                user.setUsername(rs.getString(1));
                user.setName(rs.getString(2));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void delete_user(String id) {
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = "DELETE FROM users WHERE Username='" + id + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("数据修改成功");
        }
        catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static void delete_cata(String cata) {
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = "DELETE FROM users WHERE Department='" + cata + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("数据修改成功");
        }
        catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static void delete_meeting(String id) {
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = "DELETE FROM meeting WHERE MMeeting_num='" + id + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("数据修改成功");
        }
        catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static String insert(Users user) {
        DBConn con = new DBConn();
        Connection conn = con.getConn();
        String sql = "INSERT INTO users(Username, Name, Password,Department)  VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getName());
            ps.setString(3, user.getMypassword());
            ps.setString(4, user.getDepartment());
            ps.executeUpdate();
            System.out.println("数据成功插入到数据库中");
            return "true";
        } catch (SQLException e) {
            e.printStackTrace();
            return "false";
        }
    }

    public static String insert_meeting(Meeting user) {
        DBConn con = new DBConn();
        Connection conn = con.getConn();
        String sql = "INSERT INTO meeting(MMeeting_num, Meeting_message, Meeting_time,Meeting_location)  VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getMeeting_num());
            ps.setString(2, user.getMeeting_desc());
            ps.setString(3, user.getMeeting_time());
            ps.setString(4, user.getMeeting_location());
            ps.executeUpdate();
            System.out.println("数据成功插入到数据库中");
            return "true";
        } catch (SQLException e) {
            e.printStackTrace();
            return "false";
        }
    }


    public static String alter(Admin user, String password) {

        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String id = user.getUsername();
            String pass = user.getMypassword();
            String sql = "UPDATE admini set Admni_paasswd=? WHERE Admin_id ='" + id + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("数据修改成功");
            return "true";
        } catch (SQLException e) {
            e.printStackTrace();
            return "false";
        }
    }
    public static  ArrayList<Users>  select_all_users( ) {
        ArrayList<Users> a1 = new ArrayList<Users>();
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = "select Username,Name,Department from users" ;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Users temp = new Users();
                temp.setUsername(rs.getString(1));
                temp.setName(rs.getString(2));
                temp.setDepartment(rs.getString(3));
                a1.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a1;
    }
    public static  ArrayList<String>  select_all_department( ) {
        ArrayList<String> a1 = new ArrayList<String>();
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = "select distinct Department from users group by Department  ";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                a1.add(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a1;
    }
    public ArrayList<Meeting> select_all_meeting() {
        ArrayList<Meeting> a1 = new ArrayList<Meeting>();
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = "select  MMeeting_num,Meeting_time,Meeting_message,Meeting_location from meeting";;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Meeting temp = new Meeting();
                temp.setMeeting_num(rs.getString(1));
                temp.setMeeting_time(rs.getString(2));
                temp.setMeeting_desc(rs.getString(3));
                temp.setMeeting_location(rs.getString(4));
                a1.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return a1;
        }
        return a1;
    }
    public ArrayList<Message> select_all_status() {
        ArrayList<Message> a1 = new ArrayList<Message>();
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = "select Meeting_Num,Username,Name,Department,status from users,meeting_record where Username=M_Username";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Message temp = new Message();
                temp.setMeeting_num(rs.getString(1));
                temp.setUsername(rs.getString(2));
                temp.setName(rs.getString(3));
                temp.setDepartment(rs.getString(4));
                temp.setStatus(rs.getString(5));
                a1.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return a1;
        }
        return a1;
    }
    public    static  String getRandomString(){
//用一个String泛型的List来存放10个长度为10以内的随机整数的随机字符串
        String stringList="2016";
        Random random=new Random();
        int k;
        for(int i=0;i<7;i++){
            //产生10以内的随机整数
            k=random.nextInt(10);

            stringList+=(String.valueOf(k));
        }
        return stringList;
    }

}
    /*public String getAdminname() {
        return adminname;
    }

    public String getPassword() {
        return password;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }*/

