package org.lxh.useradmin.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.lxh.useradmin.bo.Department;
import org.lxh.useradmin.bo.User;
import org.lxh.useradmin.dao.DepartmentDAO;
import org.lxh.useradmin.dao.IUserDAO;
import org.lxh.useradmin.service.SomeService;

import javax.inject.Inject;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by songqian on 16/10/11.
 */
public class WebServer {

  private Router router;
  private IUserDAO userDAO;
  private DepartmentDAO departmentDAO;
  private SomeService someService;

  @Inject
  public WebServer(Router router, SomeService someService, IUserDAO userDAO, DepartmentDAO departmentDAO) {
    this.router = router;
    this.someService = someService;
    this.departmentDAO = departmentDAO;
    this.userDAO = userDAO;
  }

  public void start() {
    router.get("/user/:id").handler(routingContext -> {
      try {
        int id = Integer.valueOf(routingContext.pathParam("id"));
        User user = userDAO.findById(id);
        routingContext.response().end(user.getName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    });

    router.get("/friend/:id").handler(new Handler<RoutingContext>() {
      @Override
      public void handle(RoutingContext event) {
        int id = Integer.valueOf(event.pathParam("id"));
        try {
          User user = userDAO.findById(id);
          event.response().end(user.getName() + "  " + user.getSex());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });


    router.get("/department/:id").handler(routingContext -> {
      try {
        int id = Integer.valueOf(routingContext.pathParam("id"));

        Department department = departmentDAO.findById(id);

        routingContext.response().end(department.getName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
    router.delete("/user/:id").handler(routingContext -> {
      try {
        int id = Integer.valueOf(routingContext.pathParam("id"));
        //userDAO.doDelete(id);
        routingContext.response().end("删除成功");
      } catch (Exception e) {
        e.printStackTrace();
      }
    });

    router.post("/postuser").consumes("application/json").handler(routerContext -> {
      routerContext.request().bodyHandler(buffer -> {
        JsonObject jsonObject = buffer.toJsonObject();
        System.out.println(jsonObject.toString());
        ObjectMapper mapper = new ObjectMapper();
        try {
          User user1 = mapper.readValue(jsonObject.toString(), User.class);
          someService.addUser(user1);







          
        } catch (IOException e) {
          e.printStackTrace();
        }
        routerContext.response().end();
      });
    });

    router.post("/department").handler(routerContext -> {
      routerContext.request().setExpectMultipart(true);
      routerContext.request().bodyHandler(buffer -> {
        MultiMap map = routerContext.request().formAttributes();
        Department department = new Department();
        department.setName(map.get("name"));
        try {
          //DAOFactoryDepartment.getDepartInstance().doCreate(department);
          routerContext.response().end("新建部门成功");
        } catch (Exception e) {
          e.printStackTrace();
          routerContext.response().end("新建部门失败");
        }
      });
    });
    router.put("/department").handler(routerContext -> {
      routerContext.request().setExpectMultipart(true);
      routerContext.request().bodyHandler(buffer -> {
        MultiMap map = routerContext.request().formAttributes();
        Department department = new Department();
        department.setName(map.get("name"));
        department.setId(Integer.valueOf(map.get("id")));
        try {
          //DAOFactoryDepartment.getDepartInstance().doUpdate(department);
          routerContext.response().end("update succeed");
        } catch (Exception e) {
          e.printStackTrace();
          routerContext.response().end("failed");
        }
      });
    });


    router.put("/user").handler(routerContext -> {
      routerContext.request().setExpectMultipart(true);
      routerContext.request().bodyHandler(buffer -> {
        MultiMap map = routerContext.request().formAttributes();
        User user = new User();
        user.setName(map.get("name"));
        user.setSex(map.get("sex"));
        user.setId(Integer.valueOf(map.get("id")));
        user.setDepart_id(Integer.valueOf(map.get("depart_id")));
        String stringDate = map.get("birthday");
        DateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        Date date = null;
        try {
          date = format.parse(stringDate);
        } catch (ParseException e) {
          e.printStackTrace();
        }
        user.setBirthday(date);
        try {
          //userDAO.doUpdate(user);
          routerContext.response().end("okkkkk");
        } catch (Exception e) {
          e.printStackTrace();
          routerContext.response().end("failllled");
        }
      });
    });


    router.post("/user").handler(routerContext -> {
      routerContext.request().setExpectMultipart(true);
      routerContext.request().bodyHandler(buffer -> {
        MultiMap map = routerContext.request().formAttributes();

        String stringDate = map.get("birthday");
        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        Date date = null;
        try {
          date = formatter.parse(stringDate);
        } catch (ParseException e) {
          e.printStackTrace();
        }

        User user = new User();
        user.setName(map.get("name"));
        user.setSex(map.get("sex"));
        user.setBirthday(date);
        user.setDepart_id(Integer.valueOf(map.get("depart_id")));
        try {
          userDAO.doCreate(user, null);
          routerContext.response().end("create succeed");
        } catch (Exception e) {
          e.printStackTrace();
          routerContext.response().end("create failed");
        }
      });
    });

    router.delete("/department/:id").handler(routingContext -> {
      try {
        int id = Integer.valueOf(routingContext.pathParam("id"));
        //DAOFactoryDepartment.getDepartInstance().doDelete(id);
        routingContext.response().end("删除成功");
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }
}


//    router.route().handler(routingContext->{
//      HttpServerResponse response =routingContext.response();
//      response.putHeader("content-type","text/plain");
//      response.end("finish");
//    router.route().handler(new Handler<RoutingContext>() {
//      @Override
//      public void handle(RoutingContext event) {
//        HttpServerResponse response =event.response();
//        response.putHeader("content-type","text/plain");
//        response.end("finishs");
//      }
//    });

//    httpServer.requestHandler(router::accept).listen(8080);
//    HttpServer httpServer = vertx.createHttpServer();
//    Router router = Router.router(vertx);
//    Route route1 = router.route("/monday").handler(routingContext -> {
//      HttpServerResponse response = routingContext.response();
//      response.setChunked(true);
//      response.write("number1");
//      routingContext.vertx().setTimer(2000, tid -> routingContext.next());
//    });
//    Route route2 = router.route("/monday").handler(routingContext -> {
//      HttpServerResponse response = routingContext.response();
//      response.write("number2");
//      routingContext.vertx().setTimer(2000, tid -> routingContext.next());
//    });
//    Route route3 = router.route("/monday").handler(routingContext -> {
//      HttpServerResponse response = routingContext.response();
//      response.write("number3");
//      routingContext.response().end();
//    });
//    httpServer.requestHandler(router::accept).listen(8080);
//  }

