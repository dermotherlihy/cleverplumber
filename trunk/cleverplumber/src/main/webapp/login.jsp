<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Login</title>
</head>
<body id="login" />

<h1> Login </h1>
<form method="post" id="loginForm" action="<c:url value="/j_security_check"/>
" >
<p class="red"><br />

  <c:if test="${param.error != null}"> <img src="images/iconWarning.gif" alt="Warning" /> Login failed, please try again. </c:if>
</p>
<p>
  <label for="j_username">Name:</label>
  <input type="text" name="j_username" id="j_username" tabindex="1" maxlength="50" />
</p>
<p>
  <label for="j_password">Password:</label>
  <input type="password" name="j_password" id="j_password" tabindex="2" maxlength="50" />&nbsp; &nbsp; &nbsp; <a href="sendNewPassword.do">Forgotton password</a>
</p>

<div id="login"><input type="submit" name="login" value="Login" tabindex="4" class="login" /></div><br class="clear" />


</form>
</body></html>