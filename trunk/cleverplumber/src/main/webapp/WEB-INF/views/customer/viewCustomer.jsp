<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<META  http-equiv="Content-Type"  content="text/html;charset=UTF-8">
<head>
	<title>View Customer</title>
</head>
</head>
<body>
	<div class="container">
		<h1>View Customer</h1>
		<div class="span-12 last">
			<form:form modelAttribute="customer" action="${customer.id}" method="post">
			<table class="form">
		  		<tr>	  		
					<td>
						<form:label for="title" path="title">Title</form:label>
					</td>
					<td>
						<form:input path="title" readonly="true" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label for="firstName" path="firstName">First Name</form:label>
					</td>
					<td>
				
						<form:input path="firstName" readonly="true" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label for="lastName" path="lastName">Last Name</form:label>
					</td>
					<td>
						<form:input path="lastName" readonly="true" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label for="addressLine1" path="addressLine1">Address Line 1</form:label>
					</td>
					<td>
						<form:input path="addressLine1" readonly="true" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label for="addressLine2" path="addressLine2">Address Line 2</form:label>
					</td>
					<td>
						<form:input path="addressLine2" readonly="true" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label for="addressLine3" path="addressLine3">Address Line 3</form:label>
					</td>
					<td>
						<form:input path="addressLine3" readonly="true" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label for="postcode" path="postcode">Post code</form:label>
					</td>
					<td>
						<form:input path="postcode" readonly="true" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label for="phoneNumber" path="phoneNumber">Phone Number</form:label>
					</td>
					<td>
						<form:input path="phoneNumber" readonly="true" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label for="emailAddress" path="emailAddress">Email Address</form:label>
					</td>
					<td>
						<form:input path="emailAddress" readonly="true" />
					</td>
				</tr>
			</table>
			</form:form>
		</div>
		<hr>
		<div class="pageMenu">
			<div class="pageMenuInner">
				<ul>
					<li class="competencies"><a href="<c:url value='/home.do'/>">Home</a></li>
					<li class="competencies"><a href="<c:url value='/viewCustomer/list.do'/>">Customer List</a></li>
					<li class="competencies"><a href="<c:url value='/editCustomer.do?id='/>${customer.id}">Edit</a></li>
					<li class="competencies"><a href="<c:url value='/newQuote.do?customer.id='/>${customer.id}">New Quote</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>
	</div>
</body>
</html>