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
			<form:form modelAttribute="customer" action="${customer.id}"
				method="post">
				<fieldset>
					<p>
						<form:label for="title" path="title">Title</form:label>
						<form:input path="title" readonly="true" />
					</p>
					<p>
						<form:label for="firstName" path="firstName">First Name</form:label>
						<form:input path="firstName" readonly="true" />
					</p>
					<p>
						<form:label for="lastName" path="lastName">Last Name</form:label>
						<form:input path="lastName" readonly="true" />
					</p>
					<p>
						<form:label for="addressLine1" path="addressLine1">Address Line 1</form:label>
						<form:input path="addressLine1" readonly="true" />
					</p>
					<p>
						<form:label for="addressLine2" path="addressLine2">Address Line 2</form:label>
						<form:input path="addressLine2" readonly="true" />
					</p>
					<p>
						<form:label for="addressLine3" path="addressLine3">Address Line 3</form:label>
						<form:input path="addressLine3" readonly="true" />
					</p>
					<p>
						<form:label for="postcode" path="postcode">Post code</form:label>
						<form:input path="postcode" readonly="true" />
					</p>
					<p>
						<form:label for="phoneNumber" path="phoneNumber">Phone Number</form:label>
						<form:input path="phoneNumber" readonly="true" />
					</p>
					<p>
						<form:label for="emailAddress" path="emailAddress">Email Address</form:label>
						<form:input path="emailAddress" readonly="true" />
					</p>
				</fieldset>
			</form:form>
		</div>
		<hr>
		<div class="pageMenu">
			<div class="pageMenuInner">
				<ul>
					<li class="competencies"><a href="<c:url value='/home'/>">Home</a>
					</li>
					<li class="competencies"><a href="<c:url value='/viewCustomer/list'/>">Customer List</a>
					</li>
				</ul>
			</div>
			<br class="clear" />
		</div>
	</div>
</body>
</html>