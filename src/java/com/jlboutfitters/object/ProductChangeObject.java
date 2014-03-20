/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.object;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author JamesHarte
 */
public class ProductChangeObject {
    private int productChangeId;
    private int status;
    private int productId;
    private String productCode;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private int vendorId;
    private int categoryId;

    public static final int STATUS_PENDING = 1;
    public static final int STATUS_APPROVED = 2;
    public static final int STATUS_DENIED = 3;
    public static final int STATUS_IN_PROCESS_APPROVED = 3;
    public static final int STATUS_IN_PROCESS_DENIED = 3;

    public ProductChangeObject() {
    }

    public ProductChangeObject(int _productChangeId,
                               int _status,
                               int _productId,
                               String _productCode,
                               String _productName,
                               String _productDescription,
                               double _price,
                               int _vendorId,
                               int _categoryId) {
        this();
        productChangeId = _productChangeId;
        status = _status;
        productId = _productId;
        productCode = _productCode;
        productName = _productName;
        productDescription = _productDescription;
        price = new BigDecimal(_price).setScale(2, RoundingMode.HALF_UP);
        vendorId = _vendorId;
        categoryId = _categoryId;
    }

    public int getProductChangeId() {
        return productChangeId;
    }

    public void setProductChangeId(int value) {
        productChangeId = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int value) {
        status = value;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int value) {
        productId = value;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String value) {
        productCode = value;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String value) {
        productName = value;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String value) {
        productDescription = value;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(double value) {
        price = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int value) {
        vendorId = value;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int value) {
        categoryId = value;
    }
}
