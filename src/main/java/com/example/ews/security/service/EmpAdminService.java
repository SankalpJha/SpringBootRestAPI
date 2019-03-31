package com.example.ews.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ews.exceptions.AdminNotFoundException;
import com.example.ews.security.AdminPrincipal;
import com.example.ews.security.model.AdminUsers;
import com.example.ews.security.repository.AdminRepo;

@Service
public class EmpAdminService implements UserDetailsService {

	@Autowired
	private AdminRepo adminRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AdminUsers adminUser = adminRepo.findByAdminName(username);
		if(adminUser==null) {
			throw new AdminNotFoundException("Admin with name " + username + " not found!");	
		}
		
		return new AdminPrincipal(adminUser);
	}

}
