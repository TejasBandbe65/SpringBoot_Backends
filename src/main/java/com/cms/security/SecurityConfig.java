package com.cms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//Entry point of spring sec configuration
@EnableWebSecurity // to enable web security frmwork
@Configuration // to tell SC following is java configuration class : to declare spring beans
//Equivalent to bean config xml file, This class can contain bean declaration : @Bean
//annotated methods(equivalent to <bean id , class....../>
public class SecurityConfig {
	
	@Autowired
	private JWTRequestFilter jwtFilter;

	@Bean
	public SecurityFilterChain authorize(HttpSecurity http) throws Exception {
		
		
		 http
				.exceptionHandling()
				.authenticationEntryPoint( 
						(req, res, exc)->
										res.sendError(HttpStatus.UNAUTHORIZED.value(), "Not yet authenticated"))
				.and()
				.cors()
				.and()
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/cms/auth/login", "/swagger*/**","/v*/api-docs/**", "/cms/user/register", "/cms/blogs/gettopblogs", "/cms/blogs/open/**", "/cms/blogs//displayAllBlogs").permitAll()
				.antMatchers("/blog/add").hasRole("USER")
				.antMatchers("/auth/test").hasRole("ADMIN")
				.anyRequest().authenticated() // all remaining end points accessible only to authenticated users
				.and().sessionManagement() // configure HttpSession management
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // DO NOT use HttpSession for storing any sec
		 		.and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	
	
}
