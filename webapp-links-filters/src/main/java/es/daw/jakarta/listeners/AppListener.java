package es.daw.jakarta.listeners;

import es.daw.jakarta.models.Carro;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AppListener implements ServletContextListener,
    ServletRequestListener, HttpSessionListener {

  private ServletContext sc; // .log del servidor de la aplicacion
  // sea cual sea se usa el servletContext, tiene una clase que es .log . donde
  // encuentra el fichero, escribe
  // tambien salen por consola. Se configura todo esto en

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    sc = sce.getServletContext(); // una vez, al iniciar

    sc.log("******** inicializando la aplicacion!");

    sc.setAttribute("mensaje", "algun valor global de la app!"); // al iniciar se pueden poner atributos
    // se mete object - variable hiper mega GLOBAL
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    sc.log("******** destruyendo la aplicacion!");
  }

  @Override
  public void requestInitialized(ServletRequestEvent sre) {
    sc.log("******** inicializando el request!");
    sre.getServletRequest().setAttribute("mensaje", "guardando algun valor para el request");
    // MIRAR que uso tiene . Global para las REQUEST
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    sc.log("******** destruyendo el request!");
  }

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    sc.log("******** inicializando la sesion http");

    // En vez de crear el carro en el servlet AgregarCarro
    Carro carro = new Carro();
    se.getSession().setAttribute("carro", carro);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    sc.log("******** destruyendo la sesion http");
  }
}
