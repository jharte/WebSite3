/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.businessObjects;

import com.jlboutfitters.beans.AddressBean;
import com.jlboutfitters.beans.CompanyBean;
import com.jlboutfitters.object.AddressObject;
import com.jlboutfitters.object.CompanyObject;
import com.jlboutfitters.object.StateObject;
import com.jlboutfitters.object.CountryObject;
import com.jlboutfitters.dao.AddressDAO;
import com.jlboutfitters.dao.CompanyDAO;
import com.jlboutfitters.dao.StateDAO;
import com.jlboutfitters.dao.CountryDAO;

/**
 *
 * @author JamesHarte
 */
public class Company {
    public CompanyBean readCompany(int id)
            throws Exception
    {
        CompanyBean companyBean = null;

        CompanyDAO companyDAO = new CompanyDAO();
        CompanyObject companyObject = companyDAO.readCompany(id);
        if (companyObject != null)
        {
            companyBean = new CompanyBean(companyObject);
            if (companyObject.getAddressId() != 0)
            {
                AddressDAO addressDAO = new AddressDAO();
                AddressObject addressObject = addressDAO.readAddress(companyObject.getAddressId());
                if (addressObject != null)
                {
                    StateDAO stateDAO = new StateDAO();
                    StateObject stateObject = stateDAO.readState(addressObject.getStateId());
                    CountryDAO countryDAO = new CountryDAO();
                    CountryObject countryObject = countryDAO.readCountry(addressObject.getCountryId());
                    AddressBean addressBean = new AddressBean(addressObject,
                                                              (stateObject==null)?null:stateObject.getStateCode(),
                                                              (countryObject==null)?null:countryObject.getCountryName());
                    companyBean.setAddress(addressBean);
                }
            }
        }
        return companyBean;
    }
}
