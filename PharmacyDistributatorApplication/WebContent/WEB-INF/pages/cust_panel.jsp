<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/style.css">
</head>
<body background="../resources/images/img2.jpg">
<h1 align="center">Customer Control Panel</h1>

<div class="col-sm-12">
<ul class="navi">
	<li><a href="index" title="">home</a></li>
	<li><a href="my_orders" title="">My orders</a></li>
	<li><a href="offers" title="">Offers</a></li>
	<!-- <li><a href="my_account" title="">My Account</a></li> -->
	<li><a href="index" title="">Logout</a></li>
	<div class="col-sm-12 li"></div>
</ul>
</div>

<c:if test="${not empty productList}">
		
		<table border="1" align="center">
		<tr bgcolor="white">
			<th>Product Name</th>
			<th>Price Of Product</th>
			<th>Buy Products</th>
		</tr>
		<c:forEach var="pro" items="${productList}">
			<tr bgcolor="white">
				<td>${pro.productname }</td>
				<td>${pro.price }</td>
				<td><input type="button" value="buy"/></td>
				<%-- <td><a href="admin_panel/get/${pro.id }">Edit</a></td> --%>
			</tr>	
		</c:forEach>
	</table>
	
	</c:if>
</body>
</html>