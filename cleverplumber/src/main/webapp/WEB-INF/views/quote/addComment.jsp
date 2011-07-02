<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
	<head>
		<title>Add Comment</title>
	</head>

	<body>
			<form:form commandName="quote">
            <form:hidden path="id"/>
			<table class="form">
				<tr>
					<td valign="top">
						Add Comment
					</td>
					<td>
						<textarea rows="5" class="inputlarge" name="newComment"></textarea>
						<c:if test="${!empty requestScope.commentError}">
						 	<span class="errorMessage">${requestScope.commentError}</span>
						</c:if>
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