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
<link rel="stylesheet" href="../resources/css/table.css">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body background="../resources/images/img2.jpg">
<p >
<h1 align="center">Admin Control Panel</h1></p>
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


<c:if test="${not empty productList}">
		
		<table border="1" align="center">
		<tr bgcolor="white">
			<th>ID</th>
			<th>Product Name</th>
			<th>Stock Available</th>
			<th>Expiry Date Of Product</th>
			
		</tr>
		<c:forEach var="pro" items="${productList}">
			<tr bgcolor="white">
				<td>${pro.pid }</td>
				<td>${pro.productname }</td>
				<td>${pro.stock }</td>
				<td>${pro.expirydate }</td>
				<%-- <td><a href="admin_panel/get/${pro.id }">Edit</a></td> --%>
			</tr>	
		</c:forEach>
	</table>
	
	</c:if>
</body>
</html>