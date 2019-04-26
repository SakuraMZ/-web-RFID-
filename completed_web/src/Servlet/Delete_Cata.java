package Servlet;

import Bean.Security;
import Bean.EmployeeLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Delete_Cata")
public class Delete_Cata extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id =request.getParameter("id");
        Bean.AdminLogin.delete_cata((id));          //删除部门
        ArrayList<Users> users = new ArrayList<Users>();
        users = new Bean.AdminLogin().select_all_users();
        session.setAttribute("U_Message",users);
        ArrayList<String> dep = new ArrayList<String>();
        dep = new Bean.AdminLogin().select_all_department();
        session.setAttribute("String",dep);
        response.sendRedirect("/staffs.jsp");
    }
}
