<%@ page import="com.jlboutfitters.beans.AddressBean" %>
<%@ page import="com.jlboutfitters.beans.PhoneNumberBean" %>
<%@ page import="com.jlboutfitters.beans.CompanyBean" %>
<%@ page import="com.jlboutfitters.businessObjects.Company" %>

<%
    // These can be put into a class
    final int ACCESS_GROUP_CUSTOMER = 1;
    final int ACCESS_GROUP_EMPLOYEE = 2;
    final int ACCESS_GROUP_VENDOR = 3;
    final String ACCESS_GROUP_NAME_CUSTOMER = "Customer";
    final String ACCESS_GROUP_NAME_EMPLOYEE = "Employee";
    final String ACCESS_GROUP_NAME_VENDOR = "Vendor";

    final String FILENAME_COMMUNITY = "community.jsp";
    final String FILENAME_ABOUTUS = "about.jsp";
    final String FILENAME_CAREERS = "careers.jsp";

    final String FILENAME_HOME = "home.jsp";
    final String FILENAME_PRODUCTS = "products.jsp";
    final String FILENAME_CLOTHING = "clothing.jsp";
    final String FILENAME_ACCESSORIES = "accessories.jsp";
    final String FILENAME_SHOPPINGCART = "shoppingcart.jsp";
    final String FILENAME_CHECKOUT = "checkout.jsp";
    final String FILENAME_REGISTER_CUSTOMER = "registerCustomer.jsp";
    final String FILENAME_FORGOT_PASSWORD = "forgotPassword.jsp";

    final String FILENAME_EMPLOYEE = "employee.jsp";
    final String FILENAME_MANAGER = "manager.jsp";
    final String FILENAME_ADD_VENDOR = "addVendor.jsp";
    final String FILENAME_DELETE_VENDOR = "deleteVendor.jsp";
    final String FILENAME_UPDATE_VENDOR = "updateVendor.jsp";
    final String FILENAME_MAINTAIN_VENDORS = "maintainVendors.jsp";
    final String FILENAME_ADD_EMPLOYEE = "registerEmployee.jsp";
    final String FILENAME_DELETE_EMPLOYEE = "deleteEmployee.jsp";
    final String FILENAME_UPDATE_EMPLOYEE = "updateEmployee.jsp";
    final String FILENAME_MAINTAIN_EMPLOYEES = "maintainEmployees.jsp";
    final String FILENAME_ADD_PRODUCT = "addProduct.jsp";
    final String FILENAME_DELETE_PRODUCT = "deleteProduct.jsp";
    final String FILENAME_UPDATE_PRODUCT = "updateProduct.jsp";
    final String FILENAME_MAINTAIN_PRODUCTS = "maintainProducts.jsp";
    final String FILENAME_APPROVE_PRODUCTS = "approveProducts.jsp";
    final String FILENAME_APPROVE_PRODUCT = "approveProduct.jsp";
    final String FILENAME_DECLINE_PRODUCT = "declineProduct.jsp";
    final String FILENAME_REGISTER_EMPLOYEE = "registerEmployee.jsp";

    final String LABEL_COMMUNITY = "Community";
    final String LABEL_ABOUTUS = "About Us";
    final String LABEL_CAREERS = "Careers";

    final String LABEL_HOME = "Home";
    final String LABEL_PRODUCTS = "Products";
    final String LABEL_CLOTHING = "Clothing";
    final String LABEL_ACCESSORIES = "Accessories";
    final String LABEL_SHOPPINGCART = "Shopping Cart";
    final String LABEL_CHECKOUT = "Checkout";
    final String LABEL_REGISTER_CUSTOMER = "Register Customer";
    final String LABEL_FORGOT_PASSWORD = "Forgot Password";

    final String LABEL_EMPLOYEE = "Employee";
    final String LABEL_MANAGER = "Manager";
    final String LABEL_ADD_VENDOR = "Create New Vendor";
    final String LABEL_DELETE_VENDOR = "Delete";
    final String LABEL_UPDATE_VENDOR = "Update";
    final String LABEL_MAINTAIN_VENDORS = "Maintain Vendors";
    final String LABEL_ADD_EMPLOYEE = "Create New Employee";
    final String LABEL_DELETE_EMPLOYEE = "Delete";
    final String LABEL_UPDATE_EMPLOYEE = "Update";
    final String LABEL_MAINTAIN_EMPLOYEES = "Maintain Employees";
    final String LABEL_ADD_PRODUCT = "Create New Product";
    final String LABEL_DELETE_PRODUCT = "Delete";
    final String LABEL_UPDATE_PRODUCT = "Update";
    final String LABEL_MAINTAIN_PRODUCTS = "Maintain Products";
    final String LABEL_APPROVE_PRODUCTS = "Approve Products";
    final String LABEL_APPROVE_PRODUCT = "Approve";
    final String LABEL_DECLINE_PRODUCT = "Decline";
    final String LABEL_REGISTER_EMPLOYEE = "Register Employee";

    final String MENULABEL_COMMUNITY = "Community";
    final String MENULABEL_ABOUTUS = "About Us";
    final String MENULABEL_CAREERS = "Careers";

    final String MENULABEL_HOME = "Home";
    final String MENULABEL_PRODUCTS = "Products";
    final String MENULABEL_CLOTHING = "Clothing";
    final String MENULABEL_ACCESSORIES = "Accessories";
    final String MENULABEL_SHOPPINGCART = "Shopping Cart";
    final String MENULABEL_CHECKOUT = "Check Out";
    final String MENULABEL_REGISTER_CUSTOMER = "Register";

    final String MENULABEL_EMPLOYEE = "Home";
    final String MENULABEL_MAINTAIN_VENDORS = "Maintain Vendors";
    final String MENULABEL_MAINTAIN_EMPLOYEES = "Maintain Employees";
    final String MENULABEL_ADD_EMPLOYEE = "Add Employee";
    final String MENULABEL_MAINTAIN_PRODUCTS = "Maintain Products";
    final String MENULABEL_APPROVE_PRODUCTS = "Approve Products";
    final String MENULABEL_REGISTER_EMPLOYEE = "Register";

    // These would come from company table
    //String clientName = "JLB Outfitters";
    //String clientInfoEmailAddress = "info@JLBOutfitters.com";
    //String clientCustomerServiceEmailAddress = "customerservice@JLBOutfitters.com";
    //String clientCustomerServicePhoneNumberPhonetic = "(888)JLB-OTFT";
    //String clientCustomerServicePhoneNumberDisplay = "(888)552-6838";
    //String clientCustomerServicePhoneNumber = "8885526838";
    //String clientCustomerServiceFaxNumberPhonetic = "(800)JLB-OTFT";
    //String clientCustomerServiceFaxNumberDisplay = "(800)552-6838";
    //String clientCustomerServiceFaxNumber = "8005526838";
    //String urlFacebook = "JLBOutfitters";
    //String urlTwitter = "JLBOutfitters";
    //String urlLinkedIn = "JLBOutfitters";
    //String urlYouTube = "JLBOutfitters";
    //String urlGooglePlus = "116135125242446632691";


    Company company = new Company();
    CompanyBean myCompany = company.readCompany(5);

    String clientName = myCompany.getName();
    String clientInfoEmailAddress = myCompany.getInfoEmailAddress();
    String clientCustomerServiceEmailAddress = myCompany.getCustomerServiceEmailAddress();
    PhoneNumberBean clientCustomerServicePhoneNumberPhonetic = myCompany.getCustomerServicePhoneNumber();
    String clientCustomerServicePhoneNumberDisplay = PhoneNumberBean.createPhoneNumberWithoutLetters(clientCustomerServicePhoneNumberPhonetic.getPhoneNumber());
    String clientCustomerServicePhoneNumber = PhoneNumberBean.createPhoneNumberWithOnlyNumbers(clientCustomerServicePhoneNumberPhonetic.getPhoneNumber());
    PhoneNumberBean clientCustomerServiceFaxNumberPhonetic = myCompany.getCustomerServicePhoneNumber();
    String clientCustomerServiceFaxNumberDisplay = PhoneNumberBean.createPhoneNumberWithoutLetters(clientCustomerServiceFaxNumberPhonetic.getPhoneNumber());
    String clientCustomerServiceFaxNumber = PhoneNumberBean.createPhoneNumberWithOnlyNumbers(clientCustomerServiceFaxNumberPhonetic.getPhoneNumber());
    String urlFacebook = myCompany.getUrlFacebook();
    String urlTwitter = myCompany.getUrlTwitter();
    String urlLinkedIn = myCompany.getUrlLinkedIn();
    String urlYouTube = myCompany.getUrlYouTube();
    String urlGooglePlus = myCompany.getUrlGooglePlus();

    // These are from the address record pointed to by the company table record
    String clientAddressLine1 = myCompany.getAddress().getAddressLine1();
    String clientAddressLine2 = myCompany.getAddress().getAddressLine2();
    String clientCity = myCompany.getAddress().getCity();
    String clientState = myCompany.getAddress().getState();
    String clientZIPCode = myCompany.getAddress().getZipCode();

    // Page specific information
    String pageDescription = "";
    String titleName = "";
    int accessGroup = ACCESS_GROUP_CUSTOMER;

    // Determines file name of page
    String uri = request.getRequestURI();
    // Used to get jsp page name (e.g. home.jsp)
    String pageName = uri.substring(uri.lastIndexOf("/")+1);

    //AddressBean myAddress = new AddressBean();
    //myAddress.setStreet("Denmark");
%>