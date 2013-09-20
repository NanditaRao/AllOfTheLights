<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>

<script type="text/javascript">

function login(){
    var userName = document.forms[0].userName.value;
    var password = document.forms[0].password.value;
    if(userName != '' && password != ''){
	document.forms[0].method = "POST";
	document.forms[0].action = "login";	
	document.forms[0].submit();
    }else{
    	alert("Please enter both username and password");
    }
}

function resetEditUser(){

	document.forms[0].method = "POST";
	document.forms[0].action = "CreateNotification.do";	
	document.forms[0].submit();
}
function createUser(){
	 var userName = document.forms[0].userNameAdd.value;
	 var password = document.forms[0].passwordAdd.value;
	 var firstName = document.forms[0].firstName.value;
	 var lastName = document.forms[0].lastName.value;
	 var city = document.forms[0].city.value;
	 var state = document.forms[0].state.value;
	 var country = document.forms[0].country.value;
	 if(userName == '' || firstName == '' ||password == '' || lastName == '' || city == '' || state == '' || country =='' ){
		 alert("Please enter all details.")
	 }else{
	document.forms[0].method = "POST";
	document.forms[0].action = "addUser.do";	
	document.forms[0].submit();
	 }
}
</script>
</head>
<body bgcolor="#ffffff">
<s:form action="login"  >
<table style="background-color:#C11B17;border:none;width:100%">

<tr>
<td colspan="3">
<font color="white" size="15px">

All of the lights

</font>
</td></tr>
<tr>
	<td width="60%"></td>
	<td style="text-align:right"><font color="white">
		User Name:</font>
	</td>
	<td>
		<s:textfield key="UserName" label="User Name" theme="simple"/>
	</td>
</tr>
<tr>
	<td width="60%"></td>
	<td style="text-align:right"><font color="white">
		Password:</font>
	</td>
	<td>
		<s:password key="password" label="Password" theme="simple" />
	</td>
</tr>
<tr>
	<td></td><td></td><td>
		<s:submit value="Log In" theme="simple"/>
	</td>
</tr>
<%
	if(request.getAttribute("successAddUserMessage")!=null){
		String successMessage = (String)request.getAttribute("successAddUserMessage");
		%>
		<tr>
		<td colspan=6 style = "font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #ffffff;" align="right"><%=successMessage%></td>
	    </tr>
		<%	
	}
	request.setAttribute("successAddUserMessage",null);
	%>
	
</table>
</s:form>

<br><br><br>
<table>
<tr>
<td width="80%">
<table   style="background-color:#ffffff;">
<tr  bgcolor="#ffffff">
<td bgcolor="#ffffff">
<img alt="" src="images/allofthelights.jpg" width="180%" height="130%">
</td>
</tr>
</table>

<td width="30%">
<table   style="background-color:#ffffff;">
<tr><td colspan=2 style="font-weight:bold;" align="center"><h1>Sign Up</h1></td></tr>
<tr><td colspan=2 height="10px"></td></tr>
	<%
	if(request.getAttribute("AddUserMessage")!=null){
		String successMessage = (String)request.getAttribute("AddUserMessage");
		%>
		<tr>
		<td colspan=2 style = "font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #000000;" align="center"><%=successMessage%></td>
	    </tr>
		<%	
	}
	request.setAttribute("AddUserMessage",null);
	%>
	<s:form action="createUser"  namespace="/user">
	<tr>
		<td><s:textfield key="firstName" label="First Name"/></td>
	</tr>
	<tr>
		
		<td><s:textfield key="lastName" label="Last Name" /></td>
	</tr>
	<tr>
		
		<td><s:textfield key="userNameAdd" label="User Name"/></td>
	</tr>
	<tr>
		
		<td><s:password key="passwordAdd" label ="Password"/></td>
	</tr>
	
	
	<tr>
		<td></td>

		<td style = "font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #000000;"><s:submit value ="Sign Up"></s:submit></td>
	</tr>
	<tr><td colspan=2 align="center" height="10px"></td></tr>
</s:form>
</table>

</table>	

</body>
</html>


