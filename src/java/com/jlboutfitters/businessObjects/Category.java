/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.businessObjects;

import com.jlboutfitters.beans.CategoryBean;
import com.jlboutfitters.object.CategoryObject;
import com.jlboutfitters.dao.CategoryDAO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author JamesHarte
 */
public class Category {
    public static String URLFIELD_CATEGORY_ID = "CATEGORY_ID";

    public CategoryBean readCategory(int id)
            throws Exception
    {
        CategoryBean categoryBean = null;

        CategoryDAO categoryDAO = new CategoryDAO();
        CategoryObject categoryObject = categoryDAO.readCategory(id);
        if (categoryObject != null)
        {
            categoryBean = new CategoryBean(categoryObject);
        }
        return categoryBean;
    }

    public ArrayList<CategoryBean> readCategories()
            throws Exception
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        ArrayList<CategoryObject> categoryObjects = categoryDAO.readCategories();
        ArrayList<CategoryBean> categoryBeans = new ArrayList<CategoryBean>();
        Iterator<CategoryObject> it = categoryObjects.iterator();
        while (it.hasNext())
        {
            CategoryObject categoryObject = it.next();
            categoryBeans.add(new CategoryBean(categoryObject));
        }
        return categoryBeans;
    }
}
