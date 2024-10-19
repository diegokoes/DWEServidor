// package es.daw.jakarta.servlets;

// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/registro")
// public class ParamsFormServletmio2 extends HttpServlet {
//   private static final long serialVersionUID = 1L; // para la serializacion
//   //

//   @Override
//   protected void doGet(HttpServletRequest req, HttpServletResponse response)
//       throws ServletException, IOException {
//     System.out.println(" ** ** * * ** DO GEEET!");

//     // LECTURA DE PARAMETROS DEL REQUEST

//     String username = req.getParameter("username").replaceAll("\\s", ""); // NO SE PONE NADA? ENVIA <> CADENA VACIA
//     // TODO ver diferencia entre replaceall y replace
//     System.out.println("[ParamsFormServlet] username:<" + username + ">");// si no va relleno es null porque no viaja...
//     String password = req.getParameter("password");
//     System.out.println("[ParamsFormServlet] password:" + password);// si no va relleno es null porque no viaja...
//     String email = req.getParameter("email");
//     System.out.println("[ParamsFormServlet] email:" + email);// si no va relleno es null porque no viaja...
//     String pais = req.getParameter("pais");
//     System.out.println("[ParamsFormServlet] pais:" + pais);// si no va relleno es null porque no viaja...

//     String[] lenguajes = req.getParameterValues("lenguajes");
//     if (lenguajes != null) {
//       System.out.println("[ParamsFormServlet] lenguajes:" + lenguajes);

//     }
//     // Arrays.toString(lenguajes));// si no va relleno es null porque
//     // no viaja...

//     String[] roles = req.getParameterValues("roles");
//     System.out.println("[ParamsFormServlet] roles:" + Arrays.toString(roles));// si no va relleno es null porque

//     String idioma = req.getParameter("idioma"); // si no hay ningun radio marcado vendra null

//     String habilitar = req.getParameter("habilitar");
//     System.out.println(habilitar);
//     boolean enabled = habilitar != null && habilitar.equals("on");

//     String secreto = req.getParameter("secreto");
//     System.out.println(secreto);
//     // ARRAYLIST DE ERRORES
//     // Disenio orientado a interfaces, mejor List y Set, y convertir es mas facil
//     // que luego castear...
//     ArrayList<String> arrayErrores = new ArrayList<>();
//     List<String> errores2 = new ArrayList<>(); // LISTA ES UNA INTERFACE (sale linklist, arraylist...) para mas
//                                                // borrados/insert LinkedList, para recorrer solo ArrayList
//     Map<String, String> errores = new HashMap<>();

//     if (username.isEmpty()) {
//       errores.put("username", "El username es obligatorio");

//     }
//     if (password.isEmpty()) {
//       errores.put("password", "La contrasenia es obligatoria");
//     }
//     if (email.isEmpty() || !email.contains("@")) {
//       errores.put("email", "No puede estar vacio y tiene que contener @");
//     }
//     if (idioma == null) {
//       errores.put("idioma", "Elige un idioma");
//     }
//     if (lenguajes == null || lenguajes.length == 0) {
//       errores.put("lenguajes", "debe seleccionar al menos un lenguaje");
//     }
//     if (roles == null || roles.length == 0) {
//       errores.put("roles", "debes seleccionar al menos un rol");
//     }
//     // QUITAR ESPACIOS EN BLANCO, TABULACIONES, INTROS..... DE LOS INPUT TEXT

//     // TODO: implement GET request handling
//     // response.getWriter().append("Served at: ").append(request.getContextPath());
//     response.setContentType("text/html");

//     //

//     try (PrintWriter out = response.getWriter()) {
//       out.println("<!DOCTYPE html>");
//       out.println("<html>");
//       out.println("<head>");
//       out.println("<title>ParamsFormServlet</title>");
//       out.println("</title>");
//       out.println("   <body>");
//       if (!arrayErrores.isEmpty()) {
//         // recorro el arrayList y pinto los errores
//         out.println("       <h1>Informe de datos recibidos</h1>");
//         out.println("<ul>");
//         arrayErrores.forEach((error) -> out.printf("<li>%s</li>", error));
//         out.println("</ul>");

//       } else {
//         // Informe de todos datos del formulario
//         out.println("<h1>Has introducido todo bien! tus datos:</h1>");

//         out.println("<li>Username:" + username + "</li>");

//         StringBuilder sb = new StringBuilder();
//         sb.append("<li>Password:").append(password).append("</li>")
//             .append("<li>Email:").append(email).append("</li>")
//             .append("<li>Lenguajes: <ul>");
//         if (lenguajes != null) {
//           Arrays.asList(lenguajes).forEach(lenguaje -> sb.append("<li>" + lenguaje + "</li>"));
//         }
//         sb.append("</ul><li>Roles: <ul>");
//         Arrays.asList(roles).forEach(role -> sb.append("<li>" + role + "</li>"));

//         sb.append("</ul><li>Idioma:").append(idioma).append("</li>")
//             .append("<li>Habilitado:").append(enabled)
//             .append("<li>Secreto:").append(secreto).append("</li>");

//         out.println(sb.toString());
//       }
//       out.println("<p><a href=\"index2.jsp\">volver</a></p>");
//       out.println("   </body>");
//       out.println("</html>");

//     }
//   }

//   @Override
//   protected void doPost(HttpServletRequest request, HttpServletResponse response)
//       throws ServletException, IOException {
//     // TODO: implement POST request handling
//     doGet(request, response);
//   }
// }