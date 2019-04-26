package Servlet;

import Bean.Security;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Alter_A_Message")
public class Alter_A_Message extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String department, password, id, name;
        Admin u = new Admin();
        //  Security md=new Security();
        try {
            id = request.getParameter("id");
            name = request.getParameter("name");
    password = request.getParameter("password");
            //   password = md.md5Password(password);
            u.setUsername(id);
            u.setMypassword(password);
            u.setName(name);
            String result = new Bean.AdminLogin().alter(u,password);
            if (result.equals("true")) {
                session.setAttribute("User",u);
                response.sendRedirect("/A_accounts_successful.jsp");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
