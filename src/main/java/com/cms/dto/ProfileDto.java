package com.cms.dto;

public class ProfileDto {
	
	private String image;
	
	private String name;
	
	private String email;
	
	private String message;
	
	private int status;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ProfileDto(String image, String name, String email, String message, int status) {
		super();
		this.image = image;
		this.name = name;
		this.email = email;
		this.message = message;
		this.status = status;
	}

	public ProfileDto() {
		super();
	}
	
	

}
