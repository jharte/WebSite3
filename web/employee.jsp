<%@ include file="/include/session.jsp" %>

<%
    // Page Specific Variables
    pageDescription = "Employee Home Page";
    titleName = "Employee Home Page";
    accessGroup = ACCESS_GROUP_EMPLOYEE; // Don't set for external since default is true
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
    <%@ include file="/include/head.jsp" %>

    <body>
        <header class="header">
            <img src="images/logo.jpg" alt="<%=clientName%>" style="border-style:none;vertical-align:middle;"/>
        </header>

        <%@ include file="/include/menu_employee.jsp" %>

        <div class="pageBody">
<%
    // This is where the main body of the page resides
    out.println(pageName);
%>
        </div>

        <footer>
            <%@ include file="/include/footer_employee.jsp" %>
        </footer>
    </body>
</html>
