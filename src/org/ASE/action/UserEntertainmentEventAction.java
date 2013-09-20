package org.ASE.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ASE.model.CheckboxList;
import org.ASE.model.Todo_List;
import org.ASE.model.UserEntertainmentEvent;
import org.ASE.model.checkbox;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserEntertainmentEventAction extends ActionSupport
{
	/**
	 * 
	 */

	
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	private static final long serialVersionUID = 1L;
	
	private int TODOId;
	private int userId;
	private int eventId;
	



	
	


		public int getUserId() {
		
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getEventId() {
		return eventId;
	}



	public void setEventId(int eventId) {
		this.eventId = eventId;
	}



	public int getTODOId() {
		return TODOId;
	}



	public void setTODOId(int tODOId) {
		TODOId = tODOId;
	}

	
	public String success()

	{

	return "success";      

	}
	
	
	
	@SuppressWarnings("unchecked")
	public String execute()
			throws Exception {
		//userForm =(UserForm) form;
		try{
			
			System.out.println("In 	UserEntertainmentEvent");
			Map<String, Object> currentsession = ActionContext.getContext().getSession();
			UserEntertainmentEvent userEntertainmentEvent = new UserEntertainmentEvent();
			int id=(Integer)currentsession.get("userId");
			System.out.println("User Id is"+id);
			System.out.println("Todo Id is"+(Integer) currentsession.get("TODOId"));
			//System.out.println();
			userEntertainmentEvent.setUserID((Integer) currentsession.get("userId"));
			userEntertainmentEvent.setTODOID((Integer) currentsession.get("TODOId"));
			userEntertainmentEvent.setEventID(getEventId());
			System.out.println("Event Id recieved is : "+getEventId());
					
			
					//userEntertainmentEvent.setTODOID((Integer) currentsession.get("TODOId"));
			Session session = HibernateUtil.getSession();
			
			session.beginTransaction();
			session.save(userEntertainmentEvent);
			
			
			
			session.getTransaction().commit();
						
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("In 	UserEntertainmentEvent!");
		//System.out.println(username);
		
		return "success";
		
		}

	

}
