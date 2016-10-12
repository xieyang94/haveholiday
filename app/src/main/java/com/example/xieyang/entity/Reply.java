package com.example.xieyang.entity;

/**
 * Created by Administrator on 2016/7/28.
 */
public class Reply {
    /**
     * 回复ID、账号（头像、姓名<外键>）、内容、时间、几楼、推送的条目ID
     */
    private int replyId;
    private User replyUser;
    private String replyContent;
    private String replyTime;
    private int replyFloor;
    private int pushedFestivalID;

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public User getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(User replyUser) {
        this.replyUser = replyUser;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public int getReplyFloor() {
        return replyFloor;
    }

    public void setReplyFloor(int replyFloor) {
        this.replyFloor = replyFloor;
    }

    public int getPushedFestivalID() {
        return pushedFestivalID;
    }

    public void setPushedFestivalID(int pushedFestivalID) {
        this.pushedFestivalID = pushedFestivalID;
    }
}
