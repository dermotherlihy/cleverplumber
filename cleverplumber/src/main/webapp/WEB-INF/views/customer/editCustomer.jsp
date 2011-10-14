<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
	<title>Edit Customer</title>
</head>	
<body>
	<h1>
		Edit Customer
	</h1>
	<form:form modelAttribute="customer"  method="post">
			<form:hidden path="id" /> 			
			<table class="form" width="30%">
		  		<tr>	  		
					<td>
						Title
					</td>
					<td>
						<form:input path="title" />
						<form:errors path ="title"/>
					</td>
				</tr>
				<tr>
					<td>
						First Name
					</td>
					<td>
						<form:input path="firstName"  />
						<form:errors path ="firstName"/>
					</td>
				</tr>
				<tr>
					<td>
						Last Name
					</td>
					<td>
						<form:input path="lastName"  />
						<form:errors path ="lastName"/>
					</td>
				</tr>
				<tr>
					<td>
						Address Line 1
					</td>
					<td>
						<form:input path="addressLine1"/>
						<form:errors path ="addressLine1"/>
					</td>
				</tr>
				<tr>
					<td>
						Address Line 2
					</td>
					<td>
						<form:input path="addressLine2"/>
						<form:errors path ="addressLine2"/>
					</td>
				</tr>
				<tr>
					<td>
						Address Line 3
					</td>
					<td>
						<form:input path="addressLine3"/>
						<form:errors path ="addressLine3"/>
					</td>
				</tr>
				<tr>
					<td>
						Post code
					</td>
					<td>
						<form:input path="postcode"  />
						<form:errors path ="postcode"/>
					</td>
				</tr>
				<tr>
					<td>
						Phone Number
					</td>
					<td>
						<form:input path="phoneNumber"  />
						<form:errors path ="phoneNumber"/>
					</td>
				</tr>
				<tr>
					<td>
						Email Address
					</td>
					<td>
						<form:input path="emailAddress"  />
						<form:errors path ="emailAddress"/>
					</td>
				</tr>
			</table>
			<div class="buttonMargin">
				<input type="submit" class="button" name="Edit" value="Edit" />
				<input type="submit" class="button" name="cancel" value="Cancel">
			</div>
			</form:form>
</body>
</html>