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
			"EventID","EventName", "EntertainmentType", "StreetAddress",
			"ContactNumber", "Website","Likes"
	};
	
	List<Entertainment> entertainmentList = new ArrayList<Entertainment>();
	
	entertainmentList = EntertainmentAction.getEntertainmentList();
	Method entryMethod = null;
	String entry = null;
	
	//Create column headers
	for(int i = 0; i < colEntries.length; i++) {
		%><th><%=colEntries[i]%></th><%
	}
	%></tr><%
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
		%></tr>
		<%
	}
	%>
	<s:form method="post" >
	<tr>
		<td><s:textfield key="eventId" label="Enter Event Id"/></td>
	</tr>
	<s:submit value ="Add to Todo List" action="UserEntertainmentEventAction"></s:submit>
	
	
	<s:submit value ="Like" action="EntertainmentLikeAction"></s:submit>
	
	</s:form>
</table>

</body>
</html>