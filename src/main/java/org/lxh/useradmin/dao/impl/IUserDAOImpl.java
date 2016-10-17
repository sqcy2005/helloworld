package org.lxh.useradmin.dao.impl;

import org.lxh.useradmin.dao.IUserDAO;
import org.lxh.useradmin.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by songqian on 16/9/24.
 */
public class IUserDAOImpl implements IUserDAO {

  private Connection conn = null;

  public IUserDAOImpl(Connection conn) {
    this.conn = conn;
  }

  public boolean doCreate(User user) throws Exception {
    boolean flag = false;
    PreparedStatement pstmt = null;
    String sql = "INSERT INTO user(name ,sex ,birthday,depart_id) VALUES (?,?,?,?)";
    try {
      pstmt = this.conn.prepareStatement(sql);
      pstmt.setString(1, user.getName());
      pstmt.setString(2, user.getSex());
      pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
      pstmt.setInt(4,user.getDepart_id());
      if (pstmt.executeUpdate() > 0) {
        flag = true;
      }
    } catch (Exception e) {
      throw e;
    } finally {
      if (pstmt != null) {
        pstmt.close();
      }
    }
    return flag;
  }

  public boolean doDelete(int id) throws Exception {
    boolean flag = false;
    PreparedStatement pstmt = null;
    String sql = "DELETE FROM user WHERE id =?";
    try {
      pstmt = this.conn.prepareStatement(sql);
      pstmt.setInt(1, id);
      if (pstmt.executeUpdate() > 0) {
        flag = true;
      }
    } catch (Exception e) {
      throw e;
    } finally {
      if (pstmt != null) {
        pstmt.close();
      }
    }
    return flag;
  }

  public User findById(int id) throws Exception {
    User user = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT * FROM user where id =?";
    try {
      pstmt = this.conn.prepareStatement(sql);
      pstmt.setInt(1, id);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        user = new User();
        user.setId(rs.getInt(1));
        user.setName(rs.getString(2));
        user.setSex(rs.getString(3));
        user.setBirthday(rs.getDate(4));
        user.setDepart_id(rs.getInt(5));
      }
      rs.close();
    } catch (Exception e) {
      throw e;
    } finally {
      if (pstmt != null) {
        pstmt.close();
      }
    }
    return user;
  }

  public boolean doUpdate(User user) throws Exception {
    PreparedStatement pstmt = null;
    boolean flag = false;
    String sql = "UPDATE user SET name=? ,sex=? ,birthday=? ,depart_id=? where id =?";
    try {
      pstmt = this.conn.prepareStatement(sql);
      pstmt.setString(1, user.getName());
      pstmt.setString(2, user.getSex());
      pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
      pstmt.setInt(4,user.getDepart_id());
      pstmt.setInt(5, user.getId());
      if (pstmt.executeUpdate() > 0) {
        flag = true;
      }
    } catch (Exception e) {
      throw e;
    } finally {
      if (pstmt != null) {
        pstmt.close();
      }
    }
    return flag;
  }

  public List<User> findAll(String keyWord) throws Exception {
    List<User> all = new ArrayList<>();
    PreparedStatement pstmt = null;
    String sql = "SELECT * FROM user WHERE name=? or sex=? or birthday=?";
    try {
      pstmt = this.conn.prepareStatement(sql);
      pstmt.setString(1, "%" + keyWord + "%");
      pstmt.setString(2, "%" + keyWord + "%");
      pstmt.setString(3, "%" + keyWord + "%");
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        User user = new User();
        user.setId(rs.getInt(1));
        user.setName(rs.getString(2));
        user.setSex(rs.getString(3));
        user.setBirthday(rs.getDate(4));
        user.setDepart_id(rs.getInt(5));
        all.add(user);
      }
      rs.close();
    } catch (Exception e) {
      throw e;
    }
    return all;
  }


}
