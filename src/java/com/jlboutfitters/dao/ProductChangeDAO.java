/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.jlboutfitters.object.ProductChangeObject;
import com.jlboutfitters.object.DBObject;
import java.util.ArrayList;

/**
 *
 * @author JamesHarte
 */
public class ProductChangeDAO {
    final static String TABLE_PRODUCT_CHANGE = "PRODUCT_CHANGE";

    final static String FIELD_PRODUCT_CHANGE_ID = "PRODUCT_CHANGE_ID";
    final static String FIELD_STATUS = "STATUS";
    final static String FIELD_PRODUCT_ID = "PRODUCT_ID";
    final static String FIELD_PRODUCT_CODE = "PRODUCT_CODE";
    final static String FIELD_PRODUCT_NAME = "PRODUCT_NAME";
    final static String FIELD_PRODUCT_DESCRIPTION = "PRODUCT_DESCRIPTION";
    final static String FIELD_PRICE = "PRICE";
    final static String FIELD_VENDOR_ID = "VENDOR_ID";
    final static String FIELD_CATEGORY_ID = "CATEGORY_ID";
    final static String FIELD_LAST_MOD_TS = "LAST_MOD_TS";
    final static String FIELD_LAST_MOD_USER = "LAST_MOD_USER";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public ProductChangeObject readProductChange(int id)
            throws Exception
    {
        ProductChangeObject productChangeObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL productment
            String sqlString = "SELECT " + FIELD_PRODUCT_CHANGE_ID + ","
                                         + FIELD_STATUS + ","
                                         + FIELD_PRODUCT_ID + ","
                                         + FIELD_PRODUCT_CODE + ","
                                         + FIELD_PRODUCT_NAME + ","
                                         + FIELD_PRODUCT_DESCRIPTION + ","
                                         + FIELD_PRICE + ","
                                         + FIELD_VENDOR_ID + ","
                                         + FIELD_CATEGORY_ID + " "
                               + "FROM " + TABLE_PRODUCT_CHANGE + " "
                              + "WHERE " + FIELD_STATUS + "=" + ProductChangeObject.STATUS_PENDING + " "
                                         + FIELD_PRODUCT_CHANGE_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productChangeObject = new ProductChangeObject();
                productChangeObject.setProductChangeId(resultSet.getInt(FIELD_PRODUCT_CHANGE_ID));
                productChangeObject.setStatus(resultSet.getInt(FIELD_STATUS));
                productChangeObject.setProductId(resultSet.getInt(FIELD_PRODUCT_ID));
                productChangeObject.setProductCode(resultSet.getString(FIELD_PRODUCT_CODE));
                productChangeObject.setProductName(resultSet.getString(FIELD_PRODUCT_NAME));
                productChangeObject.setProductDescription(resultSet.getString(FIELD_PRODUCT_DESCRIPTION));
                productChangeObject.setPrice(resultSet.getDouble(FIELD_PRICE));
                productChangeObject.setVendorId(resultSet.getInt(FIELD_VENDOR_ID));
                productChangeObject.setCategoryId(resultSet.getInt(FIELD_CATEGORY_ID));
                //productChangeObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //productChangeObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return productChangeObject;
    }

    public ArrayList<ProductChangeObject> readProductChanges()
            throws Exception
    {
        ArrayList<ProductChangeObject> productChanges = new ArrayList<ProductChangeObject>();
        ProductChangeObject productChangeObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL productment
            String sqlString = "SELECT " + FIELD_PRODUCT_CHANGE_ID + ","
                                         + FIELD_STATUS + ","
                                         + FIELD_PRODUCT_ID + ","
                                         + FIELD_PRODUCT_CODE + ","
                                         + FIELD_PRODUCT_NAME + ","
                                         + FIELD_PRODUCT_DESCRIPTION + ","
                                         + FIELD_PRICE + ","
                                         + FIELD_VENDOR_ID + ","
                                         + FIELD_CATEGORY_ID + " "
                               + "FROM " + TABLE_PRODUCT_CHANGE + " "
                              + "WHERE " + FIELD_STATUS + "=" + ProductChangeObject.STATUS_PENDING;
            //Removed condition
            //                  + "WHERE " + FIELD_PRODUCT_CHANGE_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productChangeObject = new ProductChangeObject();
                productChangeObject.setProductChangeId(resultSet.getInt(FIELD_PRODUCT_CHANGE_ID));
                productChangeObject.setStatus(resultSet.getInt(FIELD_STATUS));
                productChangeObject.setProductId(resultSet.getInt(FIELD_PRODUCT_ID));
                productChangeObject.setProductCode(resultSet.getString(FIELD_PRODUCT_CODE));
                productChangeObject.setProductName(resultSet.getString(FIELD_PRODUCT_NAME));
                productChangeObject.setProductDescription(resultSet.getString(FIELD_PRODUCT_DESCRIPTION));
                productChangeObject.setPrice(resultSet.getDouble(FIELD_PRICE));
                productChangeObject.setVendorId(resultSet.getInt(FIELD_VENDOR_ID));
                productChangeObject.setCategoryId(resultSet.getInt(FIELD_CATEGORY_ID));
                //productChangeObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //productChangeObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));

                productChanges.add(productChangeObject);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return productChanges;
    }

    public boolean alterProductChangeStatus(int id, int status)
            throws Exception
    {
        try {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL productment
            String sqlString = "UPDATE " + TABLE_PRODUCT_CHANGE + " "
                                + "SET " + FIELD_STATUS + "=? "
                              + "WHERE " + FIELD_PRODUCT_CHANGE_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return true;
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
