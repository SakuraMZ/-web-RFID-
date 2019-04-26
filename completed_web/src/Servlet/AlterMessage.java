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

@WebServlet(name = "AlterMessage")
public class AlterMessage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String department, password, id, name;
        Users u = new Users();
        //  Security md=new Security();
        try {
            id = request.getParameter("id");
            name = request.getParameter("name");
            department  = request.getParameter("category");
            password = request.getParameter("password");
            //   password = md.md5Password(password);
            u.setUsername(id);
            u.setMypassword(password);
            u.setName(name);
            u.setDepartment(department);
            String result = new Bean.EmployeeLogin().alter(u);
            ArrayList<Users> users = new ArrayList<Users>();
            users = new Bean.AdminLogin().select_all_users();
            session.setAttribute("U_Message",users);
            ArrayList<String> dep = new ArrayList<String>();
            dep = new Bean.AdminLogin().select_all_department();
                response.sendRedirect("/staffs.jsp");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
