package com.example.ews.secuirty.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService adminDetailsService;
	
	@Bean
	public AuthenticationProvider getAuthProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(adminDetailsService);
		authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		
		return authProvider;
	}
	
	/*@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("Sankalp").password("1234").roles("USER").build());
		
		return new InMemoryUserDetailsManager(users);
	}*/
 
	
}
