package Servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Require_Message")
public class Require_Message extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
      String  id = request.getParameter("username");
        session.setAttribute("Admin_id",id);
        //Users u = new User();
        ArrayList<Users> users = new ArrayList<Users>();
        users = new Bean.AdminLogin().select_all_users();
        session.setAttribute("U_Message",users);
        ArrayList<String> dep = new ArrayList<String>();
        dep = new Bean.AdminLogin().select_all_department();
        session.setAttribute("String",dep);
        response.sendRedirect("/staffs.jsp");
    }
}

