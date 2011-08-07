<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title>Quote List</title>
	</head>
    <body>
        <h1>
            Quote List
        </h1>
        <display:table id="quote" name="quoteList" requestURI="" sort="list" cellspacing="0" cellpadding="0" defaultsort="1" class="table" pagesize="10" export="true">
          	<display:column title="Date" sortable="true" url="/viewQuote" paramId="id" paramProperty="id" property="createdDate" decorator="com.cleverplumber.app.decorator.DateDecorator"/>
			<display:column title="Customer" sortable="true" url="/viewCustomer" paramId="id" paramProperty="customer.id" property="customer.fullName" />
            <display:column title="Labour" sortable="true" url="/viewQuote" paramId="id" paramProperty="id" property="labour" />
		    <display:column title="Materials" sortable="true" url="/viewQuote" paramId="id" paramProperty="id" property="materials" />
		    <display:column title="Total" sortable="true" url="/viewQuote" paramId="id" paramProperty="id" property="total" />
			<display:setProperty name="paging.banner.item_name" value="quote"/>
            <display:setProperty name="paging.banner.items_name" value="quotes" />
        </display:table>
        <div class="pageMenu">
            <div class="pageMenuInner">
                <ul>
                	<li class="competencies"><a href="<c:url value='/home'/>">Home</a></li>
                </ul>
            </div><br class="clear" />
        </div>
    </body>
</html>
