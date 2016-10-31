package org.lxh.useradmin.operate;

import org.lxh.useradmin.util.InputData;
import org.lxh.useradmin.vo.Department;

/**
 * Created by songqian on 16/10/10.
 */
public class DepartmentOperate {
  public static void insert() {
    Department department = new Department();
    InputData inputData = new InputData();
    department.setName(inputData.getString("请输入部门名称"));

  }

  public static void delete() {
    InputData inputData = new InputData();
    int id = inputData.getInt("请输入数字", "必须是数字");

  }

  public static void update() {
    InputData inputData = new InputData();
    int id = inputData.getInt("请输入要更新的ID", "必须是数字");
    Department department = null;


  }


}
