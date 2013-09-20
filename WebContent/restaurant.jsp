<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurants</title>
</head>
<body>

<%@ page import="org.ASE.model.Restaurants" %>
<%@ page import="org.ASE.action.RestaurantAction" %>
<%@	page import="java.util.List" %>
<%@	page import="java.util.ArrayList" %>
<%@	page import="java.lang.reflect.Method" %>
<%@	page import="java.lang.reflect.InvocationTargetException" %>
<%@	page import="java.lang.NoSuchMethodException" %>
<%@	page import="java.lang.SecurityException" %>
<!-- <div style="text-align:center"><button type="button">Add to Todo List</button>
</div> -->
<table border="1">
<tr>
<%
	final String colEntries[] = {
			"EventID","EventName", "RestaurantType", "CuisineType", "StreetAddress",
			"ContactNumber", "Website","Likes"
	};
	
	List<Restaurants> restaurantList = new ArrayList<Restaurants>();
	
	restaurantList = RestaurantAction.getRestaurantList();
	Method entryMethod = null;
	String entry = null;
	
	//Create column headers
	for(int i = 0; i < colEntries.length; i++) {
		%><th><%=colEntries[i]%></th><%
	}
	%><%
	for(int i = 0; i < restaurantList.size(); i++) { 
		%><tr><%
		for(int j = 0; j < colEntries.length; j++) {
			%><td><%
			try {
				entryMethod = restaurantList.get(i).getClass().
								getDeclaredMethod("get" + colEntries[j]);
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
		%></tr>
		<%
	}
	%>
	<s:form method="post" >
	<tr>
		<td><s:textfield key="eventId" label="Enter Event Id"/></td>
	</tr>
	<s:submit value ="Add to Todo List" action="UserRestaurantEventAction"></s:submit>
	<s:submit value ="Like" action="RestaurantLikeAction"></s:submit>
	</s:form>
</table>

</body>
</html>