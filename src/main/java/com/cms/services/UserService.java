package com.cms.services;

import com.cms.dto.PasswordsDto;
import com.cms.dto.ProfileDto;
import com.cms.models.User;

public interface UserService {

	public String registerUser(User user);
	
	public ProfileDto getData(User user);
	
	public String updateName(User user);
	
	public String updateEmail(User user);
	
	public String updatePassword(PasswordsDto passwords);
	
	public boolean verifyToken(User user);
}
