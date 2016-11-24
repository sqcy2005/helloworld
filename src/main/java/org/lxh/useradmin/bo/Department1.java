package org.lxh.useradmin.bo;

/**
 * Created by songqian on 16/11/24.
 */
public class Department1 {
  private final int id;
  private final String name;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Department1{" +
      "id=" + id +
      ", name='" + name + '\'' +
      '}';
  }

  public static class Builder {
    private int id;
    private String name;

    public Builder id(int id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Department1 build() {
      return new Department1(this);
    }
  }

  private Department1(Builder builder) {
    id = builder.id;
    name = builder.name;
  }

  public static void main(String[] args) {
    Department1 department1 = new Builder().id(5).name("stream").build();
    System.out.println(department1.getName() + " " + department1.getId());
  }


}
