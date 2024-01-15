package com.cms.dto;

public class CommDto {
	
	private long id;
	
	private String name;
	
	private String comment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public CommDto(long id, String name, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.comment = comment;
	}

	public CommDto() {
		super();
	}

}
