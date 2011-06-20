<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Quote Details</title>
</head>	
<body>
<div class="container">
	<h1>
		View Quote
	</h1>
	<div class="span-12 last">	
		<form:form modelAttribute="quote" action="${quote.id}" method="post">
		  	<fieldset>		
				<p>
					<form:label	for="customer.name" path="customer.name">Customer Name</form:label><br/>
					<form:input path="customer.name" readonly="true"/>		
				</p>
				<p>	
					<form:label for="labourAmount" path="labourAmount">Labour Cost</form:label><br/>
					<form:input path="labourAmount" readonly="true"/>
				</p>
				<p>
					<form:label for="materialsAmount" path="materialsAmount">Materials Cost</form:label><br/>
					<form:input path="materialsAmount" readonly="true"/>
				</p>
			</fieldset>
		</form:form>
	</div>
	<hr>	
</div>
</body>
</html>