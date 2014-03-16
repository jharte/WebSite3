/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import com.jlboutfitters.object.CompanyObject;

/**
 *
 * @author JamesHarte
 */
public class CompanyBean extends BaseBean {
    public static final String PROP_COMPANY_ID = "companyId";
    public static final String PROP_NAME = "name";
    public static final String PROP_INFO_EMAIL_ADDRESS = "infoEmailAddress";
    public static final String PROP_CUSTOMER_SERVICE_EMAIL_ADDRESS = "customerServiceEmailAddress";
    public static final String PROP_CUSTOMER_SERVICE_PHONE_NUMBER = "customerServicePhoneNumber";
    public static final String PROP_CUSTOMER_SERVICE_FAX_NUMBER = "customerServiceFaxNumber";
    public static final String PROP_URL_FACEBOOK = "urlFacebook";
    public static final String PROP_URL_TWITTER = "urlTwitter";
    public static final String PROP_URL_LINKEDIN = "urlLinkedIn";
    public static final String PROP_URL_YOUTUBE = "urlYouTube";
    public static final String PROP_URL_GOOGLEPLUS = "urlGooglePlus";

    private int companyId = 0;
    private String name = null;
    private String infoEmailAddress = null;
    private String customerServiceEmailAddress = null;
    private PhoneNumberBean customerServicePhoneNumber = null;
    private PhoneNumberBean customerServiceFaxNumber = null;
    private AddressBean address = null;
    private String urlFacebook = null;
    private String urlTwitter = null;
    private String urlLinkedIn = null;
    private String urlYouTube = null;
    private String urlGooglePlus = null;

    //private int companyId = 1;
    //private String name = "JLB Outfitters ABC";
    //private String infoEmailAddress = "info@JLBOutfitters.com";
    //private String customerServiceEmailAddress = "customerservice@JLBOutfitters.com";
    //private PhoneNumberBean customerServicePhoneNumber = new PhoneNumberBean("(888)JLB-OTFT");
    //private PhoneNumberBean customerServiceFaxNumber = new PhoneNumberBean("(800)JLB-OTFT");
    //private AddressBean address = null; //new AddressBean("","","","MyTown","","MA","02134");
    //private String urlFacebook = "JLBOutfitters";
    //private String urlTwitter = "JLBOutfitters";
    //private String urlLinkedIn = "JLBOutfitters";
    //private String urlYouTube = "JLBOutfitters";
    //private String urlGooglePlus = "116135125242446632691";

    public CompanyBean() {
        super();
    }

    public CompanyBean(CompanyObject companyObject) {
        this();
        companyId = companyObject.getCompanyId();
        name = companyObject.getName();
        infoEmailAddress = companyObject.getInfoEmailAddress();
        customerServiceEmailAddress = companyObject.getCustomerServiceEmailAddress();
        customerServicePhoneNumber = new PhoneNumberBean(companyObject.getCustomerServicePhoneCountryPfx(),
                                                         companyObject.getCustomerServicePhoneLineNumber(),
                                                         companyObject.getCustomerServicePhoneExtension());
        customerServiceFaxNumber = new PhoneNumberBean(companyObject.getCustomerServiceFaxCountryPfx(),
                                                       companyObject.getCustomerServiceFaxLineNumber(),
                                                       "");
        address = null; // Initially set to null
        urlFacebook = companyObject.getUrlFacebook();
        urlTwitter = companyObject.getUrlTwitter();
        urlLinkedIn = companyObject.getUrlLinkedIn();
        urlYouTube = companyObject.getUrlYouTube();
        urlGooglePlus = companyObject.getUrlGooglePlus();
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int value) {
        int oldValue = companyId;
        companyId = value;
        propertySupport.firePropertyChange(PROP_COMPANY_ID, oldValue, companyId);
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        String oldValue = name;
        name = value;
        propertySupport.firePropertyChange(PROP_NAME, oldValue, name);
    }

    public String getInfoEmailAddress() {
        return infoEmailAddress;
    }

    public void setInfoEmailAddress(String value) {
        String oldValue = infoEmailAddress;
        infoEmailAddress = value;
        propertySupport.firePropertyChange(PROP_INFO_EMAIL_ADDRESS, oldValue, infoEmailAddress);
    }

    public String getCustomerServiceEmailAddress() {
        return customerServiceEmailAddress;
    }

    public void setCustomerServiceEmailAddress(String value) {
        String oldValue = customerServiceEmailAddress;
        customerServiceEmailAddress = value;
        propertySupport.firePropertyChange(PROP_CUSTOMER_SERVICE_EMAIL_ADDRESS, oldValue, customerServiceEmailAddress);
    }

    public PhoneNumberBean getCustomerServicePhoneNumber() {
        return customerServicePhoneNumber;
    }

    public void setCustomerServicePhoneNumber(PhoneNumberBean value) {
        String oldValue = customerServiceEmailAddress;
        customerServicePhoneNumber = value;
        propertySupport.firePropertyChange(PROP_CUSTOMER_SERVICE_PHONE_NUMBER, oldValue, customerServicePhoneNumber);
    }

    public PhoneNumberBean getCustomerServiceFaxNumber() {
        return customerServiceFaxNumber;
    }

    public void setCustomerServiceFaxNumber(PhoneNumberBean value) {
        PhoneNumberBean oldValue = customerServiceFaxNumber;
        customerServiceFaxNumber = value;
        propertySupport.firePropertyChange(PROP_CUSTOMER_SERVICE_FAX_NUMBER, oldValue, customerServiceFaxNumber);
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean value) {
        AddressBean oldValue = address;
        address = value;
        propertySupport.firePropertyChange(PROP_CUSTOMER_SERVICE_FAX_NUMBER, oldValue, address);
    }

    public String getUrlFacebook() {
        return urlFacebook;
    }

    public void setUrlFacebook(String value) {
        String oldValue = urlFacebook;
        urlFacebook = value;
        propertySupport.firePropertyChange(PROP_URL_FACEBOOK, oldValue, urlFacebook);
    }

    public String getUrlTwitter() {
        return urlTwitter;
    }

    public void setUrlTwitter(String value) {
        String oldValue = urlTwitter;
        urlTwitter = value;
        propertySupport.firePropertyChange(PROP_URL_TWITTER, oldValue, urlTwitter);
    }

    public String getUrlLinkedIn() {
        return urlLinkedIn;
    }

    public void setUrlLinkedIn(String value) {
        String oldValue = urlLinkedIn;
        urlLinkedIn = value;
        propertySupport.firePropertyChange(PROP_URL_LINKEDIN, oldValue, urlLinkedIn);
    }

    public String getUrlYouTube() {
        return urlYouTube;
    }

    public void setUrlYouTube(String value) {
        String oldValue = urlYouTube;
        urlYouTube = value;
        propertySupport.firePropertyChange(PROP_URL_YOUTUBE, oldValue, urlYouTube);
    }

    public String getUrlGooglePlus() {
        return urlGooglePlus;
    }

    public void setUrlGooglePlus(String value) {
        String oldValue = urlGooglePlus;
        urlGooglePlus = value;
        propertySupport.firePropertyChange(PROP_URL_GOOGLEPLUS, oldValue, urlGooglePlus);
    }
}
