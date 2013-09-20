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

import org.ASE.model.Shopping;


public class ShoppingAction extends ActionSupport 
{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public static List<Shopping> shoppingList;
	//UserForm userForm = null;
	
	
	public String success()

	{

	return "success";      

	}
	
	public static List<Shopping> getShoppingList()
	{
		return shoppingList;
	}
	
	@SuppressWarnings("unchecked")
	public String execute()
			throws Exception {
		//userForm =(UserForm) form;
		try{
			System.out.println("In shopping");
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			shoppingList= session.createQuery("from Shopping").list();
			System.out.println("Size is " + shoppingList.size());
			for(int i=0;i<shoppingList.size();i++)
			{
				
				System.out.println(shoppingList.get(i).getEventName());
			}
			
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Home action!");
		//System.out.println(username);
		
		return "success";
		
		}

	

}

