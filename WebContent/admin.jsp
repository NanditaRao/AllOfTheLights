<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
<s:form  method="post" >
<span style="float:center;">
	<s:textfield key="userId" label = "Enter UserId" />
</span>
<div style="text-align:center">
	<span style="float:left;">
		
			<s:submit value="Reset Password" action="AdminResetPasswordAction"  />
		
	</span>
	<span>
		
			<s:submit  value="BanUser" action="AdminBanUserAction" />
		
	</span>
</div>
</s:form>
</body>
</html>