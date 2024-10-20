<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@pageimport="java.util.Map"%>


<%
Map<String, String> errores = (Map<String, String>)request.getAttribute("errores");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Formulario de usuarios</title>
  </head>
  <body style="padding-left:20em">
    <h1><%= "Formulario de usuarios" %></h1>
    <form action="registro2" method="post">
      <div>
        <label for="username">Usuario</label>
        <div><input type="text" name="username" id="username" /></div>
        <%
        if(errores!=null && errores.containsKey("username")){
          out.println("<p style='color:white;background-color:red;max-width:200px';>"+errores.get("username")+"</p>");
        }
        %>
      </div>
      <div>
        <label for="password">Password</label>
        <div><input type="password" name="password" id="password" /></div>
        <%
        if(errores!=null && errores.containsKey("password")){
          out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("password")+"</p>");
        }
        %>        
      </div>
      <div>
        <label for="email">Email</label>
        <div><input type="text" name="email" id="email" /></div>
        <%
        if(errores!=null && errores.containsKey("email")){
          out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("email")+"</p>");
        }
        %>   
      </div>
      <div>
        <label for="pais">País</label>
        <div>
          <select name="pais" id="pais">
            <option value="">-- seleccionar --</option>
            <option value="ES">España</option>
            <option value="MX">México</option>
            <option value="CL" >Chile</option> <%//quitado el selected para que sea mas facil testear errores%> 
            <option value="AR">Argentina</option>
            <option value="PE">Perú</option>
            <option value="CO">Colombia</option>
            <option value="VE">Venezuela</option>
          </select>
        </div>
        <%
        if(errores!=null && errores.containsKey("pais")){
          out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("pais")+"</p>");
        }
        %>  
      </div>

      <div>
        <label for="lenguajes">Lenguajes de programación</label>
        <div>
          <select name="lenguajes" id="lenguajes" multiple>
            <option value="java" selected>Java SE</option>
            <option value="jakartaee" selected>Jakarta EE9</option>
            <option value="spring">Spring Boot</option>
            <option value="js">JavaScript</option>
            <option value="angular" selected>Angular</option>
            <option value="react">React</option>
          </select>
        </div>
        <%
        if(errores!=null && errores.containsKey("lenguajes")){
          out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("lenguajes")+"</p>");
        }
        %>  
      </div>

      <div>
        <label>Roles</label>
        <div>
          <input type="checkbox" name="roles" value="ROLE_ADMIN" />
          <label>Administrador</label>
        </div>
        <div>
          <input type="checkbox" name="roles" value="ROLE_USER" checked />
          <label>Usuario</label>
        </div>
        <div>
          <input type="checkbox" name="roles" value="ROLE_MODERATOR" />
          <label>Moderador</label>
        </div>
        <%
        if(errores!=null && errores.containsKey("roles")){
          out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("roles")+"</p>");
        }
        %>  
      </div>
      <div>
        <label>Idiomas</label>
        <div>
          <input type="radio" name="idioma" value="es" />
          <label>Español</label>
        </div>
        <div>
          <input type="radio" name="idioma" value="en" />
          <label>Inglés</label>
        </div>
        <div>
          <input type="radio" name="idioma" value="fr" />
          <label>Frances</label>
        </div>
        <%
        if(errores!=null && errores.containsKey("idioma")){
          out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("idioma")+"</p>");
        }
        %>  
      </div>
      <div>
        <label for="habilitar">Habilitar</label>
        <div>
          <input type="checkbox" name="habilitar" id="habilitar" checked />
        </div>
        <%
        if(errores!=null && errores.containsKey("habilitar")){
          out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("habilitar")+"</p>");
        }
        %>  
      </div>
      <div>
        <div>
          <input type="submit" value="Enviar" />
        </div>
      </div>
      <input type="hidden" name="secreto" value="12345" />
    </form>
    <p><a href="index.html">Volver</a></p>
  </body>
</html>
