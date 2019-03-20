package com.example.ews.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.ews.model.Employee;
import com.example.ews.repository.EmployeeRepo;

@Service
public class EmployeeServiceProvider {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<Employee> getListOfAllEmployee(){
		return employeeRepo.findAll();
	}
	
	public Employee findEmpById(int eid) {
		Optional<Employee> emp = employeeRepo.findById(eid);
		if(!emp.isPresent()) {
			return null;
		}
		Employee e = emp.get();
		return e;
	}
	
	public Employee addNewEmployee(Employee emp) {
		employeeRepo.save(emp);
		Optional<Employee> newEmp = employeeRepo.findById(emp.getEid());
		if(!newEmp.isPresent()) {
			return null;
		}
		Employee e = newEmp.get();
		return e;
	}

	public Employee removeEmpById(int eid) {
		Optional<Employee> emp = employeeRepo.findById(eid);
		if(!emp.isPresent()) {
			return null;
		}
		else {
		employeeRepo.deleteById(eid);
		Employee e = emp.get();
		return e;
		}
	}
}
