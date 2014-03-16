/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.object;

//import java.beans.*;
//import java.io.Serializable;

/**
 *
 * @author JamesHarte
 */
public class VendorObject {
    private int vendorId;
    private String vendorCode;
    private String vendorName;
    private String vendorDescription;
    private String contactFirstName;
    private String contactLastName;
    private String contactPhoneCountryPfx;
    private String contactPhoneLineNumber;
    private String contactPhoneExtension;
    private String contactFaxCountryPfx;
    private String contactFaxLineNumber;

    //private VendorBean vendor = null;

    public VendorObject() {
    }

    public VendorObject(int _vendorId,
                        String _vendorCode,
                        String _vendorName,
                        String _vendorDescription,
                        String _contactFirstName,
                        String _contactLastName,
                        String _contactPhoneCountryPfx,
                        String _contactPhoneLineNumber,
                        String _contactPhoneExtension,
                        String _contactFaxCountryPfx,
                        String _contactFaxLineNumber) {
        this();
        vendorId = _vendorId;
        vendorCode = _vendorCode;
        vendorName = _vendorName;
        vendorDescription = _vendorDescription;
        contactFirstName = _contactFirstName;
        contactLastName = _contactLastName;
        contactPhoneCountryPfx = _contactPhoneCountryPfx;
        contactPhoneLineNumber = _contactPhoneLineNumber;
        contactPhoneExtension = _contactPhoneExtension;
        contactFaxCountryPfx = _contactFaxCountryPfx;
        contactFaxLineNumber = _contactFaxLineNumber;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int value) {
        vendorId = value;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String value) {
        vendorCode = value;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String value) {
        vendorName = value;
    }

    public String getVendorDescription() {
        return vendorDescription;
    }

    public void setVendorDescription(String value) {
        vendorDescription = value;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String value) {
        contactFirstName = value;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String value) {
        contactLastName = value;
    }

    public String getContactPhoneCountryPfx() {
        return contactPhoneCountryPfx;
    }

    public void setContactPhoneCountryPfx(String value) {
        contactPhoneCountryPfx = value;
    }

    public String getContactPhoneLineNumber() {
        return contactPhoneLineNumber;
    }

    public void setContactPhoneLineNumber(String value) {
        contactPhoneLineNumber = value;
    }

    public String getContactPhoneExtension() {
        return contactPhoneExtension;
    }

    public void setContactPhoneExtension(String value) {
        contactPhoneExtension = value;
    }

    public String getContactFaxCountryPfx() {
        return contactFaxCountryPfx;
    }

    public void setContactFaxCountryPfx(String value) {
        contactFaxCountryPfx = value;
    }

    public String getContactFaxLineNumber() {
        return contactFaxLineNumber;
    }

    public void setContactFaxLineNumber(String value) {
        contactFaxLineNumber = value;
    }
}
