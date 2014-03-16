/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.jlboutfitters.object.CategoryObject;
import com.jlboutfitters.object.DBObject;
import java.util.ArrayList;

/**
 *
 * @author JamesHarte
 */
public class CategoryDAO {
    final static String TABLE_CATEGORY = "CATEGORY";

    final static String FIELD_CATEGORY_ID = "CATEGORY_ID";
    final static String FIELD_CATEGORY_CODE = "CATEGORY_CODE";
    final static String FIELD_CATEGORY_NAME = "CATEGORY_NAME";
    final static String FIELD_LAST_MOD_TS = "LAST_MOD_TS";
    final static String FIELD_LAST_MOD_USER = "LAST_MOD_USER";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public CategoryObject readCategory(int id)
            throws Exception
    {
        CategoryObject categoryObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL categoryment
            String sqlString = "SELECT " + FIELD_CATEGORY_ID + ","
                                         + FIELD_CATEGORY_CODE + ","
                                         + FIELD_CATEGORY_NAME + " "
                               + "FROM " + TABLE_CATEGORY + " "
                              + "WHERE " + FIELD_CATEGORY_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categoryObject = new CategoryObject();
                categoryObject.setCategoryId(resultSet.getInt(FIELD_CATEGORY_ID));
                categoryObject.setCategoryCode(resultSet.getString(FIELD_CATEGORY_CODE));
                categoryObject.setCategoryName(resultSet.getString(FIELD_CATEGORY_NAME));
                //categoryObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //categoryObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return categoryObject;
    }

    public ArrayList<CategoryObject> readCategories()
            throws Exception
    {
        ArrayList<CategoryObject> categories = new ArrayList<CategoryObject>();
        CategoryObject categoryObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_CATEGORY_ID + ","
                                         + FIELD_CATEGORY_CODE + ","
                                         + FIELD_CATEGORY_NAME + " "
                               + "FROM " + TABLE_CATEGORY;
            preparedStatement = connect.prepareStatement(sqlString);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categoryObject = new CategoryObject();
                categoryObject.setCategoryId(resultSet.getInt(FIELD_CATEGORY_ID));
                categoryObject.setCategoryCode(resultSet.getString(FIELD_CATEGORY_CODE));
                categoryObject.setCategoryName(resultSet.getString(FIELD_CATEGORY_NAME));
                //categoryObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //categoryObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));

                categories.add(categoryObject);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return categories;
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
