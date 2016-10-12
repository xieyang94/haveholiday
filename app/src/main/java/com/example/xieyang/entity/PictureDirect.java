package com.example.xieyang.entity;

public class PictureDirect {
	private String pictureNumber;
	private String pictureUrl;
	
	public PictureDirect() {
	}
	
	public PictureDirect(String pictureNumber, String pictureUrl) {
		super();
		this.pictureNumber = pictureNumber;
		this.pictureUrl = pictureUrl;
	}

	public String getPictureNumber() {
		return pictureNumber;
	}
	public void setPictureNumber(String pictureNumber) {
		this.pictureNumber = pictureNumber;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	
	

}
