<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>Home Page </title>
	</head>
<body>
<div class="container">  
	<hr>	
	<ul>
		<li><a href="viewCustomer/list.do">Customers</a></li>
		<li><a href="viewQuote/list.do">Quotes</a></li>
		<li><a href="company.do">Company Information</a></li>
		<li class="logout"><a href="logout.do">Logout</a></li>
	</ul>
</div>
</body>
</html>