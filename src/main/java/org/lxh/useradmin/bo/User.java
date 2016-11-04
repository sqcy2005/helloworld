package org.lxh.useradmin.bo;

import java.util.Date;

/**
 * Created by songqian on 16/9/24.
 */
public class User {
  private int id;
  private String name;
  private String sex;
  private Date birthday;
  private int depart_id;

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

  public int getDepart_id() {
    return depart_id;
  }

  public void setDepart_id(int depart_id) {
    this.depart_id = depart_id;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", sex='" + sex + '\'' +
      ", birthday=" + birthday +
      ", depart_id=" + depart_id +
      '}';
  }
}
