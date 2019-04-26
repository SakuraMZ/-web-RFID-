package Bean;
import java.sql.*;
import java.security.*;
import java.sql.Connection;
import java.sql.SQLException;
public class Select {
public static void main(String []args){

    try{
        DBConn con = new DBConn();
        Connection conn = con.getConn();
        Statement st = conn.createStatement();
        ResultSet rs = null;
	 String sql = "SELECT id, password FROM passwd where id=2016200";
     rs = st.executeQuery(sql);
     Security md=new Security();
     while(rs.next()){
         int id  = rs.getInt("id");
          String pd = rs.getString("password");
          String  y=md.md5Password("woma");
         System.out.print("ID: " + id+"\n");
         System.out.print( pd+"\n"  );
         System.out.print(y+"\n");
         if(pd.equals(y))
        	 System.out.print("ok"+"\n");
     }
     rs.close();
     st.close();
     conn.close();
 }catch(SQLException se){

    se.printStackTrace();
}catch(Exception e){
    e.printStackTrace();
}
}
}
