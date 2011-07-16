<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
	<head>
		<title>Add Comment</title>
	</head>

	<body>
			<form:form commandName="comment">
            <form:hidden path="quote.id"/>
			<table class="form">
				<tr>
					<td valign="top">
						Add Comment
					</td>
					<td>
						<form:textarea rows="5" cssClass="inputmedium" path="text" />
						<form:errors path="text" cssClass="errorMessage" />
					</td>
				</tr>
				<tr>
					<td />
					<td>
						<input type="submit" class="button" name="save" value="Add" />
					</td>
				</tr>
				<tr style="width: 20%">
					<td valign="top">
						Comments
					</td>
					<td >
					   <c:forEach items="${quote.comments}" var="comment">
                           	 <c:out value="${comment.text}"/>&nbsp
                           	 <a href="edit/${comment.id}">Edit</a>
                       </c:forEach>
                	</td>
				</tr>
			</table>

			<div class="pageMenu">
				<div class="pageMenuInner">
				    <ul>
        	        </ul>
      </div><br class="clear" />

			</div>
		</form:form>
	</body>
</html>