package com.cms.dto;

public class PasswordsDto {
	
	private long userId;
	
	private String oldPass;
	
	private String newPass;
	
	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	

	public PasswordsDto(long userId, String oldPass, String newPass) {
		super();
		this.userId = userId;
		this.oldPass = oldPass;
		this.newPass = newPass;
	}

	public PasswordsDto() {
		super();
	}
	
	
}
