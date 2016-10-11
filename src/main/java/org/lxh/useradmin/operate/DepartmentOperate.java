package org.lxh.useradmin.operate;

import org.lxh.useradmin.factory.DAOFactoryDepartment;
import org.lxh.useradmin.util.InputData;
import org.lxh.useradmin.vo.Department;

/**
 * Created by songqian on 16/10/10.
 */
public class DepartmentOperate {
  public static void insert(){
    Department department =new Department();
    InputData inputData =new InputData();
    department.setName(inputData.getString("请输入部门名称"));
     try{
       DAOFactoryDepartment.getDepartInstance().doCreate(department);
     } catch (Exception e) {
       e.printStackTrace();
     }
  }
  public static void delete(){
    InputData inputData =new InputData();
    int id = inputData.getInt("请输入数字","必须是数字");
    try{
      DAOFactoryDepartment.getDepartInstance().doDelete(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void update(){
    InputData inputData =new InputData();
    int id =inputData.getInt("请输入要更新的ID","必须是数字");
    Department department=null;
    try{
      department=DAOFactoryDepartment.getDepartInstance().findById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if(department!=null){
      department.setName(inputData.getString("输入新的名称，原来的名称是"+department.getName()+"."));
      try{
        DAOFactoryDepartment.getDepartInstance().doUpdate(department);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }else {
      System.out.println("没有找到该用户");
    }
  }



}
