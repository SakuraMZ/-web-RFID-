package Servlet;
import Bean.AdminLogin;
import Servlet.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Add_Meeting")
public class Add_Meeting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String  test_name,description,id,start_time,locate;
        Meeting test = new Meeting();
        id = request.getParameter("id");
       test_name = request.getParameter("name");
        start_time = request.getParameter("expire_date");
        locate = request.getParameter("stock");
        description = request.getParameter("description");
        test.setMeeting_num(id);
        test.setMeeting_time(start_time);
        test.setMeeting_desc(description);
        test.setMeeting_location(locate);
        String result = new Bean.AdminLogin().select_meeting(id);
        if(result.equals("false")){             //数据库不含有该成员
            AdminLogin.insert_meeting(test);
            ArrayList<Meeting> users = new ArrayList<Meeting>();
            users = new Bean.AdminLogin().select_all_meeting();
            session.setAttribute("Meeting",users);
            response.sendRedirect("/A_references.jsp");  //sendredirect 发送跳转的界面
            return;
        }
        else
            return;
    }
}
