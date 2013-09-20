package org.ASE.action;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ASE.model.Entertainment;
import org.ASE.model.Restaurants;
import org.ASE.model.Shopping;
import org.ASE.model.Todo_List;
import org.ASE.model.UserEntertainmentEvent;
import org.ASE.model.UserRestaurantEvent;
import org.ASE.model.UserShoppingEvent;
import org.hibernate.Query;
import org.hibernate.Session;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class viewTodoListAction  extends ActionSupport 
{

	private static final long serialVersionUID = 1L;
	public static List<Entertainment> EntertainmenteventList = new ArrayList<Entertainment>();
	public static List<Restaurants> RestauranteventList = new ArrayList<Restaurants>();
	public static List<Shopping> ShoppingeventList = new ArrayList<Shopping>();
	SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
	//UserForm userForm = null;
	private int eventID;
	private Date date;
	public int getEventID() {
		return eventID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String success()

	{

	return "success";      

	}
	
	public static final List<Entertainment> getEntertainmentList()
	{
		return EntertainmenteventList;
	}
	
	public static final List<Restaurants> getRestaurantList()
	{
		return RestauranteventList;
	}
	public static final List<Shopping> getShoppingList()
	{
		return ShoppingeventList;
	}
	
	@SuppressWarnings("unchecked")
	public String execute()
			throws Exception {
		//userForm =(UserForm) form;
		try{
			int eventid;
			System.out.println("In viewTodoList");
			Map<String, Object> currentsession = ActionContext.getContext().getSession();
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			System.out.println("entered date is "+getDate());
			String d = dt.format(getDate());
			int userID = (Integer) currentsession.get("userId");
			System.out.println("User id "+userID);
			//Date date=getDate();
			int todoID = -1;
			
			List<Todo_List> todoList= session.createQuery("from Todo_List ").list();
			for(int i=0;i<todoList.size();i++)
			{
				System.out.println(todoList.get(i).getDate());
				System.out.println(d);
				boolean b = (todoList.get(i).getDate().equals(d));
				System.out.println(b);
				if((todoList.get(i).getDate().equals(d)) && (todoList.get(i).getUserId() == userID))
				{
				System.out.println("TodoId is "+todoList.get(i).getTODOId());
				todoID = todoList.get(i).getTODOId();
				
				break;
				}
			}
			List<UserEntertainmentEvent> userEntertainmentEvent = new ArrayList<UserEntertainmentEvent>();
			Query userEntertainmentList = session.createQuery("from UserEntertainmentEvent e where e.userID ="+userID+" and e.TODOID = "+todoID);
			//ResultSet userEntertainmentList= st.executeQuery(sql);
			for(Iterator it=userEntertainmentList.iterate();it.hasNext();)
			{
					 UserEntertainmentEvent UEE=(UserEntertainmentEvent)it.next();
					 System.out.println("ID: " + UEE.getEventID());
					 userEntertainmentEvent.add(UEE);
			}
			System.out.println("Size is " + userEntertainmentEvent.size());
			for(int i=0;i<userEntertainmentEvent.size();i++)
			{
				System.out.println("Values are "+userEntertainmentEvent.get(i).getEventID());
			}
			EntertainmenteventList.clear();
			for(int i=0;i<userEntertainmentEvent.size();i++)
			{
				
				eventid = userEntertainmentEvent.get(i).getEventID();
				Query userEntertainment = session.createQuery("from Entertainment e1 where e1.EventID ="+eventid);
				for(Iterator it=userEntertainment.iterate();it.hasNext();)
				{
						 Entertainment E=(Entertainment)it.next();
						 System.out.println("ID: " + E.getEventID());
						 EntertainmenteventList.add(E);
				}
				
				
			}
			
			
			//Restaurants
			
			List<UserRestaurantEvent> userRestaurantEvent = new ArrayList<UserRestaurantEvent>();
			Query userRestaurantList = session.createQuery("from UserRestaurantEvent e where e.userID ="+userID+" and e.TODOID = "+todoID);
			//ResultSet userEntertainmentList= st.executeQuery(sql);
			for(Iterator it=userRestaurantList.iterate();it.hasNext();)
			{
					 UserRestaurantEvent UEE=(UserRestaurantEvent)it.next();
					 System.out.println("ID: " + UEE.getEventID());
					 userRestaurantEvent.add(UEE);
			}
			System.out.println("Size is " + userRestaurantEvent.size());
			for(int i=0;i<userRestaurantEvent.size();i++)
			{
				System.out.println("Values are "+userRestaurantEvent.get(i).getEventID());
			}
			RestauranteventList.clear();
			for(int i=0;i<userRestaurantEvent.size();i++)
			{
				
				eventid = userRestaurantEvent.get(i).getEventID();
				Query userRestaurant = session.createQuery("from Restaurants r1 where r1.EventID ="+eventid);
				for(Iterator it=userRestaurant.iterate();it.hasNext();)
				{
						 Restaurants R=(Restaurants)it.next();
						 System.out.println("ID: " + R.getEventID());
						 RestauranteventList.add(R);
				}
				
				
			}
			
//Shopping
			
			List<UserShoppingEvent> userShoppingEvent = new ArrayList<UserShoppingEvent>();
			Query userShoppingList = session.createQuery("from UserShoppingEvent s where s.userID ="+userID+" and s.TODOID = "+todoID);
			//ResultSet userEntertainmentList= st.executeQuery(sql);
			for(Iterator it=userShoppingList.iterate();it.hasNext();)
			{
					 UserShoppingEvent UEE=(UserShoppingEvent)it.next();
					 System.out.println("ID: " + UEE.getEventID());
					 userShoppingEvent.add(UEE);
			}
			System.out.println("Size is " + userShoppingEvent.size());
			for(int i=0;i<userShoppingEvent.size();i++)
			{
				System.out.println("Values are "+userShoppingEvent.get(i).getEventID());
			}
			ShoppingeventList.clear();
			for(int i=0;i<userShoppingEvent.size();i++)
			{
				
				eventid = userShoppingEvent.get(i).getEventID();
				Query userShopping = session.createQuery("from Shopping s where s.EventID ="+eventid);
				for(Iterator it=userShopping.iterate();it.hasNext();)
				{
					Shopping S=(Shopping)it.next();
				    System.out.println("ID: " + S.getEventID());
				   ShoppingeventList.add(S);
				}
				
				
			}
			
			
			
			/*for(int i=0;i<EntertainmenteventList.size();i++)
			{
				System.out.println(EntertainmenteventList.get(i).getEntertainmentType());
			}
			*/
			
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Home action!");
		//System.out.println(username);
		
		return "success";
		
		}

	

	
}
