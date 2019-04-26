package Servlet;

import Bean.AdminLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddEmployee")
public class AddEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String test_dep,test_name,test_pass,test_category,id;
       Users test = new Users();
        test_category = request.getParameter("category");
        test_name = request.getParameter("name");
        test_pass = request.getParameter("password");
        id = request.getParameter("id");
        test.setName(test_name);
        test.setMypassword(test_pass);
        test.setDepartment(test_category);
        test.setUsername(id);
        String result = new Bean.EmployeeLogin().select(test);
        if(result.equals("false")){             //数据库不含有该成员
            AdminLogin.insert(test);
            session.setAttribute("User",test);
            response.sendRedirect("/sign_up_successful.jsp");  //sendredirect 发送跳转的界面
            return;
        }
        else
            return;
    }
}
