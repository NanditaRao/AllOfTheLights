<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="org.ASE.action.HomeAction" %>
<%@ page import="org.ASE.model.Entertainment" %>
<%@ page import="org.ASE.model.Restaurants" %>
<%@ page import="org.ASE.model.Shopping" %>
<%@	page import="java.util.List" %>
<%@	page import="java.util.ArrayList" %>
<%@	page import="java.lang.reflect.Method" %>
<%@	page import="java.lang.reflect.InvocationTargetException" %>
<%@	page import="java.lang.NoSuchMethodException" %>
<%@	page import="java.lang.SecurityException" %>

<div style="text-align:center">
	Most Recent Todo List
</div>

<%
	final String EntertainmentEntries[] = {
		"EventID", "EventName", "EntertainmentType", "StreetAddress",
		"ContactNumber", "Website", "Likes"
	};

	final String RestaurantEntries[] = {
			"EventName", "RestaurantType", "CuisineType", "StreetAddress",
			"ContactNumber", "Website", "Likes"
	};
	
	final String ShoppingEntries[] = {
			"EventName", "ShopType", "StreetAddress",
			"ContactNumber", "Website", "Likes"
	};
%>

<table border="1" width="100%">
	<tr><td><table border="1" width="100%">
	<caption style = "font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 20px">Entertainment</caption>
	
	<tr>
	<%
	
	List<Entertainment> entertainmentList = new ArrayList<Entertainment>();
	
	entertainmentList = HomeAction.getEntertainmentList();
	Method entryMethod = null;
	String entry = null;
	//Create column headers
	for(int i = 0; i < EntertainmentEntries.length; i++) {
		%><th><%=EntertainmentEntries[i]%></th><%
	}
	
	if (entertainmentList.size() == 0) {
		%><tr><td align="center" colspan="7">NONE SELECTED</td>
		<%
	}
	else {
		for(int i = 0; i < entertainmentList.size(); i++) { 
			%><tr><%
			for(int j = 0; j < EntertainmentEntries.length; j++) {
				%><td align="center"><%
				try {
					entryMethod = entertainmentList.get(i).getClass().
									getDeclaredMethod("get" + EntertainmentEntries[j]);
				} catch (SecurityException e) {
					System.out.println("Exception: " + e);
				} catch (NoSuchMethodException e) {
					System.out.println("Exception: " + e);
				}
				try {
					entry = (String)entryMethod.invoke(entertainmentList.get(i));
				} catch (InvocationTargetException e) {
					System.out.println("Exception: " + e);
				} catch (ExceptionInInitializerError e) {
					System.out.println("Exception: " + e);
				}
				%><%=entry%></td><%
			}
		}
	}
	%>	
	</tr>

	</table></td></tr>
	<tr><td><table border="1" width="100%">
	<caption style = "font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 20px">Restaurants</caption>
	<tr>
	<%
	List<Restaurants> restaurantList = new ArrayList<Restaurants>();
	
	
	restaurantList = HomeAction.getRestaurantList();

	
	//Create column headers
	for(int i = 0; i < RestaurantEntries.length; i++) {
		%><th><%=RestaurantEntries[i]%></th><%
	}
	
	if (restaurantList.size() == 0) {
		%><tr><td align="center" colspan="7">NONE SELECTED</td>
		<%
	}
	else {
		for(int i = 0; i < restaurantList.size(); i++) { 
			%><tr><%
			for(int j = 0; j < RestaurantEntries.length; j++) {
				%><td align="center"><%
				try {
					entryMethod = restaurantList.get(i).getClass().
									getDeclaredMethod("get" + RestaurantEntries[j]);
				} catch (SecurityException e) {
					System.out.println("Exception: " + e);
				} catch (NoSuchMethodException e) {
					System.out.println("Exception: " + e);
				}
				try {
					entry = (String)entryMethod.invoke(restaurantList.get(i));
				} catch (InvocationTargetException e) {
					System.out.println("Exception: " + e);
				} catch (ExceptionInInitializerError e) {
					System.out.println("Exception: " + e);
				}
				%><%=entry%></td><%
			}
		}
	}
	%>	
	</tr>

	</table></td></tr>
	<tr><td><table border="1" width="100%">
	<caption style = "font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 20px">Shopping</caption>
	<tr>
	<%
	List<Shopping> shoppingList = new ArrayList<Shopping>();
	
	
	//shoppingList = HomeAction.getShoppingList();

	
	//Create column headers
	for(int i = 0; i < ShoppingEntries.length; i++) {
		%><th><%=ShoppingEntries[i]%></th><%
	}
	
	if (shoppingList.size() == 0) {
		%><tr><td align="center" colspan="6">NONE SELECTED</td>
		<%
	}
	else {
		for(int i = 0; i < shoppingList.size(); i++) { 
			%><tr><%
			for(int j = 0; j < ShoppingEntries.length; j++) {
				%><td align="center"><%
				try {
					entryMethod = shoppingList.get(i).getClass().
									getDeclaredMethod("get" + ShoppingEntries[j]);
				} catch (SecurityException e) {
					System.out.println("Exception: " + e);
				} catch (NoSuchMethodException e) {
					System.out.println("Exception: " + e);
				}
				try {
					entry = (String)entryMethod.invoke(shoppingList.get(i));
				} catch (InvocationTargetException e) {
					System.out.println("Exception: " + e);
				} catch (ExceptionInInitializerError e) {
					System.out.println("Exception: " + e);
				}
				%><%=entry%></td><%
			}
		}
	}	
	%>
	</tr>
	</table></td></tr>

</table>


</body>
</html>