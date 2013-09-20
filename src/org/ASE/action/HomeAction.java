package org.ASE.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FacebookApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import org.ASE.model.Entertainment;
import org.ASE.model.Restaurants;
import org.ASE.model.Shopping;
import org.ASE.model.Todo_List;
import org.ASE.model.UserDetails;
import org.ASE.model.UserEntertainmentEvent;
import org.ASE.model.UserFriends;
import org.ASE.model.UserRestaurantEvent;
import org.ASE.model.UserShoppingEvent;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FacebookApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class HomeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//UserForm userForm = null;
	String username = new String();
	public static Todo_List todoList = new Todo_List();
	public static List<Entertainment> EntertainmentList = new ArrayList<Entertainment>();
	public static List<Restaurants> RestaurantList = new ArrayList<Restaurants>();
	public static List<Shopping> ShoppingList = new ArrayList<Shopping>();

	public static List<Entertainment> getEntertainmentList() {
		return EntertainmentList;
	}

	public static void setEntertainmentList(List<Entertainment> entertainmentList) {
		EntertainmentList = entertainmentList;
	}

	public static List<Restaurants> getRestaurantList() {
		return RestaurantList;
	}

	public static void setRestaurantList(List<Restaurants> restaurantList) {
		RestaurantList = restaurantList;
	}

	public static List<Shopping> getShoppingList() {
		return ShoppingList;
	}

	public static void setShoppingList(List<Shopping> shoppingList) {
		ShoppingList = shoppingList;
	}
	
	
	public String success()

	{

	return "success";      

	}
	
	public String execute()
			throws Exception {
		//userForm =(UserForm) form;
		try{
			System.out.println("Getting Todo Lists");
			
			
			Map<String,Object> session = ActionContext.getContext().getSession();
			 username = (String) session.get("loginUser");
		    
			EntertainmentList.clear();
			RestaurantList.clear();
			ShoppingList.clear();
			
			Map<String,Object> currentSession = ActionContext.getContext().getSession();
			int userId = ((Integer) currentSession.get("userId"));
			Session hibernateSession = HibernateUtil.getSession();
			hibernateSession.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<Todo_List> tempTodoList = hibernateSession.createCriteria(Todo_List.class)
									.add(Restrictions.eq("userId", userId))
									.addOrder(Order.asc("date"))
									.setMaxResults(1)
									.list();
			todoList = tempTodoList.get(0);
			
			//todo check errors
			/* Get User Entertainment Events */
			@SuppressWarnings("unchecked")
			List<UserEntertainmentEvent> userEntertainmentEvents = hibernateSession.createCriteria(UserEntertainmentEvent.class)
									.add(Restrictions.eq("TODOID", todoList.getTODOId()))
									.list();
			
			
			
			
			/* Get User Restaurant Events */
			@SuppressWarnings("unchecked")
			List<UserRestaurantEvent> userRestaurantEvents = hibernateSession.createCriteria(UserRestaurantEvent.class)
									.add(Restrictions.eq("TODOID", todoList.getTODOId()))
									.list();
			
	
		
			/* Get User Shopping Events */
			
			@SuppressWarnings("unchecked")
			List<UserShoppingEvent> userShoppingEvents = hibernateSession.createCriteria(UserShoppingEvent.class)
									.add(Restrictions.eq("TODOID", todoList.getTODOId()))
									.list();
			
			/* Get actual event objects */
			int eventId;
			for (int i = 0; i < userEntertainmentEvents.size(); i++) {
				eventId = userEntertainmentEvents.get(i).getEventID();
				Query userEntertainment = hibernateSession.createQuery("from Entertainment e1 where e1.EventID ="+ eventId);
				for(Iterator it=userEntertainment.iterate();it.hasNext();)
				{
						 Entertainment E = (Entertainment)it.next();
						 System.out.println("ID: " + E.getEventID());
						 EntertainmentList.add(E);
				}
			}
			
			for (int i = 0; i < userRestaurantEvents.size(); i++) {
				eventId = userRestaurantEvents.get(i).getEventID();
				Query userRestaurant = hibernateSession.createQuery("from Restaurant r1 where r1.EventID ="+ eventId);
				for(Iterator it=userRestaurant.iterate();it.hasNext();)
				{
						 Restaurants R = (Restaurants)it.next();
						 System.out.println("ID: " + R.getEventID());
						 RestaurantList.add(R);
				}
			}
			
			for (int i = 0; i < userShoppingEvents.size(); i++) {
				eventId = userShoppingEvents.get(i).getEventID();
				Query userShopping = hibernateSession.createQuery("from Shopping s1 where s1.EventID ="+ eventId);
				for(Iterator it=userShopping.iterate();it.hasNext();)
				{
						 Shopping S = (Shopping)it.next();
						 System.out.println("ID: " + S.getEventID());
						 ShoppingList.add(S);
				}
			}

			facebookConnect();
		}catch (Exception e) {
			e.printStackTrace();
			return "success";
		}
		System.out.println("Home action!");
		System.out.println(username);

		return "success";
		
		}
	
	private static final String NETWORK_NAME = "Facebook";
	private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
	private static final org.scribe.model.Token EMPTY_TOKEN = null;

	
	public void createFriendMapping()
	{
		System.out.println("Creating friend mapping");
		Map<String,Object> currentsession = ActionContext.getContext().getSession();
		List<String> facebookIdList =(ArrayList<String>) currentsession.get("friendids");
		//Populate the list here.
		/*for(int i=0;i<facebookIdList.size();i++)
		{
			System.out.println("ids :"+facebookIdList.get(i));
		}*/
		int userID = (Integer) currentsession.get("userId");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		List<UserDetails> userList = session.createQuery("from UserDetails").list();
		
		
		for(int i=0;i<facebookIdList.size();i++)
		{
			for(int j=0; j<userList.size();j++)
			{
				System.out.println("From user "+userList.get(j).getFacebookID());
				System.out.println("From facebook "+facebookIdList.get(i));
				
				if(userList.get(j).getFacebookID() != null)
				{
				if(userList.get(j).getFacebookID().equals(facebookIdList.get(i)))
				{
					UserFriends uf = new UserFriends();
					uf.setUserID(userID);
					uf.setFriendID(userList.get(j).getUserId());
					session.save(uf);
				}
				
			}}
		}
		
		session.getTransaction().commit();
	}
	
	private void facebookConnect() throws IOException {
		// TODO Auto-generated method stub
		String apiKey = "482344355138854";
	    String apiSecret = "4be2aee78ae046cf7ef2591f7af87287";
	   
	    HttpServletRequest request = ServletActionContext.getRequest();
	    String code = request.getParameter("code");

	    OAuthService service = new ServiceBuilder()
        .provider(FacebookApi.class)
        .apiKey(apiKey)
        .apiSecret(apiSecret)
        .callback("http://localhost:8080/Struts2Test/HomeAction")
        .build();
	    
	    System.out.println("Fetching the Authorization URL...");
	    String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
	    System.out.println("Got the Authorization URL!");
	    System.out.println("Now go and authorize Scribe here:");
	    System.out.println(authorizationUrl);
	    System.out.println("And paste the authorization code here");
	    System.out.print(">>");
	    
	    Verifier verifier = new Verifier(code);
	    System.out.println();
	    
	    // Trade the Request Token and Verfier for the Access Token
	    System.out.println("Trading the Request Token for an Access Token...");
	    org.scribe.model.Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
	    System.out.println("Got the Access Token!");
	    System.out.println("(if your curious it looks like this: " + accessToken + " )");
	    System.out.println();
	    String token = accessToken.toString().substring(accessToken.toString().indexOf("[")+1,accessToken.toString().indexOf(",")).trim();
	    URL u = new URL("https://graph.facebook.com/me/friends?access_token="+token);
	    System.out.println(u.openConnection().getContent());

	    // Now let's go and ask for a protected resource!
	    System.out.println("Now we're going to access a protected resource...");
	    OAuthRequest arequest = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
	    service.signRequest(accessToken, arequest);
	    Response aresponse = arequest.send();
	    System.out.println("Got it! Lets see what we found...");
	    System.out.println();
	    System.out.println(aresponse.getCode());
	    System.out.println(aresponse.getBody());
	    
	    String myinfo = aresponse.getBody();
	    StringTokenizer st = new StringTokenizer(myinfo,":\",");
	   st.nextElement();
	   st.nextElement();
	   UserDetails user;
	   Map<String,Object> currentsession = ActionContext.getContext().getSession();
	    currentsession.put("fid",st.nextElement());
	    String facebookid = (String) currentsession.get("fid");
	    int userID = (Integer) currentsession.get("userId");
	    Session session = HibernateUtil.getSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, userID, LockOptions.UPGRADE);
		user.setFacebookID(facebookid);
		session.update(user);
		session.getTransaction().commit();
		

	    System.out.println();
	    System.out.println("Thats it man! Go and build something awesome with Scribe! :)");
		
		System.out.println(code);
		System.out.println("error");
		
		
		 BufferedReader in = new BufferedReader(
			        new InputStreamReader(u.openStream()));

			        String inputLine;
			        ArrayList<String> ids = new ArrayList<String>();
			        while ((inputLine = in.readLine()) != null)
			        {
			        	 st = new StringTokenizer(inputLine,":\",");
			        	 String str = null;
			        	while(st.hasMoreElements())
			        	{
			        		str = (String) st.nextElement();
			        		if(str.equals("id"))
			        		{
			        			ids.add((st.nextToken()));
			        		}
			        	}
			        }
			        currentsession.put("friendids",ids);
			        createFriendMapping();
			        in.close();
			for(String i : ids)
			{
				System.out.println("id"+ i);
			}

	    

	}

}
