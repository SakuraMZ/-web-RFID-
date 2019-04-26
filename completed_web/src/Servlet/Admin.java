package Servlet;

import java.util.Date;

//管理员实体类
public class Admin {

    private String username; //用户名
    private String mypassword; //密码
    private String name; //用户名称
    public Admin()
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

}
