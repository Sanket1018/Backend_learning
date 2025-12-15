package com.security_demo.spring_security_demo.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security_demo.spring_security_demo.service.JwtTokenService;
import com.security_demo.spring_security_demo.service.MYUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtTokenService service;
	
	@Autowired
	private MYUserDetailsService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader =  request.getHeader("Authorization");
		String token = null;
		String name = null;
		if(authHeader!= null && authHeader.startsWith("Bearer"))
		{
			token = authHeader.substring(7);
			name = service.extractUserName(token);
		}
		
		if(name != null && SecurityContextHolder.getContext().getAuthentication()== null)
		{
			// end user entered a name
			// we extracted from a token
			// checked into database it is present or not
			UserDetails userDetails = userService.loadUserByUsername(name);
			boolean status = service.validateToken(token,userDetails);
			
			if(status)
			{
				
			}
			filterChain.doFilter(request, response);
			
		}
		
	}
		
		

}
