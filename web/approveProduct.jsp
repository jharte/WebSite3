<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error_page.jsp"%>

<%@ include file="/include/session.jsp" %>

<%@ page import="com.jlboutfitters.beans.ProductBean" %>
<%@ page import="com.jlboutfitters.businessObjects.ProductChange" %>
<%@ page import="com.jlboutfitters.utility.WebUtility" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Enumeration" %>

<%
    // Page Specific Variables
    pageDescription = "Approve Products";
    titleName = "Approve Products";
    accessGroup = ACCESS_GROUP_EMPLOYEE; // Don't set for external since default is true

    //Product product = new Product();
    //ArrayList<ProductBean> myProducts = product.readProducts();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
    <%@ include file="/include/head.jsp" %>

    <body>
        <header class="header">
            <img src="images/logo.jpg" alt="<%=clientName%>" style="border-style:none;vertical-align:middle;"/>
        </header>

        <%@ include file="/include/menu_manager.jsp" %>
<%
    {
        int i = 1/0;
    }
    {
        Object paramValue = request.getParameter(ProductChange.URLFIELD_PRODUCT_CHANGE_ID);
        if (paramValue != null) {
            ProductChange myProductChange = new ProductChange();
            myProductChange.approveProductChange(paramValue.toString());
        }
    }
%>
        <%@ include file="/include/ShowEnvironment.jsp" %>

        <footer>
            <%@ include file="/include/footer_employee.jsp" %>
        </footer>
    </body>
</html>
