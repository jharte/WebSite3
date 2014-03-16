/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.jlboutfitters.object.AddressObject;
import com.jlboutfitters.object.DBObject;

/**
 *
 * @author JamesHarte
 */
public class AddressDAO {
    final static String TABLE_ADDRESS = "ADDRESS";

    final static String FIELD_ADDRESS_ID = "ADDRESS_ID";
    final static String FIELD_STREET = "ADDRESS_LINE1";
    final static String FIELD_ADDRESS_LINE1 = "ADDRESS_LINE2";
    final static String FIELD_ADDRESS_LINE2 = "ADDRESS_LINE3";
    final static String FIELD_CITY = "CITY";
    final static String FIELD_COUNTY = "COUNTY";
    //TODO  Add Zip Code Column - currently hardcoded to POSTAL_CODE
    final static String FIELD_ZIP_CODE = "POSTAL_CODE";
    final static String FIELD_STATE_ID = "STATE_ID";
    final static String FIELD_POSTAL_CODE = "POSTAL_CODE";
    final static String FIELD_PROVINCE = "PROVINCE";
    final static String FIELD_COUNTRY_ID = "COUNTRY_ID";
    final static String FIELD_LAST_MOD_TS = "LAST_MOD_TS";
    final static String FIELD_LAST_MOD_USER = "LAST_MOD_USER";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public AddressObject readAddress(int id)
            throws Exception
    {
        AddressObject addressObject = null;
        //int addressId = 0;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_ADDRESS_ID + ","
                                         + FIELD_STREET + ","
                                         + FIELD_ADDRESS_LINE1 + ","
                                         + FIELD_ADDRESS_LINE2 + ","
                                         + FIELD_CITY + ","
                                         + FIELD_COUNTY + ","
                                         + FIELD_STATE_ID + ","
                                         + FIELD_ZIP_CODE + ","
                                         + FIELD_POSTAL_CODE + ","
                                         + FIELD_PROVINCE + ","
                                         + FIELD_COUNTRY_ID + ","
                                         + FIELD_LAST_MOD_TS + ","
                                         + FIELD_LAST_MOD_USER + " "
                               + "FROM " + TABLE_ADDRESS + " "
                              + "WHERE " + FIELD_ADDRESS_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                addressObject = new AddressObject();
                addressObject.setAddressId(resultSet.getInt(FIELD_ADDRESS_ID));
                addressObject.setStreet(resultSet.getString(FIELD_STREET));
                addressObject.setAddressLine1(resultSet.getString(FIELD_ADDRESS_LINE1));
                addressObject.setAddressLine2(resultSet.getString(FIELD_ADDRESS_LINE2));
                addressObject.setCity(resultSet.getString(FIELD_CITY));
                addressObject.setCounty(resultSet.getString(FIELD_COUNTY));
                addressObject.setStateId(resultSet.getInt(FIELD_STATE_ID));
                addressObject.setZipCode(resultSet.getString(FIELD_ZIP_CODE));
                addressObject.setPostalCode(resultSet.getString(FIELD_POSTAL_CODE));
                addressObject.setProvince(resultSet.getString(FIELD_PROVINCE));
                addressObject.setCountryId(resultSet.getInt(FIELD_COUNTRY_ID));
                //addressObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //addressObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return addressObject;
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
