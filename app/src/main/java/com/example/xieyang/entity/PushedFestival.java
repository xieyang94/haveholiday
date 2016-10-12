package com.example.xieyang.entity;

public class PushedFestival {

	/**
	 * 条目ID、条目图片、简单文字标题、内容背景图片、内容简单文字说明、主要内容、回复ID、回复数量、点赞数量、点赞状态、条目推送时间
	 */
	private int pushedFestivalId;
	private String pushedFestivalItemPicture;
	private String pushedFestivalTitle;
	private String pushedFestivalContentBg;
	private String pushedFestivalContentTitle;
	private String pushedFestivalContent;
	private String pushedFestivalContent2;
	private String pushedFestivalContent3;
	private String pushedFestivalContent4;
	private String pushedFestivalContent5;
	private String pushedFestivalContent6;
	private String pushedFestivalContent7;
	private String replyID;// 回复表的推送ID为当前ID记录数量
	private int replyCount;// 查询回复表有多少条记录
	private int likeState;// 点赞状态
	private int likeCount;// 点赞数量
	private String pushFestivalTime;

	public PushedFestival() {
	}

	public int getPushedFestivalId() {
		return pushedFestivalId;
	}

	public void setPushedFestivalId(int pushedFestivalId) {
		this.pushedFestivalId = pushedFestivalId;
	}

	public String getPushedFestivalItemPicture() {
		return pushedFestivalItemPicture;
	}

	public void setPushedFestivalItemPicture(String pushedFestivalItemPicture) {
		this.pushedFestivalItemPicture = pushedFestivalItemPicture;
	}

	public String getPushedFestivalTitle() {
		return pushedFestivalTitle;
	}

	public void setPushedFestivalTitle(String pushedFestivalTitle) {
		this.pushedFestivalTitle = pushedFestivalTitle;
	}

	public String getPushedFestivalContentBg() {
		return pushedFestivalContentBg;
	}

	public void setPushedFestivalContentBg(String pushedFestivalContentBg) {
		this.pushedFestivalContentBg = pushedFestivalContentBg;
	}

	public String getPushedFestivalContentTitle() {
		return pushedFestivalContentTitle;
	}

	public void setPushedFestivalContentTitle(String pushedFestivalContentTitle) {
		this.pushedFestivalContentTitle = pushedFestivalContentTitle;
	}

	public String getPushedFestivalContent() {
		return pushedFestivalContent;
	}

	public void setPushedFestivalContent(String pushedFestivalContent) {
		this.pushedFestivalContent = pushedFestivalContent;
	}

	public String getPushedFestivalContent2() {
		return pushedFestivalContent2;
	}

	public void setPushedFestivalContent2(String pushedFestivalContent2) {
		this.pushedFestivalContent2 = pushedFestivalContent2;
	}

	public String getPushedFestivalContent3() {
		return pushedFestivalContent3;
	}

	public void setPushedFestivalContent3(String pushedFestivalContent3) {
		this.pushedFestivalContent3 = pushedFestivalContent3;
	}

	public String getPushedFestivalContent4() {
		return pushedFestivalContent4;
	}

	public void setPushedFestivalContent4(String pushedFestivalContent4) {
		this.pushedFestivalContent4 = pushedFestivalContent4;
	}

	public String getPushedFestivalContent5() {
		return pushedFestivalContent5;
	}

	public void setPushedFestivalContent5(String pushedFestivalContent5) {
		this.pushedFestivalContent5 = pushedFestivalContent5;
	}

	public String getPushedFestivalContent6() {
		return pushedFestivalContent6;
	}

	public void setPushedFestivalContent6(String pushedFestivalContent6) {
		this.pushedFestivalContent6 = pushedFestivalContent6;
	}

	public String getPushedFestivalContent7() {
		return pushedFestivalContent7;
	}

	public void setPushedFestivalContent7(String pushedFestivalContent7) {
		this.pushedFestivalContent7 = pushedFestivalContent7;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getReplyID() {
		return replyID;
	}

	public void setReplyID(String replyID) {
		this.replyID = replyID;
	}

	public int getLikeState() {
		return likeState;
	}

	public void setLikeState(int likeState) {
		this.likeState = likeState;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getPushFestivalTime() {
		return pushFestivalTime;
	}

	public void setPushFestivalTime(String pushFestivalTime) {
		this.pushFestivalTime = pushFestivalTime;
	}

}
