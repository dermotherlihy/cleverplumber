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
		<form:form modelAttribute="company" action="${company.id}" method="post">
			<table class="form">
					<tr>
						<td width="30%">
							 <strong>Name</strong>
						</td>
						<td>
							<form:input path="name" readonly="true"/> 
							<form:errors path="name" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Address Line 1</strong>
						</td>
						<td>
							<form:input path="addressLine1" readonly="true"/> 
							<form:errors path="addressLine1" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Address Line 2</strong>
						</td>
						<td>
							<form:input path="addressLine2" readonly="true"/> 
							<form:errors path="addressLine2" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Address Line 3</strong>
						</td>
						<td>
							<form:input path="addressLine3" readonly="true"/> 
							<form:errors path="addressLine3" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Postcode</strong>
						</td>
						<td>
							<form:input path="postcode" readonly="true"/> 
							<form:errors path="postcode" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Phone Number</strong>
						</td>
						<td>
							<form:input path="phoneNumber" readonly="true"/> 
							<form:errors path="phoneNumber" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Vat Number</strong>
						</td>
						<td>
							<form:input path="vatNumber" readonly="true"/> 
							<form:errors path="vatNumber" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Registered Number</strong>
						</td>
						<td>
							<form:input path="registeredNumber" readonly="true"/> 
							<form:errors path="registeredNumber" cssClass="errorMessage"/>	
						</td>
					</tr>
					<tr>
						<td>
							 <strong>Email Address</strong>
						</td>
						<td>
							<form:input path="emailAddress" readonly="true"/> 
							<form:errors path="emailAddress" cssClass="errorMessage"/>	
						</td>
					</tr>
			</table>
		</form:form>
		<hr>
		<div class="pageMenu">
			<div class="pageMenuInner">
				<ul>
					<li class="competencies"><a href="<c:url value='/home.do'/>">Home</a></li>
					<li class="competencies"><a href="<c:url value='/editCompany.do?id='/>${company.id}">Edit</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>	
</div>
</body>
</html>