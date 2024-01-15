package com.cms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.BlogDto;
import com.cms.models.User;
import com.cms.services.BlogService;


@CrossOrigin("*")
@RestController
@RequestMapping("/cms/blogs")
public class BlogsController {
	
	@Autowired
	private BlogService bser;
	
	@PostMapping("/add")
	public String addBlog(@RequestBody BlogDto blog) {
		return bser.saveBlog(blog);
	}
	
	@GetMapping("/displayAllBlogs")
	public List<BlogDto> displayAll(){
		
		return bser.showBlogs();
	}
	
	@GetMapping("/gettopblogs")
	public List<BlogDto> topBlogs(){
		
		return bser.getTopBlogs();
	}
	
	@GetMapping("/open/{id}")
	public BlogDto getById(@PathVariable long id) {
		
		return bser.getBlogById(id);
	}
	
	@PostMapping("/myblogs")
	public List<BlogDto> getMyBlogs(@RequestBody User user) {
		return bser.myBlogs(user);
	}
	
	@PutMapping("/update/{id}")
	public String editBlog(@RequestBody BlogDto blog, @PathVariable long id) {
		return bser.updateBlog(blog, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBlog(@PathVariable long id) {
		return bser.deleteTheBlog(id);
	}
	
	
}
