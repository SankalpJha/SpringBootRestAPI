package com.example.ews.security.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminUsers {

	@Id
	private long adminId;
	private String adminName;
	private String adminPassword;
	
	public AdminUsers() {
	
	}
	
	public AdminUsers(String adminName, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
