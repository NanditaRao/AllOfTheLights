package org.ASE.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import org.ASE.model.UserFriends;
import org.ASE.model.UserDetails;
import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class viewFriendAction extends ActionSupport 
{
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	//UserForm userForm = null;
	
	public static final List<UserDetails> friendList = new ArrayList<UserDetails>();
	
		
	public static List<UserDetails> getFriendlist() {
		return friendList;
	}
	
	public String execute()
			throws Exception {
	System.out.println("In view Friend Action");
	Map<String,Object> currentsession = ActionContext.getContext().getSession();
	int userID = (Integer) currentsession.get("userId");
	
	Session session = HibernateUtil.getSession();
	session.beginTransaction();
	List<UserFriends> friendIDList = session.createQuery("from UserFriends u1 where u1.userID="+userID).list();
	System.out.println("size "+friendIDList.size());
	for(int i =0;i<friendIDList.size();i++)
	{
		System.out.println("friends : "+friendIDList.get(i).getFriendID());
	}
	friendList.clear();
	for(int i=0;i<friendIDList.size();i++)
	{
		Query query = session.createQuery("from UserDetails u where u.userId="+friendIDList.get(i).getFriendID());
		for(Iterator it=query.iterate();it.hasNext();)
		{
			UserDetails U=(UserDetails)it.next();
				 System.out.println("ID: " + U.getfirstName());
				 friendList.add(U);
		}
	}
	
	session.getTransaction().commit();
	if(friendList.size() == 0)
	{
		return "nofriends";
	}
	else
	{
		return "success";
	}
}
}