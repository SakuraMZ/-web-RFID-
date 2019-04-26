package Servlet;

import java.util.Date;

//用户实体类
public class Users {

    private String username; //用户名
    private String mypassword; //密码
    private String name; //用户名称
    private String Department; //用户名称
    private String meeting; //会议名称
    private int signal1; //是否签到
    private int signal2; //会议是否早退

    public Users()
    {

    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getMypassword() {
        return mypassword;
    }
    public void setMypassword(String mypassword) {
        this.mypassword = mypassword;
    }
    public String getName() {
        return name;
    }
    public void setName(String id) {
        this.name = id;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String id) {
        this.Department = id;
    }
    public int getSignal1() {
        return signal1;
    }
    public void setSignal1(int id) {
        this.signal1 = id;
    }
    public int getSignal2() {
        return signal2;
    }
    public void setSignal2(int id) {
        this.signal2 = id;
    }
}
