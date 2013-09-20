package org.ASE.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserFriends {
	@Id
	@GeneratedValue
	private int ID;
	private int userID;
	private int friendID;
	
	public UserFriends()
	{
		
	}
	public UserFriends(int uid, int fid)
	{
		setUserID(uid);
		setFriendID(fid);
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getFriendID() {
		return friendID;
	}
	public void setFriendID(int friendID) {
		this.friendID = friendID;
	}

}
