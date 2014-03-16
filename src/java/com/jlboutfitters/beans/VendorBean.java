/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import com.jlboutfitters.object.VendorObject;

/**
 *
 * @author JamesHarte
 */
public class VendorBean extends BaseBean {
    public static final String PROP_VENDOR_ID = "vendorId";
    public static final String PROP_VENDOR_CODE = "vendorCode";
    public static final String PROP_VENDOR_NAME = "vendorName";
    public static final String PROP_VENDOR_DESCRIPTION = "vendorDescription";
    public static final String PROP_CONTACT_FIRST_NAME = "contactFirstName";
    public static final String PROP_CONTACT_LAST_NAME = "contactLastName";
    public static final String PROP_CONTACT_PHONE_NUMBER = "contactPhoneNumber";
    public static final String PROP_CONTACT_FAX_NUMBER = "contactFaxNumber";

    public static final String LABEL_VENDOR_ID = "Id";
    public static final String LABEL_VENDOR_CODE = "Vendor Code";
    public static final String LABEL_VENDOR_NAME = "Name";
    public static final String LABEL_VENDOR_DESCRIPTION = "Description";
    public static final String LABEL_CONTACT_FIRST_NAME = "Contact First Name";
    public static final String LABEL_CONTACT_LAST_NAME = "Contact Last Name";
    public static final String LABEL_CONTACT_PHONE_NUMBER = "Contact Phone Number";
    public static final String LABEL_CONTACT_FAX_NUMBER = "Contact Fax Number";

    private int vendorId;
    private String vendorCode;
    private String vendorName;
    private String vendorDescription;
    private String contactFirstName;
    private String contactLastName;
    private PhoneNumberBean contactPhoneNumber;
    private PhoneNumberBean contactFaxNumber;

    public VendorBean() {
        super();
    }

    public VendorBean(int _vendorId, String _vendorCode, String _vendorName, String _vendorDescription,
                      String _contactFirstName, String _contactLastName,
                      String _contactPhoneCountryPfx, String _contactPhoneLineNumber, String _contactPhoneExtension,
                      String _contactFaxCountryPfx, String _contactFaxLineNumber) {
        this();
        vendorId = _vendorId;
        vendorCode = _vendorCode;
        vendorName = _vendorName;
        vendorDescription = _vendorDescription;
        contactFirstName = _contactFirstName;
        contactLastName = _contactLastName;
        contactPhoneNumber = new PhoneNumberBean(_contactPhoneCountryPfx, _contactPhoneLineNumber, _contactPhoneExtension);
        contactFaxNumber = new PhoneNumberBean(_contactFaxCountryPfx, _contactFaxLineNumber, "");
    }

    public VendorBean(VendorObject vendorObject) {
        this();
        vendorId = vendorObject.getVendorId();
        vendorCode = vendorObject.getVendorCode();
        vendorName = vendorObject.getVendorName();
        vendorDescription = vendorObject.getVendorDescription();
        contactFirstName = vendorObject.getContactFirstName();
        contactLastName = vendorObject.getContactLastName();
        contactPhoneNumber = new PhoneNumberBean(vendorObject.getContactPhoneCountryPfx(), vendorObject.getContactPhoneLineNumber(), vendorObject.getContactPhoneExtension());
        contactFaxNumber = new PhoneNumberBean(vendorObject.getContactFaxCountryPfx(), vendorObject.getContactFaxLineNumber(), "");
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int value) {
        int oldValue = vendorId;
        vendorId = value;
        propertySupport.firePropertyChange(PROP_VENDOR_ID, oldValue, vendorId);
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String value) {
        String oldValue = vendorCode;
        vendorCode = value;
        propertySupport.firePropertyChange(PROP_VENDOR_CODE, oldValue, vendorCode);
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String value) {
        String oldValue = vendorName;
        vendorName = value;
        propertySupport.firePropertyChange(PROP_VENDOR_NAME, oldValue, vendorName);
    }

    public String getVendorDescription() {
        return vendorDescription;
    }

    public void setVendorDescription(String value) {
        String oldValue = vendorDescription;
        vendorDescription = value;
        propertySupport.firePropertyChange(PROP_VENDOR_DESCRIPTION, oldValue, vendorDescription);
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String value) {
        String oldValue = contactFirstName;
        contactFirstName = value;
        propertySupport.firePropertyChange(PROP_CONTACT_FIRST_NAME, oldValue, contactFirstName);
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String value) {
        String oldValue = contactLastName;
        contactLastName = value;
        propertySupport.firePropertyChange(PROP_CONTACT_LAST_NAME, oldValue, contactLastName);
    }

    public PhoneNumberBean getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(PhoneNumberBean value) {
        PhoneNumberBean oldValue = contactPhoneNumber;
        contactPhoneNumber = value;
        propertySupport.firePropertyChange(PROP_CONTACT_PHONE_NUMBER, oldValue, contactPhoneNumber);
    }

    public PhoneNumberBean getContactFaxNumber() {
        return contactFaxNumber;
    }

    public void setContactFaxNumber(PhoneNumberBean value) {
        PhoneNumberBean oldValue = contactFaxNumber;
        contactFaxNumber = value;
        propertySupport.firePropertyChange(PROP_CONTACT_FAX_NUMBER, oldValue, contactFaxNumber);
    }
}
