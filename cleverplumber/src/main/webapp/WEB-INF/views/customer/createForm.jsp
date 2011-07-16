<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
	<title>Create Customer</title>
</head>	
<body>
<div class="container">
	<h1>
		Create Customer
	</h1>
	<div class="span-12 last">	
		<form:form modelAttribute="customer" method="post">
		  	<fieldset>		
				<p>
					<form:label	for="title" path="title" cssErrorClass="error">Title</form:label>
					<form:input path="title" /> <form:errors path="title" />			
				</p>
				<p>
					<form:label	for="firstName" path="firstName" cssErrorClass="error">First Name</form:label>
					<form:input path="firstName" /> <form:errors path="firstName" />			
				</p>
				<p>
					<form:label	for="lastName" path="lastName" cssErrorClass="error">Last Name</form:label>
					<form:input path="lastName" /> <form:errors path="lastName" />			
				</p>
				<p>	
					<form:label for="addressLine1" path="addressLine1" cssErrorClass="error">Address Line 1</form:label>
					<form:input path="addressLine1" /> <form:errors path="addressLine1" />
				</p>
				<p>	
					<form:label for="addressLine2" path="addressLine2" cssErrorClass="error">Address Line 2</form:label>
					<form:input path="addressLine2" /> <form:errors path="addressLine2" />
				</p>
				<p>	
					<form:label for="addressLine3" path="addressLine3" cssErrorClass="error">Address Line 3</form:label>
					<form:input path="addressLine3" /> <form:errors path="addressLine3" />
				</p>
				<p>	
					<form:label for="postcode" path="postcode" cssErrorClass="error">Postcode</form:label>
					<form:input path="postcode" /> <form:errors path="postcode" />
				</p>
				<p>	
					<form:label for="phoneNumber" path="phoneNumber" cssErrorClass="error">Phone Number</form:label>
					<form:input path="phoneNumber" /> <form:errors path="phoneNumber" />
				</p>
				
				<p>	
					<form:label for="emailAddress" path="emailAddress" cssErrorClass="error">Email Address</form:label>
					<form:input path="emailAddress" /> <form:errors path="emailAddress" />
				</p>
				<p>	
					<input type="submit" />
				</p>
			</fieldset>
		</form:form>
	</div>
	<hr>	
</div>
</body>
</html>