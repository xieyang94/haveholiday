package com.example.xieyang.entity;

public class ReplyItemContent {

	/**
	 * 实体类的内容： 推送节日ID【查找到当前节日的全部记录】 用户ID、（用户头像、用户姓名）【通过用户ID查找到】
	 * 回复ID、（回复内容、回复时间、楼层）【根据当前表记录的ID可查到】
	 */
	private int replyPushedFestivalID;
	private String replyUserID;
	private String replyUserHeadPicure;
	private String replyUserName;
	private int replyID;
	private String replyItemContent;
	private String replyUserTime;
	private int replyUserFloor;
	private String token;

	public ReplyItemContent() {
	}

	public ReplyItemContent(int replyPushedFestivalID, String replyUserID,
			String replyUserHeadPicure, String replyUserName, int replyID,
			String replyItemContent, String replyUserTime, int replyUserFloor) {
		super();
		this.replyPushedFestivalID = replyPushedFestivalID;
		this.replyUserID = replyUserID;
		this.replyUserHeadPicure = replyUserHeadPicure;
		this.replyUserName = replyUserName;
		this.replyID = replyID;
		this.replyItemContent = replyItemContent;
		this.replyUserTime = replyUserTime;
		this.replyUserFloor = replyUserFloor;
	}

	public int getReplyPushedFestivalID() {
		return replyPushedFestivalID;
	}

	public void setReplyPushedFestivalID(int replyPushedFestivalID) {
		this.replyPushedFestivalID = replyPushedFestivalID;
	}

	public String getReplyUserID() {
		return replyUserID;
	}

	public void setReplyUserID(String replyUserID) {
		this.replyUserID = replyUserID;
	}

	public String getReplyUserHeadPicure() {
		return replyUserHeadPicure;
	}

	public void setReplyUserHeadPicure(String replyUserHeadPicure) {
		this.replyUserHeadPicure = replyUserHeadPicure;
	}

	public String getReplyUserName() {
		return replyUserName;
	}

	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}

	public int getReplyID() {
		return replyID;
	}

	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}

	public String getReplyItemContent() {
		return replyItemContent;
	}

	public void setReplyItemContent(String replyItemContent) {
		this.replyItemContent = replyItemContent;
	}

	public String getReplyUserTime() {
		return replyUserTime;
	}

	public void setReplyUserTime(String replyUserTime) {
		this.replyUserTime = replyUserTime;
	}

	public int getReplyUserFloor() {
		return replyUserFloor;
	}

	public void setReplyUserFloor(int replyUserFloor) {
		this.replyUserFloor = replyUserFloor;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
