package com.cms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String comment;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="blog_id")
	private Blog blog;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;

	public Comment(String comment, Blog blog, User user) {
		super();
		this.comment = comment;
		this.blog = blog;
		this.user = user;
	}

	public Comment() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
