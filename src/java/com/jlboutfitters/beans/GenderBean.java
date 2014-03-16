/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import com.jlboutfitters.object.GenderObject;

/**
 *
 * @author JamesHarte
 */
public class GenderBean extends BaseBean {

    public static final String PROP_GENDER_ID = "genderId";
    public static final String PROP_GENDER_CODE = "genderCode";
    public static final String PROP_GENDER_DESC = "genderDesc";

    private int genderId = 0;
    private String genderCode = null;
    private String genderDesc = null;

    public GenderBean() {
        super();
    }

    public GenderBean(int _genderId, String _genderCode, String _genderDesc) {
        this();
        genderId = _genderId;
        genderCode = _genderCode;
        genderDesc = _genderDesc;
    }

    public GenderBean(GenderObject genderObject) {
        this(genderObject.getGenderId(), genderObject.getGenderCode(), genderObject.getGenderDesc());
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int value) {
        int oldValue = genderId;
        genderId = value;
        propertySupport.firePropertyChange(PROP_GENDER_ID, oldValue, genderId);
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String value) {
        String oldValue = genderCode;
        genderCode = value;
        propertySupport.firePropertyChange(PROP_GENDER_CODE, oldValue, genderCode);
    }

    public String getGenderDesc() {
        return genderCode;
    }

    public void setGenderDesc(String value) {
        String oldValue = genderDesc;
        genderDesc = value;
        propertySupport.firePropertyChange(PROP_GENDER_DESC, oldValue, genderDesc);
    }
}
