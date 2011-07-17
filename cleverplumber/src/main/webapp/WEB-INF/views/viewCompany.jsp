<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Company Details</title>
</head>	
<body>
<div class="container">
	<h1>
		View Company
	</h1>
	<div class="span-12 last">	
		<form:form modelAttribute="company" action="${company.id}" method="post">
		  	<fieldset>		
				<p>
					<form:label	for="name" path="name">Name</form:label><br/>
					<form:input path="name" readonly="true"/>		
				</p>
				<p>	
					<form:label for="addressLine1" path="addressLine1">Address Line 1</form:label><br/>
					<form:input path="addressLine1" readonly="true"/>
				</p>
				<p>
					<form:label for="addressLine2" path="addressLine2">Address Line 2</form:label><br/>
					<form:input path="addressLine2" readonly="true"/>
				</p>
				<p>	
					<form:label for="addressLine3" path="addressLine3">Address Line 3</form:label><br/>
					<form:input path="addressLine3" readonly="true"/>
				</p>
				<p>	
					<form:label for="postcode" path="postcode">Post code</form:label><br/>
					<form:input path="postcode" readonly="true"/>
				</p>
				<p>	
					<form:label for="phoneNumber" path="phoneNumber">Phone Number</form:label><br/>
					<form:input path="phoneNumber" readonly="true"/>
				</p>
				<p>	
					<form:label for="vatNumber" path="vatNumber">Vat Number</form:label><br/>
					<form:input path="vatNumber" readonly="true"/>
				</p>
				<p>	
					<form:label for="emailAddress" path="emailAddress">Email Address</form:label><br/>
					<form:input path="emailAddress" readonly="true"/>
				</p>
				
			</fieldset>
		</form:form>
		<hr>
		<div class="pageMenu">
			<div class="pageMenuInner">
				<ul>
					<li class="competencies"><a href="<c:url value='/home'/>">Home</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>	
</div>
</body>
</html>