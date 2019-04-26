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
@WebServlet(name = "Modify_Admin_owncount")
public class Modify_Admin_owncount  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin user =Bean.AdminLogin.select_own((Temp.forever_id));
        session.setAttribute("Admin",user);
        response.sendRedirect("/A_accounts.jsp");
    }
}
