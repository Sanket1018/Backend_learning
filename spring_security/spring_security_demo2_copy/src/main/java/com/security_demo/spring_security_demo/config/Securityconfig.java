package com.security_demo.spring_security_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Securityconfig {

    @Autowired
    private UserDetailsService userDetailsService;

    // we are disabling or disturbing the default security
    @Bean
    public SecurityFilterChain securityFilteChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        
        // particular request is accessing from anyone
        http.authorizeHttpRequests(authorizeHttp -> authorizeHttp.requestMatchers("add-user").permitAll().anyRequest().authenticated());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authProvider() {

        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
        daoProvider.setUserDetailsService(userDetailsService); 
        //daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        daoProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return daoProvider;
    }
    
// checking the users manually
//@Bean
//public UserDetailsService userDetails()
//{
//	UserDetails user = User.withDefaultPasswordEncoder()
//			.username("sumit")
//			.password("123")
//			.roles("USER")
//			.build();
//			
//	UserDetails admin = User.withDefaultPasswordEncoder()
//			.username("Rohan")
//			.password("456")
//			.roles("Admin")
//			.build();
//	
//	return new InMemoryUserDetailsManager(user,admin);
//}

}


