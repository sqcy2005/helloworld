package org.lxh.useradmin.service.impl;

import org.jooq.DSLContext;
import org.lxh.useradmin.bo.Department;
import org.lxh.useradmin.bo.User;
import org.lxh.useradmin.dao.DepartmentDAO;
import org.lxh.useradmin.dao.IUserDAO;
import org.lxh.useradmin.service.SomeService;

import javax.inject.Inject;

/**
 * Created by songqian on 16/11/2.
 */
public class SomeServiceImpl implements SomeService {
  //
//  private DSLContext jooq;
//  private IUserDAO userDAO;
//  private DepartmentDAO departmentDAO;
//
  private DSLContext jooq;
  private IUserDAO userDAO;
  private DepartmentDAO departmentDAO;


//
//  @Inject
//  public SomeServiceImpl(DSLContext jooq, IUserDAO userDAO, DepartmentDAO departmentDAO) {
//    this.jooq = jooq;
//    this.userDAO = userDAO;
//    this.departmentDAO = departmentDAO;
//  }

  @Inject
  public SomeServiceImpl(DSLContext jooq, IUserDAO userDAO, DepartmentDAO departmentDAO) {
    this.jooq = jooq;
    this.userDAO = userDAO;
    this.departmentDAO = departmentDAO;
  }
//
//  @Override
//  public boolean addUserAndDepartment(User user, Department department) {
//    return jooq.transactionResult(configuration -> {
//      boolean userCreateResult = userDAO.doCreate(user, configuration);
//      boolean departCreateResult = departmentDAO.doCreate(department, configuration);
//      if (userCreateResult && departCreateResult) {
//        return true;
//      } else {
//        //通过抛出异常，实现回滚
//        throw new RuntimeException("create failed.");
//      }
//    });
//  }
  public boolean addUserAndDepartment(User user, Department department) {
    return jooq.transactionResult(configuration -> {
      boolean userCreateResult = userDAO.doCreate(user, configuration);
      boolean departCreateResult = departmentDAO.doCreate(department, configuration);
      if (userCreateResult && departCreateResult) {
        return true;
      } else {
        throw new RuntimeException("create failed");
      }
    });
  }

  public boolean addUser(User user) {
    return jooq.transactionResult(configuration -> {
      boolean userCreateResult = userDAO.doCreate(user, configuration);
      if (userCreateResult) {
        return true;
      } else {
        throw new RuntimeException("create failed");
      }
    });
  }

  public boolean addDepartment(Department department) {

    return jooq.transactionResult(configuration -> {
      boolean departmentCreateResult = departmentDAO.doCreate(department, configuration);
      if (departmentCreateResult) {
        return true;
      } else {
        throw new RuntimeException("create failed");
      }
    });
  }


  public boolean updateUser(User user) {

    return jooq.transactionResult(configuration -> {
      boolean userUpdateResult = userDAO.doUpdate(user, configuration);
      if (userUpdateResult) {
        return true;
      } else {
        throw new RuntimeException("update failed");
      }
    });
  }
}
