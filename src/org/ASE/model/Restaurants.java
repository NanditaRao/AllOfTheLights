package org.ASE.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Restaurants extends Event {
	@Id
	@GeneratedValue
	private int EventID;
	private String RestaurantType;
	private String CuisineType;
	private String EventName;
	private String ContactNumber;
	private String Website;
	private String StreetAddress;
	private String EventType;
	private int Likes;
	
	
	
	public String getLikes() {
		return Integer.toString(Likes);
	}

	public void setLikes(int like) {
		this.Likes = like;
	}

	public String getEventName() {
		return EventName;
	}
	
	public void setEventName(String eventName) {
		EventName = eventName;
	}
	
	public String getContactNumber() {
		return ContactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	
	public String getWebsite() {
		return Website;
	}
	
	public void setWebsite(String website) {
		Website = website;
	}
	
	public String getStreetAddress() {
		return StreetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		StreetAddress = streetAddress;
	}
	
	public String getEventType() {
		return EventType;
	}
	
	public void setEventType(String eventType) {
		EventType = eventType;
	}
	
	
	public String getEventID() {
		return Integer.toString(EventID);
	}
	
	public void setEventID(int eventID) {
		EventID = eventID;
	}
	
	public String getRestaurantType() {
		return RestaurantType;
	}
	public void setRestaurantType(String restaurantType) {
		RestaurantType = restaurantType;
	}
	public String getCuisineType() {
		return CuisineType;
	}
	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
	}
}
