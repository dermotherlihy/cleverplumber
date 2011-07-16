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
            <display:column title="Customer" sortable="true" url="/customer" paramId="id" paramProperty="id" property="customer.fullName" />
            <display:column title="Labour Cost" sortable="true" url="/viewQuote" paramId="id" paramProperty="id" property="labourCost" />
		    <display:column title="Materials Cost" sortable="true" url="/viewQuote" paramId="id" paramProperty="id" property="materialCost" />
			<display:setProperty name="paging.banner.item_name" value="quote"/>
            <display:setProperty name="paging.banner.items_name" value="quotes" />
        </display:table>
        <div class="pageMenu">
            <div class="pageMenuInner">
                <ul>
                	<li class="competencies"><a href="../newQuote">New Quote</a></li>
                </ul>
                <ul>
                	<li class="competencies"><a href="../home">Home</a></li>
                </ul>
            </div><br class="clear" />
        </div>
    </body>
</html>
