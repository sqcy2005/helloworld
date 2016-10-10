package org.lxh.useradmin.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by songqian on 16/9/24.
 */
public class DataBaseConnection {
  private static final String DBDRIVER = "com.mysql.jdbc.Driver";
  private static final String DBURL = "jdbc:mysql://localhost:3306/kostream";
  private static final String DBUSER = "root";
  private static final String DBPASS = "root";
  private Connection conn = null;

  public DataBaseConnection() {
    try {
      Class.forName(DBDRIVER);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
  }

  public Connection getConnection() {
    return this.conn;
  }

  public void close() {
    if (this.conn != null) {
      try {
        this.conn.close();
      } catch (SQLException e2) {
        e2.printStackTrace();
      }
    }
  }
}
