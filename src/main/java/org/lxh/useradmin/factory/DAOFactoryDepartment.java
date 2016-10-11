package org.lxh.useradmin.factory;

import org.lxh.useradmin.dao.DepartmentDAO;
import org.lxh.useradmin.dao.proxy.DepartmentDAOProxy;

/**
 * Created by songqian on 16/10/10.
 */
public class DAOFactoryDepartment {
  public static DepartmentDAO getDepartInstance(){
    return new DepartmentDAOProxy() ;
  }
}
