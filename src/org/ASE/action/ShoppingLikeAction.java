package org.ASE.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.ASE.model.Shopping;

public class ShoppingLikeAction {
	
	private int EventId;

	public int getEventId() {
		return EventId;
	}

	public void setEventId(int eventId) {
		EventId = eventId;
	}
	
	public String execute()	throws Exception {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int eventid = getEventId();
		Shopping S;
		S= (Shopping)session.get(Shopping.class,eventid); 
		S.setLikes(Integer.parseInt(S.getLikes())+1);
		session.update(S);
		session.getTransaction().commit();
		return "success";
	}

}
