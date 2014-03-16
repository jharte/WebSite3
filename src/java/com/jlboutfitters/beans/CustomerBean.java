/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import com.jlboutfitters.object.CustomerObject;
import java.sql.Date;

/**
 *
 * @author JamesHarte
 */
public class CustomerBean extends UserBean {

    public static final String PROP_EMAIL_ADDRESS = "emailAddress";
    public static final String PROP_BIRTH_DATE = "birthDate";
    public static final String PROP_PHONE_NUMBER = "phoneNumber";
    public static final String PROP_MAILING_ADDRESS = "mailingAddress";
    public static final String PROP_GENDER = "gender";

    private String emailAddress;
    private Date birthDate;
    private PhoneNumberBean phoneNumber;
    private AddressBean mailingAddress;
    private GenderBean gender;

    public CustomerBean() {
        super();
    }

    public CustomerBean(CustomerObject customerObject, QuestionBean _loginPwQuestion, AddressBean _mailingAddress, GenderBean _gender) {
        super(USER_TYPE_CUSTOMER, customerObject.getLoginId(), customerObject.getLoginPw(), customerObject.getLoginPwAnswer(), customerObject.getFirstName(), customerObject.getLastName(), _loginPwQuestion);
        emailAddress = customerObject.getEmailAddress();
        birthDate = customerObject.getBirthDate();
        phoneNumber = new PhoneNumberBean(customerObject.getPhoneCountryPfx(), customerObject.getPhoneLineNumber(), customerObject.getPhoneExtension());
        mailingAddress = _mailingAddress;
        gender = _gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String value) {
        String oldValue = emailAddress;
        emailAddress = value;
        propertySupport.firePropertyChange(PROP_EMAIL_ADDRESS, oldValue, emailAddress);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date value) {
        Date oldValue = birthDate;
        birthDate = value;
        propertySupport.firePropertyChange(PROP_BIRTH_DATE, oldValue, birthDate);
    }

    public String getPhoneNumber() {
        return emailAddress;
    }

    public void setPhoneNumber(PhoneNumberBean value) {
        PhoneNumberBean oldValue = phoneNumber;
        phoneNumber = value;
        propertySupport.firePropertyChange(PROP_PHONE_NUMBER, oldValue, phoneNumber);
    }

    public AddressBean getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(AddressBean value) {
        AddressBean oldValue = mailingAddress;
        mailingAddress = value;
        propertySupport.firePropertyChange(PROP_MAILING_ADDRESS, oldValue, mailingAddress);
    }

    public GenderBean getGender() {
        return gender;
    }

    public void setGender(GenderBean value) {
        GenderBean oldValue = gender;
        gender = value;
        propertySupport.firePropertyChange(PROP_GENDER, oldValue, gender);
    }
}
