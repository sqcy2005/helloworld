package org.lxh.useradmin.bo;

/**
 * Created by songqian on 16/10/10.
 */
public class Department {
  private int id;
  private String name;

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

  @Override
  public String toString() {
    return "Department{" +
      "id=" + id +
      ", name='" + name + '\'' +
      '}';
  }
}
