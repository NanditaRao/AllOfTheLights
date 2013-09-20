package org.ASE.action;

import org.ASE.model.UserDetails;
import org.hibernate.LockOptions;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

public class AdminBanUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String execute() throws Exception {
		Session session = HibernateUtil.getSession();
		UserDetails user;
		
		System.out.println("In Admin Ban User");
		
		session.beginTransaction();
		
		user = (UserDetails)session.get(UserDetails.class, getUserId(), LockOptions.UPGRADE);
		user.setBanned(1);
		
		session.update(user);
		session.getTransaction().commit();
		
		return "success";
	}
}
