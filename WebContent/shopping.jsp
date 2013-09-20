<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping</title>
</head>
<body>

<%@ page import="org.ASE.model.Shopping" %>
<%@ page import="org.ASE.action.ShoppingAction" %>
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
		"EventID","EventName", "ContactNumber", "Website", "StreetAddress",
		"EventType", "ShopType","Likes"
	};
	
	List<Shopping> shoppingList = new ArrayList<Shopping>();
	
	shoppingList = ShoppingAction.getShoppingList();
	Method entryMethod = null;
	String entry = null;
	
	//Create column headers
	for(int i = 0; i < colEntries.length; i++) {
		%><th><%=colEntries[i]%></th><%
	}
	%></tr><%
	for(int i = 0; i < shoppingList.size(); i++) { 
		%><tr><%
		for(int j = 0; j < colEntries.length; j++) {
			%><td><%
			try {
				entryMethod = shoppingList.get(i).getClass().
								getDeclaredMethod("get" + colEntries[j]);
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
		%>
		<%
	}
	%>
	<s:form method="post" >
	<tr>
		<td><s:textfield key="eventId" label="Enter Event Id"/></td>
	</tr>
	<s:submit value ="Add to Todo List" action="UserShoppingEventAction"></s:submit>
	<s:submit value ="Like" action="ShoppingLikeAction"></s:submit>
	</s:form>
</table>

</body>
</html>