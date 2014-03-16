/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.businessObjects;

import com.jlboutfitters.beans.CountryBean;
import com.jlboutfitters.object.CountryObject;
import com.jlboutfitters.dao.CountryDAO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author JamesHarte
 */
public class Country {
    public CountryBean readCountry(int id)
            throws Exception
    {
        CountryBean countryBean = null;

        CountryDAO countryDAO = new CountryDAO();
        CountryObject countryObject = countryDAO.readCountry(id);
        if (countryObject != null)
        {
            countryBean = new CountryBean(countryObject);
        }
        return countryBean;
    }

    public ArrayList<CountryBean> readCountries()
            throws Exception
    {
        CountryDAO countryDAO = new CountryDAO();
        ArrayList<CountryObject> countryObjects = countryDAO.readCountries();
        ArrayList<CountryBean> countryBeans = new ArrayList<CountryBean>();
        Iterator<CountryObject> it = countryObjects.iterator();
        while (it.hasNext())
        {
            CountryObject countryObject = it.next();
            countryBeans.add(new CountryBean(countryObject));
        }
        return countryBeans;
    }
}
