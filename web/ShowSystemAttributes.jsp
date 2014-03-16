<%--
    Document   : ShowSystemAttributes
    Created on : Mar 11, 2014, 7:54:57 PM
    Author     : JamesHarte
--%>

<%@ page language="java" import="java.util.*" %>
<%@ include file="/include/session.jsp" %>

<%
    // Page Specific Variables
    pageDescription = "Approve Products";
    titleName = "Approve Products";
    accessGroup = ACCESS_GROUP_EMPLOYEE; // Don't set for external since default is true
%>

<html>
    <%@ include file="/include/head.jsp" %>
<body>
<table border="1">
    <tr class="table_header"><th colspan="2" valign="CENTER">Session Attributes</th></tr>
<%
    int i = 0;
%>

<%
    i = 0;
    for (Enumeration e = session.getAttributeNames(); e.hasMoreElements(); ) {
        String attribName = (String) e.nextElement();
        Object attribValue = session.getAttribute(attribName);
        i++;
%>
    <tr class=<%=((i%2)==0)?"table_even_row":"table_even_row"%>><td><%= attribName %></td><td><%= attribValue %></td></tr>

<%
    }
%>
</table>
<br/>

<table border="1">
    <tr class="table_header"><th colspan="2" valign="CENTER">Request Parameters</th></tr>
<%
    i = 0;
    for (Enumeration e = request.getParameterNames(); e.hasMoreElements(); ) {
        String paramName = (String) e.nextElement();
        Object paramValue = request.getParameter(paramName);
        i++;
%>
    <tr class=<%=((i%2)==0)?"table_even_row":"table_odd_row"%>><td><%= paramName %></td><td><%= paramValue %></td></tr>

<%
    }
%>
</table>
<br/>

<table border="1">
    <tr class="table_header"><th colspan="2" valign="CENTER">Request Attributes</th></tr>
<%
    i = 0;
    for (Enumeration e = request.getAttributeNames(); e.hasMoreElements(); ) {
        String attribName = (String) e.nextElement();
        Object attribValue = request.getParameter(attribName);
        i++;
%>
    <tr class=<%=((i%2)==0)?"table_even_row":"table_odd_row"%>><td><%= attribName %></td><td><%= attribValue %></td></tr>

<%
    }
%>
</table>
<br/>

<table border="1">
    <tr class="table_header"><th colspan="2" valign="CENTER">Request Header</th></tr>
<%
    i = 0;
    for (Enumeration e = request.getHeaderNames(); e.hasMoreElements(); ) {
        String attribName = (String) e.nextElement();
        Object attribValue = request.getHeader(attribName);
        i++;
%>
    <tr class=<%=((i%2)==0)?"table_even_row":"table_odd_row"%>><td><%= attribName %></td><td><%= attribValue %></td></tr>

<%
    }
%>
</table>
<br/>

<table border="1">
    <tr class="table_header"><th colspan="2" valign="CENTER">Request Information</th></tr>
    <tr class="table_odd_row"><td>AuthType</td><td><%=request.getAuthType()%></td></tr>
    <tr class="table_even_row"><td>CharacterEncoding</td><td><%=request.getCharacterEncoding()%></td></tr>
    <tr class="table_odd_row"><td>ContentType</td><td><%=request.getContentType()%></td></tr>
    <tr class="table_even_row"><td>ContextPath</td><td><%=request.getContextPath()%></td></tr>
    <tr class="table_odd_row"><td>LocalAddr</td><td><%=request.getLocalAddr()%></td></tr>
    <tr class="table_even_row"><td>LocalName=</td><td><%=request.getLocalName()%></td></tr>
    <tr class="table_odd_row"><td>Method</td><td><%=request.getMethod()%></td></tr>
    <tr class="table_even_row"><td>PathInfo</td><td><%=request.getPathInfo()%></td></tr>
    <tr class="table_odd_row"><td>PathTranslated</td><td><%=request.getPathTranslated()%></td></tr>
    <tr class="table_even_row"><td>Protocol</td><td><%=request.getProtocol()%></td></tr>
    <tr class="table_odd_row"><td>QueryString</td><td><%=request.getQueryString()%></td></tr>
    <tr class="table_even_row"><td>RemoteAddr</td><td><%=request.getRemoteAddr()%></td></tr>
    <tr class="table_odd_row"><td>RemoteHost</td><td><%=request.getRemoteHost()%></td></tr>
    <tr class="table_even_row"><td>RemoteUser</td><td><%=request.getRemoteUser()%></td></tr>
    <tr class="table_odd_row"><td>RequestedSessionId</td><td><%=request.getRequestedSessionId()%></td></tr>
    <tr class="table_even_row"><td>Scheme</td><td><%=request.getScheme()%></td></tr>
    <tr class="table_odd_row"><td>ServerName</td><td><%=request.getServerName()%></td></tr>
    <tr class="table_even_row"><td>ServletPath</td><td><%=request.getServletPath()%></td></tr>
    <tr class="table_odd_row"><td>LocalPort</td><td><%=request.getLocalPort()%></td></tr>
    <tr class="table_even_row"><td>Locale</td><td><%=request.getLocale().toString()%></td></tr>
    <tr class="table_odd_row"><td>RequestURL</td><td><%=request.getRequestURL()%></td></tr>
    <tr class="table_even_row"><td>ServerPort</td><td><%=request.getServerPort()%></td></tr>
    <tr class="table_odd_row"><td>UserPrincipal</td><td><%=(request.getUserPrincipal()==null)?"&nbsp;":request.getUserPrincipal().toString()%></td></tr>
    <tr class="table_even_row"><td>ServerPort</td><td><%=session.getServletContext()%></td></tr>
</table>
<br/>

</body>
</html>