/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.jlboutfitters.object.CompanyObject;
import com.jlboutfitters.object.DBObject;

/**
 *
 * @author JamesHarte
 */
public class CompanyDAO {
    final static String TABLE_COMPANY = "COMPANY";

    final static String FIELD_COMPANY_ID = "COMPANY_ID";
    final static String FIELD_NAME = "NAME";
    final static String FIELD_INFO_EMAIL_ADDRESS = "INFO_EMAIL_ADDRESS";
    final static String FIELD_CUST_SVC_EMAIL_ADDRESS = "CUST_SVC_EMAIL_ADDRESS";
    final static String FIELD_CUST_SVC_PHONE_COUNTRY_PFX = "CUST_SVC_PHONE_COUNTRY_PFX";
    final static String FIELD_CUST_SVC_PHONE_LINE_NUMBER = "CUST_SVC_PHONE_LINE_NUMBER";
    final static String FIELD_CUST_SVC_PHONE_EXTENSION = "CUST_SVC_PHONE_EXTENSION";
    final static String FIELD_CUST_SVC_FAX_COUNTRY_PFX = "CUST_SVC_FAX_COUNTRY_PFX";
    final static String FIELD_CUST_SVC_FAX_LINE_NUMBER = "CUST_SVC_FAX_LINE_NUMBER";
    final static String FIELD_URL_FACEBOOK = "URL_FACEBOOK";
    final static String FIELD_URL_TWITTER = "URL_TWITTER";
    final static String FIELD_URL_LINKEDIN = "URL_LINKEDIN";
    final static String FIELD_URL_YOUTUBE = "URL_YOUTUBE";
    final static String FIELD_URL_GOOGLEPLUS = "URL_GOOGLEPLUS";
    final static String FIELD_ADDRESS_ID = "ADDRESS_ID";
    final static String FIELD_CONTACT_ID = "CONTACT_ID";
    final static String FIELD_LAST_MOD_TS = "LAST_MOD_TS";
    final static String FIELD_LAST_MOD_USER = "LAST_MOD_USER";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public CompanyObject readCompany(int id)
            throws Exception
    {
        CompanyObject companyObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_COMPANY_ID + ","
                                         + FIELD_NAME + ","
                                         + FIELD_INFO_EMAIL_ADDRESS + ","
                                         + FIELD_CUST_SVC_EMAIL_ADDRESS + ","
                                         + FIELD_CUST_SVC_PHONE_COUNTRY_PFX + ","
                                         + FIELD_CUST_SVC_PHONE_LINE_NUMBER + ","
                                         + FIELD_CUST_SVC_PHONE_EXTENSION + ","
                                         + FIELD_CUST_SVC_FAX_COUNTRY_PFX + ","
                                         + FIELD_CUST_SVC_FAX_LINE_NUMBER + ","
                                         + FIELD_URL_FACEBOOK + ","
                                         + FIELD_URL_TWITTER + ","
                                         + FIELD_URL_LINKEDIN + ","
                                         + FIELD_URL_YOUTUBE + ","
                                         + FIELD_URL_GOOGLEPLUS + ","
                                         + FIELD_ADDRESS_ID + ","
                                         + FIELD_CONTACT_ID + ","
                                         + FIELD_LAST_MOD_TS + ","
                                         + FIELD_LAST_MOD_USER + " "
                               + "FROM " + TABLE_COMPANY + " "
                              + "WHERE " + FIELD_COMPANY_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                companyObject = new CompanyObject();
                companyObject.setCompanyId(resultSet.getInt(FIELD_COMPANY_ID));
                companyObject.setName(resultSet.getString(FIELD_NAME));
                companyObject.setInfoEmailAddress(resultSet.getString(FIELD_INFO_EMAIL_ADDRESS));
                companyObject.setCustomerServiceEmailAddress(resultSet.getString(FIELD_CUST_SVC_EMAIL_ADDRESS));
                companyObject.setCustomerServicePhoneCountryPfx(resultSet.getString(FIELD_CUST_SVC_PHONE_COUNTRY_PFX));
                companyObject.setCustomerServicePhoneLineNumber(resultSet.getString(FIELD_CUST_SVC_PHONE_LINE_NUMBER));
                companyObject.setCustomerServicePhoneExtension(resultSet.getString(FIELD_CUST_SVC_PHONE_EXTENSION));
                companyObject.setCustomerServiceFaxCountryPfx(resultSet.getString(FIELD_CUST_SVC_FAX_COUNTRY_PFX));
                companyObject.setCustomerServiceFaxLineNumber(resultSet.getString(FIELD_CUST_SVC_FAX_LINE_NUMBER));
                companyObject.setUrlFacebook(resultSet.getString(FIELD_URL_FACEBOOK));
                companyObject.setUrlTwitter(resultSet.getString(FIELD_URL_TWITTER));
                companyObject.setUrlLinkedIn(resultSet.getString(FIELD_URL_LINKEDIN));
                companyObject.setUrlYouTube(resultSet.getString(FIELD_URL_YOUTUBE));
                companyObject.setUrlGooglePlus(resultSet.getString(FIELD_URL_GOOGLEPLUS));
                companyObject.setAddressId(resultSet.getInt(FIELD_ADDRESS_ID));
                companyObject.setContactId(resultSet.getInt(FIELD_CONTACT_ID));
                //companyObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //companyObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return companyObject;
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
