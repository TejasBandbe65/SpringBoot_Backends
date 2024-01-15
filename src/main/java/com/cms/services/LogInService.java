package com.cms.services;

import com.cms.dto.LogInDto;
import com.cms.models.User;

public interface LogInService {

	public User validateEmail(String email);
	
	public long validateAndLogin(LogInDto cred);
}
