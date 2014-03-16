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
public class CategoryObject {
    private int categoryId = 0;
    private String categoryCode = null;
    private String categoryName = null;

    //private CategoryBean category = null;

    public CategoryObject() {
    }

    public CategoryObject(int _categoryId, String _categoryCode, String _categoryName) {
        this();
        categoryId = _categoryId;
        categoryCode = _categoryCode;
        categoryName = _categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int value) {
        categoryId = value;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String value) {
        categoryCode = value;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String value) {
        categoryName = value;
    }
}
