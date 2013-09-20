package org.ASE.model;

import java.util.Date;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Todo_List {
	@Id
	@GeneratedValue
	private int TODOId;
	private String date;
	private int userId;
	
	
	public int getTODOId() {
		return TODOId;
	}

	public void setTODOId(int TODOId) {
		this.TODOId = TODOId;
	}


	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	
	public String getDate() {
		return this.date;
	}
	
	
}