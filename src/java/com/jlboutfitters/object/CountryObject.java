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
public class CountryObject {
    private int countryId = 0;
    private String countryName = null;

    //private CountryBean country = null;

    public CountryObject() {
    }

    public CountryObject(int _countryId, String _countryName) {
        this();
        countryId = _countryId;
        countryName = _countryName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int value) {
        countryId = value;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String value) {
        countryName = value;
    }
}
