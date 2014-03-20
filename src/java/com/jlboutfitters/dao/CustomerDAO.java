/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.jlboutfitters.object.DBObject;
import com.jlboutfitters.object.CustomerObject;
import java.util.ArrayList;

/**
 *
 * @author JamesHarte
 */
public class CustomerDAO {
    final static String TABLE_CUSTOMER = "CUSTOMER";

    final static String FIELD_CUSTOMER_ID = "CUSTOMER_ID";
    final static String FIELD_LOGIN_ID = "LOGIN_ID";
    final static String FIELD_LOGIN_PW = "LOGIN_PW";
    final static String FIELD_LOGIN_PW_QUESTION = "LOGIN_PW_QUESTION";
    final static String FIELD_LOGIN_PW_ANSWER = "LOGIN_PW_ANSWER";
    final static String FIELD_FIRST_NAME = "FIRST_NAME";
    final static String FIELD_LAST_NAME = "LAST_NAME";
    final static String FIELD_EMAIL_ADDRESS = "EMAIL_ADDRESS";
    final static String FIELD_PHONE_COUNTRY_PFX = "PHONE_COUNTRY_PFX";
    final static String FIELD_PHONE_LINE_NUMBER = "PHONE_LINE_NUMBER";
    final static String FIELD_PHONE_EXTENSION = "PHONE_EXTENSION";
    final static String FIELD_MAILING_ADDRESS_ID = "MAILING_ADDRESS_ID";
    final static String FIELD_LAST_MOD_TS = "LAST_MOD_TS";
    final static String FIELD_LAST_MOD_USER = "LAST_MOD_USER";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public CustomerObject readCustomer(int id)
            throws Exception
    {
        CustomerObject customerObject = new CustomerObject();

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_CUSTOMER_ID + ","
                                         + FIELD_LOGIN_ID + ","
                                         + FIELD_LOGIN_PW + ","
                                         + FIELD_LOGIN_PW_QUESTION + ","
                                         + FIELD_LOGIN_PW_ANSWER + ","
                                         + FIELD_FIRST_NAME + ","
                                         + FIELD_LAST_NAME + ","
                                         + FIELD_EMAIL_ADDRESS + ","
                                         + FIELD_PHONE_COUNTRY_PFX + ","
                                         + FIELD_PHONE_LINE_NUMBER + ","
                                         + FIELD_PHONE_EXTENSION + ","
                                         + FIELD_MAILING_ADDRESS_ID + ","
                                         + FIELD_LAST_MOD_TS + ","
                                         + FIELD_LAST_MOD_USER + " "
                               + "FROM " + TABLE_CUSTOMER + " "
                              + "WHERE " + FIELD_CUSTOMER_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customerObject = new CustomerObject();
                customerObject.setCustomerId(resultSet.getInt(FIELD_CUSTOMER_ID));
                customerObject.setLoginId(resultSet.getString(FIELD_LOGIN_ID));
                customerObject.setLoginPw(resultSet.getString(FIELD_LOGIN_PW));
                customerObject.setLoginPwQuestion(resultSet.getInt(FIELD_LOGIN_PW_QUESTION));
                customerObject.setLoginPwAnswer(resultSet.getString(FIELD_LOGIN_PW_ANSWER));
                customerObject.setFirstName(resultSet.getString(FIELD_FIRST_NAME));
                customerObject.setLastName(resultSet.getString(FIELD_LAST_NAME));
                customerObject.setEmailAddress(resultSet.getString(FIELD_EMAIL_ADDRESS));
                customerObject.setPhoneCountryPfx(resultSet.getString(FIELD_PHONE_COUNTRY_PFX));
                customerObject.setPhoneLineNumber(resultSet.getString(FIELD_PHONE_LINE_NUMBER));
                customerObject.setPhoneExtension(resultSet.getString(FIELD_PHONE_EXTENSION));
                customerObject.setMailingAddressId(resultSet.getInt(FIELD_MAILING_ADDRESS_ID));
                //customerObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //customerObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return customerObject;
    }

    public ArrayList<CustomerObject> readCustomers()
            throws Exception
    {
        ArrayList<CustomerObject> customers = new ArrayList<CustomerObject>();
        CustomerObject customerObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_CUSTOMER_ID + ","
                                         + FIELD_LOGIN_ID + ","
                                         + FIELD_LOGIN_PW + ","
                                         + FIELD_LOGIN_PW_QUESTION + ","
                                         + FIELD_LOGIN_PW_ANSWER + ","
                                         + FIELD_FIRST_NAME + ","
                                         + FIELD_LAST_NAME + ","
                                         + FIELD_EMAIL_ADDRESS + ","
                                         + FIELD_PHONE_COUNTRY_PFX + ","
                                         + FIELD_PHONE_LINE_NUMBER + ","
                                         + FIELD_PHONE_EXTENSION + ","
                                         + FIELD_MAILING_ADDRESS_ID + ","
                                         + FIELD_LAST_MOD_TS + ","
                                         + FIELD_LAST_MOD_USER + " "
                               + "FROM " + TABLE_CUSTOMER;
            preparedStatement = connect.prepareStatement(sqlString);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customerObject = new CustomerObject();
                customerObject.setCustomerId(resultSet.getInt(FIELD_CUSTOMER_ID));
                customerObject.setLoginId(resultSet.getString(FIELD_LOGIN_ID));
                customerObject.setLoginPw(resultSet.getString(FIELD_LOGIN_PW));
                customerObject.setLoginPwQuestion(resultSet.getInt(FIELD_LOGIN_PW_QUESTION));
                customerObject.setLoginPwAnswer(resultSet.getString(FIELD_LOGIN_PW_ANSWER));
                customerObject.setFirstName(resultSet.getString(FIELD_FIRST_NAME));
                customerObject.setLastName(resultSet.getString(FIELD_LAST_NAME));
                customerObject.setEmailAddress(resultSet.getString(FIELD_EMAIL_ADDRESS));
                customerObject.setPhoneCountryPfx(resultSet.getString(FIELD_PHONE_COUNTRY_PFX));
                customerObject.setPhoneLineNumber(resultSet.getString(FIELD_PHONE_LINE_NUMBER));
                customerObject.setPhoneExtension(resultSet.getString(FIELD_PHONE_EXTENSION));
                customerObject.setMailingAddressId(resultSet.getInt(FIELD_MAILING_ADDRESS_ID));
                //customerObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //customerObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));

                customers.add(customerObject);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return customers;
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
