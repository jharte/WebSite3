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
public class AddressObject {
    private int addressId = 0;
    private String street = null;
    private String addressLine1 = null;
    private String addressLine2 = null;
    private String city = null;
    private String county = null;
    private int stateId = 0;
    private String zipCode = null;
    private int countryId = 0;
    private String province = null;
    private String postalCode = null;

    //private AddressBean address = null;

    public AddressObject() {
    }

    public AddressObject(String _street, String _addressLine1, String _addressLine2, String _city, String _county, int _stateId, String _zipCode) {
        this();
        street = _street;
        addressLine1 = _addressLine1;
        addressLine2 = _addressLine2;
        city = _city;
        county = _county;
        stateId = _stateId;
        zipCode = _zipCode;
    }

    public AddressObject(String _street, String _addressLine1, String _addressLine2, String _city, String _province, String _postalCode, int _countryId) {
        this(_street, _addressLine1, _addressLine2, _city, null, 0, null);
        province = _province;
        countryId = _countryId;
        postalCode = _postalCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int value) {
        addressId = value;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String value) {
        street = value;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String value) {
        addressLine1 = value;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String value) {
        addressLine2 = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        city = value;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String value) {
        county = value;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int value) {
        stateId = value;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String value) {
        zipCode = value;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int value) {
        countryId = value;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String value) {
        province = value;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String value) {
        postalCode = value;
    }
}
