package org.ASE.action;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;


import org.ASE.model.UserDetails;

import org.hibernate.Session;




import antlr.Token;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String UserName;
	String password;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	 public void validate()
	   {
	      if (UserName == null || UserName.trim().equals(""))
	      {
	         addFieldError("UserName","name is required");
	      }
	      if (password == null || password.trim().equals(""))
	      {
	         addFieldError("password","Password is required");
	      }
	   }
	 
	
	public String execute()
			throws Exception {
	
		try{
			Map<String,Object> currentsession = ActionContext.getContext().getSession();
			
			boolean correctadminCredentials = false;
			System.out.println("Inside login action");
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			List<UserDetails> userList= session.createQuery("from UserDetails").list();
			System.out.println("Size is " + userList.size());
			for(int i=0;i<userList.size();i++)
			{
				System.out.println("Username :" +userList.get(i).getuserName());
				
				if(getUserName().equals("admin")&& getPassword().equals("adminpassword"))
				{
				correctadminCredentials = true;
				currentsession.put("loginUser", getUserName());
				currentsession.put("password", getPassword());
				currentsession.put("userId", userList.get(i).getUserId());
				System.out.println("User Id in current session of admin"+currentsession.get("userId"));
				System.out.println("User Id in current session of admin"+userList.get(i).getUserId());
				return "admin";
				}
				else if(userList.get(i).getuserName().equals(getUserName())&& userList.get(i).getPassword().equals(getPassword()))
				{
					if(userList.get(i).getBanned()==1)
					{
						return "banneduser";
					}
					System.out.println("Valid user :" +userList.get(i).getuserName());
					correctadminCredentials = false;
					currentsession.put("loginUser", getUserName());
					currentsession.put("password", getPassword());
					currentsession.put("userId", userList.get(i).getUserId());
					System.out.println("User Id in current session"+currentsession.get("userId"));
					System.out.println("User Id in current session"+userList.get(i).getUserId());
					
			
					return "validuser";
				}
					
			}
			
			session.getTransaction().commit();
		    
		     // todo
		    
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return "invaliduser";
	}
	

}
