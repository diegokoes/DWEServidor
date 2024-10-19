package es.daw.jakarta.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registro")
public class ParamsFormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L; // para la serializacion

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println(" ** ** * * ** DO GEEET!");

    // LECTURA DE PARAMETROS DEL REQUEST
    String username = req.getParameter("username").replaceAll("\\s", "");
    String password = req.getParameter("password").replaceAll("\\s", "");
    String email = req.getParameter("email").replaceAll("\\s", "");
    String pais = req.getParameter("pais");
    String[] lenguajes = req.getParameterValues("lenguajes");
    String[] roles = req.getParameterValues("roles");
    String idioma = req.getParameter("idioma");
    String secreto = req.getParameter("secreto");
    String habilitar = req.getParameter("habilitar");

    System.out.println("username : " + username + "\n" +
        "password : " + password + "\n" +
        "email : " + email + "\n" +
        "roles : " + Arrays.toString(roles) + "\n" +
        "pais : " + pais + "\n" +
        "lenguajes : " + Arrays.toString(lenguajes) + "\n" +
        "idioma : " + idioma + "\n" +
        "secreto : " + secreto + "\n" +
        "habilitar : " + habilitar);

    List<String> listErrores = new ArrayList<>();

    if (username.isBlank()) {
      listErrores.add("El username es obligatorio");
    }
    if (password.isBlank()) {
      listErrores.add("El password no puede estar vacio");
    }
    if (email.isBlank() || !email.matches("[a-zA-Z]+@[a-z]{3,}.[a-z]{2,}")) {
      listErrores.add("El email es requerido y debe tener un formato adecuado!");
    }
    if (idioma == null) {
      listErrores.add("no has aniadido ningun idioma");
    }
    if (lenguajes == null) {
      listErrores.add("tienes que seleccionar algun lenguaje de programacion!!");
    }
    boolean habilitado = habilitar!=null && habilitar.equals("on");
    if(!habilitado){
      listErrores.add("No has habilitado el formulario!!");
    }
    listErrores.forEach(error -> System.out.println(error));

    response.setContentType("text/html");

    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      if (listErrores.isEmpty()) {
        out.println("<title>Reto1 resultados form</title>");
        out.println("<body>");
        out.println("<h1>Formulario rellenado correctamente! Tus datos: </h1>");
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Username: " + username + "</p>").append("<p>Password: " + password + "</p>")
            .append("<p>Email: " + email + "</p>").append("<p>Roles: \n<ul>");
        for (String rol : roles) {
          sb.append("<li>" + rol + "</li>");
        }
        sb.append("</ul></p>").append("<p>Pais: " + pais + "</p>").append("<p>Lenguajes : <ol>");
        for (String lenguaje : lenguajes) {
          sb.append("<li>" + lenguaje + "</li>");
        }
        sb.append("</ol><p>Idioma: " + idioma + "</p>").append("<p>Habilitado?: " + habilitado + "</p>")
            .append("<p>nº secreto: " + secreto + "</p>");

        out.println(sb.toString());

      } else {
        out.println("<title>Errores!</title>");
        out.println("<title>Hay errores!! son estos:</title>");
        out.println("<h1>No has rellenado el formulario bien! Errores: </h1>");

        out.println("   <body>");
        out.println("   <ol>");
        listErrores.forEach(error -> {
          out.printf("<li>%s</li>", error);
        });

        out.println("</ol>");

      }

      out.println("<p><a href=\"index.jsp\">volver</a></p>");
      out.println("</body>");
      out.println("</html>");

    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO: implement POST request handling
    doGet(request, response);
  }
}