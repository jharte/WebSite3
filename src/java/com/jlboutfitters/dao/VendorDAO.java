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
import com.jlboutfitters.object.VendorObject;
import java.util.ArrayList;

/**
 *
 * @author JamesHarte
 */
public class VendorDAO {
    final static String TABLE_VENDOR = "VENDOR";

    final static String FIELD_VENDOR_ID = "VENDOR_ID";
    final static String FIELD_VENDOR_CODE = "VENDOR_CODE";
    final static String FIELD_VENDOR_NAME = "VENDOR_NAME";
    final static String FIELD_VENDOR_DESCRIPTION = "VENDOR_DESCRIPTION";
    final static String FIELD_CONTACT_FIRST_NAME = "CONTACT_FIRST_NAME";
    final static String FIELD_CONTACT_LAST_NAME = "CONTACT_LAST_NAME";
    final static String FIELD_CONTACT_PHONE_COUNTRY_PFX = "CONTACT_PHONE_COUNTRY_PFX";
    final static String FIELD_CONTACT_PHONE_LINE_NUMBER = "CONTACT_PHONE_LINE_NUMBER";
    final static String FIELD_CONTACT_PHONE_EXTENSION = "CONTACT_PHONE_EXTENSION";
    final static String FIELD_CONTACT_FAX_COUNTRY_PFX = "CONTACT_FAX_COUNTRY_PFX";
    final static String FIELD_CONTACT_FAX_LINE_NUMBER = "CONTACT_FAX_LINE_NUMBER";
    final static String FIELD_LAST_MOD_TS = "LAST_MOD_TS";
    final static String FIELD_LAST_MOD_USER = "LAST_MOD_USER";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public VendorObject readVendor(int id)
            throws Exception
    {
        VendorObject vendorObject = new VendorObject();

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_VENDOR_ID + ","
                                         + FIELD_VENDOR_CODE + ","
                                         + FIELD_VENDOR_NAME + ","
                                         + FIELD_VENDOR_DESCRIPTION + ","
                                         + FIELD_CONTACT_FIRST_NAME + ","
                                         + FIELD_CONTACT_LAST_NAME + ","
                                         + FIELD_CONTACT_PHONE_COUNTRY_PFX + ","
                                         + FIELD_CONTACT_PHONE_LINE_NUMBER + ","
                                         + FIELD_CONTACT_PHONE_EXTENSION + ","
                                         //+ FIELD_CONTACT_FAX_COUNTRY_PFX + ","
                                         //+ FIELD_CONTACT_FAX_LINE_NUMBER + ","
                                         + FIELD_LAST_MOD_TS + ","
                                         + FIELD_LAST_MOD_USER + " "
                               + "FROM " + TABLE_VENDOR + " "
                              + "WHERE " + FIELD_VENDOR_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vendorObject = new VendorObject();
                vendorObject.setVendorId(resultSet.getInt(FIELD_VENDOR_ID));
                vendorObject.setVendorCode(resultSet.getString(FIELD_VENDOR_CODE));
                vendorObject.setVendorName(resultSet.getString(FIELD_VENDOR_NAME));
                vendorObject.setVendorDescription(resultSet.getString(FIELD_VENDOR_DESCRIPTION));
                vendorObject.setContactFirstName(resultSet.getString(FIELD_CONTACT_FIRST_NAME));
                vendorObject.setContactLastName(resultSet.getString(FIELD_CONTACT_LAST_NAME));
                vendorObject.setContactPhoneCountryPfx(resultSet.getString(FIELD_CONTACT_PHONE_COUNTRY_PFX));
                vendorObject.setContactPhoneLineNumber(resultSet.getString(FIELD_CONTACT_PHONE_LINE_NUMBER));
                vendorObject.setContactPhoneExtension(resultSet.getString(FIELD_CONTACT_PHONE_EXTENSION));
                //vendorObject.setContactFaxCountryPfx(resultSet.getString(FIELD_CONTACT_FAX_COUNTRY_PFX));
                //vendorObject.setContactFaxLineNumber(resultSet.getString(FIELD_CONTACT_FAX_LINE_NUMBER));
                //vendorObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //vendorObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return vendorObject;
    }

    public ArrayList<VendorObject> readVendors()
            throws Exception
    {
        ArrayList<VendorObject> vendors = new ArrayList<VendorObject>();
        VendorObject vendorObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_VENDOR_ID + ","
                                         + FIELD_VENDOR_CODE + ","
                                         + FIELD_VENDOR_NAME + ","
                                         + FIELD_VENDOR_DESCRIPTION + ","
                                         + FIELD_CONTACT_FIRST_NAME + ","
                                         + FIELD_CONTACT_LAST_NAME + ","
                                         + FIELD_CONTACT_PHONE_COUNTRY_PFX + ","
                                         + FIELD_CONTACT_PHONE_LINE_NUMBER + ","
                                         + FIELD_CONTACT_PHONE_EXTENSION + ","
                                         //+ FIELD_CONTACT_FAX_COUNTRY_PFX + ","
                                         //+ FIELD_CONTACT_FAX_LINE_NUMBER + ","
                                         + FIELD_LAST_MOD_TS + ","
                                         + FIELD_LAST_MOD_USER + " "
                               + "FROM " + TABLE_VENDOR;
            preparedStatement = connect.prepareStatement(sqlString);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vendorObject = new VendorObject();
                vendorObject.setVendorId(resultSet.getInt(FIELD_VENDOR_ID));
                vendorObject.setVendorCode(resultSet.getString(FIELD_VENDOR_CODE));
                vendorObject.setVendorName(resultSet.getString(FIELD_VENDOR_NAME));
                vendorObject.setVendorDescription(resultSet.getString(FIELD_VENDOR_DESCRIPTION));
                vendorObject.setContactFirstName(resultSet.getString(FIELD_CONTACT_FIRST_NAME));
                vendorObject.setContactLastName(resultSet.getString(FIELD_CONTACT_LAST_NAME));
                vendorObject.setContactPhoneCountryPfx(resultSet.getString(FIELD_CONTACT_PHONE_COUNTRY_PFX));
                vendorObject.setContactPhoneLineNumber(resultSet.getString(FIELD_CONTACT_PHONE_LINE_NUMBER));
                vendorObject.setContactPhoneExtension(resultSet.getString(FIELD_CONTACT_PHONE_EXTENSION));
                //vendorObject.setContactFaxCountryPfx(resultSet.getString(FIELD_CONTACT_FAX_COUNTRY_PFX));
                //vendorObject.setContactFaxLineNumber(resultSet.getString(FIELD_CONTACT_FAX_LINE_NUMBER));
                //vendorObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //vendorObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));

                vendors.add(vendorObject);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return vendors;
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
