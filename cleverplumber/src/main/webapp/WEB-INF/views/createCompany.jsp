<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Create Company</title>
</head>	
<body>
<div class="container">
	<h1>
		Create Company
	</h1>
	<div class="span-12 last">	
		<form:form modelAttribute="company" action="company" method="post">
		  	<fieldset>		
				<p>
					<form:label	for="name" path="name" cssErrorClass="error">Name</form:label><br/>
					<form:input path="name" /> <form:errors path="name" />			
				</p>
				<p>	
					<form:label for="addressLine1" path="addressLine1" cssErrorClass="error">Address Line 1</form:label><br/>
					<form:input path="addressLine1" /> <form:errors path="addressLine1" />
				</p>
				<p>	
					<form:label for="addressLine2" path="addressLine2" cssErrorClass="error">Address Line 2</form:label><br/>
					<form:input path="addressLine2" /> <form:errors path="addressLine2" />
				</p>
				<p>	
					<form:label for="addressLine3" path="addressLine3" cssErrorClass="error">Address Line 3</form:label><br/>
					<form:input path="addressLine3" /> <form:errors path="addressLine3" />
				</p>
				<p>	
					<form:label for="postcode" path="postcode" cssErrorClass="error">Postcode</form:label><br/>
					<form:input path="postcode" /> <form:errors path="postcode" />
				</p>
				<p>	
					<form:label for="phoneNumber" path="phoneNumber" cssErrorClass="error">Phone Number</form:label><br/>
					<form:input path="phoneNumber" /> <form:errors path="phoneNumber" />
				</p>
				
				<p>	
					<form:label for="vatNumber" path="vatNumber" cssErrorClass="error">Vat Number</form:label><br/>
					<form:input path="vatNumber" /> <form:errors path="vatNumber" />
				</p>
				
				<p>	
					<form:label for="emailAddress" path="emailAddress" cssErrorClass="error">Email Address</form:label><br/>
					<form:input path="emailAddress" /> <form:errors path="emailAddress" />
				</p>
				
				<p>	
					<input type="submit"  value="Create"/>
				</p>
			</fieldset>
		</form:form>
	</div>
	<hr>	
</div>
</body>
</html>