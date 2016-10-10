package org.lxh.useradmin.menu;

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

  public void show() {
    System.out.println("系统");
    System.out.println("1,增加");
    System.out.println("2，修改");
    System.out.println("3，删除");
    System.out.println("4，查询单个");
    System.out.println("5，查询全部系统");
    System.out.println("6，退出系统");
    InputData input = new InputData();
    int ch = input.getInt("选择数字", "输入正确的选择");
    switch (ch) {
      default: {
        System.out.println("再来一次吧");
        break;
      }
      case 1: {
        UserOperate.insert();
        break;
      }
      case 2: {
        UserOperate.delete();
        break;
      }
      case 3: {
        UserOperate.findId();
        break;
      }
      case 4: {
        UserOperate.update();
        break;
      }
      case 5: {
        UserOperate.findAll();
      }
      case 6: {
        System.exit(1);
        break;
      }
    }
  }

  public static void main(String[] args) {
    Menu menu =new Menu();
  }
}
