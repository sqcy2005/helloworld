package org.lxh.useradmin.dao.proxy;

import org.lxh.useradmin.dao.DepartmentDAO;
import org.lxh.useradmin.dao.impl.DepartmentImpl;
import org.lxh.useradmin.dbc.DataBaseConnection;
import org.lxh.useradmin.vo.Department;

/**
 * Created by songqian on 16/10/10.
 */
public class DepartmentDAOProxy implements DepartmentDAO {
  private DataBaseConnection dbc = null;
  private DepartmentDAO dep = null;

  public DepartmentDAOProxy() {
    this.dbc = new DataBaseConnection();
    this.dep = new DepartmentImpl(this.dbc.getConnection());
  }

  public boolean doCreate(Department department) throws Exception {
    boolean flag = true;
    try {
      flag = this.dep.doCreate(department);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.dbc.close();
    }
    return flag;
  }

  public boolean doDelete(int id) throws Exception {
    boolean flag = true;
    try {
      flag = this.dep.doDelete(id);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.dbc.close();
    }
    return flag;
  }

  public boolean doUpdate(Department department) throws Exception {
    boolean flag = true;
    try {
      flag = this.dep.doUpdate(department);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.dbc.close();
    }
    return flag;
  }

  public Department findById(int id) throws Exception {
    Department department =null;
    try{
      department =this.dep.findById(id);
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      this.dbc.close();
    }
    return department;
  }
}
