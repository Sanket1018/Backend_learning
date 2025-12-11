package com.security_demo.spring_security_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security_demo.spring_security_demo.entity.Users;
import com.security_demo.spring_security_demo.repo.IUserRepo;

@Service
public class MYUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private IUserRepo repo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		 Users users = repo.findByUsername(username);
		 
		 if(users == null)
		 {
			 throw new UsernameNotFoundException("user not found");
		 }
		 // return users; give error 
		 return new UserPrincipal(users);
	}

}
