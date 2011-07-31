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
	<form:form modelAttribute="quote" action="${quote.id}" method="post">
		  	<table class="form">
		  		<tr>	  		
					<td>
						<form:label	for="customer.fullName" path="customer.fullName" cssErrorClass="error">Customer</form:label>
					</td>
					<td>
						<form:input path="customer.fullName" readonly="true"/>			
					</td>
				</tr>
				<tr>	  		
					<td>	
						<form:label	for="quoteType.description" path="quoteType.description" cssErrorClass="error">Quote Type</form:label>
					</td>
					<td>
						<form:input path="quoteType.description" readonly="true"/>			
					</td>
				</tr>
				<tr>	  		
					<td>
						<form:label	for="brochureType.description" path="brochureType.description" cssErrorClass="error">Brochure</form:label>
					</td>
					<td>
						<form:input path="brochureType.description" readonly="true"/>			
					</td>
				</tr>
				<tr>	  		
					<td>
							<form:label for="labour" path="labour">Labour Cost</form:label>
					</td>
					<td>
						<form:input path="labour" readonly="true"/>
					</td>
				</tr>
				<tr>	  		
					<td>
						<form:label for="materials" path="materials">Materials Cost</form:label>
					</td>
					<td>
						<form:input path="materials" readonly="true"/>
					</td>
				</tr>
				
				<tr style="width: 20%">
					<td valign="top">
						Comments
					</td>
					<td>
					   <c:forEach items="${quote.comments}" var="comment">
                           	 <c:out value="${comment.text}"/>&nbsp
                           	<br/>
                       </c:forEach>
                	</td>
				</tr>
				
			</table>
		</form:form>
	<hr>
		<div class="pageMenu">
			<div class="pageMenuInner">
				<ul>
					<li class="competencies"><a href="<c:url value='/home'/>">Home</a></li>
					<li class="competencies"><a href="<c:url value='/viewQuote/list'/>">Quote List</a></li>
					<li class="competencies"><a href="<c:url value='/viewQuote/pdf/'/>${quote.id}">View PDF</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>	
</div>
</body>
</html>