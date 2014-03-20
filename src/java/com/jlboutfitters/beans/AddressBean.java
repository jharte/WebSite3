/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import java.beans.*;
import com.jlboutfitters.object.AddressObject;

/**
 *
 * @author JamesHarte
 */
public class AddressBean extends BaseBean {

    public static final String PROP_ADDRESS_ID = "addressId";
    public static final String PROP_STREET = "street";
    public static final String PROP_ADDRESS_LINE1 = "addressLine1";
    public static final String PROP_ADDRESS_LINE2 = "addressLine2";
    public static final String PROP_CITY = "city";
    public static final String PROP_COUNTY = "county";
    public static final String PROP_STATE = "state";
    public static final String PROP_ZIP_CODE = "zipCode";
    public static final String PROP_COUNTRY = "country";;
    public static final String PROP_PROVINCE = "province";
    public static final String PROP_POSTAL_CODE = "postalCode";

    private int addressId = 0;
    private String street = null;
    private String addressLine1 = null;
    private String addressLine2 = null;
    private String city = null;
    private String county = null;
    private String state = null;
    private String zipCode = null;
    private String country = null;
    private String province = null;
    private String postalCode = null;

    public AddressBean() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public AddressBean(int _addressId, String _street, String _addressLine1, String _addressLine2, String _city, String _county, String _state, String _zipCode) {
        this();
        addressId = _addressId;
        street = _street;
        addressLine1 = _addressLine1;
        addressLine2 = _addressLine2;
        city = _city;
        state = _state;
        zipCode = _zipCode;
    }

    public AddressBean(int _addressId, String _street, String _addressLine1, String _addressLine2, String _city, String _county, String _state, String _zipCode, String _province, String _postalCode, String _country) {
        this(_addressId, _street, _addressLine1, _addressLine2, _city, _county, _state, _zipCode);
        province = _province;
        country = _country;
        postalCode = _postalCode;
    }

    public AddressBean(AddressObject addressObject, String _state, String _country) {
        this(addressObject.getAddressId(), addressObject.getStreet(), addressObject.getAddressLine1(), addressObject.getAddressLine2(), addressObject.getCity(), addressObject.getCounty(), _state, addressObject.getZipCode());
        province = addressObject.getProvince();
        country = _country;
        postalCode = addressObject.getPostalCode();
    }

    public AddressBean(AddressObject addressObject, StateBean _state, CountryBean _country) {
        this(addressObject.getAddressId(), addressObject.getStreet(), addressObject.getAddressLine1(), addressObject.getAddressLine2(), addressObject.getCity(), addressObject.getCounty(), _state.getStateName(), addressObject.getZipCode());
        province = addressObject.getProvince();
        country = _country.getCountryName();
        postalCode = addressObject.getPostalCode();
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int value) {
        int oldValue = addressId;
        addressId = value;
        propertySupport.firePropertyChange(PROP_ADDRESS_ID, oldValue, addressId);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String value) {
        String oldValue = street;
        street = value;
        propertySupport.firePropertyChange(PROP_STREET, oldValue, street);
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String value) {
        String oldValue = addressLine1;
        addressLine1 = value;
        propertySupport.firePropertyChange(PROP_ADDRESS_LINE1, oldValue, addressLine1);
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String value) {
        String oldValue = addressLine2;
        addressLine2 = value;
        propertySupport.firePropertyChange(PROP_ADDRESS_LINE2, oldValue, addressLine2);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        String oldValue = city;
        city = value;
        propertySupport.firePropertyChange(PROP_CITY, oldValue, city);
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String value) {
        String oldValue = county;
        county = value;
        propertySupport.firePropertyChange(PROP_COUNTY, oldValue, county);
    }

    public String getState() {
        return state;
    }

    public void setState(String value) {
        String oldValue = state;
        state = value;
        propertySupport.firePropertyChange(PROP_STATE, oldValue, state);
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String value) {
        String oldValue = zipCode;
        zipCode = value;
        propertySupport.firePropertyChange(PROP_ZIP_CODE, oldValue, zipCode);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        String oldValue = country;
        country = value;
        propertySupport.firePropertyChange(PROP_COUNTRY, oldValue, country);
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String value) {
        String oldValue = province;
        province = value;
        propertySupport.firePropertyChange(PROP_PROVINCE, oldValue, province);
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String value) {
        String oldValue = postalCode;
        postalCode = value;
        propertySupport.firePropertyChange(PROP_POSTAL_CODE, oldValue, postalCode);
    }
}
