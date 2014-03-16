<%@ include file="/include/session.jsp" %>
<%@ page import="com.jlboutfitters.beans.VendorBean" %>
<%@ page import="com.jlboutfitters.businessObjects.Vendor" %>
<%@ page import="com.jlboutfitters.utility.WebUtility" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<%
    // Page Specific Variables
    pageDescription = "Maintain Vendors";
    titleName = "Maintain Vendors";
    accessGroup = ACCESS_GROUP_EMPLOYEE; // Don't set for external since default is true

    Vendor vendor = new Vendor();
    ArrayList<VendorBean> myVendors = vendor.readVendors();
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
            <center><legend><b>Maintain Vendors</b></legend><br/></center>
            <table border="1">
                <tr>
                    <th>
                        <a href="<%=FILENAME_ADD_VENDOR%>"><button type="button"><%=WebUtility.spaceToNbsp(LABEL_ADD_VENDOR)%></button></a>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(VendorBean.LABEL_VENDOR_CODE)%>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(VendorBean.LABEL_VENDOR_NAME)%>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(VendorBean.LABEL_CONTACT_FIRST_NAME)%>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(VendorBean.LABEL_CONTACT_LAST_NAME)%>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(VendorBean.LABEL_CONTACT_PHONE_NUMBER)%>
                    </th>
                </tr>
<%
Iterator<VendorBean> it = myVendors.iterator();
while (it.hasNext())
{
    VendorBean myVendor = it.next();
%>
                <tr>
                    <td>
                        <a href="<%=FILENAME_UPDATE_VENDOR%>?<%=Vendor.URLFIELD_VENDOR_ID%>=<%=myVendor.getVendorId()%>"><button type="button"><%=WebUtility.spaceToNbsp(LABEL_UPDATE_VENDOR)%></button></a>
                        <a href="<%=FILENAME_DELETE_VENDOR%>?<%=Vendor.URLFIELD_VENDOR_ID%>=<%=myVendor.getVendorId()%>"><button type="button"><%=WebUtility.spaceToNbsp(LABEL_DELETE_VENDOR)%></button></a>
                    </td>
                    <td>
                        <%=myVendor.getVendorCode()%>
                    </td>
                    <td>
                        <%=myVendor.getVendorName()%>
                    </td>
                    <td>
                        <%=myVendor.getContactFirstName()%>
                    </td>
                    <td>
                        <%=myVendor.getContactLastName()%>
                    </td>
                    <td>
                        <%=myVendor.getContactPhoneNumber().getPhoneNumber()%>
                    </td>
                </tr>
<%
}
%>
            </table>
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
