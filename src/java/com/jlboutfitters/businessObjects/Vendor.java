/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.businessObjects;

import com.jlboutfitters.beans.VendorBean;
import com.jlboutfitters.object.VendorObject;
import com.jlboutfitters.dao.VendorDAO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author JamesHarte
 */
public class Vendor {
    public static String URLFIELD_VENDOR_ID = "VENDOR_ID";

    public VendorBean readVendor(int id)
            throws Exception
    {
        VendorBean vendorBean = null;

        VendorDAO vendorDAO = new VendorDAO();
        VendorObject vendorObject = vendorDAO.readVendor(id);
        if (vendorObject != null)
        {
            vendorBean = new VendorBean(vendorObject);
        }
        return vendorBean;
    }

    public ArrayList<VendorBean> readVendors()
            throws Exception
    {
        VendorDAO vendorDAO = new VendorDAO();
        ArrayList<VendorObject> vendorObjects = vendorDAO.readVendors();
        ArrayList<VendorBean> vendorBeans = new ArrayList<VendorBean>();
        Iterator<VendorObject> it = vendorObjects.iterator();
        while (it.hasNext())
        {
            VendorObject vendorObject = it.next();
            vendorBeans.add(new VendorBean(vendorObject));
        }
        return vendorBeans;
    }
}
