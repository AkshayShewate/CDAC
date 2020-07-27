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
<h1 align ="center">Pending orders</h1>

<div class="col-sm-12">
<ul class="navi">
	<li><a href="index" title="">home</a></li>
	<li><a href="sales" title="">Pending orders</a></li>
	<li><a href="cust_details" title="">Customer Information</a></li>
	<li><a href="promo" title="">Promotions</a></li>
	<li><a href="report" title="">Sales Report</a></li>
	<li><a href="index" title="">Logout</a></li>
	<div class="col-sm-12 li"></div>
</ul>
</div>

<c:if test="${not empty orderList}">
		
		<table border="1" align="center">
		<tr bgcolor="white">
			<th>Product ID</th>
			<th>Customer Info</th>
			<th>Product Name</th>
			<th>Quantity</th>
			<th>Order Date</th>
		</tr>
		<c:forEach var="pro" items="${orderList}">
			<tr bgcolor="white">
				<td>${pro.pid }</td>
				<td>${pro.cid }</td>
				<td>${pro.productname }</td>
				<td>${pro.quantity }</td>
				<td>${pro.odate }</td>
				<%-- <td><a href="admin_panel/get/${pro.id }">Edit</a></td> --%>
			</tr>	
		</c:forEach>
	</table>
	
	</c:if>
</body>
</html>