package org.ASE.action;

import java.util.Random;

import org.ASE.model.UserDetails;
import org.hibernate.LockOptions;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

public class AdminResetPasswordAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
//	private String UserName;
	private int passwordLength = 7;
	
	private int userId;
		
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String execute() throws Exception {
		
		String newPassword;
		Session session = HibernateUtil.getSession();
		UserDetails user;
		
		System.out.println("In Admin Reset Password");
		
		newPassword = generateRandomPassword(passwordLength);
		System.out.println(newPassword);
		session.beginTransaction();
		System.out.println(getUserId());
		user = (UserDetails)session.get(UserDetails.class, getUserId(), LockOptions.UPGRADE);
		System.out.println("ID "+getUserId());
		System.out.println(user.getBanned());
		System.out.println(user.getFacebookID());
		System.out.println(user.getfirstName());
		System.out.println(user.getlastName());
		System.out.println(user.getuserName());
		System.out.println(user.getPassword());
		user.setPassword(newPassword);
		
		session.update(user);
		session.getTransaction().commit();
		 
		System.out.println("New Password for User (" + getUserId() + "): " + newPassword);
		
		return "success";
	}
	
	private String generateRandomPassword(int length) {
		
		char[] newPassword = new char[length];
		final String charSet = "1234567890abcdefghijklmnopqrstuvwxyz";
		Random rand = new Random();
		
		for (int i = 0; i < length; i++) {
			newPassword[i] = charSet.charAt(rand.nextInt(charSet.length()));
		}
		
		return new String(newPassword);
	}
	
//	private String notifyUser(String password) {
//		final String from = "admin@AllOfTheLights.com";
//		final String host = "localhost";
//		
//		Properties properties = new Properties();
//		properties.setProperty("mail.smtp.host", host);
//		Session session = Session.getDefaultInstance(properties);
//		
//		try {
//			
//		}
//		
//		return "success";
//	}
}


