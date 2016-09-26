package org.lxh.useradmin.vo;

import java.util.Date;

/**
 * Created by songqian on 16/9/24.
 */
public class User {
  private int id;
  private String name;
  private String sex;
  private Date birthday;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id + ", name='" + name  + ", sex='" + sex + ", birthday=" + birthday + '}';
  }

}
