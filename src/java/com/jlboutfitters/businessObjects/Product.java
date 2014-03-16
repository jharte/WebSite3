/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.businessObjects;

import com.jlboutfitters.beans.ProductBean;
import com.jlboutfitters.beans.CategoryBean;
import com.jlboutfitters.beans.VendorBean;
import com.jlboutfitters.object.ProductObject;
import com.jlboutfitters.object.CategoryObject;
import com.jlboutfitters.object.VendorObject;
import com.jlboutfitters.dao.ProductDAO;
import com.jlboutfitters.dao.CategoryDAO;
import com.jlboutfitters.dao.VendorDAO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author JamesHarte
 */
public class Product {
    public static String URLFIELD_PRODUCT_ID = "PRODUCT_ID";

    public ProductBean readProduct(int id)
            throws Exception
    {
        ProductBean productBean = null;

        ProductDAO productDAO = new ProductDAO();
        ProductObject productObject = productDAO.readProduct(id);
        if (productObject != null)
        {
            VendorDAO vendorDAO = new VendorDAO();
            VendorObject vendorObject = vendorDAO.readVendor(productObject.getVendorId());
            VendorBean vendorBean = null;
            if (vendorObject != null)
            {
                vendorBean = new VendorBean(vendorObject);
            }

            CategoryDAO categoryDAO = new CategoryDAO();
            CategoryObject categoryObject = categoryDAO.readCategory(productObject.getCategoryId());
            CategoryBean categoryBean = null;
            if (vendorObject != null)
            {
                vendorBean = new VendorBean(vendorObject);
            }

            productBean = new ProductBean(productObject, vendorBean, categoryBean);
        }
        return productBean;
    }

    public ArrayList<ProductBean> readProducts()
            throws Exception
    {
        ProductBean productBean = null;

        ProductDAO productDAO = new ProductDAO();
        ArrayList<ProductObject> productObjects = productDAO.readProducts();
        ArrayList<ProductBean> productBeans = new ArrayList<ProductBean>();
        Iterator<ProductObject> it = productObjects.iterator();
        while (it.hasNext())
        {
            ProductObject productObject = it.next();

            VendorDAO vendorDAO = new VendorDAO();
            VendorObject vendorObject = vendorDAO.readVendor(productObject.getVendorId());
            VendorBean vendorBean = null;
            if (vendorObject != null)
            {
                vendorBean = new VendorBean(vendorObject);
            }

            CategoryDAO categoryDAO = new CategoryDAO();
            CategoryObject categoryObject = categoryDAO.readCategory(productObject.getCategoryId());
            CategoryBean categoryBean = null;
            if (categoryObject != null)
            {
                categoryBean = new CategoryBean(categoryObject);
            }

            productBean = new ProductBean(productObject, vendorBean, categoryBean);
            productBeans.add(productBean);
        }
        return productBeans;
    }
}
