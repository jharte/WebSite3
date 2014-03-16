/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

/**
 *
 * @author JamesHarte
 */
public class PhoneNumberBean extends BaseBean {

    public static final String PROP_COUNTRY_PREFIX = "countryPrefix";
    public static final String PROP_PHONE_NUMBER = "phoneNumber";
    public static final String PROP_EXTENSION = "extension";
    private String countryPrefix;
    private String phoneNumber;
    private String extension;

    public PhoneNumberBean() {
        super();
    }

    public PhoneNumberBean(String _countryPrefix, String _phoneNumber, String _extension) {
        this();

        countryPrefix = _countryPrefix;
        phoneNumber = _phoneNumber;
        extension = _extension;
    }

    public PhoneNumberBean(String _phoneNumber) {
        this();

        countryPrefix = null;
        phoneNumber = _phoneNumber;
        extension = null;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String value) {
        String oldValue = phoneNumber;
        phoneNumber = value;
        propertySupport.firePropertyChange(PROP_PHONE_NUMBER, oldValue, phoneNumber);
    }

    public static String createPhoneNumberWithoutLetters(String value) {
        String phoneNumberWithoutLetters = new String(value);
        phoneNumberWithoutLetters = phoneNumberWithoutLetters.replaceAll("[a-cA-C]","2");
        phoneNumberWithoutLetters = phoneNumberWithoutLetters.replaceAll("[d-fD-F]","3");
        phoneNumberWithoutLetters = phoneNumberWithoutLetters.replaceAll("[g-iG-I]","4");
        phoneNumberWithoutLetters = phoneNumberWithoutLetters.replaceAll("[j-lJ-L]","5");
        phoneNumberWithoutLetters = phoneNumberWithoutLetters.replaceAll("[m-oM-O]","6");
        phoneNumberWithoutLetters = phoneNumberWithoutLetters.replaceAll("[p-sP-S]","7");
        phoneNumberWithoutLetters = phoneNumberWithoutLetters.replaceAll("[t-vT-V]","8");
        phoneNumberWithoutLetters = phoneNumberWithoutLetters.replaceAll("[w-zW-Z]","9");
        return phoneNumberWithoutLetters;
    }

    public static String createPhoneNumberWithOnlyNumbers(String value) {
        String phoneNumberWithOnlyNumbers = new String(createPhoneNumberWithoutLetters(value));
        phoneNumberWithOnlyNumbers = phoneNumberWithOnlyNumbers.replaceAll( "[^\\d]","");
        return phoneNumberWithOnlyNumbers;
    }

    public String getCountryPrefix() {
        return countryPrefix;
    }

    public void setCountryPrefix(String value) {
        String oldValue = countryPrefix;
        countryPrefix = value;
        propertySupport.firePropertyChange(PROP_COUNTRY_PREFIX, oldValue, countryPrefix);
    }

    public String getExension() {
        return extension;
    }

    public void setExtension(String value) {
        String oldValue = extension;
        extension = value;
        propertySupport.firePropertyChange(PROP_EXTENSION, oldValue, extension);
    }

    public String toString() {
        return ((countryPrefix==null)?"":countryPrefix + "") +
               ((phoneNumber==null)?"":phoneNumber) +
               ((extension==null)?"":"#"+extension);
    }
}
