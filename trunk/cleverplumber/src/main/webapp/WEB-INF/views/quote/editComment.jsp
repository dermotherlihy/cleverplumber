<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Edit Comment</title>
</head>

<body>
	<h1>${comment.quote.customer.fullName} - quote comment</h1>
	<form:form commandName="comment" method="PUT">
		<form:hidden path="id" />
		<table class="form">
			<tr>
				<td valign="top">Comment</td>
				<td>
					<form:textarea rows="5" cssClass="inputmedium" path="text" />
					<form:errors path="text" cssClass="errorMessage" />
				</td>
			</tr>

		</table>
		<div class="buttonMargin">
			<input type="submit" class="button" name="Edit" value="Edit" /> <input
				type="submit" class="button" name="cancel" value="Cancel" />
		</div>
		<div class="pageMenu">
			<div class="pageMenuInner">
				<ul>
					<li class="home"><a href="home">home</a></li>
					<li class="competencyList"><a href="viewQuote/list">Quote
							List</a></li>
				</ul>
			</div>
			<br class="clear" />

		</div>
	</form:form>
</body>
</html>