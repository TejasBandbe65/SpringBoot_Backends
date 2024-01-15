package com.cms.dto;

import java.time.LocalDateTime;

public class BlogDto {
	
	private long Id;
	
	private String title;
	
	private String author;
	
	private String content;
	
	private String category;
	
	private long userId;
	
	private LocalDateTime updated_timestamp;
	
	private String image;
	
	

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public LocalDateTime getUpdated_timestamp() {
		return updated_timestamp;
	}

	public void setUpdated_timestamp(LocalDateTime updated_timestamp) {
		this.updated_timestamp = updated_timestamp;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BlogDto(long id, String title, String author, String content, String category, long userId,
			LocalDateTime updated_timestamp, String image) {
		super();
		Id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.category = category;
		this.userId = userId;
		this.updated_timestamp = updated_timestamp;
		this.image = image;
	}

	public BlogDto(String title, String author, String content, String category, long userId,
			LocalDateTime updated_timestamp, String image) {
		super();
		this.title = title;
		this.author = author;
		this.content = content;
		this.category = category;
		this.userId = userId;
		this.updated_timestamp = updated_timestamp;
		this.image = image;
	}

	public BlogDto() {
		super();
	}
	
	

}
