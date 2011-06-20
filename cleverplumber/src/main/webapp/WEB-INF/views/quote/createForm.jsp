<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Create Quote</title>
</head>	
<body>
<div class="container">
	<h1>
		Create Quote
	</h1>
	<div class="span-12 last">	
		<form:form modelAttribute="quote" action="quote" method="post">
		  	<fieldset>		
				<legend>Quote Fields</legend>
				<p>
					<form:select path="customer" items="${customerList}" itemValue="id" itemLabel="fullName"/>
					<form:errors path="customer" cssClass="errors"/>
				<p>
				<p>	
					<form:label for="labourAmount" path="labourAmount" cssErrorClass="error">Labour Cost</form:label><br/>
					<form:input path="labourAmount" /> <form:errors path="labourAmount" />
				</p>
				<p>	
					<form:label for="materialsAmount" path="materialsAmount" cssErrorClass="error">Materials Cost</form:label><br/>
					<form:input path="materialsAmount" /> <form:errors path="materialsAmount" />
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