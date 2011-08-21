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
						<input type="submit" class="button" name="finish" value="Finish" />
					</td>
				</tr>
				<tr style="width: 20%">
					<td valign="top">
						Comments
					</td>
					<td>
					   <c:forEach items="${quote.comments}" var="comment">
                           	 <c:out value="${comment.text}"/>&nbsp
                           	 <a href="<c:url value='/comment/edit.do?id='/>${comment.id}">Edit</a><br/>
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
		<hr>
		<div class="pageMenu">
			<div class="pageMenuInner">
				<ul>
					<li class="competencies"><a href="<c:url value='/home.do'/>">Home</a></li>
					<li class="competencies"><a href="<c:url value='/viewQuote/list.do'/>">Quote List</a></li>
					<li class="competencies"><a href="<c:url value='/viewQuote/pdf.do?id='/>${quote.id}">View PDF</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>	
	</body>
</html>