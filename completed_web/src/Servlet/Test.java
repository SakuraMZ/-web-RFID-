package Servlet;

import Bean.DBConn;

import java.sql.*;
import java.util.ArrayList;
public class Test {
    private String Test_id;
    private String Test_name;
    private String Test_date;
    private String Test_room;

    public ArrayList<Test> select(String stu_id){
        ArrayList<Test> a1 = new ArrayList<Test>();
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = "SELECT * FROM test WHERE Test_id IN (SELECT Test_id FROM student WHERE Stu_id='"+stu_id+"')";
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                Test temp = new Test();
                temp.setTest_id(rs.getString(1));
                temp.setTest_name(rs.getString(2));
                temp.setTest_date(rs.getString(3));
                temp.setTest_room(rs.getString(1)+"区");
                a1.add(temp);
            }
            return a1;
        }catch (SQLException e){
            e.printStackTrace();
            return a1;
        }
    }

    public ArrayList<Test> selectall(){
        ArrayList<Test> a1 = new ArrayList<Test>();
        try {
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql = "SELECT * FROM test";
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                Test temp = new Test();
                temp.setTest_id(rs.getString(1));
                temp.setTest_name(rs.getString(2));
                temp.setTest_date(rs.getString(3));
                temp.setTest_room(rs.getString(1)+"区");
                a1.add(temp);
            }
            return a1;
        }catch (SQLException e){
            e.printStackTrace();
            return a1;
        }
    }

    public String add(Test test) {
        DBConn con = new DBConn();
        Connection conn = con.getConn();
        String sql= "INSERT INTO test(Test_id,Test_name,Test_date) VALUES (?,?,?)";
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,test.getTest_id());
            ps.setString(2,test.getTest_name());
            ps.setString(3,test.getTest_date());
            ps.executeUpdate();
            System.out.println("数据成功插入到数据库中");
            return "true";
        }catch (SQLException e){
            e.printStackTrace();
            return "false";
        }
    }

    public String delete(String test_id){
        try {

            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String sql="DELETE FROM test WHERE  Test_id ='" +test_id+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            conn.close();
            System.out.println("数据修改成功");
            return "true";

        }catch (SQLException ex){
            ex.printStackTrace();
            return "false";
        }
    }

    public void setTest_name(String test_name) {
        Test_name = test_name;
    }

    public void setTest_id(String test_id) {
        Test_id = test_id;
    }

    public String getTest_name() {
        return Test_name;
    }

    public String getTest_id() {
        return Test_id;
    }

    public String getTest_date() {
        return Test_date;
    }

    public String getTest_room() {
        return Test_room;
    }

    public void setTest_date(String test_date) {
        Test_date = test_date;
    }

    public void setTest_room(String test_room) {
        Test_room = test_room;
    }
}
