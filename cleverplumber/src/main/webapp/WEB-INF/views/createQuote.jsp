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
		<form:form modelAttribute="quote" method="post">
		  	<fieldset>		
				<form:hidden path="customer.id"/>
				<p>
					<form:label for="company" path="company" cssErrorClass="error">Company</form:label><br/>
					<form:select path="company" items="${companyList}" itemValue="id" itemLabel="name"/>
					<form:errors path="company" cssClass="errors"/>
				</p>
				<p>
                  <form:label for="quoteType" path="quoteType" cssErrorClass="error">Quote Type</form:label><br/>
                  <form:select path="quoteType">
                     <form:option value="" label="" />
                     <form:options items="${quoteTypes}" itemValue="value" itemLabel="description"/>
                  </form:select>
                  <form:errors path="quoteType" cssClass="errorMessage" />
               </p>
               <p>
                  <form:label for="brochureType" path="brochureType" cssErrorClass="error">Brochure Type</form:label><br/>
                  <form:select path="brochureType">
                     <form:option value="" label="" />
                     <form:options items="${brochureTypes}" itemValue="value" itemLabel="description"/>
                  </form:select>
                  <form:errors path="brochureType" cssClass="errorMessage" />
               </p>
				<p>	
					<form:label for="labourCost" path="labourCost" cssErrorClass="error">Labour Cost</form:label><br/>
					<form:input path="labourCost" /> <form:errors path="labourCost" />
				</p>
				<p>	
					<form:label for="materialCost" path="materialCost" cssErrorClass="error">Materials Cost</form:label><br/>
					<form:input path="materialCost" /> <form:errors path="labourCost" />
				</p>
				<p>	
					<input type="submit" value="Create"/>
				</p>
			</fieldset>
		</form:form>
	</div>
	<hr>	
</div>
</body>
</html>