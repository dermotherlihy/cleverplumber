<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Edit Quote</title>
</head>	
<body>
<div class="container">
	<h1>
		Edit Quote
	</h1>
	<div class="span-12 last">	
		<form:form modelAttribute="quote" method="post">
		  	<fieldset>		
		  		<form:hidden path="id"/>
				<form:hidden path="customer.id"/>
				<form:hidden path="company.id"/>
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
					<form:label for="labour" path="labour" cssErrorClass="error">Labour Cost</form:label><br/>
					<form:input path="labour" /> <form:errors path="labour" cssClass="errorMessage" />
				</p>
				<p>	
					<form:label for="materials" path="materials" cssErrorClass="error">Materials Cost</form:label><br/>
					<form:input path="materials" /> <form:errors path="materials"  cssClass="errorMessage"/>
				</p>
				<p>	
					<input type="submit" class="button" value="Edit"/>
					<input type="submit" class="button" name="cancel" value="Cancel">
				</p>
			</fieldset>
		</form:form>
	</div>
	<hr>	
</div>
</body>
</html>