/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlboutfitters.object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JamesHarte
 */
public class DBObject {

//}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.jlboutfitters.utility;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Date;

/**
 *
 * @author JamesHarte
 */
//public class DBConnect {
  private Connection connect = null;
  private Statement statement = null;
  //private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
  private String driver = "com.mysql.jdbc.Driver";
  private String url = "jdbc:mysql://localhost";
  private String portDelimiter = ":";
  private String port = "3306";
  private String urlDelimiter = "/";
  private String dbName = "JLBOutfittersDB";
  private String username = "root";
  private String password = "";

  public DBObject()
  {
    //this(url + portDelimiter + port + urlDelimiter + dbName, username, password);
    //logger = Logger.getLogger();
    try{
      Class.forName(driver);

      //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      connect = DriverManager.getConnection(url + portDelimiter + port + urlDelimiter + dbName, username, password);
    }
    catch(SQLException sqle)
    {
      System.err.println( "SQLException in DbObject-DbObject: " + sqle);
    }
    catch(Exception e)
    {
      System.err.println( "Exception in DbObject-DbObject: " + e);
    }
  }

  /**
   * Constructor Method
   *
   * @param connectionString Database connection string
   * @param userName - Oracle User Name which is retrieved from the server configuration file
   * @param password - Password for the specified user name, which is retrieved from the server configuration file
   */
  public DBObject(String connectString, String username, String password)
  {
    //logger = Logger.getLogger();
    try{
      //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      connect = DriverManager.getConnection(connectString, username, password);
    }
    catch(SQLException sqle)
    {
      System.err.println( "SQLException in DbObject-DbObject: " + sqle);
    }
    catch(Exception e)
    {
      System.err.println( "Exception in DbObject-DbObject: " + e);
    }
  }

  public Connection getConnection() throws Exception {
    return connect;
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