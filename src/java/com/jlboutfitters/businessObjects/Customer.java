/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.businessObjects;

import com.jlboutfitters.beans.AddressBean;
import com.jlboutfitters.beans.CountryBean;
import com.jlboutfitters.beans.CustomerBean;
import com.jlboutfitters.beans.QuestionBean;
import com.jlboutfitters.beans.StateBean;
import com.jlboutfitters.dao.AddressDAO;
import com.jlboutfitters.dao.CountryDAO;
import com.jlboutfitters.object.CustomerObject;
import com.jlboutfitters.dao.CustomerDAO;
import com.jlboutfitters.dao.QuestionDAO;
import com.jlboutfitters.dao.StateDAO;
import com.jlboutfitters.object.AddressObject;
import com.jlboutfitters.object.CountryObject;
import com.jlboutfitters.object.QuestionObject;
import com.jlboutfitters.object.StateObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author JamesHarte
 */
public class Customer {
    public static String URLFIELD_CUSTOMER_ID = "CUSTOMER_ID";

    public CustomerBean readCustomer(int id)
            throws Exception
    {
        CustomerBean customerBean = null;

        CustomerDAO customerDAO = new CustomerDAO();
        CustomerObject customerObject = customerDAO.readCustomer(id);

        QuestionBean questionBean = null;
        if (customerObject != null)
        {
            {
                QuestionDAO questionDAO = new QuestionDAO();
                QuestionObject questionObject = questionDAO.readQuestion(customerObject.getLoginPwQuestion());
                if (questionObject != null)
                {
                    questionBean = new QuestionBean(questionObject);
                }
            }

            AddressBean addressBean = null;
            {
                AddressDAO addressDAO = new AddressDAO();
                AddressObject addressObject = addressDAO.readAddress(customerObject.getMailingAddressId());

                if (addressObject != null)
                {
                    StateBean stateBean = null;
                    {
                        StateDAO stateDAO = new StateDAO();
                        StateObject stateObject = stateDAO.readState(addressObject.getStateId());
                        if (stateObject != null)
                        {
                            stateBean = new StateBean(stateObject);
                        }
                    }

                    CountryBean countryBean = null;
                    {
                        CountryDAO countryDAO = new CountryDAO();
                        CountryObject countryObject = countryDAO.readCountry(addressObject.getCountryId());
                        if (countryObject != null)
                        {
                            countryBean = new CountryBean(countryObject);
                        }
                    }

                    addressBean = new AddressBean(addressObject, stateBean, countryBean);
                }
            }

            customerBean = new CustomerBean(customerObject, questionBean, addressBean);
        }
        return customerBean;
    }

    public ArrayList<CustomerBean> readCustomers()
            throws Exception
    {
        CustomerBean customerBean = null;

        CustomerDAO customerDAO = new CustomerDAO();
        ArrayList<CustomerObject> customerObjects = customerDAO.readCustomers();
System.out.println("Customer "+customerObjects.size());
        ArrayList<CustomerBean> customerBeans = new ArrayList<CustomerBean>();
        Iterator<CustomerObject> it = customerObjects.iterator();
        while (it.hasNext())
        {
            CustomerObject customerObject = it.next();

            QuestionBean questionBean = null;
            {
                QuestionDAO questionDAO = new QuestionDAO();
                QuestionObject questionObject = questionDAO.readQuestion(customerObject.getLoginPwQuestion());
                if (questionObject != null)
                {
                    questionBean = new QuestionBean(questionObject);
                }
            }

            AddressBean addressBean = null;
            {
                AddressDAO addressDAO = new AddressDAO();
                AddressObject addressObject = addressDAO.readAddress(customerObject.getMailingAddressId());
                if (addressObject != null)
                {
                    StateBean stateBean = null;
                    {
                        StateDAO stateDAO = new StateDAO();
                        StateObject stateObject = stateDAO.readState(addressObject.getStateId());
                        if (stateObject != null)
                        {
                            stateBean = new StateBean(stateObject);
                        }
                    }

                    CountryBean countryBean = null;
                    {
                        CountryDAO countryDAO = new CountryDAO();
                        CountryObject countryObject = countryDAO.readCountry(addressObject.getCountryId());
                        if (countryObject != null)
                        {
                            countryBean = new CountryBean(countryObject);
                        }
                    }

                    addressBean = new AddressBean(addressObject, stateBean, countryBean);
                }
            }

            customerBean = new CustomerBean(customerObject, questionBean, addressBean);

            customerBeans.add(customerBean);
        }
        return customerBeans;
    }
}
