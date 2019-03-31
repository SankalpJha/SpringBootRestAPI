package com.example.ews.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.ews.security.model.AdminUsers;

public class AdminPrincipal implements UserDetails {

	/*
	 * Need access of AdminUsers class to return 
	 * admin name and password
	 */
	private AdminUsers adminUsers;
	
	
	public AdminPrincipal(AdminUsers adminUsers) {
		super();
		this.adminUsers = adminUsers;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return 	Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		
		return adminUsers.getAdminPassword();
	}

	@Override
	public String getUsername() {
		
		return adminUsers.getAdminName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
