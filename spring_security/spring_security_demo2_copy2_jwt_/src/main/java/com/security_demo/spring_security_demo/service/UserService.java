package com.security_demo.spring_security_demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security_demo.spring_security_demo.entity.Users;
import com.security_demo.spring_security_demo.repo.IUserRepo;

@Service
public class UserService {
	@Autowired
	private IUserRepo repo;
	
	public Users register(Users user)
	{
		return repo.save(user);
	}

}
