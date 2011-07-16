<%@ include file="/common/taglibs.jsp"%>
<html>
	<head>
		<title>Customer List</title>
	</head>
    <body>
        <h1>
            Customers
        </h1>
        <display:table id="customer" name="customerList" requestURI="" sort="list" cellspacing="0" cellpadding="0" defaultsort="1" class="table" pagesize="10" export="true">
            <display:column title="First Name" sortable="true" url="/viewCustomer" paramId="id" paramProperty="id" property="firstName" />
             <display:column title="Last Name" sortable="true" url="/viewCustomer" paramId="id" paramProperty="id" property="lastName" />
		    <display:column title="Address Line 1" sortable="true" url="/viewCustomer" paramId="id" paramProperty="id" property="addressLine1" />
			<display:column title="Postcode" sortable="true" url="/viewCustomer" paramId="id" paramProperty="id" property="postcode" />
			<display:column title="Phone Number" sortable="true" url="/viewCustomer" paramId="id" paramProperty="id" property="phoneNumber" />
		    <display:setProperty name="paging.banner.item_name" value="/customer" />
            <display:setProperty name="paging.banner.items_name" value="/customers" />
        </display:table>
        <div class="pageMenu">
            <div class="pageMenuInner">
                <ul>
                	<li class="competencies"><a href="newCustomer">New Customer</a></li>
                </ul>
                <ul>
                	<li class="competencies"><a href="home">Home</a></li>
                </ul>
            </div><br class="clear" />
        </div>
    </body>
</html>
