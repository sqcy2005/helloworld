package org.lxh.useradmin.dao.impl;

import com.google.inject.Inject;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.RecordMapper;
import org.jooq.impl.DSL;
import org.lxh.useradmin.bo.Department;
import org.lxh.useradmin.dao.DepartmentDAO;
import org.lxh.useradmin.entity.tables.records.DepartmentRecord;

import static org.lxh.useradmin.entity.tables.Department.DEPARTMENT;

/**
 * Created by songqian on 16/10/10.
 */
public class DepartmentImpl implements DepartmentDAO {
  //  private Connection conn = null;
  private DSLContext jooq;

  @Inject
  public DepartmentImpl(DSLContext jooq) {
    this.jooq = jooq;
  }

  private RecordMapper<DepartmentRecord, Department> departmentRecordMapper = departmentRecord -> {
    Department department = null;
    if (departmentRecord != null) {
      department = new Department();
      department.setName(departmentRecord.getName());
      department.setId(departmentRecord.getId());
    }
    return department;
  };

  //
//  public boolean doCreate(Department department) throws SQLException {
//    boolean flag = false;
//    PreparedStatement pstmt = null;
//    String sql = "INSERT INTO department(name) VALUES (?)";
//    try {
//      pstmt = this.conn.prepareStatement(sql);
//      pstmt.setString(1, department.getName());
//      if (pstmt.executeUpdate() > 0) {
//        flag = true;
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//    } finally {
//      if (pstmt != null) {
//        pstmt.close();
//      }
//    }
//    return flag;
//  }
  public boolean doCreate(Department department, Configuration configuration) throws Exception {
    int effectRow = DSL.using(configuration).insertInto(DEPARTMENT)
      .set(DEPARTMENT.ID, department.getId())
      .set(DEPARTMENT.NAME, department.getName())
      .execute();
    return effectRow > 0;
  }

  //
//  public boolean doUpdate(Department department) throws SQLException {
//    boolean flag = false;
//    PreparedStatement pstmt = null;
//    String sql = " UPDATE department SET name=? where id =?";
//    try {
//      pstmt = this.conn.prepareStatement(sql);
//      pstmt.setString(1, department.getName());
//      pstmt.setInt(2, department.getId());
//      if (pstmt.executeUpdate() > 0) {
//        flag = true;
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//    } finally {
//      if (pstmt != null) {
//        pstmt.close();
//      }
//    }
//    return flag;
//  }
//
  public boolean doUpdate(Department department) throws Exception {
    int effectRow = jooq.update(DEPARTMENT)
      .set(DEPARTMENT.NAME, department.getName())
      .where(DEPARTMENT.ID.equal(department.getId()))
      .execute();
    return effectRow > 0;
  }

  //  public boolean doDelete(int id) throws SQLException {
//    boolean flag = false;
//    PreparedStatement pstmt = null;
//    String sql = "DELETE FROM department WHERE id =?";
//    try {
//      pstmt = this.conn.prepareStatement(sql);
//      pstmt.setInt(1, id);
//      if (pstmt.executeUpdate() > 0) {
//        flag = true;
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//    } finally {
//      if (pstmt != null) {
//        pstmt.close();
//      }
//    }
//    return flag;
//  }
  public boolean doDelete(int id) throws Exception {

    return jooq.delete(DEPARTMENT)
      .where(DEPARTMENT.ID.equal(id))
      .execute() > 0;

  }


  //  public Department findById(int id) throws SQLException {
//    Department department = null;
//    PreparedStatement pstmt = null;
//    ResultSet rs = null;
//    String sql = "SELECT * FROM department WHERE id =?";
//    try {
//      pstmt = this.conn.prepareStatement(sql);
//      pstmt.setInt(1, id);
//      rs = pstmt.executeQuery();
//      if (rs.next()) {
//        department = new Department();
//        department.setId(rs.getInt(1));
//        department.setName(rs.getString(2));
//      }
//      rs.close();
//
//    } catch (SQLException e) {
//      e.printStackTrace();
//    } finally {
//      if (pstmt != null) {
//        pstmt.close();
//      }
//    }
//    return department;
//  }
  public Department findById(int id) throws Exception {
    return jooq.selectFrom(DEPARTMENT)
      .where(DEPARTMENT.ID.equal(id))
      .fetchOne(departmentRecordMapper);
  }

}
