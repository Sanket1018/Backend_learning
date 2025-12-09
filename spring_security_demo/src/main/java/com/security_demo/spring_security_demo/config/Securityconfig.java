package com.security_demo.spring_security_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Securityconfig {
	// Distrubing the default spring security
	// Making the stateless APIS
	@Bean
	public SecurityFilterChain securityFilteChain(HttpSecurity http)
	{
		http.csrf(customizer->customizer.disable()); // to disable the csfr token
		//http.formLogin(Customizer.withDefaults());
		
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}
	
	// checking the users manually
	@Bean
	public UserDetailsService userDetails()
	{
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("sumit")
				.password("123")
				.roles("USER")
				.build();
				
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("Rohan")
				.password("456")
				.roles("Admin")
				.build();
		
		return new InMemoryUserDetailsManager(user,admin);
	}
	

}
