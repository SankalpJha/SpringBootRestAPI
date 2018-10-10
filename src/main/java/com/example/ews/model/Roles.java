package com.example.ews.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles {

	@Id
	private int rid;
	private String roleName;
	
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

	@Override
	public String toString() {
		return "Roles [rid=" + rid + ", roleName=" + roleName + "]";
	}

	
}
