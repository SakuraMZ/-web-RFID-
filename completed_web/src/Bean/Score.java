package Bean;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;

public class Score {
    private String stu_id;
    private String test_id;
    private String test_name;
    private int grade;
    private String stu_class;
    private String stu_name;

    public ArrayList<Score> select(Score u){
        ArrayList<Score> a1 = new ArrayList<Score>();
        try{
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String stu_id = u.getStu_id();
            String test_name = u.getTest_name();
            if (test_name.equals("all"))
            {
                String sql = "select Test_grade,Test_id,Test_name from score where Student_id ='" + stu_id + "'";
                rs = st.executeQuery(sql);
                while (rs.next())
                {   Score temp = new Score();
                    temp.setGrade(rs.getInt(1));
                    temp.setTest_id(rs.getString(2));
                    temp.setTest_name(rs.getString(3));
                    a1 .add(temp);
                }
            }
            else {
                String sql = "select Test_grade,Test_id from score where Student_id ='" + stu_id + "' AND Test_name ='" + test_name + "'";
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Score temp = new Score();
                    temp.setGrade(rs.getInt(1));
                    temp.setTest_id(rs.getString(2));
                    temp.setTest_name(u.getTest_name());
                    a1.add(temp);

                }
            }
            return a1;
        }catch (SQLException e){
            e.printStackTrace();
            return a1;
        }
    }

    public ArrayList<Score> classselect(Score u){
        ArrayList<Score> a1 = new ArrayList<Score>();
        try{
            DBConn con = new DBConn();
            Connection conn = con.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = null;
            String stu_class = u.getStu_class();
            String test_name = u.getTest_name();
            if (test_name.equals("all"))
            {
                String sql = "select Test_grade,Test_id,Test_name,Stu_name from score,student where score.Student_id =student.Stu_id AND student.Stu_class='"+stu_class+"'";
                rs = st.executeQuery(sql);
                while (rs.next())
                {   Score temp = new Score();
                    temp.setGrade(rs.getInt(1));
                    temp.setTest_id(rs.getString(2));
                    temp.setTest_name(rs.getString(3));
                    temp.setStu_name(rs.getString(4));
                    a1 .add(temp);
                }
            }
            else {
                String sql = "select Test_grade,Test_id,Stu_name from score,student where score.Student_id =student.Stu_id AND Test_name ='" + test_name + "' AND  student.Stu_class='"+stu_class+"'";
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    Score temp = new Score();
                    temp.setGrade(rs.getInt(1));
                    temp.setTest_id(rs.getString(2));
                    temp.setStu_name(rs.getString(3));
                    temp.setTest_name(u.getTest_name());
                    a1.add(temp);

                }
            }
            return a1;
        }catch (SQLException e){
            e.printStackTrace();
            return a1;
        }
    }

    public String LoadScore(Score u){

        try {
    DBConn con = new DBConn();
    Connection conn = con.getConn();
    Statement st = conn.createStatement();
    ResultSet rs = null;
    stu_name = u.getStu_name();
    stu_id = u.getStu_id();
    test_name = u.getTest_name();
    grade = u.getGrade();
    String sql = "UPDATE score SET Test_grade=? WHERE Test_name='"+test_name+"' AND Student_id='"+stu_id+"'";
            PreparedStatement ps =conn.prepareStatement(sql);
           ps.setInt(1,grade);
           ps.executeUpdate();
           ps.close();
           return "true";
}       catch (SQLException e){
            e.printStackTrace();
            return "fales";
        }
    }
    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public String getStu_class() {
        return stu_class;
    }

    public int getGrade() {
        return grade;
    }

    public String getStu_id() {
        return stu_id;
    }

    public String getTest_id() {
        return test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

}
