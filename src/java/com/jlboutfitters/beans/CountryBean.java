/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import com.jlboutfitters.object.CountryObject;

/**
 *
 * @author JamesHarte
 */
public class CountryBean extends BaseBean {

    public static final String PROP_COUNTRY_ID = "countryId";
    public static final String PROP_COUNTRY_NAME = "countryName";

    private int countryId = 0;
    private String countryName = null;

    public CountryBean() {
        super();
    }

    public CountryBean(int _countryId, String _countryName) {
        this();
        countryId = _countryId;
        countryName = _countryName;
    }

    public CountryBean(CountryObject countryObject) {
        this(countryObject.getCountryId(), countryObject.getCountryName());
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int value) {
        int oldValue = countryId;
        countryId = value;
        propertySupport.firePropertyChange(PROP_COUNTRY_ID, oldValue, countryId);
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String value) {
        String oldValue = countryName;
        countryName = value;
        propertySupport.firePropertyChange(PROP_COUNTRY_NAME, oldValue, countryName);
    }
}
