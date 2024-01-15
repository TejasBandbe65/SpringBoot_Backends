package com.cms.models;

import java.time.LocalDateTime;

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
@Table(name = "blogs")
public class Blog {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Column(nullable = false, length = 30)
	private String author;
	
	@Column(nullable = false)
	private LocalDateTime updated_timestamp;
	
	@Column(columnDefinition = "MEDIUMTEXT", nullable = false)
	private String content;
	
	@Column(nullable = false, length = 20)
	private String category;
	
	@Column(nullable = false, length = 255)
	private String image;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getUpdated_timestamp() {
		return updated_timestamp;
	}

	public void setUpdated_timestamp(LocalDateTime updated_timestamp) {
		this.updated_timestamp = updated_timestamp;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Blog(Long id, String title, String author, LocalDateTime updated_timestamp, String content, String category,
			String image, User user) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.updated_timestamp = updated_timestamp;
		this.content = content;
		this.category = category;
		this.image = image;
		this.user = user;
	}

	public Blog(String title, String author, LocalDateTime updated_timestamp, String content, String category,
			String image, User user) {
		super();
		this.title = title;
		this.author = author;
		this.updated_timestamp = updated_timestamp;
		this.content = content;
		this.category = category;
		this.image = image;
		this.user = user;
	}

	public Blog() {
		super();
	}
	
	

}
