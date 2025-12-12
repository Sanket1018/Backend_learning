package com.security_demo.spring_security_demo.config;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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

    		// disabling the csrf token
        http.csrf(csrf -> csrf.disable());
        http.httpBasic(Customizer.withDefaults());
        // making stateless project
        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        
        // particular request is accessing from anyone
        http.authorizeHttpRequests(authorizeHttp -> authorizeHttp.requestMatchers("add-user","login").permitAll().anyRequest().authenticated());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authProvider() {
        
    	// getting password from the database
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
    
    // we have to authenticate the request
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
    		return config.getAuthenticationManager();
    }

}


