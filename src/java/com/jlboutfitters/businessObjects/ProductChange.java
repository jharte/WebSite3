/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.businessObjects;

import com.jlboutfitters.beans.ProductChangeBean;
import com.jlboutfitters.beans.ProductBean;
import com.jlboutfitters.beans.CategoryBean;
import com.jlboutfitters.beans.VendorBean;
import com.jlboutfitters.object.ProductChangeObject;
import com.jlboutfitters.object.ProductObject;
import com.jlboutfitters.object.CategoryObject;
import com.jlboutfitters.object.VendorObject;
import com.jlboutfitters.dao.ProductChangeDAO;
import com.jlboutfitters.dao.ProductDAO;
import com.jlboutfitters.dao.CategoryDAO;
import com.jlboutfitters.dao.VendorDAO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author JamesHarte
 */
public class ProductChange {
    public static String URLFIELD_PRODUCT_CHANGE_ID = "PRODUCT_CHANGE_ID";

    public ProductChangeBean readProductChange(int id)
            throws Exception
    {
        ProductChangeBean productChangeBean = null;

        ProductChangeDAO productChangeDAO = new ProductChangeDAO();
        ProductChangeObject productChangeObject = productChangeDAO.readProductChange(id);
        if (productChangeObject != null)
        {
            Product product = new Product();
            ProductBean originalProductBean = product.readProduct(productChangeObject.getProductId());

            ProductDAO productDAO = new ProductDAO();
            ProductObject productObject = productDAO.readProduct(productChangeObject.getProductId());
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
                if (categoryObject != null)
                {
                    categoryBean = new CategoryBean(categoryObject);
                }

                ProductBean changedProductBean = new ProductBean(productObject, vendorBean, categoryBean);

                productChangeBean = new ProductChangeBean(productChangeObject, originalProductBean, changedProductBean);
            }
        }
        return productChangeBean;
    }

    public ArrayList<ProductChangeBean> readProductChanges()
            throws Exception
    {
        ProductChangeDAO productChangeDAO = new ProductChangeDAO();

        //This line taken out
        //ProductChangeObject productChangeObject = productChangeDAO.readProductChanges();

        //Replaced with these lines
        ArrayList<ProductChangeObject> productChangeObjects = productChangeDAO.readProductChanges();
        ArrayList<ProductChangeBean> productChangeBeans = new ArrayList<ProductChangeBean>();
        Iterator<ProductChangeObject> it = productChangeObjects.iterator();
        ProductChangeBean productChangeBean = null;

        //while instead of if
        //if (productChangeObject != null)
        while (it.hasNext())
        {
            //Created inside loop
            ProductChangeObject productChangeObject = it.next();

            Product product = new Product();
            ProductBean originalProductBean = product.readProduct(productChangeObject.getProductId());

            ProductDAO productDAO = new ProductDAO();
            ProductObject productObject = productDAO.readProduct(productChangeObject.getProductId());
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
                if (categoryObject != null)
                {
                    categoryBean = new CategoryBean(categoryObject);
                }

                ProductBean changedProductBean = new ProductBean(productChangeObject, vendorBean, categoryBean);

                productChangeBean = new ProductChangeBean(productChangeObject, originalProductBean, changedProductBean);

                productChangeBeans.add(productChangeBean);
            }
        }
        return productChangeBeans;
    }
}
