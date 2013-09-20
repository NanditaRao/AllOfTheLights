package org.ASE.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.nearus.hibernate.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.ASE.model.Entertainment;


public class EntertainmentAction extends ActionSupport 
{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public static List<Entertainment> entertainmentList;
	//UserForm userForm = null;
	
	
	public String success()

	{

	return "success";      

	}
	
	public static final List<Entertainment> getEntertainmentList()
	{
		return entertainmentList;
	}
	
	@SuppressWarnings("unchecked")
	public String execute()
			throws Exception {
		//userForm =(UserForm) form;
		try{
			System.out.println("In entertainment");
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			entertainmentList= session.createQuery("from Entertainment").list();
			System.out.println("Size is " + entertainmentList.size());
			for(int i=0;i<entertainmentList.size();i++)
			{
				
				System.out.println(entertainmentList.get(i).getEventName());
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