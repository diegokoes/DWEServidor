package es.daw.jakarta.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/registro4")
public class ParamsFormServlet4 extends HttpServlet {
    /*
     * El campo serialVersionUID es una identificación única para la clase
     * serializable.
     * Evita conflictos.
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println(" ** ** * * ** DO GEEET!");

        // Lo mismo que en el Params1 con los getPara...
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
        // Utilizaremos en el Sevlet una colección Map para indicar el campo del
        // formulario y la descripción del error.
        Map<String, String> errores = new HashMap<>();

        if (username.isBlank()) {
            errores.put("username", "El username es obligatorio");
        }
        if (password.isBlank()) {
            errores.put("password", "El password no puede estar vacio");
        }
        if (email.isBlank() || !email.matches("[a-zA-Z]+@[a-z]{3,}.[a-z]{2,}")) {
            errores.put("email", "El email es requerido y debe tener un formato adecuado!");
        }
        if (idioma == null) {
            errores.put("idioma", "no has aniadido ningun idioma");
        }
        if (pais.isBlank()) {
            errores.put("pais", "selecciona un pais");
        }
        if (lenguajes == null) {
            errores.put("lenguajes", "tienes que seleccionar algun lenguaje de programacion!!");
        }
        if (roles == null) {
            errores.put("roles", "tienes que seleccionar algun rol!!");
        }
        boolean habilitado = habilitar != null && habilitar.equals("on");
        if (!habilitado) {
            errores.put("habilitar", "No has habilitado el formulario!!");
        }

        if (errores.isEmpty()) {
            resp.setContentType("text/html");

            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
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
                Arrays.asList(lenguajes).forEach(lenguaje -> sb.append("<li>" + lenguaje + "</li>"));

                sb.append("</ol><p>Idioma: " + idioma + "</p>").append("<p>Habilitado?: " + habilitado + "</p>")
                        .append("<p>nº secreto: " + secreto + "</p>");

                out.println(sb.toString());
                out.println("</body>");
                out.println("</html>");
                out.println("<p><a href=\"index.html\">volver</a></p>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index4.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO: implement POST request handling
        doGet(request, response);
    }
}