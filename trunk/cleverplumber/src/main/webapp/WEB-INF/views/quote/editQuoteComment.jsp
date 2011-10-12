<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Edit Comment</title>
</head>

<body>
		
		<input type="hidden" value="${quote.id}" name="quote.id" />
		<form:form commandName="comment" method="PUT">
		<form:hidden path="id" />
		<table class="form">
			<tr>
				<td valign="top">Comment</td>
				<td><form:textarea rows="5" cssClass="inputmedium" path="text" />
					<form:errors path="text" cssClass="errorMessage" /></td>
			</tr>

		</table>
		<div class="buttonMargin">
			<input type="submit" class="button" name="Edit" value="Edit" /> 
			<input type="submit" class="button" name="cancel" value="Cancel" />
		</div>

	</form:form>
	<hr>
	<div class="pageMenu">
		<div class="pageMenuInner">
			<ul>
				<li class="competencies"><a href="<c:url value='/home.do'/>">Home</a></li>
				<li class="competencies"><a	href="<c:url value='/viewQuote.do/list'/>">Quote List</a></li>
				<li class="competencies"><a	href="<c:url value='/viewQuote.do/pdf/'/>${quote.id}">View PDF</a>	</li>
			</ul>
		</div>
		<br class="clear" />
	</div>

</body>
</html>