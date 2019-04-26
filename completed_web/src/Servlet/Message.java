package Servlet;

import Bean.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Message {
    private String username;
    private String name;
    private String Meeting_num;
    private String Meeting_time;
    private String Meeting_location;
    private String Meeting_desc;
    private String Department;
    private String status;
    public void setUsername(String adminname) {
        this.username = adminname;
    }
    public void setName(String adminname) {
        this.name = adminname;
    }

    public void setStatus(String birthday) {
        this.status = birthday;
    }

    public void setDepartment(String birthday) {
        this.Department = birthday;
    }
    public void setMeeting_time(String Meeting_time) {
        this.Meeting_time = Meeting_time;
    }
   public void setMeeting_num(String Meeting_num) {
        this.Meeting_num = Meeting_num;
   }
    public void setMeeting_location(String Meeting_time) {
        this.Meeting_location = Meeting_time;
    }
    public void setMeeting_desc(String Meeting_num) {
        this.Meeting_desc = Meeting_num;
    }

    public String getMeeting_location() {
        return Meeting_location;
    }
    public String getMeeting_desc() {
        return Meeting_desc;
    }

    public String getMeeting_time() {
        return Meeting_time;
    }



    public String getDepartment() {
        return Department;
    }

    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public String getMeeting_num() {
        return Meeting_num;
    }

    public String getStatus() {
        return status;
    }

}
