<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="Dermot Herlihy" />
<c:set var="ctxPath" value="${pageContext.request.contextPath}" scope="request" />
<title>
<decorator:title /> | Watford Plumbers Ltd</title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/style/layout.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/style/calendar.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/style/cupertino/jquery-ui-1.7.1.custom.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/style/jquery.asmselect.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/jquery-1.3.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/jquery-ui-1.7.1.custom.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/ui.core.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/jquery.asmselect.js'/>"></script>
<link rel="icon" href="<c:url value='/images/favicon.ico'/>" type="image/x-icon">
<link rel="shortcut icon" href="<c:url value='/images/favicon.ico'/>"type="image/x-icon"> 

<decorator:head />
</head>
<body>
<div id="wrapper">
<div id="banner"> </div>
<div id="navbarleft">
  <ul id="nav">
    
  </ul>
</div>

<div id="blueContainer">
  <div id="content">
    <decorator:body />
  </div>
<div id="footer">
    <p>Version 0.0.2 </p>
  </div>
 </div>
</div>
</body>
</html>