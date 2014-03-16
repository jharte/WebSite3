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
public class GenderObject {
    private int genderId = 0;
    private String genderCode = null;
    private String genderDesc = null;

    public GenderObject() {
    }

    public GenderObject(int _genderId, String _genderCode, String _genderDesc) {
        this();
        genderId = _genderId;
        genderCode = _genderCode;
        genderDesc = _genderDesc;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int value) {
        genderId = value;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String value) {
        genderCode = value;
    }

    public String getGenderDesc() {
        return genderDesc;
    }

    public void setGenderDesc(String value) {
        genderDesc = value;
    }
}
