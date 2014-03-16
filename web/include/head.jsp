    <head>
        <%@ include file="/include/title.jsp" %>
        <link rel='stylesheet' id='global-css' href='css/default.css' type='text/css' media='all'/>
        <link rel='stylesheet' id='global-css' href='css/menu.css' type='text/css' media='all'/>
<%
if (accessGroup == ACCESS_GROUP_EMPLOYEE) {
%>
        <link rel='stylesheet' id='global-css' href='css/employee.css' type='text/css' media='all'/>
<%
} else if (accessGroup == ACCESS_GROUP_VENDOR) {
%>
        <link rel='stylesheet' id='global-css' href='css/vendor.css' type='text/css' media='all'/>
<%
} else if (accessGroup == ACCESS_GROUP_CUSTOMER) {
%>
        <link rel='stylesheet' id='global-css' href='css/customer.css' type='text/css' media='all'/>
<%
} else { // Default to customer
%>
        <link rel='stylesheet' id='global-css' href='css/customer.css' type='text/css' media='all'/>
<%
}
%>
        <script src="scripts/common.js" type="text/javascript"></script>
        <script src="scripts/validateLogin.js" type="text/javascript"></script>
<%
if (pageName.equals(FILENAME_REGISTER_CUSTOMER)) {
%>
        <script src="scripts/validateRegistrationCustomer.js" type="text/javascript"></script>
<%
} else if (pageName.equals(FILENAME_REGISTER_EMPLOYEE)) {
%>
        <script src="scripts/validateRegistrationEmployee.js" type="text/javascript"></script>
<%
}
%>
    </head>