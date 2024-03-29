package com.cms.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dao.BlogDao;
import com.cms.dao.FavoriteDao;
import com.cms.dao.UserDao;
import com.cms.dto.FavouriteDto;
import com.cms.models.Blog;
import com.cms.models.Favourite;
import com.cms.models.User;

@Service
public class FavouriteServiceImpl implements FavouriteService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BlogDao bdao;
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private FavoriteDao fdao;

	@Override
	public String addLike(FavouriteDto fdto) {
		
		Blog blog =  bdao.findById(fdto.getBlogId()).orElse(null);
		User user = udao.findById(fdto.getUserId()).orElse(null);
		
		if(blog != null && user != null) {
			try {
				Favourite mappedFav = mapper.map(fdto, Favourite.class);
				mappedFav.setBlog(blog);
				mappedFav.setUser(user);
				
				fdao.save(mappedFav);
				return "Post liked";
			}catch(Exception e) {
				return "Something went wrong";
			}
		}
		else if(blog == null) {
			return "Blog not found";
		}	
		else {
			return "User not found";
		}
	}

	@Override
	public boolean isBlogLiked(FavouriteDto fdto) {
		long userId = fdto.getUserId();
		long blogId = fdto.getBlogId();
		
		Blog b = bdao.findById(blogId).orElse(null);
		User u = udao.findById(userId).orElse(null);
		
		List<Favourite> list = fdao.findAll();
		
		for(Favourite f : list) {
			Blog newblog = f.getBlog();
			User newuser = f.getUser();
			if(b == newblog && u == newuser) {
				return true;
			}
		}
		
		return false;
	}

}
