package org.ASE.action;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.ASE.model.Entertainment;

public class EntertainmentLikeAction {
	
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
		System.out.println("Event id "+eventid);
		Entertainment E;
		E= (Entertainment)session.get(Entertainment.class,eventid,LockOptions.UPGRADE);
		System.out.println("Entertainment type is: "+E);
		System.out.println("Like value: "+E.getLikes());
		E.setLikes(Integer.parseInt(E.getLikes())+1);
		System.out.println("Like value: "+E.getLikes());
		session.update(E);
		session.getTransaction().commit();
		return "success";
	}

}
