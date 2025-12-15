package com.security_demo.spring_security_demo.service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtTokenService {
	// here we have to write a logic to generate a token
	
	public String secretkey;
	
	public JwtTokenService()
	{
		this.secretkey=getTheSecretkey();
	}
	
	// process of generating token later we will validate it.
	// generating a key
	private String getTheSecretkey() {
		try {
			KeyGenerator key = KeyGenerator.getInstance("HmacSHA256");
			SecretKey secret = key.generateKey();
			return Base64.getEncoder().encodeToString(secret.getEncoded());
		}
		catch(Exception e)
		{
			throw new RuntimeException("Error is generating key");
		}
	}

	// generating a token
	public String generateToken(String name)
	{
		// create a claims
		// claims means payload or information
		Map<String,Object> clamis = new HashMap<>();
		return Jwts.builder()
				.setClaims(clamis)
				.setSubject(name)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+18000000))
				.signWith(getKey(),SignatureAlgorithm.HS256).compact();
				
				
	}

	private Key getKey() {
		byte[] b = Decoders.BASE64.decode(secretkey);
		return Keys.hmacShaKeyFor(b);
		
	}

	public String extractUserName(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		// TODO Auto-generated method stub
		return false;
	}

}
