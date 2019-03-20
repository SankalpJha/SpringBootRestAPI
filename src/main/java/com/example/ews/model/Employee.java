package com.example.ews.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="Employee Details")
public class Employee {

	@Id
	@GeneratedValue
	private int eid;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	@ApiModelProperty(notes="Name should have atleast 2 characters")
	private String eName;
	
	@Digits(integer = 10, message="Salary should be integer value", fraction = 0)
	@ApiModelProperty(dataType="Salary should be Integer")
	private int salary;
	
	private String teamName;
	
	@ApiModelProperty(notes="An employee can have multiple roles")
	@OneToMany(mappedBy="employee")
	private List<Roles> roles;
	
	public Employee() {
		
	}

	public Employee(int eid, String eName, int salary, String teamName, List<Roles> roles) {
		super();
		this.eid = eid;
		this.eName = eName;
		this.salary = salary;
		this.teamName = teamName;
		this.roles = roles;
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", eName=" + eName + ", salary=" + salary + ", teamName=" + teamName
				+ ", roles=" + roles + "]";
	}
	
	
	
	
}
