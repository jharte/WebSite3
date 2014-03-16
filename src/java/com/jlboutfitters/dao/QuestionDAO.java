/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.jlboutfitters.object.QuestionObject;
import com.jlboutfitters.object.DBObject;
import java.util.ArrayList;

/**
 *
 * @author JamesHarte
 */
public class QuestionDAO {
    final static String TABLE_QUESTION = "QUESTION";

    final static String FIELD_QUESTION_ID = "QUESTION_ID";
    final static String FIELD_QUESTION_TEXT = "QUESTION_TEXT";
    final static String FIELD_LAST_MOD_TS = "LAST_MOD_TS";
    final static String FIELD_LAST_MOD_USER = "LAST_MOD_USER";

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public QuestionObject readQuestion(int id)
            throws Exception
    {
        QuestionObject questionObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_QUESTION_ID + ","
                                         + FIELD_QUESTION_TEXT + " "
                               + "FROM " + TABLE_QUESTION + " "
                              + "WHERE " + FIELD_QUESTION_ID + "=?";
            preparedStatement = connect.prepareStatement(sqlString);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                questionObject = new QuestionObject();
                questionObject.setQuestionId(resultSet.getInt(FIELD_QUESTION_ID));
                questionObject.setQuestionText(resultSet.getString(FIELD_QUESTION_TEXT));
                //questionObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //questionObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return questionObject;
    }

    public ArrayList<QuestionObject> readQuestions()
            throws Exception
    {
        ArrayList<QuestionObject> questions = new ArrayList<QuestionObject>();
        QuestionObject questionObject = null;

        try
        {
            // Statements allow to issue SQL queries to the database
            DBObject dbObject = new DBObject();
            connect = dbObject.getConnection();
            statement = connect.createStatement();

            // Set up the SQL statement
            String sqlString = "SELECT " + FIELD_QUESTION_ID + ","
                                         + FIELD_QUESTION_TEXT + " "
                               + "FROM " + TABLE_QUESTION;
            preparedStatement = connect.prepareStatement(sqlString);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                questionObject = new QuestionObject();
                questionObject.setQuestionId(resultSet.getInt(FIELD_QUESTION_ID));
                questionObject.setQuestionText(resultSet.getString(FIELD_QUESTION_TEXT));
                //questionObject.setLastModTs(resultSet.getTimestamp(FIELD_LAST_MOD_TS));
                //questionObject.setLastModUser(resultSet.getString(FIELD_LAST_MOD_USER));

                questions.add(questionObject);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

        return questions;
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
