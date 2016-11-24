package org.lxh.useradmin.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import org.jooq.DSLContext;
import org.lxh.useradmin.dao.DepartmentDAO;
import org.lxh.useradmin.dao.IUserDAO;
import org.lxh.useradmin.dao.impl.DepartmentImpl;
import org.lxh.useradmin.dao.impl.IUserDAOImpl;
import org.lxh.useradmin.dbc.DataBaseConnection;
import org.lxh.useradmin.rest.WebServer;
import org.lxh.useradmin.service.SomeService;
import org.lxh.useradmin.service.impl.SomeServiceImpl;

/**
 * Created by songqian on 16/10/18.
 */
public class ModuleForTwo implements Module {
  public void configure(Binder binder) {
    binder.bind(IUserDAO.class).to(IUserDAOImpl.class).in(Scopes.SINGLETON);
    binder.bind(DepartmentDAO.class).to(DepartmentImpl.class).in(Scopes.SINGLETON);
    binder.bind(SomeService.class).to(SomeServiceImpl.class).in(Scopes.SINGLETON);
    binder.bind(WebServer.class);
  }

//  @Provides
//  DSLContext jooq() {
//    return DataBaseConnection.getJooq();
//  }
//


  @Provides
  public DSLContext jooq() {

    return DataBaseConnection.getJooq();
  }

//  @Provides
//  Router webRouter() {
//    Vertx vertx = Vertx.vertx();
//    HttpServer server = vertx.createHttpServer();
//    Router router = Router.router(vertx);
//    server.requestHandler(router::accept);
//    server.listen(8080);
//    return router;
//  }


  @Provides
  public Router webRouter() {
    Vertx vertx = Vertx.vertx();
    HttpServer server = vertx.createHttpServer();
    Router router = Router.router(vertx);
    server.requestHandler(router::accept);
    server.listen(8080);
    return router;
  }


}
