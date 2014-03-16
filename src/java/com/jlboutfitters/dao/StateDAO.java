/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.jlboutfitters.object.StateObject;
import com.jlboutfitters.object.DBObject;
import java.util.ArrayList;

/**
 *
 * @author JamesHarte
 */
public class StateDAO {
    final static String TABLE_STATE = "STATE";

    final static String FIELD_STATE_ID = "STATE_ID";
    final static String FIELD_STATE_CODE = "STATE_CODE";
    final static String FIELD_STATE_NAME = "STATE_NAME";
    final static String FIELD_STATE_TAX_IND = "STATE_TAX_IND";
    final static String FIELD_LAST_MOD_TS = "LAST_MOD_TS";
    final static String FIELD_LAST_MOD_USER = "LAST_MOD_USER";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public StateObject readState(int id)
            throws Exception
    {
        StateObject stateObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_STATE_ID + ","
                                         + FIELD_STATE_CODE + ","
                                         + FIELD_STATE_NAME + ","
                                         + FIELD_STATE_TAX_IND + " "
                               + "FROM " + TABLE_STATE + " "
                              + "WHERE " + FIELD_STATE_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stateObject = new StateObject();
                stateObject.setStateId(resultSet.getInt(FIELD_STATE_ID));
                stateObject.setStateCode(resultSet.getString(FIELD_STATE_CODE));
                stateObject.setStateName(resultSet.getString(FIELD_STATE_NAME));
                stateObject.setStateTaxInd(resultSet.getString(FIELD_STATE_TAX_IND));
                //stateObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //stateObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return stateObject;
    }

    public ArrayList<StateObject> readStates()
            throws Exception
    {
        ArrayList<StateObject> states = new ArrayList<StateObject>();
        StateObject stateObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_STATE_ID + ","
                                         + FIELD_STATE_CODE + ","
                                         + FIELD_STATE_NAME + ","
                                         + FIELD_STATE_TAX_IND + " "
                               + "FROM " + TABLE_STATE;
            preparedStatement = connect.prepareStatement(sqlString);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stateObject = new StateObject();
                stateObject.setStateId(resultSet.getInt(FIELD_STATE_ID));
                stateObject.setStateCode(resultSet.getString(FIELD_STATE_CODE));
                stateObject.setStateName(resultSet.getString(FIELD_STATE_NAME));
                stateObject.setStateTaxInd(resultSet.getString(FIELD_STATE_TAX_IND));
                //stateObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //stateObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));

                states.add(stateObject);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return states;
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
