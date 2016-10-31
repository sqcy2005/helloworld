package org.lxh.useradmin;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.lxh.useradmin.module.ModuleForTwo;
import org.lxh.useradmin.rest.WebServer;

/**
 * Created by songqian.
 */
public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ModuleForTwo());
    WebServer webServer = injector.getInstance(WebServer.class);
    webServer.start();
  }
}
