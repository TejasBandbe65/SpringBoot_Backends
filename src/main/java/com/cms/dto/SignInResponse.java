package com.cms.dto;

public class SignInResponse {
	
	private String token;
	
	private String msg;
	
	private long userId;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public SignInResponse(String token, String msg, long userId) {
		super();
		this.token = token;
		this.msg = msg;
		this.userId = userId;
	}

	public SignInResponse() {
		super();
	}
	
	

}
