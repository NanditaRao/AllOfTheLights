<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="org.ASE.model.UserFriends" %>
<%@ page import="org.ASE.action.viewFriendAction" %>
<%@ page import="org.ASE.model.UserDetails" %>
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
			"firstName", "lastName", "userName",
			};
	
	List<UserDetails> friendList = new ArrayList<UserDetails>();
	
	
	friendList = viewFriendAction.getFriendlist();
    
	
	Method entryMethod = null;
	String entry = null;
	
	//Create column headers
	for(int i = 0; i < colEntries.length; i++) {
		%><th><%=colEntries[i]%></th><%
	}
	%><th>AddToList</th><th>Like</th></tr><%
	for(int i = 0; i < friendList.size(); i++) { 
		%><tr><%
		for(int j = 0; j < colEntries.length; j++) {
			%><td><%
			try {
				entryMethod = friendList.get(i).getClass().
								getDeclaredMethod("get" + colEntries[j]);
			} catch (SecurityException e) {
				System.out.println("Exception: " + e);
			} catch (NoSuchMethodException e) {
				System.out.println("Exception: " + e);
			}
			try {
				entry = (String)entryMethod.invoke(friendList.get(i));
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


</body>
</html>