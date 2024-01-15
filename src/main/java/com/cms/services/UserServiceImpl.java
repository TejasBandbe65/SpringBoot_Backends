package com.cms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cms.dao.UserDao;
import com.cms.dto.PasswordsDto;
import com.cms.dto.ProfileDto;
import com.cms.models.Role;
import com.cms.models.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private PasswordEncoder pencoder;

	@Override
	public String registerUser(User user) {
		
		try {
			user.setImage("https://cdn-icons-png.flaticon.com/128/3135/3135715.png");
			user.setRole(Role.ROLE_USER);
			user.setPassword(pencoder.encode(user.getPassword()));
			udao.save(user);
			return "User registered successfully";
		}catch(Exception e){
			return e.toString();
		}
	}

	@Override
	public ProfileDto getData(User user) {
		long userId = user.getId();
		ProfileDto pDto = new ProfileDto();
		try {
			User u = udao.findById(userId).orElse(null);
			if(u != null) {
				String image = u.getImage();
				String name = u.getName();
				String email = u.getEmail();
				pDto.setImage(image);
				pDto.setName(name);
				pDto.setEmail(email);
				pDto.setStatus(200);
				pDto.setMessage("Data fetched");
				return pDto;
			}
			else {
				pDto.setStatus(500);
				pDto.setMessage("User not found");
			}
		}catch(Exception e) {
			pDto.setStatus(500);
			pDto.setMessage(e.toString());
			return pDto;
		}
		return pDto;
	}

	@Override
	public String updateName(User user) {
		long userId = user.getId();
		
		try {
			User u = udao.findById(userId).orElse(null);
			if(u != null) {
				u.setName(user.getName());
				udao.save(u);
				return "Name updated successfully";
			}
			else {
				return "User not found";
			}
		}catch(Exception e) {
			return e.toString();
		}
	}

	@Override
	public String updateEmail(User user) {
		long userId = user.getId();
		
		try {
			User u = udao.findById(userId).orElse(null);
			if(u != null) {
				u.setEmail(user.getEmail());
				udao.save(u);
				return "Email updated successfully";
			}
			else {
				return "User not found";
			}
		}catch(Exception e) {
			return e.toString();
		}
	}
	
	private boolean authenticateUser(String pass1, String pass2) {
		return pencoder.matches(pass1, pass2);
	}

	@Override
	public String updatePassword(PasswordsDto passwords) {
		long userId = passwords.getUserId();
		String oldPass = passwords.getOldPass();
		String newPass = passwords.getNewPass();
		
		try {
			User u = udao.findById(userId).orElse(null);
			if(u != null) {
				String curPass = u.getPassword();
				if(authenticateUser(oldPass, curPass)) {
					u.setPassword(pencoder.encode(newPass));
					udao.save(u);
					return "Password updated.";
				}
				else {
					return "Old Password is incorrect.";
				}
			}else {
				return "User not found";
			}
		}catch(Exception e) {
			return e.toString();
		}
	}

	@Override
	public boolean verifyToken(User user) {
		
		User u = udao.findById(user.getId()).orElse(null);
		if(u != null) {
			return true;
		}
		return false;
	}
	
	
	

}
