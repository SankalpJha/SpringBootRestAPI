package com.example.ews.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ews.model.Employee;
import com.example.ews.service.EmployeeServiceProvider;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceProvider employeeServiceProvider;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmp(){
		return employeeServiceProvider.getListOfAllEmployee();
	}
	
	@GetMapping("/employee/{eid}")
	public Employee findByEid(@PathVariable final int eid) {
		return employeeServiceProvider.findEmpById(eid);	
	}
	
	@PostMapping("/new_joinee")
	public Employee load(@RequestBody final Employee emp) {
		return employeeServiceProvider.addNewEmployee(emp);
		
	}
	

}
