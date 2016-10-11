package org.lxh.useradmin.dao.impl;

import org.lxh.useradmin.dao.DepartmentDAO;
import org.lxh.useradmin.vo.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by songqian on 16/10/10.
 */
public class DepartmentImpl implements DepartmentDAO {
  private Connection conn = null;

  public DepartmentImpl(Connection conn) {
    this.conn = conn;
  }

  public boolean doCreate(Department department) throws SQLException {
    boolean flag = false;
    PreparedStatement pstmt = null;
    String sql = "INSERT INTO department(name) VALUES (?)";
    try {
      pstmt = this.conn.prepareStatement(sql);
      pstmt.setString(1, department.getName());
      if (pstmt.executeUpdate() > 0) {
        flag = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) {
        pstmt.close();
      }
    }
    return flag;
  }

  public boolean doUpdate(Department department) throws SQLException {
    boolean flag = false;
    PreparedStatement pstmt = null;
    String sql = " UPDATE department SET name=? where id =?";
    try {
      pstmt = this.conn.prepareStatement(sql);
      pstmt.setString(1, department.getName());
      pstmt.setInt(2, department.getId());
      if (pstmt.executeUpdate() > 0) {
        flag = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) {
        pstmt.close();
      }
    }
    return flag;
  }

  public boolean doDelete(int id) throws SQLException {
    boolean flag = false;
    PreparedStatement pstmt = null;
    String sql = "DELETE FROM department WHERE id =?";
    try {
      pstmt = this.conn.prepareStatement(sql);
      pstmt.setInt(1, id);
      if (pstmt.executeUpdate() > 0) {
        flag = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) {
        pstmt.close();
      }
    }
    return flag;
  }

  public Department findById(int id) throws SQLException {
    Department department = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM department WHERE id =?";
    try {
      pstmt = this.conn.prepareStatement(sql);
      pstmt.setInt(1, id);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        department = new Department();
        department.setId(rs.getInt(1));
        department.setName(rs.getString(2));
      }
      rs.close();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) {
        pstmt.close();
      }
    }
    return department;
  }


}
