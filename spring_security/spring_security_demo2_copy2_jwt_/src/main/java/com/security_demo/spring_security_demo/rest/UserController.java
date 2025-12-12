package com.security_demo.spring_security_demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security_demo.spring_security_demo.entity.Users;
import com.security_demo.spring_security_demo.service.JwtTokenService;
import com.security_demo.spring_security_demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtTokenService jwtService;
	
	BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
	
	
	@PostMapping("/add-user")
	public Users registerUser(@RequestBody Users users)
	{
		String encodedPassword = bpe.encode(users.getPassword());
		users.setPassword(encodedPassword);
		return service.register(users);
	}
	
	@GetMapping("/course-info")
	public String getCourseInfo()
	{
		return "This is the course from the Telusko";
	}
	
	
	// checking authentication logic 
	@PostMapping("/login")
	public String loginUser(@RequestBody Users user)
	{
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated())
		{
			String jwt = jwtService.generateToken(user.getUsername());
			return jwt;
			// I want to generate the token
		}
		else {
			return "invalid increditionals";
		}
	}
	
	

}
