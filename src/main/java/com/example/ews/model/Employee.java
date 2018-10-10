package com.example.ews.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int eid;
	private String eName;
	private int salary;
	private String teamName;
	@OneToMany
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
