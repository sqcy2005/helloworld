package org.lxh.useradmin.factory;

import org.lxh.useradmin.dao.IUserDAO;
import org.lxh.useradmin.dao.proxy.IUserDAOProxy;

/**
 * Created by songqian on 16/9/24.
 */
public class DAOFactory {

  public static IUserDAO getIUserInstance() {

    return new IUserDAOProxy();
  }
}
