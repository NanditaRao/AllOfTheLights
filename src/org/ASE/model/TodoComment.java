package org.ASE.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

public class TodoComment {
	private String userName;
	private Date date;
	
	public void setUserName(String firstName, String lastName) {
		this.userName = firstName + " " + lastName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return this.date;
	}
}
