<%
    String filenameHome = FILENAME_EMPLOYEE;
    //String filenameProducts = FILENAME_PRODUCTS;
    //String filenameClothing = FILENAME_CLOTHING;
    //String filenameAccessories = FILENAME_ACCESSORIES;
    String filenameMaintainVendors = FILENAME_MAINTAIN_VENDORS;
    String filenameMaintainEmployees = FILENAME_MAINTAIN_EMPLOYEES;
    String filenameMaintainProducts = FILENAME_MAINTAIN_PRODUCTS;
    String filenameApproveProducts = FILENAME_APPROVE_PRODUCTS;
    String filenameCommunity = FILENAME_COMMUNITY;
    String filenameAboutUs = FILENAME_ABOUTUS;
    //String filenameShoppingCart = FILENAME_SHOPPINGCART;
    //String filenameCheckOut = FILENAME_CHECKOUT;
    String filenameCareers = FILENAME_CAREERS;
    String filenameRegister = FILENAME_REGISTER_EMPLOYEE;

    String filenameCurrentPage = "#";

    if(pageName!=null && pageName.equals(FILENAME_EMPLOYEE)) {
        filenameHome = filenameCurrentPage;
    }
//    if(pageName!=null && pageName.equals(FILENAME_PRODUCTS)) {
//        filenameProducts = filenameCurrentPage;
//    }
//    if(pageName!=null && pageName.equals(FILENAME_CLOTHING)) {
//        filenameClothing = filenameCurrentPage;
//    }
//    if(pageName!=null && pageName.equals(FILENAME_ACCESSORIES)) {
//        filenameAccessories = filenameCurrentPage;
//    }
    if(pageName!=null && pageName.equals(FILENAME_MAINTAIN_VENDORS)) {
        filenameMaintainVendors = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_MAINTAIN_EMPLOYEES)) {
        filenameMaintainEmployees = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_MAINTAIN_PRODUCTS)) {
        filenameMaintainProducts = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_APPROVE_PRODUCTS)) {
        filenameApproveProducts = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_COMMUNITY)) {
        filenameCommunity = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_ABOUTUS)) {
        filenameAboutUs = filenameCurrentPage;
    }
//    if(pageName!=null && pageName.equals(FILENAME_SHOPPINGCART)) {
//        filenameShoppingCart = filenameCurrentPage;
//    }
//    if(pageName!=null && pageName.equals(FILENAME_CHECKOUT)) {
//        filenameCheckOut = filenameCurrentPage;
//    }
    if(pageName!=null && pageName.equals(FILENAME_CAREERS)) {
        filenameCareers = filenameCurrentPage;
    }
%>

<%
if(session.getAttribute("loggedin")==null) {
%>
    <%@ include file="/include/menu_employee_loggedout.jsp" %>
<%
} else {
%>
    <%@ include file="/include/menu_employee_loggedin.jsp" %>
<%
}%>

    <br/>