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
import com.jlboutfitters.object.EmployeeObject;
import java.util.ArrayList;

/**
 *
 * @author JamesHarte
 */
public class EmployeeDAO {
    final static String TABLE_EMPLOYEE = "EMPLOYEE";

    final static String FIELD_EMPLOYEE_ID = "EMPLOYEE_ID";
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
    final static String FIELD_MANAGER_IND = "MANAGER_IND";
    final static String FIELD_LAST_MOD_TS = "LAST_MOD_TS";
    final static String FIELD_LAST_MOD_USER = "LAST_MOD_USER";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public EmployeeObject readEmployee(int id)
            throws Exception
    {
        EmployeeObject employeeObject = new EmployeeObject();

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_EMPLOYEE_ID + ","
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
                                         + FIELD_MANAGER_IND + ","
                                         + FIELD_LAST_MOD_TS + ","
                                         + FIELD_LAST_MOD_USER + " "
                               + "FROM " + TABLE_EMPLOYEE + " "
                              + "WHERE " + FIELD_EMPLOYEE_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeeObject = new EmployeeObject();
                employeeObject.setEmployeeId(resultSet.getInt(FIELD_EMPLOYEE_ID));
                employeeObject.setLoginId(resultSet.getString(FIELD_LOGIN_ID));
                employeeObject.setLoginPw(resultSet.getString(FIELD_LOGIN_PW));
                employeeObject.setLoginPwQuestion(resultSet.getInt(FIELD_LOGIN_PW_QUESTION));
                employeeObject.setLoginPwAnswer(resultSet.getString(FIELD_LOGIN_PW_ANSWER));
                employeeObject.setFirstName(resultSet.getString(FIELD_FIRST_NAME));
                employeeObject.setLastName(resultSet.getString(FIELD_LAST_NAME));
                employeeObject.setEmailAddress(resultSet.getString(FIELD_EMAIL_ADDRESS));
                employeeObject.setPhoneCountryPfx(resultSet.getString(FIELD_PHONE_COUNTRY_PFX));
                employeeObject.setPhoneLineNumber(resultSet.getString(FIELD_PHONE_LINE_NUMBER));
                employeeObject.setPhoneExtension(resultSet.getString(FIELD_PHONE_EXTENSION));
                employeeObject.setManagerInd(resultSet.getString(FIELD_MANAGER_IND));
                //employeeObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //employeeObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return employeeObject;
    }

    public ArrayList<EmployeeObject> readEmployees()
            throws Exception
    {
        ArrayList<EmployeeObject> employees = new ArrayList<EmployeeObject>();
        EmployeeObject employeeObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_EMPLOYEE_ID + ","
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
                                         + FIELD_MANAGER_IND + ","
                                         + FIELD_LAST_MOD_TS + ","
                                         + FIELD_LAST_MOD_USER + " "
                               + "FROM " + TABLE_EMPLOYEE;
            preparedStatement = connect.prepareStatement(sqlString);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employeeObject = new EmployeeObject();
                employeeObject.setEmployeeId(resultSet.getInt(FIELD_EMPLOYEE_ID));
                employeeObject.setLoginId(resultSet.getString(FIELD_LOGIN_ID));
                employeeObject.setLoginPw(resultSet.getString(FIELD_LOGIN_PW));
                employeeObject.setLoginPwQuestion(resultSet.getInt(FIELD_LOGIN_PW_QUESTION));
                employeeObject.setLoginPwAnswer(resultSet.getString(FIELD_LOGIN_PW_ANSWER));
                employeeObject.setFirstName(resultSet.getString(FIELD_FIRST_NAME));
                employeeObject.setLastName(resultSet.getString(FIELD_LAST_NAME));
                employeeObject.setEmailAddress(resultSet.getString(FIELD_EMAIL_ADDRESS));
                employeeObject.setPhoneCountryPfx(resultSet.getString(FIELD_PHONE_COUNTRY_PFX));
                employeeObject.setPhoneLineNumber(resultSet.getString(FIELD_PHONE_LINE_NUMBER));
                employeeObject.setPhoneExtension(resultSet.getString(FIELD_PHONE_EXTENSION));
                employeeObject.setManagerInd(resultSet.getString(FIELD_MANAGER_IND));
                //employeeObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //employeeObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));

                employees.add(employeeObject);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return employees;
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
