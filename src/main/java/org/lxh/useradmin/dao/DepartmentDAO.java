package org.lxh.useradmin.dao;

import org.lxh.useradmin.vo.Department;

/**
 * Created by songqian on 16/10/10.
 */
public interface DepartmentDAO {

  boolean doCreate(Department department) throws Exception;

  boolean doDelete(int id) throws Exception;

  boolean doUpdate(Department department) throws Exception;

  Department findById(int id) throws Exception;
}
