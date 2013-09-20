package org.ASE.action;

import java.util.Map;

import org.ASE.model.UserEntertainmentEvent;
import org.ASE.model.UserRestaurantEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class UserRestaurantEventAction {

	
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
			UserRestaurantEvent userRestaurantEvent = new UserRestaurantEvent();
			int id=(Integer)currentsession.get("userId");
			System.out.println("User Id is"+id);
			System.out.println("Todo Id is"+(Integer) currentsession.get("TODOId"));
			//System.out.println();
			userRestaurantEvent.setUserID((Integer) currentsession.get("userId"));
			userRestaurantEvent.setTODOID((Integer) currentsession.get("TODOId"));
			userRestaurantEvent.setEventID(getEventId());
			System.out.println("Event Id recieved is : "+getEventId());
					
			
					//userEntertainmentEvent.setTODOID((Integer) currentsession.get("TODOId"));
			Session session = HibernateUtil.getSession();
			
			session.beginTransaction();
			session.save(userRestaurantEvent);
			
			
			
			session.getTransaction().commit();
						
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("In 	UserRestaurantEvent!");
		//System.out.println(username);
		
		return "success";
		
		}

	

}

