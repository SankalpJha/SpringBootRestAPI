package com.example.ews.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ews.model.Employee;
import com.example.ews.model.Roles;
import com.example.ews.repository.EmployeeRepo;
import com.example.ews.repository.RolesRepo;

@Service
public class RolesServiceProvider {

	@Autowired
	private RolesRepo rolesRepo;
	
	public List<Roles> getListOfAllRoles(){
		return rolesRepo.findAll();
	}
	
	public Roles findRoleById(int rid) {
		Optional<Roles> role = rolesRepo.findById(rid);
		if(!role.isPresent()) {
			return null;
		}
		Roles r = role.get();
		return r;
	}
	
	public Roles addNewRoles(Roles role) {
		rolesRepo.save(role);
		Optional<Roles> savedRole = rolesRepo.findById(role.getRid());
		if(!savedRole.isPresent()) {
			return null;
		}
		Roles r = savedRole.get();
		return r;
	}

	public Roles removeRoleById(int rid) {
		Optional<Roles> role = rolesRepo.findById(rid);
		if(!role.isPresent()) {
			return null;
		}
		else {
			rolesRepo.deleteById(rid);
		Roles r = role.get();
		return r;
		}
	}
}
