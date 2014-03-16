<%@ include file="/include/session.jsp" %>

<%
    // Page Specific Variables
    pageDescription = "Register Customer";
    titleName = "Register Customer";
    accessGroup = ACCESS_GROUP_EMPLOYEE; // Don't set for external since default is true
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
    <%@ include file="/include/head.jsp" %>

    <body>
        <header class="header">
            <img src="images/logo.jpg" alt="<%=clientName%>" style="border-style:none;vertical-align:middle;"/>
        </header>

        <%@ include file="/include/menu_manager.jsp" %>

        <div class="pageBody">
            <form method="POST" action="RegisterEmployeeLogin.jsp" onsubmit="return validateEmployeeRegistration(this);">
            <table border="1">
                <tr>
                    <td>
                        <fieldset>
                            <legend><b>Add a New Employee</b></legend><br/>
                            * indicates a required field<br/>
                            <table>
                                <tr>
                                    <td align="RIGHT">
                                        <label for="userid">Employee&nbsp;Id</label>&nbsp;
                                    </td>
                                    <td>
                                        <span><input type="text" name="userid" id="userid" size="8" maxlength="8"/>*</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="RIGHT"><label for="pwd">Password</label>&nbsp;
                                    </td>
                                    <td>
                                        <span><input type="password" name="pwd" id="pwd" size="8" maxlength="10"/>*</span>&nbsp;
                                        <label for="pwdConfirm">Confirm&nbsp;Password</label>&nbsp;
                                        <span><input type="password" name="pwdConfirm" id="pwdConfirm" size="8" maxlength="10"/>*</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="RIGHT"><label for="managerInd">Manager&nbsp;Ind</label>&nbsp;
                                    </td>
                                    <td>
                                        <span><input type="checkbox" name="managerInd" value="XXXX" />*</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="RIGHT"><label for="firstName">First&nbsp;Name</label>&nbsp;
                                    </td>
                                    <td>
                                        <span><input type="text" name="firstName" id="firstName" size="30" maxlength="50"/>*</span>&nbsp;
                                        <label for="lastName">Last&nbsp;Name</label>&nbsp;<span>&nbsp
                                        <input type="text" name="lastName" id="lastName" size="30" maxlength="50"/>*</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="RIGHT">
                                        <label for="emailAddress">Email Address</label>&nbsp;
                                    </td>
                                    <td>
                                        <span><input type="text" name="emailAddress" id="emailAddress" size="40" maxlength="40" placeholder="abc@mycompany.com"/>*</span>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="RIGHT">
                                        <label for="phoneNumber">Phone Number</label>&nbsp;
                                    </td>
                                    <td>
                                        <span><input type="text" name="phoneNumber" id="phoneNumber" size="40" maxlength="40" placeholder="999-999-9999"/></span><br/>
                                    </td>
                                </tr>
                            </table>
                            <center><span><input type="submit" value="Submit Registration Request"></span></center>
                        </fieldset>
                    </td>
                </tr>
            </table>
            </form>
<%
    // This is where the main body of the page resides
    //out.println(pageName);
%>
        </div>

        <footer>
            <%@ include file="/include/footer_employee.jsp" %>
        </footer>
    </body>
</html>
