<%@ include file="/include/session.jsp" %>
<%@ page import="com.jlboutfitters.beans.ProductBean" %>
<%@ page import="com.jlboutfitters.businessObjects.Product" %>
<%@ page import="com.jlboutfitters.utility.WebUtility" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Enumeration" %>

<%
    // Page Specific Variables
    pageDescription = "Approve Products";
    titleName = "Approve Products";
    accessGroup = ACCESS_GROUP_EMPLOYEE; // Don't set for external since default is true

    Product product = new Product();
    ArrayList<ProductBean> myProducts = product.readProducts();
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
            <center><legend><b>Maintain Products</b></legend><br/></center>
            <table border="1">
                <tr>
                    <th>
                        <a href="<%=FILENAME_ADD_PRODUCT%>"><button type="button"><%=WebUtility.spaceToNbsp(LABEL_ADD_PRODUCT)%></button></a>
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
                        <%=WebUtility.spaceToNbsp(ProductBean.LABEL_PRICE)%>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(ProductBean.LABEL_CATEGORY)%>
                    </th>
                    <th>
                        <%=WebUtility.spaceToNbsp(ProductBean.LABEL_VENDOR)%>
                    </th>
                </tr>

<%
Iterator<ProductBean> it = myProducts.iterator();
while (it.hasNext())
{
    ProductBean myProduct = it.next();
%>
                <tr>
                    <td>
                        <a href="<%=FILENAME_UPDATE_PRODUCT%>?<%=Product.URLFIELD_PRODUCT_ID%>=<%=myProduct.getProductId()%>"><button type="button"><%=WebUtility.spaceToNbsp(LABEL_UPDATE_PRODUCT)%></button></a>
                        <a href="<%=FILENAME_DELETE_PRODUCT%>?<%=Product.URLFIELD_PRODUCT_ID%>=<%=myProduct.getProductId()%>"><button type="button"><%=WebUtility.spaceToNbsp(LABEL_UPDATE_PRODUCT)%></button></a>
                    </td>
                    <td>
                        <%=myProduct.getProductCode()%>
                    </td>
                    <td>
                        <%=myProduct.getProductName()%>
                    </td>
                    <td>
                        <%=myProduct.getProductDescription()%>
                    </td>
                    <td>
                        <%=myProduct.getPrice()%>
                    </td>
                    <td>
                        <%=(myProduct.getCategory()==null)?"":myProduct.getCategory().getCategoryName()%>
                    </td>
                    <td>
                        <%=(myProduct.getVendor()==null)?"":myProduct.getVendor().getVendorName()%>
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
