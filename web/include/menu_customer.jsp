<%
    String filenameHome = FILENAME_HOME;
    String filenameProducts = FILENAME_PRODUCTS;
    String filenameClothing = FILENAME_CLOTHING;
    String filenameAccessories = FILENAME_ACCESSORIES;
    String filenameCommunity = FILENAME_COMMUNITY;
    String filenameAboutUs = FILENAME_ABOUTUS;
    String filenameShoppingCart = FILENAME_SHOPPINGCART;
    String filenameCheckOut = FILENAME_CHECKOUT;
    String filenameCareers = FILENAME_CAREERS;
    String filenameRegister = FILENAME_REGISTER_CUSTOMER;

    String filenameCurrentPage = "#";

    if(pageName!=null && pageName.equals(FILENAME_HOME)) {
        filenameHome = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_PRODUCTS)) {
        filenameProducts = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_CLOTHING)) {
        filenameClothing = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_ACCESSORIES)) {
        filenameAccessories = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_COMMUNITY)) {
        filenameCommunity = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_ABOUTUS)) {
        filenameAboutUs = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_SHOPPINGCART)) {
        filenameShoppingCart = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_CHECKOUT)) {
        filenameCheckOut = filenameCurrentPage;
    }
    if(pageName!=null && pageName.equals(FILENAME_CAREERS)) {
        filenameCareers = filenameCurrentPage;
    }
%>

<%
if(session.getAttribute("loggedin")==null) {
%>
    <%@ include file="/include/menu_customer_loggedout.jsp" %>
<%
} else {
%>
    <%@ include file="/include/menu_customer_loggedin.jsp" %>
<%
}%>

    <br/>