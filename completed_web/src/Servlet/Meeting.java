package Servlet;

public class Meeting {
    private String Meeting_num;
//    private String Meeting_name;
    private String Meeting_time;
    private String Meeting_location;
    private String Meeting_desc;
    public static String meeting_num;
   // public void setMeeting_name(String Meeting_message) {
       // this.Meeting_name = Meeting_message;
 //   }
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

 //   public String getMeeting_name() {
  //      return Meeting_name;
 //   }

    public String getMeeting_time() {
        return Meeting_time;
    }
    public String getMeeting_num() {
        return Meeting_num;
    }
}
