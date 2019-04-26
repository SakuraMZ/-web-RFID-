package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;



public class Insert {
	
   public static boolean method(){
        boolean result = false;
        Security md=new Security();
       DBConn con = new DBConn();
       Connection conn = con.getConn();
             try {

             String password=md.md5Password("mzz25");
             String sqlInset = "INSERT INTO `passwords` VALUES (?, ?)";
             PreparedStatement stmt = conn.prepareStatement(sqlInset);
             
             stmt.setString(1, "20161000453");
             stmt.setString(2, password);
            // stmt.setInt(3, emp.getEmpAge());
            // stmt.setString(4, emp.getEmpSex());
             int i = stmt.executeUpdate();
             if (i == 1) {
                return true;
             }
             } catch (SQLException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             } finally {
                 try {
                     conn.close();
                 } catch(SQLException e) {
                     e.printStackTrace();
                 }
             }
             return false;
             
   }
   public static void main(String[] args) {    //���������ݿ�ı��в���Ԫ�صķ���
        Insert emp = new Insert();
        
        boolean res =emp.method();;
        if (res == true) {
            System.out.println("��pad���в������ݳɹ�");
        } else {
            System.out.println("��pad���в�������ʧ��");
        }
    }
    
}