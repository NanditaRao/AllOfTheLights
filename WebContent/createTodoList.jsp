<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create TodoList</title>
</head>
<body>
<s:form action="TodoListAction"  >
<table style="background-color:#C11B17;border:none" >

<tr>

<td bordercolor="none">
<td style = "font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #ffffff;" align="right"></td>
		<td align="left" width="10%"><s:textfield key="date" label="Enter Date"/></td>



<s:submit value="Create TodoList"/></td>


</tr>

	
</table>
</s:form>
<s:form action="viewTodoListAction"  >
<table style="background-color:#C11B17;border:none" >

<tr>

<td bordercolor="none">
<td style = "font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #ffffff;" align="right"></td>
		<td align="left" width="10%"><s:textfield key="date" label="Enter Date"/></td>



<s:submit value="View TodoList"/></td>


</tr>

	
</table>
</s:form>

</body>
</html>