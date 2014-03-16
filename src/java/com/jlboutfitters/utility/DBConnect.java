/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Date;

/**
 *
 * @author JamesHarte
 */
public class DBConnect {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
  private String driver = "com.mysql.jdbc.Driver";
  private String url = "jdbc:mysql://localhost";
  private String portDelimiter = ":";
  private String port = "3306";
  private String urlDelimiter = "/";
  private String dbName = "JLBOutfittersDB";
  private String username = "root";
  private String password = "";

  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName(driver);

      // Setup the connection with the DB
      connect = DriverManager.getConnection(url + portDelimiter + port + urlDelimiter + dbName, username, password);

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement.executeQuery("SELECT * FROM STATE");
      writeResultSet(resultSet);

      // PreparedStatements can use variables and are more efficient
      //preparedStatement = connect.prepareStatement("insert into  FEEDBACK.COMMENTS values (default, ?, ?, ?, ? , ?, ?)");
      //// "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
      //// Parameters start with 1
      //preparedStatement.setString(1, "Test");
      //preparedStatement.setString(2, "TestEmail");
      //preparedStatement.setString(3, "TestWebpage");
      //preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
      //preparedStatement.setString(5, "TestSummary");
      //preparedStatement.setString(6, "TestComment");
      //preparedStatement.executeUpdate();

      //preparedStatement = connect.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
      //resultSet = preparedStatement.executeQuery();
      //writeResultSet(resultSet);

      // Remove again the insert comment
      //preparedStatement = connect.prepareStatement("delete from FEEDBACK.COMMENTS where myuser= ? ; ");
      //preparedStatement.setString(1, "Test");
      //preparedStatement.executeUpdate();

      resultSet = statement.executeQuery("SELECT * FROM STATE");
      writeMetaData(resultSet);

    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query

    System.out.println("The columns in the table are: ");

    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String code = resultSet.getString("STATE_CODE");
      int id = resultSet.getInt("STATE_ID");
      String name = resultSet.getString("STATE_NAME");
      String taxInd = resultSet.getString("STATE_TAX_IND");
      System.out.println("Code: " + code);
      System.out.println("Id: " + id);
      System.out.println("Name: " + name);
      System.out.println("Tax Ind: " + taxInd);
    }
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