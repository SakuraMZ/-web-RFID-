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
@WebServlet(name = "Modify_Account")
public class Modify_Account extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id =request.getParameter("id");
        System.out.println(id);
       Users user =Bean.EmployeeLogin.select_users((id));
        session.setAttribute("User",user);
       String sign =request.getParameter("sign");
        if(sign.equals("1"))
        {
            response.sendRedirect("/E_accounts.jsp");
        }
        else
        response.sendRedirect("/accounts.jsp");
    }
}
