package com.cms.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dao.BlogDao;
import com.cms.dao.UserDao;
import com.cms.dto.BlogDto;
import com.cms.models.Blog;
import com.cms.models.User;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogDao bdao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserDao udao;

	@Override
	public String saveBlog(BlogDto blog) {
		
		System.out.println(blog.toString());
		User user = udao.findById(blog.getUserId()).orElse(null);
		System.out.println(user);
		
		if(user != null) {
			Blog mappedBlog = mapper.map(blog, Blog.class);
			mappedBlog.setUpdated_timestamp(LocalDateTime.now());
			
			mappedBlog.setUser(user);
			try {
				bdao.save(mappedBlog);
				return "Blog Added";
			}
			catch(Exception e) {
				return "Blog not added";
			}
		}
		else {
			return "User not found";
		}
	}

	@Override
	public List<BlogDto> showBlogs() {
		
		List<Blog> blogs = bdao.findAll();
		List<BlogDto> blogDs = new ArrayList<>();
		
		for(Blog b : blogs) {
			User u = b.getUser();
			long userId = u.getId();
			BlogDto blogDto = mapper.map(b, BlogDto.class);
			blogDto.setUserId(userId);
			blogDs.add(blogDto);
		}
		
		return blogDs;
		
	}

	@Override
	public List<BlogDto> getTopBlogs() {
		
		List<Blog> blogs =  bdao.findAll();
		List<BlogDto> blogDs = new ArrayList<>();
		
		for(Blog b : blogs) {
			BlogDto blogDto = mapper.map(b, BlogDto.class);
			blogDs.add(blogDto);
		}
		
		List<BlogDto> topBlogs = new ArrayList<>();

		for (BlogDto blog : blogDs) {
		    if ("top".equals(blog.getCategory())) {
		        topBlogs.add(blog);
		    }
		}
		
		return topBlogs;
	}

	@Override
	public BlogDto getBlogById(long id) {
		
		Blog b = bdao.findById(id).orElse(null);
		if(b != null) {
			BlogDto bdto = mapper.map(b, BlogDto.class);
			return bdto;
		}else {
			return null;
		}
	}

	@Override
	public List<BlogDto> myBlogs(User user) {
		long id = user.getId();
		
		List<BlogDto> allBlogs = showBlogs();
			
		List<BlogDto> myBlogs = new ArrayList<>();
		for(BlogDto b : allBlogs) {
			if(b.getUserId() == id) {
				myBlogs.add(b);
			}
		}
		return myBlogs;
	}

	@Override
	public String updateBlog(BlogDto blog, long id) {
		
		Blog b = bdao.findById(id).orElse(null);
		if(b != null) {
			b.setTitle(blog.getTitle());
			b.setAuthor(blog.getAuthor());
			b.setImage(blog.getImage());
			b.setContent(blog.getContent());
			bdao.save(b);
			return "Blog updated successfully.";
		}
		return "Blog not found";
	}

	@Override
	public String deleteTheBlog(long id) {
		Blog b = bdao.findById(id).orElse(null);
		
		if( b!= null) {
			bdao.delete(b);
			return "Blog deleted successfully";
		}
		return "Blog not found";
	}

	
	
	
}
