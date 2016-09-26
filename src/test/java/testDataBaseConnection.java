import org.junit.Assert;
import org.junit.Test;
import org.lxh.useradmin.dbc.DataBaseConnection;
import org.lxh.useradmin.menu.Menu;

import java.sql.Connection;

/**
 * Created by songqian on 16/9/23.
 */

public class testDataBaseConnection {
  @Test
  public void test() {
    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection = dataBaseConnection.getConnection();
    Assert.assertNotNull(connection);
  }

  @Test
  public void howtodo() {
    Menu menu = new Menu();
  }
}

