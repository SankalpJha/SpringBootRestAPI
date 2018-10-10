package com.example.ews.service;

import java.util.List;

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
		return employeeRepo.findById(eid).orElse(null);		
	}
	
	public Employee addNewEmployee(Employee emp) {
		employeeRepo.save(emp);
		return employeeRepo.findById(emp.getEid()).orElse(null);
	}
}
