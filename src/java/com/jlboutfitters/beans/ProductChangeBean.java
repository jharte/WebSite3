/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.beans;

import com.jlboutfitters.object.ProductChangeObject;

/**
 *
 * @author JamesHarte
 */
public class ProductChangeBean extends BaseBean {

    public static final String PROP_PRODUCT_CHANGE_ID = "productChangeId";
    public static final String PROP_CHANGED_PRODUCT = "changedProduct";
    public static final String PROP_ORIGINAL_PRODUCT = "originalProduct";

    public static final String LABEL_PRODUCT_ID = "Product Change Id";

    public static final int STATUS_PENDING = ProductChangeObject.STATUS_PENDING;
    public static final int STATUS_APPROVED = ProductChangeObject.STATUS_APPROVED;
    public static final int STATUS_DENIED = ProductChangeObject.STATUS_DENIED;
    public static final int STATUS_IN_PROCESS_APPROVED = ProductChangeObject.STATUS_IN_PROCESS_APPROVED;
    public static final int STATUS_IN_PROCESS_DENIED = ProductChangeObject.STATUS_IN_PROCESS_DENIED;

    private int productChangeId;
    private int status;
    private ProductBean changedProduct;
    private ProductBean originalProduct;

    public ProductChangeBean() {
        super();
    }

    public ProductChangeBean(int _productChangeId, int _status) {
        this();

        productChangeId = _productChangeId;
        status = _status;
    }

    public ProductChangeBean(ProductChangeObject productChangeObject) {
        this(productChangeObject.getProductChangeId(), productChangeObject.getStatus());
    }

    public ProductChangeBean(ProductChangeObject productChangeObject, ProductBean _originalProduct, ProductBean _changedProduct) {
        this(productChangeObject);

        changedProduct = _changedProduct;
        originalProduct = _originalProduct;
    }

    public int getProductChangeId() {
        return productChangeId;
    }

    public void setProductId(int value) {
        int oldValue = productChangeId;
        productChangeId = value;
        propertySupport.firePropertyChange(PROP_PRODUCT_CHANGE_ID, oldValue, productChangeId);
    }

    public ProductBean getChangedProduct() {
        return changedProduct;
    }

    public void setChangedProduct(ProductBean value) {
        ProductBean oldValue = changedProduct;
        changedProduct = value;
        propertySupport.firePropertyChange(PROP_CHANGED_PRODUCT, oldValue, changedProduct);
    }

    public ProductBean getOriginalProduct() {
        return originalProduct;
    }

    public void setOriginalProduct(ProductBean value) {
        ProductBean oldValue = originalProduct;
        originalProduct = value;
        propertySupport.firePropertyChange(PROP_ORIGINAL_PRODUCT, oldValue, originalProduct);
    }

    public boolean changedProductCode() {
        return ((originalProduct == null)||(!changedProduct.getProductCode().equals(originalProduct.getProductCode())));
    }

    public boolean changedProductName() {
        return ((originalProduct == null)||(!changedProduct.getProductName().equals(originalProduct.getProductName())));
    }

    public boolean changedProductDescription() {
        System.out.println(" changedProduct.getProductDescription()=*"+changedProduct.getProductDescription()+"*");
        System.out.println("originalProduct.getProductDescription()=*"+originalProduct.getProductDescription()+"*");
        System.out.println("Compare="+(!changedProduct.getProductDescription().equals(originalProduct.getProductDescription())));
        return ((originalProduct == null)||(!changedProduct.getProductDescription().equals(originalProduct.getProductDescription())));
    }

    public boolean changedVendor() {
        if ((originalProduct == null) && (changedProduct == null))
            return false;
        else
            if ((originalProduct == null) || (changedProduct == null))
                return true;
            else
                if ((originalProduct.getVendor()==null) && (changedProduct.getVendor()==null))
                    return false;
                else
                    if ((originalProduct.getVendor() == null) || (changedProduct.getVendor() == null))
                        return true;
                    else
                        if (originalProduct.getVendor().getVendorId() == originalProduct.getVendor().getVendorId())
                            return false;
                        else
                            return true;
    }

    public boolean changedCategory() {
        if ((originalProduct == null) && (changedProduct == null))
            return false;
        else
            if ((originalProduct == null) || (changedProduct == null))
                return true;
            else
                if ((originalProduct.getCategory()==null) && (changedProduct.getCategory()==null))
                    return false;
                else
                    if ((originalProduct.getCategory() == null) || (changedProduct.getCategory() == null))
                        return true;
                    else
                        if (originalProduct.getCategory().getCategoryId() == originalProduct.getCategory().getCategoryId())
                            return false;
                        else
                            return true;
    }

    public boolean changedPrice() {
        return ((originalProduct == null)||(changedProduct.getPrice() != originalProduct.getPrice()));
    }
}
