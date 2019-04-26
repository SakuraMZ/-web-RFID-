package Servlet;
import Servlet.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Delete_Meeting")
public class Delete_Meeting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id =request.getParameter("num");
        new Bean.AdminLogin().delete_meeting(id);
        ArrayList<Meeting> users = new ArrayList<Meeting>();
        users = new Bean.AdminLogin().select_all_meeting();
        session.setAttribute("Meeting",users);
        response.sendRedirect("/A_references.jsp");
    }
}

