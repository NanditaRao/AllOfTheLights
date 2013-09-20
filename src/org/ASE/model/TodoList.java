package org.ASE.model;

import java.util.Date;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class TodoList {
	@Id
	@GeneratedValue
	private int TODOId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private int userId;
	private Date date;
	//private Vector<Event> events;
	//private Vector<TodoComment> comments;
	
	TodoList() {
		this.date = new Date();
//		this.events = new Vector<Event>();
		//this.comments = new Vector<TodoComment>();
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return this.userId;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	@Temporal(TemporalType.DATE) @Column(updatable=false, nullable=false)
	public Date getDate() {
		return this.date;
	}
	
	/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public Vector<Event> getEvents() {
		return this.events;
	}
	
	public void addEvent(Event e) {
		this.events.add(e);
	}
	
	public void removeEvent(Event e) {
		this.events.remove(e);
	}
	
	public Event getEvent(int i) {
		return this.events.get(i);
	}*/
	
	/*@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	public Vector<TodoComment> getComments() {
		return this.comments;
	}
	public void addComment(TodoComment c) {
		this.comments.add(c);
	}*/
	
}
