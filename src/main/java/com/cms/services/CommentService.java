package com.cms.services;

import java.util.List;

import com.cms.dto.CommDto;
import com.cms.dto.CommentDto;

public interface CommentService {
	
	public String addComment(CommentDto comment);
	
	public List<CommDto> getAllComments(long blogId);

}
