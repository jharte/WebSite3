/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.object;

import java.io.Serializable;

/**
 *
 * @author JamesHarte
 */
public class CompanyObject implements Serializable {

    private int companyId = 0;
    private String name = null;
    private String infoEmailAddress = null;
    private String customerServiceEmailAddress = null;
    private String customerServicePhoneCountryPfx = null;
    private String customerServicePhoneLineNumber = null;
    private String customerServicePhoneExtension = null;
    private String customerServiceFaxCountryPfx = null;
    private String customerServiceFaxLineNumber = null;
    private int addressId = 0;
    private int contactId = 0;
    private String urlFacebook = null;
    private String urlTwitter = null;
    private String urlLinkedIn = null;
    private String urlYouTube = null;
    private String urlGooglePlus = null;

    public CompanyObject() {
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int value) {
        companyId = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getInfoEmailAddress() {
        return infoEmailAddress;
    }

    public void setInfoEmailAddress(String value) {
        infoEmailAddress = value;
    }

    public String getCustomerServiceEmailAddress() {
        return customerServiceEmailAddress;
    }

    public void setCustomerServiceEmailAddress(String value) {
        customerServiceEmailAddress = value;
    }

    public String getCustomerServicePhoneCountryPfx() {
        return customerServicePhoneCountryPfx;
    }

    public void setCustomerServicePhoneCountryPfx(String value) {
        customerServicePhoneCountryPfx = value;
    }

    public String getCustomerServicePhoneLineNumber() {
        return customerServicePhoneLineNumber;
    }

    public void setCustomerServicePhoneLineNumber(String value) {
        customerServicePhoneLineNumber = value;
    }

    public String getCustomerServicePhoneExtension() {
        return customerServicePhoneExtension;
    }

    public void setCustomerServicePhoneExtension(String value) {
        customerServicePhoneExtension = value;
    }

    public String getCustomerServiceFaxCountryPfx() {
        return customerServiceFaxCountryPfx;
    }

    public void setCustomerServiceFaxCountryPfx(String value) {
        customerServiceFaxCountryPfx = value;
    }

    public String getCustomerServiceFaxLineNumber() {
        return customerServiceFaxLineNumber;
    }

    public void setCustomerServiceFaxLineNumber(String value) {
        customerServiceFaxLineNumber = value;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int value) {
        addressId = value;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int value) {
        contactId = value;
    }

    public String getUrlFacebook() {
        return urlFacebook;
    }

    public void setUrlFacebook(String value) {
        urlFacebook = value;
    }

    public String getUrlTwitter() {
        return urlTwitter;
    }

    public void setUrlTwitter(String value) {
        urlTwitter = value;
    }

    public String getUrlLinkedIn() {
        return urlLinkedIn;
    }

    public void setUrlLinkedIn(String value) {
        urlLinkedIn = value;
    }

    public String getUrlYouTube() {
        return urlYouTube;
    }

    public void setUrlYouTube(String value) {
        urlYouTube = value;
    }

    public String getUrlGooglePlus() {
        return urlGooglePlus;
    }

    public void setUrlGooglePlus(String value) {
        urlGooglePlus = value;
    }
}
