package com.cms.services;

import java.util.List;

import com.cms.dto.BlogDto;
import com.cms.models.User;


public interface BlogService {
	
	public String saveBlog(BlogDto blog);
	
	public List<BlogDto> showBlogs();
	
	public List<BlogDto> getTopBlogs();
	
	public BlogDto getBlogById(long id);
	
	public List<BlogDto> myBlogs(User user);
	
	public String updateBlog(BlogDto blog, long id);
	
	public String deleteTheBlog(long id);
}
