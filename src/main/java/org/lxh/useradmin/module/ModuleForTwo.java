package org.lxh.useradmin.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import org.lxh.useradmin.dao.DepartmentDAO;
import org.lxh.useradmin.dao.proxy.DepartmentDAOProxy;
import org.lxh.useradmin.rest.WebServer;

/**
 * Created by songqian on 16/10/18.
 */
public class ModuleForTwo implements Module {
  public void configure(Binder binder){
    binder.bind(DepartmentDAO.class).to(DepartmentDAOProxy.class).in(Scopes.SINGLETON);
    binder.bind(WebServer.class);
  }

  @Provides
  Router webRouter() {
    Vertx vertx = Vertx.vertx();
    HttpServer server = vertx.createHttpServer();
    Router router = Router.router(vertx);
    server.requestHandler(router::accept);
    server.listen(8080);
    return router;
  }
}
