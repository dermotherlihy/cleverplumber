<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<META  http-equiv="Content-Type"  content="text/html;charset=UTF-8">
<title>Create Quote</title>
</head>
<body>
	<div class="container">
		<h1>Create Quote</h1>
		<div class="span-12 last">
			<form:form modelAttribute="quote" method="post">
				<fieldset>
					<form:hidden path="id" />
					<table class="form">
						<tr>
							<td><form:label for="quoteType" path="quoteType"
									cssErrorClass="error">Quote Type</form:label><br />
							</td>
							<td><form:select path="quoteType">
									<form:option value="" label="" />
									<form:options items="${quoteTypes}" itemValue="value"
										itemLabel="description" />
								</form:select> <form:errors path="quoteType" cssClass="errorMessage" />
							</td>
						</tr>
						<tr>
							<td><form:label for="brochureType" path="brochureType"
									cssErrorClass="error">Brochure Type</form:label>
							</td>
							<td><form:select path="brochureType">
									<form:option value="" label="" />
									<form:options items="${brochureTypes}" itemValue="value"
										itemLabel="description" />
								</form:select> <form:errors path="brochureType" cssClass="errorMessage" />
							</td>
						</tr>
						<tr>
							<td><form:label for="job.addressLine1"
									path="job.addressLine1" cssErrorClass="error">Job Address Line 1</form:label>
							</td>
							<td><form:input path="job.addressLine1" /> <form:errors
									path="job.addressLine1" />
							</td>
						</tr>
						<tr>
							<td><form:label for="job.addressLine2"
									path="job.addressLine2" cssErrorClass="error">Job Address Line 2</form:label>
							</td>
							<td><form:input path="job.addressLine2" /> <form:errors
									path="job.addressLine2" />
							</td>
						</tr>
						<tr>
							<td><form:label for="job.addressLine3"
									path="job.addressLine3" cssErrorClass="error">Job Address Line 3</form:label>
							</td>
							<td><form:input path="job.addressLine3" /> <form:errors
									path="job.addressLine3" />
							</td>
						</tr>
						<tr>
							<td><form:label for="job.postcode" path="job.postcode"
									cssErrorClass="error">Job Postcode</form:label>
							</td>
							<td><form:input path="job.postcode" /> <form:errors
									path="job.postcode" />
							</td>
						</tr>
						<tr>
							<td><form:label for="labour" path="labour"
									cssErrorClass="error">Labour Cost</form:label>
							</td>
							<td><form:input path="labour" /> <form:errors path="labour"
									cssClass="errorMessage" />
							</td>
						</tr>
						<tr>
							<td><form:label for="materials" path="materials"
									cssErrorClass="error">Materials Cost</form:label></td>
							<td><form:input path="materials" /> <form:errors
									path="materials" cssClass="errorMessage" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Create" />
							</td>
						</tr>
					</table>
				</fieldset>
			</form:form>
		</div>

	</div>
</body>
</html>