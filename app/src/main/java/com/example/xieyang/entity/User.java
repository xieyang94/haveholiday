package com.example.xieyang.entity;

/**
 * Created by Administrator on 2016/7/28.
 */
public class User {
    /**
     * id，邮箱，密码，姓名，性别，头像，注册时间，生日，星座，所在地，籍贯
     */
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userSex;
    private String userHeadpicture;//头像
    private String userRegisttime;
    private String userBirthday;
    private String userConstellation;//星座
    private String userLocation;//所在地    ---->保留
    private String userNativeplace;//籍贯  ---->保留
//    private int userState;
    private String token;

    public User(){}
    public User(String userPassword, String Email) {
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }



    public String getUserConstellation() {
        return userConstellation;
    }

    public void setUserConstellation(String userConstellation) {
        this.userConstellation = userConstellation;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserHeadpicture() {
        return userHeadpicture;
    }

    public void setUserHeadpicture(String userHeadpicture) {
        this.userHeadpicture = userHeadpicture;
    }

    public String getUserRegisttime() {
        return userRegisttime;
    }

    public void setUserRegisttime(String userRegisttime) {
        this.userRegisttime = userRegisttime;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

//    public int getUserState() {
//        return userState;
//    }
//
//    public void setUserState(int userState) {
//        this.userState = userState;
//    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                ", userPassword='" + userPassword + '\'' +
                ", userEMail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userHeadpicture='" + userHeadpicture + '\'' +
                ", userRegisttime='" + userRegisttime + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userConstellation='" + userConstellation + '\'' +
                ", userLocation='" + userLocation + '\'' +
                ", userNativeplace='" + userNativeplace + '\'' +
                '}';
    }
}
