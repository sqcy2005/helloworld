package org.lxh.useradmin.menu;

import org.lxh.useradmin.operate.DepartmentOperate;
import org.lxh.useradmin.operate.UserOperate;
import org.lxh.useradmin.util.InputData;

/**
 * Created by songqian on 16/9/24.
 */
public class Menu {
  public Menu() {

    while (true) {
      this.show();
    }
  }
  public static void show(){
    System.out.println("系统");
    System.out.println("1 用户信息系统");
    System.out.println("2 部门信息系统");
    System.out.println("3 退出系统");
    InputData input =new InputData();
    int ch =input.getInt("选择数字","输入正确的选项");
    switch (ch){
      default:
        System.out.println("再来一次");
        break;
      case 1:UserPage();
        break;
      case 2:DepartmentPage();
        break;
      case 3:
        System.exit(1);
        break;
    }
  }

  public static void UserPage() {
    System.out.println("1，增加");
    System.out.println("2，修改");
    System.out.println("3，删除");
    System.out.println("4，查询单个");
    System.out.println("5，查询全部系统");
    System.out.println("6，返回上层菜单");
    InputData input = new InputData();
    int ch = input.getInt("选择数字", "输入正确的选择");
    switch (ch) {
      default: {
        System.out.println("再来一次吧111");
        break;
      }
      case 1: {
        UserOperate.insert();
        break;
      }
      case 2: {
        UserOperate.update();
        break;
      }
      case 3: {
        UserOperate.delete();
        break;
      }
      case 4: {
        UserOperate.findId();
        break;
      }
      case 5: {
        UserOperate.findAll();
      }
      case 6: {
        show();
        break;
      }
    }
  }
  public  static void DepartmentPage(){
    System.out.println("1,增加部门");
    System.out.println("2,删除部门");
    System.out.println("3,修改部门");
    System.out.println("4,查询部门");
    System.out.println("5,返回上层菜单");
    InputData inputData =new InputData();
    int ch = inputData.getInt("选择数字","输入正确的选项");
    switch (ch){
      default:System.out.println("再来一次吧222");
        break;
      case 1:
        DepartmentOperate.insert();
        break;
      case 2:
        DepartmentOperate.delete();
        break;
      case 3:
        DepartmentOperate.update();

      case 4:
      case 5: show();
        break;

    }

  }

  public static void main(String[] args) {
    Menu menu =new Menu();
  }
}
