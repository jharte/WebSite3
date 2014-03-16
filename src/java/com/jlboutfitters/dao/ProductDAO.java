/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.jlboutfitters.object.ProductObject;
import com.jlboutfitters.object.DBObject;
import java.util.ArrayList;

/**
 *
 * @author JamesHarte
 */
public class ProductDAO {
    final static String TABLE_PRODUCT = "PRODUCT";

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

    public ProductObject readProduct(int id)
            throws Exception
    {
        ProductObject productObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL productment
            String sqlString = "SELECT " + FIELD_PRODUCT_ID + ","
                                         + FIELD_PRODUCT_CODE + ","
                                         + FIELD_PRODUCT_NAME + ","
                                         + FIELD_PRODUCT_DESCRIPTION + ","
                                         + FIELD_PRICE + ","
                                         + FIELD_VENDOR_ID + ","
                                         + FIELD_CATEGORY_ID + " "
                               + "FROM " + TABLE_PRODUCT + " "
                              + "WHERE " + FIELD_PRODUCT_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productObject = new ProductObject();
                productObject.setProductId(resultSet.getInt(FIELD_PRODUCT_ID));
                productObject.setProductCode(resultSet.getString(FIELD_PRODUCT_CODE));
                productObject.setProductName(resultSet.getString(FIELD_PRODUCT_NAME));
                productObject.setProductDescription(resultSet.getString(FIELD_PRODUCT_DESCRIPTION));
                productObject.setPrice(resultSet.getDouble(FIELD_PRICE));
                productObject.setVendorId(resultSet.getInt(FIELD_VENDOR_ID));
                productObject.setCategoryId(resultSet.getInt(FIELD_CATEGORY_ID));
                //productObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //productObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return productObject;
    }

    public ArrayList<ProductObject> readProducts()
            throws Exception
    {
        ArrayList<ProductObject> products = new ArrayList<ProductObject>();
        ProductObject productObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL productment
            String sqlString = "SELECT " + FIELD_PRODUCT_ID + ","
                                         + FIELD_PRODUCT_CODE + ","
                                         + FIELD_PRODUCT_NAME + ","
                                         + FIELD_PRODUCT_DESCRIPTION + ","
                                         + FIELD_PRICE + ","
                                         + FIELD_VENDOR_ID + ","
                                         + FIELD_CATEGORY_ID + " "
                               + "FROM " + TABLE_PRODUCT + " "
                              + "WHERE " + FIELD_PRODUCT_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productObject = new ProductObject();
                productObject.setProductId(resultSet.getInt(FIELD_PRODUCT_ID));
                productObject.setProductCode(resultSet.getString(FIELD_PRODUCT_CODE));
                productObject.setProductName(resultSet.getString(FIELD_PRODUCT_NAME));
                productObject.setProductDescription(resultSet.getString(FIELD_PRODUCT_DESCRIPTION));
                productObject.setPrice(resultSet.getDouble(FIELD_PRICE));
                productObject.setVendorId(resultSet.getInt(FIELD_VENDOR_ID));
                productObject.setCategoryId(resultSet.getInt(FIELD_CATEGORY_ID));
                //productObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //productObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));

                products.add(productObject);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return products;
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
