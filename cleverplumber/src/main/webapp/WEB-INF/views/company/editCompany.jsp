<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Edit Company</title>
</head>	
<body>
<div class="container">
	<h1>
		Edit Company
	</h1>
		<form:form modelAttribute="company" action="editCompany.do" method="post">
			<form:hidden path="id" /> 	
			<table class="form">
					<tr>
						<td width="30%">
							 <strong>Name</strong>
						</td>
						<td>
							<form:input path="name" /> 
							<form:errors path="name" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Address Line 1</strong>
						</td>
						<td>
							<form:input path="addressLine1" /> 
							<form:errors path="addressLine1" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Address Line 2</strong>
						</td>
						<td>
							<form:input path="addressLine2" /> 
							<form:errors path="addressLine2" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Address Line 3</strong>
						</td>
						<td>
							<form:input path="addressLine3" /> 
							<form:errors path="addressLine3" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Postcode</strong>
						</td>
						<td>
							<form:input path="postcode" /> 
							<form:errors path="postcode" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Phone Number</strong>
						</td>
						<td>
							<form:input path="phoneNumber" /> 
							<form:errors path="phoneNumber" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Vat Number</strong>
						</td>
						<td>
							<form:input path="vatNumber" /> 
							<form:errors path="vatNumber" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Registered Number</strong>
						</td>
						<td>
							<form:input path="registeredNumber" /> 
							<form:errors path="registeredNumber" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Email Address</strong>
						</td>
						<td>
							<form:input path="emailAddress" /> 
							<form:errors path="emailAddress" cssClass="errorMessage"/>	
						</td>
					</tr>
			</table>
	 		<div class="buttonMargin">
				<input type="submit" class="button" name="Edit" value="Edit" />
			</div>
	 	</form:form>
	</div>
	<hr>	
</body>
</html>