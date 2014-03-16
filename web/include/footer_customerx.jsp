<br/>
<%
if(session.getAttribute("loggedin")==null) {
%>
            <form method='POST' action='login.jsp' onsubmit='return validateLogin(this);'>
<%
} else {
%>
            <form method='POST' action='logout.jsp'>
<%
}%>
                <table border="1">
                    <tr>
                        <td valign="top">
                            <p>
                               <%=clientName%><br/>
<%
if(clientAddressLine1!=null && clientAddressLine1.trim().length() > 0) {
%>
                               <%=clientAddressLine1%><br/>
<%
}
%>

<%
if(clientAddressLine2!=null && clientAddressLine2.trim().length() > 0) {
%>
                               <%=clientAddressLine2%><br/>
<%
}
%>
                               <%=clientCity%>, <%=clientState%> <%=clientZIPCode%><br/>
                               <br/>
                               <%=clientInfoEmailAddress%><br/>
                               fax: <%=clientCustomerServiceFaxNumberDisplay%>
                            </p>
                        </td>
                        <td valign="top">
                            <fieldset>
                                <legend><b>Customer Service</b></legend><br/>
                                <a href="mailto:<%=clientCustomerServiceEmailAddress%>">Email Customer Service</a><br/>
                                <%=clientCustomerServicePhoneNumberPhonetic%><br/>
                                <a href="tel:<%=clientCustomerServicePhoneNumber%>"><%=clientCustomerServicePhoneNumberDisplay%></a>
                            </fieldset>
                        </td>
                        <td valign="top">

<%
if(session.getAttribute("loggedin")==null) {
%>
    <%@ include file="/include/login_insert.jsp" %>
<%
} else {
%>
    <%@ include file="/include/logout_insert.jsp" %>
<%
}%>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" align="right">
                            <a href="http://www.facebook.com/<%=urlFacebook%>">
                                <img src="images/icon_facebook.png" border="0" alt="Facebook Icon" />
                            </a>
                            <a href="http://twitter.com/<%=urlTwitter%>">
                                <img src="images/icon_twitter.png" border="0" alt="Twitter Icon" />
                            </a>
                            <a href="http://www.linkedin.com/company/<%=urlLinkedIn%>">
                                <img src="images/icon_linkedin.png" border="0" alt="LinkedIn Icon" />
                            </a>
                            <a href="http://www.youtube.com/user/<%=urlYouTube%>">
                                <img src="images/icon_youtube.png" border="0" alt="YouTube Icon" />
                            </a>
                            <a href="http://plus.google.com/<%=urlGooglePlus%>">
                                <img src="images/icon_googlep.png" border="0" alt="Google+ Icon" />
                            </a>
                        </td>
                    </tr>
                </table>
            </form>
