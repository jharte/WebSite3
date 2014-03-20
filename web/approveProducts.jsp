<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error_page.jsp"%>

<%@ include file="/include/session.jsp" %>

<%@ page import="com.jlboutfitters.beans.ProductChangeBean" %>
<%@ page import="com.jlboutfitters.beans.ProductBean" %>
<%@ page import="com.jlboutfitters.beans.BaseBean" %>
<%@ page import="com.jlboutfitters.businessObjects.ProductChange" %>
<%@ page import="com.jlboutfitters.utility.WebUtility" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<%
    // Page Specific Variables
    pageDescription = "Approve Products";
    titleName = "Approve Products";
    accessGroup = ACCESS_GROUP_EMPLOYEE; // Don't set for external since default is true

    ProductChange productChange = new ProductChange();
    ArrayList<ProductChangeBean> myProductChanges = productChange.readProductChanges();
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
            <center><legend><b>Approve Products</b></legend><br/></center>
            <table border="1">
                <tr>
                    <th>
                        &nbsp;
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(ProductBean.LABEL_PRODUCT_CODE)%>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(ProductBean.LABEL_PRODUCT_NAME)%>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(ProductBean.LABEL_PRODUCT_DESCRIPTION)%>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(ProductBean.LABEL_CATEGORY)%>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(ProductBean.LABEL_VENDOR)%>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(ProductBean.LABEL_PRICE)%>
                    </th>
                </tr>

<%
Iterator<ProductChangeBean> it = myProductChanges.iterator();
while (it.hasNext())
{
    ProductChangeBean myProductChange = it.next();
%>
                <tr>
                    <td>
                        <a href="<%=FILENAME_APPROVE_PRODUCT%>?<%=ProductChange.URLFIELD_PRODUCT_CHANGE_ID%>=<%=myProductChange.getProductChangeId()%>"><button type="button"><%=LABEL_APPROVE_PRODUCT%></button></a>
                        <a href="<%=FILENAME_DECLINE_PRODUCT%>?<%=ProductChange.URLFIELD_PRODUCT_CHANGE_ID%>=<%=myProductChange.getProductChangeId()%>"><button type="button"><%=LABEL_DECLINE_PRODUCT%></button></a>
                    </td>
                    <td<%=(myProductChange.changedProductCode())?" bgcolor=red":""%>>
                        <%=myProductChange.getChangedProduct().getProductCode()%>
                    </td>
                    <td<%=(myProductChange.changedProductName())?" bgcolor=red":""%>>
                        <%=myProductChange.getChangedProduct().getProductName()%>
                    </td>
                    <td<%=(myProductChange.changedProductDescription())?" bgcolor=red":""%>>
                        <%=myProductChange.getChangedProduct().getProductDescription()%>
                    </td>
                    <td<%=(myProductChange.changedCategory())?" bgcolor=red":""%>>
                        <%=(myProductChange.getChangedProduct().getCategory()==null)?"":myProductChange.getChangedProduct().getCategory().getCategoryName()%>
                    </td>
                    <td<%=(myProductChange.changedVendor())?" bgcolor=red":""%>>
                        <%=(myProductChange.getChangedProduct().getVendor()==null)?"":myProductChange.getChangedProduct().getVendor().getVendorName()%>
                    </td>
                    <td<%=(myProductChange.changedPrice())?" bgcolor=red":""%>>
                        <%=myProductChange.getChangedProduct().getPrice()%>
                    </td>
                </tr>
                <tr>
                    <td>
                        Current&nbsp;Values
                    </td>
                    <td>
                        <%=myProductChange.getOriginalProduct().getProductCode()%>
                    </td>
                    <td>
                        <%=myProductChange.getOriginalProduct().getProductName()%>
                    </td>
                    <td>
                        <%=myProductChange.getOriginalProduct().getProductDescription()%>
                    </td>
                    <td>
                        <%=(myProductChange.getOriginalProduct().getCategory()==null)?"":myProductChange.getOriginalProduct().getCategory().getCategoryName()%>
                    </td>
                    <td>
                        <%=(myProductChange.getOriginalProduct().getVendor()==null)?"":myProductChange.getOriginalProduct().getVendor().getVendorName()%>
                    </td>
                    <td>
                        <%=myProductChange.getOriginalProduct().getPrice()%>
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
