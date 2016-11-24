package org.lxh.useradmin.bo;

import java.util.Date;

/**
 * Created by songqian on 16/11/24.
 */
public class User1 {

  private final int id;
  private final String name;
  private final String sex;
  private final Date birthday;
  private final int departId;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSex() {
    return sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public int getDepartId() {
    return departId;
  }

  @Override
  public String toString() {
    return "User1{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", sex='" + sex + '\'' +
      ", birthday=" + birthday +
      ", departId=" + departId +
      '}';
  }

  public static class Builder {
    private int id;
    private String name;
    private String sex;
    private Date birthday;
    private int departId;

    public Builder id(int id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder sex(String sex) {
      this.sex = sex;
      return this;
    }

    public Builder birthday(Date birthday) {
      this.birthday = birthday;
      return this;
    }

    public Builder departId(int departId) {
      this.departId = departId;
      return this;
    }

    public User1 build() {
      return new User1(this);
    }
  }

  private User1(Builder builder) {
    id = builder.id;
    name = builder.name;
    sex = builder.sex;
    birthday = builder.birthday;
    departId = builder.departId;
  }


}