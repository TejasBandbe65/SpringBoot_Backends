package com.cms.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cms.dao.UserDao;
import com.cms.models.User;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao udao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = udao.findByEmail(email).orElseThrow( ()-> new UsernameNotFoundException("User not Found"));
		return new CustomUserDetails(user);
	}

}
