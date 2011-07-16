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
					<form:label	for="customer.fullName" path="customer.fullName" cssErrorClass="error">Customer</form:label>
					<form:input path="customer.firstName" readonly="true"/>			
				</p>
				<p>
					<form:label	for="quoteType.description" path="quoteType.description" cssErrorClass="error">Quote Type</form:label>
					<form:input path="quoteType.description" readonly="true"/>			
				</p>
				<p>
					<form:label	for="brochureType.description" path="brochureType.description" cssErrorClass="error">Brochure</form:label>
					<form:input path="brochureType.description" readonly="true"/>			
				</p>
				<p>	
					<form:label for="labourCost" path="labourCost">Labour Cost</form:label>
					<form:input path="labourCost" readonly="true"/>
				</p>
				<p>
					<form:label for="materialCost" path="materialCost">Materials Cost</form:label>
					<form:input path="materialCost" readonly="true"/>
				</p>
		
				<p>
					<form:label for="Comments" path="materialCost">Comments</form:label>
					<c:forEach items="${quote.comments}" var="comment">
                           	 <c:out value="${comment.text}"/>&nbsp
                    </c:forEach>
				</p>
			</fieldset>
		</form:form>
	</div>
	
	<hr>
		<div class="pageMenu">
			<div class="pageMenuInner">
				<ul>
					<li class="competencies"><a href="home">Home</a>
					</li>
					<li class="competencies"><a href="viewQuote/list">Quote List</a>
					</li>
					<li class="competencies"><a href="viewQuote/pdf/${quote.id}">View PDF</a>
					</li>
				</ul>
			</div>
			<br class="clear" />
		</div>	
</div>
</body>
</html>