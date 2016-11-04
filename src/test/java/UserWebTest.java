import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.BeforeClass;
import org.junit.Test;
import org.lxh.useradmin.bo.Department;
import org.lxh.useradmin.bo.User;
import org.lxh.useradmin.dao.IUserDAO;
import org.lxh.useradmin.module.ModuleForTwo;
import org.lxh.useradmin.service.SomeService;

import java.util.Date;

/**
 * Created by songqian on 16/9/23.
 */

public class UserWebTest {

  private static Injector injector;

  @BeforeClass
  public static void beforeClass() {
    injector = Guice.createInjector(new ModuleForTwo());

  }

  @Test
  public void someService() {
    SomeService someService = injector.getInstance(SomeService.class);
    IUserDAO userDAO = injector.getInstance(IUserDAO.class);
    User user = new User();
    user.setName("aabb");
    user.setSex("male");
    user.setDepart_id(1);
    user.setBirthday(new Date(System.currentTimeMillis()));

    Department department = new Department();
    department.setId(19);
    someService.addUserAndDepartment(user, department);


  }




}

