package com.example.ews.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Roles {

	@Id
	@GeneratedValue
	private int rid;
	private String roleName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Employee employee;
	
	public Roles() {
		
	}
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Roles [rid=" + rid + ", roleName=" + roleName + "]";
	}

	
}
