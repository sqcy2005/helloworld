package org.lxh.useradmin.dao;

import org.lxh.useradmin.vo.User;

import java.util.*;


public interface IUserDAO {

  boolean doCreate(User user) throws Exception;

  boolean doUpdate(User user) throws Exception;

  boolean doDelete(int id) throws Exception;

  User findById(int id) throws Exception;

  List<User> findAll(String keyWord) throws Exception;

}
