package org.lxh.useradmin.dao;

import org.jooq.Configuration;
import org.lxh.useradmin.bo.User;

import java.util.*;


public interface IUserDAO {

  boolean doCreate(User user, Configuration configuration) throws Exception;

  boolean doUpdate(User user, Configuration configuration) throws Exception;

  boolean doDelete(int id, Configuration configuration) throws Exception;

  User findById(int id) throws Exception;

  List<User> findAll(String keyWord) throws Exception;

}
