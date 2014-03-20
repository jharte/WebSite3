<%--
    Document   : error_page
    Created on : Mar 20, 2014, 8:20:42 AM
    Author     : JamesHarte
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' id='global-css' href='css/default.css' type='text/css' media='all'/>
        <title>Error Page</title>
    </head>

    <center><b>ERROR PAGE</b></center><br/>

    You have been brought to this page due to an error occurring while using the application.<br/><br/>
    Please note the following to handle the issue:<br/><br/>

    <table border="1">
        <tr class="table_header"><th colspan="2" valign="CENTER">Exception Information</th></tr>
        <tr class="table_odd_row"><td>Exception Class</td><td><%=exception.getClass().getName()%></td></tr>
        <tr class="table_even_row"><td>Message</td><td><%=exception.getMessage()%></td></tr>
        <tr class="table_odd_row"><td>Localized Message</td><td><%=exception.getLocalizedMessage()%></td></tr>
    </table>
    <br/>

    <table border="1">
        <tr class="table_header"><th colspan="" valign="CENTER">Stack Trace</th></tr>
        <tr class="table_odd_row"><td><pre><%exception.printStackTrace(response.getWriter());%></pre></td></tr>
    </table>
    <br/>

    <%@ include file="/include/ShowEnvironment.jsp" %>

    <body>
        <h1>Hello World!</h1>
    </body>
</html>
