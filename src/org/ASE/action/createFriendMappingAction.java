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

public class createFriendMappingAction extends ActionSupport 
{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	//UserForm userForm = null;
	
		
	public String execute()
			throws Exception {
	
	Map<String,Object> currentsession = ActionContext.getContext().getSession();
	List<String> facebookIdList =(ArrayList<String>) currentsession.get("friendids");
	//Populate the list here.
	int userID = (Integer) currentsession.get("userId");
	Session session = HibernateUtil.getSession();
	session.beginTransaction();
	List<UserDetails> userList = session.createQuery("from UserDetails").list();
	
	
	for(int i=0;i<facebookIdList.size();i++)
	{
		for(int j=0; j<userList.size();j++)
		{
			if(userList.get(j).getFacebookID().equals(facebookIdList.get(i)))
			{
				UserFriends uf = new UserFriends();
				uf.setUserID(userID);
				uf.setFriendID(userList.get(j).getUserId());
				session.save(uf);
			}
		}
	}
	
	session.getTransaction().commit();
	return "success";		 
}
	
}




