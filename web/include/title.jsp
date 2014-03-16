<%
if (titleName == null || titleName.trim().length() == 0) {
%>
    <title><%=clientName%></title>
<%
} else {
%>
    <title><%=clientName%> - <%=titleName%></title>
<%
}
%>