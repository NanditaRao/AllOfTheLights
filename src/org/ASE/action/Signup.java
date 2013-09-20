package org.ASE.action;

import java.util.List;
import java.util.Map;


import org.ASE.model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Signup extends ActionSupport {

	public void validate()
    {
     String error = new String();
       if (firstName == null || firstName.trim().equals(""))
       {
          error = "First Name";
       }
       if (lastName == null || lastName.trim().equals(""))
       {
           error += " Last Name";
       }
       
      
       if (userNameAdd == null || userNameAdd.trim().equals(""))
       {
         error += " Username";
       }
       if(passwordAdd == null || passwordAdd.trim().equals(""))
       {
           error+=" Password";
       }
      
          
       addFieldError("Fields:",error + " is required ");
    }
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	private static final long serialVersionUID = 1L;
	String firstName;
	String lastName;
	/*
	String UserName;
	String password;*/
	
	String userNameAdd;
	String passwordAdd;

	public String getUserNameAdd() {
		return userNameAdd;
	}

	public void setUserNameAdd(String userNameAdd) {
		this.userNameAdd = userNameAdd;
	}

	public String getPasswordAdd() {
		return passwordAdd;
	}

	public void setPasswordAdd(String passwordAdd) {
		this.passwordAdd = passwordAdd;
	}

	


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	

	public String execute() {
		// signup
		UserDetails user = new UserDetails();
		
		Map<String, Object> currentsession = ActionContext.getContext().getSession();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		List<UserDetails> userList= session.createQuery("from UserDetails").list();
		System.out.println("Size is " + userList.size());
		for(int i=0;i<userList.size();i++)
		{
			if(getUserNameAdd().equals(userList.get(i).getuserName()))
			{
				return "failure";
			}
		}
		currentsession.put("userId", user.getUserId());
		
		
		user.setUserName(getUserNameAdd());
		user.setPassword(getPasswordAdd());
		user.setFirstName(getFirstName());
		user.setLastName(getLastName());
		System.out.println(user.getUserId());
		System.out.println(user.getuserName());
	    
		
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		session2.save(user);
		session2.getTransaction().commit();
		
		//session.put("loginUser", getUserNameAdd());

		//.out.println("Hello World!");
		//System.out.println(getUserNameAdd());
		return "success";
	}

}
