/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import com.jlboutfitters.object.CategoryObject;

/**
 *
 * @author JamesHarte
 */
public class CategoryBean extends BaseBean {

    public static final String PROP_CATEGORY_ID = "categoryId";
    public static final String PROP_CATEGORY_CODE = "categoryCode";
    public static final String PROP_CATEGORY_NAME = "categoryName";

    private int categoryId;
    private String categoryCode;
    private String categoryName;

    public CategoryBean() {
        super();
    }

    public CategoryBean(CategoryObject categoryObject) {
        this();

        categoryId = categoryObject.getCategoryId();
        categoryCode = categoryObject.getCategoryCode();
        categoryName = categoryObject.getCategoryName();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int value) {
        int oldValue = categoryId;
        categoryId = value;
        propertySupport.firePropertyChange(PROP_CATEGORY_ID, oldValue, categoryId);
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String value) {
        String oldValue = categoryCode;
        categoryCode = value;
        propertySupport.firePropertyChange(PROP_CATEGORY_CODE, oldValue, categoryCode);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String value) {
        String oldValue = categoryName;
        categoryName = value;
        propertySupport.firePropertyChange(PROP_CATEGORY_NAME, oldValue, categoryName);
    }
}
