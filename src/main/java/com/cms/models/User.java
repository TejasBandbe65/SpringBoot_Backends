package com.cms.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "app_users")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(unique = true, nullable = false, length = 100)
	private String email;
	
	@Column(nullable= false, length = 255)
	private String password;
	
	@Column(length = 20, columnDefinition = "varchar(20) default 'ROLE_USER'", nullable = false)
	@Enumerated(EnumType.STRING) 
	private Role role;
		
	
	@Column(length = 100)
	private String image;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Blog> blogs;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Favourite> favourites;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Comment> comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public List<Favourite> getFavourites() {
		return favourites;
	}

	public void setFavourites(List<Favourite> favourites) {
		this.favourites = favourites;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	

	public User(Long id, String name, String email, String password, Role role, String image,
			List<Blog> blogs, List<Favourite> favourites, List<Comment> comments) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.image = image;
		this.blogs = blogs;
		this.favourites = favourites;
		this.comments = comments;
	}

	// public User(String name, String email, String password, Role role, String image, List<Blog> blogs,
	// 		List<Favourite> favourites, List<Comment> comments) {
	// 	super();
	// 	this.name = name;
	// 	this.email = email;
	// 	this.password = password;
	// 	this.role = role;
	// 	this.image = image;
	// }

	public User() {
		super();
	}
	
	
	

	
}