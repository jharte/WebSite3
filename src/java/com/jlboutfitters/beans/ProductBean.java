/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import com.jlboutfitters.object.ProductChangeObject;
import com.jlboutfitters.object.ProductObject;
import java.math.BigDecimal;

/**
 *
 * @author JamesHarte
 */
public class ProductBean extends BaseBean {

    public static final String PROP_PRODUCT_ID = "productId";
    public static final String PROP_PRODUCT_CODE = "productCode";
    public static final String PROP_PRODUCT_NAME = "productName";
    public static final String PROP_PRODUCT_DESCRIPTION = "productDescription";
    public static final String PROP_PRICE = "price";
    public static final String PROP_VENDOR = "vendor";
    public static final String PROP_CATEGORY = "category";

    public static final String LABEL_PRODUCT_ID = "Product&nbsp;Id";
    public static final String LABEL_PRODUCT_CODE = "productCode";
    public static final String LABEL_PRODUCT_NAME = "productName";
    public static final String LABEL_PRODUCT_DESCRIPTION = "productDescription";
    public static final String LABEL_PRICE = "price";
    public static final String LABEL_VENDOR = "vendor";
    public static final String LABEL_CATEGORY = "category";

    private int productId;
    private String productCode;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private VendorBean vendor;
    private CategoryBean category;

    public ProductBean() {
        super();
    }

    public ProductBean(int _productId, String _productCode, String _productName, String _productDescription, BigDecimal _price) {
        this();

        productId = _productId;
        productCode = _productCode;
        productName = _productName;
        productDescription = _productDescription;
        price = _price;
    }

    public ProductBean(ProductObject productObject) {
        this();

        productId = productObject.getProductId();
        productCode = productObject.getProductCode();
        productName = productObject.getProductName();
        productDescription = productObject.getProductDescription();
        price = productObject.getPrice();
    }

    public ProductBean(ProductObject _productObject, VendorBean _vendor, CategoryBean _category) {
        this(_productObject);

        vendor = _vendor;
        category = _category;
    }

    public ProductBean(ProductChangeObject _productChangeObject) {
        this();

        productId = _productChangeObject.getProductId();
        productCode = _productChangeObject.getProductCode();
        productName = _productChangeObject.getProductName();
        productDescription = _productChangeObject.getProductDescription();
        price = _productChangeObject.getPrice();
    }

    public ProductBean(ProductChangeObject _productChangeObject, VendorBean _vendor, CategoryBean _category) {
        this(_productChangeObject);

        vendor = _vendor;
        category = _category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int value) {
        int oldValue = productId;
        productId = value;
        propertySupport.firePropertyChange(PROP_PRODUCT_ID, oldValue, productId);
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String value) {
        String oldValue = productCode;
        productCode = value;
        propertySupport.firePropertyChange(PROP_PRODUCT_CODE, oldValue, productCode);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String value) {
        String oldValue = productName;
        productName = value;
        propertySupport.firePropertyChange(PROP_PRODUCT_NAME, oldValue, productName);
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String value) {
        String oldValue = productDescription;
        productDescription = value;
        propertySupport.firePropertyChange(PROP_PRODUCT_DESCRIPTION, oldValue, productDescription);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal value) {
        BigDecimal oldValue = price;
        price = value;
        propertySupport.firePropertyChange(PROP_PRICE, oldValue, price);
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean value) {
        CategoryBean oldValue = category;
        category = value;
        propertySupport.firePropertyChange(PROP_CATEGORY, oldValue, category);
    }

    public VendorBean getVendor() {
        return vendor;
    }

    public void setVendor(VendorBean value) {
        VendorBean oldValue = vendor;
        vendor = value;
        propertySupport.firePropertyChange(PROP_VENDOR, oldValue, vendor);
    }
}
