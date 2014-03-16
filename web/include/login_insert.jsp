                            <fieldset>

<%
String accessGroupName = ACCESS_GROUP_NAME_CUSTOMER;
if (accessGroup == ACCESS_GROUP_EMPLOYEE) {
    accessGroupName = ACCESS_GROUP_NAME_EMPLOYEE;
} else if (accessGroup == ACCESS_GROUP_VENDOR) {
    accessGroupName = ACCESS_GROUP_NAME_VENDOR;
} else if (accessGroup == ACCESS_GROUP_CUSTOMER) {
    accessGroupName = ACCESS_GROUP_NAME_CUSTOMER;
} else { // Default to customer
    accessGroupName = ACCESS_GROUP_NAME_CUSTOMER;
}
%>

                                <legend><b><%=accessGroupName%> Login</b></legend><br/>
                                <label for="userid">UserId</label>&nbsp;<span><input type="text" name="userid" id="userid" size="8" maxlength="8"/></span><br/>
                                <label for="pwd">Password</label>&nbsp;<span><input type="password" name="pwd" id="pwd" size="8" maxlength="10"/></span><br/>
                                <span><input type="submit" value="Submit Login Request"></span><br/>
<%
if (!pageName.equals(filenameRegister) && (accessGroup == ACCESS_GROUP_CUSTOMER)) {
%>
                                <br/>
                                Not Registered?&nbsp;<a href="<%=filenameRegister%>">Register Now</a><br/><br/>
<%
}
%>
                                <br/>
                                <a href="<%=FILENAME_FORGOT_PASSWORD%>">I Forgot My Password</a> 
                            </fieldset>