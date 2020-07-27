<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- ${message } -->
	<h1>Hello Customer : Please Register</h1>
	<sf:form modelAttribute="CustomerDetail"  action="${pageContext.request.contextPath}/pharmacy/sucess.jsp" method="POST">
		<table align="center" border="1">
			<tr>
				<td>Name: </td>
				<td><sf:input id="txtCustName" path="name" /></td>
			</tr>
			
			<tr>
				<td>Address: </td>
				<td><sf:input id="txtAdd" path="address" /></td>
			</tr>
			
			<tr>
				<td>Email Id: </td>
				<td><sf:input id="txtEmailId" path="emailId" /></td>
			</tr>
			
			<tr>
				<td>Password: </td>
				<td><sf:input id="txtPassword" path="password" /></td>
			</tr>			
			
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	
	</sf:form>
</body>

</html>
