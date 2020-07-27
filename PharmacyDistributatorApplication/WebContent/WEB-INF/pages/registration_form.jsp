<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="../resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body background="../resources/images/img2.jpg">

<h2 align="center">Registration Form</h2>
	<sf:form modelAttribute="customer" action="${pageContext.request.contextPath}/pharmacy/registration_form">
	<table align ="center">
	<tr>
		<td>Username *</td>
		<td>: <sf:input type="text" name="username" required="required" path="cname"/></td>
	</tr>
	
	<tr>
		<td>Password * </td>
		<td>:  <input type="password" name="pwd" required="required" /></td>
	</tr>
	
	<tr>
		<td>Confirm Password *</td>
		<td>: <sf:input type="password" name="pwd" required="required" path="upass"/></td>
	</tr>
	
	<tr>
		<td>Address *</td>
		<td>: <sf:input type="text" name="add" required="required" path="address"/></td>
	</tr>
	
	<tr>
		<td>Email *</td>
		<td>: <sf:input type="email" name="email" required="required" path="emailid"/></td>
	</tr>
		
	<tr>
		<td>Mobile no *</td>
		<td>: <sf:input type="text" name="tel" required="required" path="mobileno"/></td>
	</tr>	
	
	<tr>
		<td>Post Code *</td>
		<td>: <sf:input type="text" name="ptc" required="required" path="pincode"/></td>
	</tr>
			
	<tr>
		<td>
		<input type="submit" value="Submit" />
		</td>
	</tr>
	</table>
	</sf:form>

</body>
</html>