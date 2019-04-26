package Servlet;

import Bean.Security;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Servlet.Login")
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    HttpSession session = request.getSession();
    Users users= new Users();
    Security md=new Security();
    String id,password,idtype;
    id = request.getParameter("username");
    password = request.getParameter("password");
    idtype = request.getParameter("idtype");
    users.setUsername(id);
    users.setMypassword(password);
    //判断登录的方式
    if ("employee".equals(idtype))
    {
        //判断密码是否正确
        String result = new Bean.EmployeeLogin().select(users);
        if(result.equals("true")){
            Temp.forever_id=id;
            ArrayList<Message> user = new ArrayList<Message>();
            user = new Bean.EmployeeLogin().select_all_status(id);
            session.setAttribute("Employee_Meeting",user);
            response.sendRedirect("/Employee.jsp");  //sendredirect 发送跳转的界面
            return;
        }
        else
        {
            response.sendRedirect("/LoginFailure.jsp");
        }
    }
    else if ("admin".equals(idtype))
    {

        String result = new Bean.AdminLogin().select(users);
        if(result.equals("true")){
           ArrayList<Message> user = new ArrayList<Message>();
            user = new Bean.AdminLogin().select_all_status();
            Temp.forever_id=id;
            session.setAttribute("Admin_Message",user);
            response.sendRedirect("/Admin.jsp");
            //response.sendRedirect("/Admin.jsp");
        }
        else
        {
            response.sendRedirect("/LoginFailure.jsp");
        }
    }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }
}
