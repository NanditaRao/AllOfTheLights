package org.ASE.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ASE.model.Entertainment;
import org.ASE.model.Todo_List;
import org.ASE.model.UserDetails;
import org.ASE.model.UserEntertainmentEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TodoListAction extends ActionSupport 
{
	/**
	 * 
	 */
	//public static List<Entertainment> EntertainmenteventList;
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	private static final long serialVersionUID = 1L;
	private Date date;
	//private int TODOId;
/*private int eventID;
	
	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}*/
	
   
    
	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	/*public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}



	private int userID;*/
	
	public String success()

	{

	return "success";      

	}
	/*public static final List<Entertainment> getEntertainmentList()
	{
		return EntertainmenteventList;
	}*/
	
	
	
	@SuppressWarnings("unchecked")
	public String execute()
			throws Exception {
		//userForm =(UserForm) form;
		try{
			int eventid;
			System.out.println("In TodoList");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			Map<String, Object> currentsession = ActionContext.getContext().getSession();
			Todo_List todolist = new Todo_List();
			todolist.setDate(dt.format(getDate()));
			int id = (Integer) currentsession.get("userId");
			String d = dt.format(getDate());
			todolist.setUserId((Integer) currentsession.get("userId"));
			//todolist.setTODOId(todolist.getTODOId());
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			
						
			/*List<UserEntertainmentEvent> userEntertainmentList= session.createQuery("from UserEntertainmentEvent e where e.userID = userID and e.TODOID = TODOId").list();
			System.out.println("Size is " + userEntertainmentList.size());
			for(int i=0;i<userEntertainmentList.size();i++)
			{
				
				eventid = userEntertainmentList.get(i).getEventID();
				EntertainmenteventList = session.createQuery("from Entertainment e1 where e1.EventID = eventid").list();
				
				
			}*/
			session.save(todolist);
			List<Todo_List> todoList= session.createQuery("from Todo_List ").list();
			for(int i=0;i<todoList.size();i++)
			{
				if((todoList.get(i).getDate().equals(d)) && (todoList.get(i).getUserId() == id))
				{
				System.out.println("TodoId is "+todoList.get(i).getTODOId());
				currentsession.put("TODOId", todoList.get(i).getTODOId());
				currentsession.put("Date", getDate());
				break;
				}
			}
			session.getTransaction().commit();
			
			
						
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("TodoList action!");
		//System.out.println(username);
		
		return "success";
		
		}

	

}
