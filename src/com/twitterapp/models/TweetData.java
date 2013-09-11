package com.twitterapp.models;

import java.io.Serializable;

public class TweetData implements Serializable {

	private static final long serialVersionUID = 4236358850885598795L;

	private long id;
	private String userName;
	private String tweet;
	private String userBackGroundImageURL;
	private String userProfileImageURL;
	private String jsonString;
	private String userString;

	public String getUserString() {
		return userString;
	}

	public void setUserString(String userString) {
		this.userString = userString;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUserBackGroundImageURL() {
		return userBackGroundImageURL;
	}

	public void setUserBackGroundImageURL(String userBackGroundImageURL) {
		this.userBackGroundImageURL = userBackGroundImageURL;
	}

	public String getUserProfileImageURL() {
		return userProfileImageURL;
	}

	public void setUserProfileImageURL(String userProfileImageURL) {
		this.userProfileImageURL = userProfileImageURL;
	}

}