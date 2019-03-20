package com.example.ews.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ews.exceptions.EmloyeeNotFoundException;
import com.example.ews.model.Employee;
import com.example.ews.model.Roles;
import com.example.ews.service.EmployeeServiceProvider;
import com.example.ews.service.RolesServiceProvider;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1")
@Api(value="Employee Resource")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceProvider employeeServiceProvider;
	
	@Autowired
	private RolesServiceProvider rolesServiceProvider;
	
	@ApiOperation(value="Returns the list of all employees")
	@GetMapping("/employee")
	public List<Employee> getAllEmp(){
		return employeeServiceProvider.getListOfAllEmployee();
	}
	
	@ApiOperation(value="Returns the user for perticular employee Id")
	@GetMapping("/employee/{eid}")
	public Resource<Employee> findByEid(@PathVariable int eid) {
		Employee emp = employeeServiceProvider.findEmpById(eid);
		if(emp==null) {
			throw new EmloyeeNotFoundException("E-Id :" + eid);
		}
		//HATEOAS - to return link if user not present
		Resource<Employee> resource = new Resource<Employee>(emp);
		ControllerLinkBuilder selfLink = linkTo(methodOn(EmployeeController.class).getAllEmp());
		resource.add(selfLink.withRel("all-employees"));
		
		return resource;
 	
	}
	
	@ApiOperation(value="Adds a new employee")
	@PostMapping("/employee")
	public ResponseEntity<Object> load(@Valid @RequestBody Employee emp) {
		Employee newEmp = employeeServiceProvider.addNewEmployee(emp);
		// CREATED
		// /employee/{id}     newEmp.getEid()
		
		URI newEmpURI = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{eid}")
				.buildAndExpand(newEmp.getEid()).toUri();
		
		return ResponseEntity.created(newEmpURI).build();
		
	}
	
	@ApiOperation(value="Removes an employees from Organization")
	@DeleteMapping("/employee/{eid}")
	public void deleteEmployee(@PathVariable int eid) {
		Employee emp = employeeServiceProvider.removeEmpById(eid);
		
		if(emp==null)
			throw new EmloyeeNotFoundException("E-id :" + eid);		
	}
	
	
	@ApiOperation(value="Returns the list of roles of an employee")
	@GetMapping("/employee/{eid}/roles")
	public List<Roles> getEmpSpecificRoles(@PathVariable int eid){
		Employee emp = employeeServiceProvider.findEmpById(eid);
		if(emp==null) {
			throw new EmloyeeNotFoundException("E-Id :" + eid);
		}
		
		return emp.getRoles();
	}
	
	
	@ApiOperation(value="Adds a new role for an employee")
	@PostMapping("/employee/{eid}/role")
	public ResponseEntity<Object> addRole(@PathVariable int eid, @RequestBody Roles role) {
		Employee emp = employeeServiceProvider.findEmpById(eid);
		if(emp==null) {
			throw new EmloyeeNotFoundException("E-Id :" + eid);
		}
		
		role.setEmployee(emp);
		
		rolesServiceProvider.addNewRoles(role);
		
		URI newRoleURI = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{eid}")
				.buildAndExpand(role.getRid()).toUri();
		
		return ResponseEntity.created(newRoleURI).build();
		
	}
	

}
