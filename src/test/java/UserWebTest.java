import com.google.inject.Guice;
import com.google.inject.Injector;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.lxh.useradmin.module.ModuleForTwo;
import org.lxh.useradmin.rest.WebServer;

/**
 * Created by songqian on 16/9/23.
 */

public class UserWebTest {

  private static Injector injector;

  @BeforeClass
  public static void beforeClass() {
    injector = Guice.createInjector(new ModuleForTwo());
    WebServer webServer = injector.getInstance(WebServer.class);
    webServer.start();
  }

  @Test
  public void user() {
    Vertx vertx = Vertx.vertx();

    JsonObject userJson = new JsonObject();
    userJson.put("name", "xxaxx");
    userJson.put("sex", "male");
    userJson.put("birthDay", "1984-11-26");

    vertx.createHttpClient()
      .post(8080, "localhost", "/user", response -> {
        response.bodyHandler(bodyBuffer -> {
          Assert.assertEquals(bodyBuffer.toString(), "create succeed");
        });
      })
      .putHeader("Content-Type", "application/json")
      .end(userJson.encode());


  }

  @AfterClass
  public static void afterClass() {

  }


}

