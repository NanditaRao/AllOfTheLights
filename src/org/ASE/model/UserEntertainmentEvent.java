package org.ASE.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserEntertainmentEvent {
	
	@Id
	@GeneratedValue
	private int ID;
	private int userID;
	private int TODOID;
	private int eventID;
	
		
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getTODOID() {
		return TODOID;
	}
	public void setTODOID(int tODOID) {
		TODOID = tODOID;
	}
	public int getEventID() {
		return eventID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	

}
