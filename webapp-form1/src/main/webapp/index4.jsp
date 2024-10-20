<%@page contentType="text/html"  pageEncoding="UTF-8"%>
<%@pageimport="java.util.Map"%>

<%
Map<String,String> errores = (Map<String,String>)request.getAttribute("errores");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="/webapp-formBootstrap2/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body>
<h3>Formulario de usuarios</h3>


<div class="px-5">
<form action="registro4" method="post">

  <div class="row mb-3">
    <label for="username" class="col-form-label col-sm-2">Usuario</label>
    <div class="col-sm-4">
        <input type="text" name="username" id="username" class="form-control" value="${param.username}">
    </div>
    <%
    if(errores!=null && errores.containsKey("username")){
      out.println("<p style='color:white;background-color:red;max-width:200px';>"+errores.get("username")+"</p>");
    }
    %>
  </div>
      
  <div class="row mb-3">
    <label for="password" class="col-form-label col-sm-2">Password</label>
    <div class="col-sm-4"><input type="password" name="password" id="password" class="form-control" value="${param.password}"></div>
    <%
    if(errores!=null && errores.containsKey("password")){
      out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("password")+"</p>");
    }
    %>  
  </div>
  <div class="row mb-3">
    <label for="email" class="col-form-label col-sm-2">Email</label>
    <div class="col-sm-4"><input type="text" name="email" id="email" class="form-control" value="${param.email}"></div>
    <%
    if(errores!=null && errores.containsKey("email")){
      out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("email")+"</p>");
    }
    %> 
  </div>
  <div class="row mb-3">
    <label for="pais" class="col-form-label col-sm-2">País</label>
    <div class="col-sm-4">
      <select name="pais" id="pais" class="form-select">
        <option value="">-- seleccionar --</option>
        <option value="ES" ${param.pais.equals("ES")? "selected":""}>España</option>
        <option value="MX" ${param.pais.equals("MX")? "selected":""}>México</option>
        <option value="CL" ${param.pais.equals("CL")? "selected":""}>Chile</option>
        <option value="AR" ${param.pais.equals("AR")? "selected":""}>Argentina</option>
        <option value="PE" ${param.pais.equals("PE")? "selected":""}>Perú</option>
        <option value="CO" ${param.pais.equals("CO")? "selected":""}>Colombia</option>
        <option value="VE" ${param.pais.equals("VE")? "selected":""}>Venezuela</option>
      </select>
    </div>
    <%
    if(errores!=null && errores.containsKey("pais")){
      out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("pais")+"</p>");
    }
    %>  
  </div>

  <div class="row mb-3">
    <label for="lenguajes" class="col-form-label col-sm-2">Lenguajes de programación</label>
    <div class="col-sm-4">
      <select name="lenguajes" id="lenguajes" multiple class="form-select">
        <option value="java" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("java"))?"selected":""}>Java SE</option>
        <option value="jakartaee" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("jakartaee"))?"selected":""}>Jakarta EE10</option>
        <option value="spring" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("spring"))?"selected":""}>Spring Boot</option>
        <option value="js" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("js"))?"selected":""}>JavaScript</option>
        <option value="angular" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("angular"))?"selected":""}>Angular</option>
        <option value="react" ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("react"))?"selected":""}>React</option>
      </select>
    </div>
    <%
    if(errores!=null && errores.containsKey("lenguajes")){
      out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("lenguajes")+"</p>");
    }
    %> 
  </div>

  <div class="row mb-3">
    <label class="col-form-label col-sm-2">Roles</label>
    <div class="form-check col-sm-2">
      <input type="checkbox" name="roles" value="ROLE_ADMIN"
      ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_ADMIN"))?"checked":""}
      class="form-check-input">
      <label class="form-check-label">Administrador</label>
    </div>
    <div class="form-check col-sm-2">
      <input type="checkbox" name="roles" value="ROLE_USER" class="form-check-input"
            ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_USER"))?"checked":""}>
      <label class="form-check-label">Usuario</label>
    </div>
    <div class="form-check col-sm-2">
      <input type="checkbox" name="roles" value="ROLE_MODERATOR" class="form-check-input"
            ${paramValues.roles.stream().anyMatch(v->v.equals("ROLE_MODERATOR"))?"checked":""}>
      <label class="form-check-label">Moderador</label>
    </div>
    <%
    if(errores!=null && errores.containsKey("roles")){
      out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("roles")+"</p>");
    }
    %>  
  </div>
  <div class="row mb-3">
    <label class="col-form-label col-sm-2">Idiomas</label>
    <div class="form-check col-sm-2">
      <input type="radio" name="idioma" value="es" class="form-check-input" ${param.idioma.equals("es")? "checked": ""}>
      <label class="form-check-label">Español</label>
    </div>
    <div class="form-check col-sm-2">
      <input type="radio" name="idioma" value="en" class="form-check-input" ${param.idioma.equals("en")? "checked": ""}>
      <label class="form-check-label">Inglés</label>
    </div>
    <div class="form-check col-sm-2">
      <input type="radio" name="idioma" value="fr" class="form-check-input" ${param.idioma.equals("fr")? "checked": ""}>
      <label class="form-check-label">Frances</label>
    </div>
    <%
    if(errores!=null && errores.containsKey("idioma")){
      out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("idioma")+"</p>");
    }
    %>  
  </div>
  <div class="row mb-3">
    <label for="habilitar" class="col-form-label col-sm-2">Habilitar</label>
    <div class="form-check col-sm-2">
      <input type="checkbox" name="habilitar" id="habilitar" class="form-check-input" ${param.habilitar.equalsIgnoreCase("on")?"checked":""}>    </div>
    <%
    if(errores!=null && errores.containsKey("habilitar")){
      out.println("<p style='color:white;background-color:red;max-width:200px'>"+errores.get("habilitar")+"</p>");
    }
    %>  
  </div>
  <div class="row mb-3">
    <div>
      <input type="submit" value="Enviar" class="btn btn-primary">
    </div>
  </div>
  <input type="hidden" name="secreto" value="12345">
</form>
<p><a href="index.html">Volver</a></p>

</div>
</body>
</html>