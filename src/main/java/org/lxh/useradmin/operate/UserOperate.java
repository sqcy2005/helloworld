package org.lxh.useradmin.operate;

import org.lxh.useradmin.util.InputData;
import org.lxh.useradmin.vo.User;

import java.util.Iterator;
import java.util.List;

/**
 * Created by songqian on 16/9/24.
 */
public class UserOperate {
  public static void insert() {
    User user = new User();
    InputData input = new InputData();
    user.setName(input.getString("输入姓名"));
    user.setSex(input.getString("输入性别"));
    user.setBirthday(input.getDate("请输入日期", "请按照格式输入"));
    user.setDepart_id(input.getInt("请输入部门号码","输入数字"));


  }

  public static void delete() {
    InputData input = new InputData();
    int id = input.getInt("请输入删除人的ID", "必须是数字");

  }

  public static void findId() {
    InputData input = new InputData();
    int id = input.getInt("输入数字", "必须是数字啊啊啊");
    User user = null;

    if (user != null) {
      System.out.println(user);
    } else {
      System.out.println("找不到");
    }
  }

  public static void update() {
    InputData input = new InputData();
    int id = input.getInt("输入要修改的学号", "输入正确的学号");
    User user = null;

    if (user != null) {
      user.setName(input.getString("输入新的姓名，原来的姓名是" + user.getName() + "。"));
      user.setSex(input.getString("输入性别，原来的性别" + user.getSex() + "。"));
      user.setBirthday(input.getDate("输入新的日期，原来的是" + user.getBirthday() + "。", "输入错误"));
      user.setDepart_id(input.getInt("以前的部门编号是"+user.getDepart_id()+",","输入错误"));

    } else {
      System.out.print("查找用户不存在");
    }

  }

  public static void findAll() {
    InputData input = new InputData();
    String keyWord = input.getString("输入要查询的关键字");
    List<User> all = null;

    Iterator<User> iter = all.iterator();
    while (iter.hasNext()) {
      User user = iter.next();
      System.out.println(user);
    }

  }

}

