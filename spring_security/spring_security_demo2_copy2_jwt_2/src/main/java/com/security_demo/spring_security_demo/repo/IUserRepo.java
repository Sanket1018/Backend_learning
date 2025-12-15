package com.security_demo.spring_security_demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security_demo.spring_security_demo.entity.Users;

public interface IUserRepo extends JpaRepository<Users, Integer>{


	public Users findByUsername(String username);

}
