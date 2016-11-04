package org.lxh.useradmin.dao;

import org.jooq.Configuration;
import org.lxh.useradmin.bo.Department;

/**
 * Created by songqian on 16/10/10.
 */
public interface DepartmentDAO {

  boolean doCreate(Department department, Configuration configuration) throws Exception;

  boolean doDelete(int id) throws Exception;

  boolean doUpdate(Department department) throws Exception;

  Department findById(int id) throws Exception;
}
