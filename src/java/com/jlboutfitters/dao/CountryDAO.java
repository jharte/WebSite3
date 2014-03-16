/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.jlboutfitters.object.CountryObject;
import com.jlboutfitters.object.DBObject;
import java.util.ArrayList;

/**
 *
 * @author JamesHarte
 */
public class CountryDAO {
    final static String TABLE_COUNTRY = "COUNTRY";

    final static String FIELD_COUNTRY_ID = "COUNTRY_ID";
    final static String FIELD_COUNTRY_NAME = "COUNTRY_NAME";
    final static String FIELD_LAST_MOD_TS = "LAST_MOD_TS";
    final static String FIELD_LAST_MOD_USER = "LAST_MOD_USER";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public CountryObject readCountry(int id)
            throws Exception
    {
        CountryObject countryObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL countryment
            String sqlString = "SELECT " + FIELD_COUNTRY_ID + ","
                                         + FIELD_COUNTRY_NAME + " "
                               + "FROM " + TABLE_COUNTRY + " "
                              + "WHERE " + FIELD_COUNTRY_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                countryObject = new CountryObject();
                countryObject.setCountryId(resultSet.getInt(FIELD_COUNTRY_ID));
                countryObject.setCountryName(resultSet.getString(FIELD_COUNTRY_NAME));
                //countryObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //countryObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return countryObject;
    }

    public ArrayList<CountryObject> readCountries()
            throws Exception
    {
        ArrayList<CountryObject> countries = new ArrayList<CountryObject>();
        CountryObject countryObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_COUNTRY_ID + ","
                                         + FIELD_COUNTRY_NAME + " "
                               + "FROM " + TABLE_COUNTRY;
            preparedStatement = connect.prepareStatement(sqlString);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                countryObject = new CountryObject();
                countryObject.setCountryId(resultSet.getInt(FIELD_COUNTRY_ID));
                countryObject.setCountryName(resultSet.getString(FIELD_COUNTRY_NAME));
                //countryObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //countryObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));

                countries.add(countryObject);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return countries;
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
