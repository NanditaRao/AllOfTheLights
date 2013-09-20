<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entertainment</title>
</head>
<body>

<%@ page import="org.ASE.model.Entertainment" %>
<%@ page import="org.ASE.action.EntertainmentAction" %>
<%@ page import="org.ASE.model.Shopping" %>
<%@ page import="org.ASE.action.ShoppingAction" %>
<%@ page import="org.ASE.model.Restaurants" %>
<%@ page import="org.ASE.action.RestaurantAction" %>
<%@ page import="org.ASE.action.viewTodoListAction" %>
<%@	page import="java.util.List" %>
<%@	page import="java.util.ArrayList" %>
<%@	page import="java.lang.reflect.Method" %>
<%@	page import="java.lang.reflect.InvocationTargetException" %>
<%@	page import="java.lang.NoSuchMethodException" %>
<%@	page import="java.lang.SecurityException" %>


<table border="1">
<tr>

<%


	final String colEntries[] = {
			"EventName", "EntertainmentType", "StreetAddress",
			"ContactNumber", "Website"
	};
	
	List<Entertainment> entertainmentList = new ArrayList<Entertainment>();
	
	
	entertainmentList = viewTodoListAction.getEntertainmentList();
    List<Restaurants> restaurantList = new ArrayList<Restaurants>();
	
	restaurantList = viewTodoListAction.getRestaurantList();
	
List<Shopping> shoppingList = new ArrayList<Shopping>();
	
shoppingList = viewTodoListAction.getShoppingList();
	
	Method entryMethod = null;
	String entry = null;
	
	//Create column headers
	for(int i = 0; i < colEntries.length; i++) {
		%><th><%=colEntries[i]%></th><%
	}
	%><th>AddToList</th><th>Like</th></tr><%
	for(int i = 0; i < entertainmentList.size(); i++) { 
		%><tr><%
		for(int j = 0; j < colEntries.length; j++) {
			%><td><%
			try {
				entryMethod = entertainmentList.get(i).getClass().
								getDeclaredMethod("get" + colEntries[j]);
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
					//<button><img src="Images/smiley.jpg" />
		}
		%><!-- <td align="center" ><form><input type="checkbox"></form></td>
		<td><button style="background:url('Images/smiley.jpg');height:40px;width:40px;" 
		/></button></td></tr> -->
		<%
		
	}
	%>

	
</table>

<table border="1">
<tr>
<%	
	final String colResEntries[] = {
			"EventName", "RestaurantType", "CuisineType", "StreetAddress",
			"ContactNumber", "Website"
	};
	
	
	
	Method entryMethodRes = null;
	String entryRes = null;
	
	//Create column headers
	for(int i = 0; i < colResEntries.length; i++) {
		%><th><%=colResEntries[i]%></th><%
	}
	%><th>AddToList</th><th>Like</th></tr><%
	for(int i = 0; i < restaurantList.size(); i++) { 
		%><tr><%
		for(int j = 0; j < colResEntries.length; j++) {
			%><td><%
			try {
				entryMethodRes = restaurantList.get(i).getClass().
								getDeclaredMethod("get" + colResEntries[j]);
			} catch (SecurityException e) {
				System.out.println("Exception: " + e);
			} catch (NoSuchMethodException e) {
				System.out.println("Exception: " + e);
			}
			try {
				entryRes = (String)entryMethodRes.invoke(restaurantList.get(i));
			} catch (InvocationTargetException e) {
				System.out.println("Exception: " + e);
			} catch (ExceptionInInitializerError e) {
				System.out.println("Exception: " + e);
			}
			%><%=entryRes%></td><%
		}
		%><!-- <td align="center" ><form><input type="checkbox"></form></td>
		<td><button style="background:url('Images/smiley.jpg');height:40px;width:40px;" 
		/></button></td></tr> -->
		<%
	}
	%>

</table>


<table border="1">
<tr>
<%	
	final String colShpEntries[] = {
		"EventID","EventName", "ContactNumber", "Website", "StreetAddress",
		"EventType", "ShopType","Likes"
	};
	
	
	
	Method entryMethodShp = null;
	String entryShp = null;
	
	//Create column headers
	for(int i = 0; i < colShpEntries.length; i++) {
		%><th><%=colShpEntries[i]%></th><%
	}
	%></tr><%
	for(int i = 0; i < shoppingList.size(); i++) { 
		%><tr><%
		for(int j = 0; j < colShpEntries.length; j++) {
			%><td><%
			try {
				entryMethodShp = shoppingList.get(i).getClass().
								getDeclaredMethod("get" + colShpEntries[j]);
			} catch (SecurityException e) {
				System.out.println("Exception: " + e);
			} catch (NoSuchMethodException e) {
				System.out.println("Exception: " + e);
			}
			try {
				entryShp = (String)entryMethodShp.invoke(shoppingList.get(i));
			} catch (InvocationTargetException e) {
				System.out.println("Exception: " + e);
			} catch (ExceptionInInitializerError e) {
				System.out.println("Exception: " + e);
			}
			%><%=entryShp%></td><%
		}
		%><!-- <td align="center" ><form><input type="checkbox"></form></td>
		<td><button style="background:url('Images/smiley.jpg');height:40px;width:40px;" 
		/></button></td></tr> -->
		<%
	}
	%>

</table>


</body>
</html>