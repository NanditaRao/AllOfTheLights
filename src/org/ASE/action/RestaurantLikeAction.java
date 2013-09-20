package org.ASE.action;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.ASE.model.Entertainment;
import org.ASE.model.Restaurants;

public class RestaurantLikeAction {
	
	private int eventId;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	public String execute()	throws Exception {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		int eventid = getEventId();
		Restaurants R;
		R= (Restaurants)session.get(Restaurants.class,eventid,LockOptions.UPGRADE); 
		R.setLikes(Integer.parseInt(R.getLikes())+1);
		session.update(R);
		session.getTransaction().commit();
		return "success";
	}

}

