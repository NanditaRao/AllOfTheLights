package org.ASE.action;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.nearus.hibernate.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.ASE.model.Restaurants;

public class RestaurantAction extends ActionSupport 
{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	//UserForm userForm = null;
	
	public static List<Restaurants> restaurantList;
	public String success()

	{

	return "success";      

	}
	
	public static List<Restaurants> getRestaurantList()
	{
		return restaurantList;
	}
	
	@SuppressWarnings("unchecked")
	public String execute()
			throws Exception {
		//userForm =(UserForm) form;
		try{
			System.out.println("In restaurant");
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			restaurantList= session.createQuery("from Restaurants").list();
			System.out.println("Size is " + restaurantList.size());
			for(int i=0;i<restaurantList.size();i++)
			{
				
				System.out.println(restaurantList.get(i).getEventName());
			}
			
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("Home action!");
		//System.out.println(username);
		
		return "success";
		
		}

	

}

