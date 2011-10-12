<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
	<head>
		<title>Add Comment</title>
	</head>

	<body>
			<form:form commandName="quote">
			<form:input type ="hidden" path="id"/>
			<table class="form">
				<tr>	  		
					<td>
						<b>Vat</b>
					</td>
					<td>
						<form:input path="vat" readonly="true"/>
					</td>
				</tr>
				<tr>	  		
					<td>
						<b>Total</b>
					</td>
					<td>
						<form:input path="total" readonly="true"/>
					</td>
				</tr>
				<tr>
					<td valign="top">
						<b>Add Comment</b>
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
						<input type="submit" class="button" name="finish" value="Send Quote" />
					</td>
				</tr>
				<tr style="width: 20%">
					<td valign="top">
						<b>Comments</b>
					</td>
					<td>
					   <c:forEach items="${quote.comments}" var="comment">
                           	 <c:out value="${comment.text}"/>&nbsp
                           	 <a href="<c:url value='/comment/edit.do?id='/>${comment.id}&quote.id=${quote.id}">Edit</a>
                           	 <a href="<c:url value='/comment/delete.do?id='/>${comment.id}&quote.id=${quote.id}">Delete</a><br/>
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