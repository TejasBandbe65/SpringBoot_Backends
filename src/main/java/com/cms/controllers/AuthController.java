package com.cms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.LogInDto;
import com.cms.dto.SignInResponse;
import com.cms.jwtutils.JwtUtils;
import com.cms.services.LogInService;

@CrossOrigin("*")
@RestController
@RequestMapping("/cms/auth")
public class AuthController {
	
	@Autowired
	private LogInService lser;
	
	@Autowired
	public AuthenticationManager amgr;

	@Autowired
	public JwtUtils jwtutil;
	
	@PostMapping("/login")
	public ResponseEntity<?> logIn(@RequestBody LogInDto cred) {
		
		System.out.println("in sign in " + cred);
		
		UsernamePasswordAuthenticationToken unauthorizedUser = new UsernamePasswordAuthenticationToken(cred.getEmail(), cred.getPassword());
		Authentication authorizedUser = amgr.authenticate(unauthorizedUser);
		
		long userId = lser.validateAndLogin(cred);
		
		if(userId == -1) {
			return ResponseEntity.ok(
					new SignInResponse(null, "Email id not registered", -1));
		}else if(userId == 0) {
			return ResponseEntity.ok(
					new SignInResponse(null, "Password is wrong", 0));
		}else {
			String jwtToken = jwtutil.generateJwtToken(authorizedUser);
			
			return ResponseEntity.ok(
					new SignInResponse(jwtToken, "User authentication success!!!",userId));
		}
	}
	
	@GetMapping("/test")
	public String test() {
		
		return "Test is Working";
	}

}
