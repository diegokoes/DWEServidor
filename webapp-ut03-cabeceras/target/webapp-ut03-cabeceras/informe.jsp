<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>informe.jsp</title>
</head>
<body>
  <%
  Map<String>,<String> cabeceras = (Map<String>,<String>)request.getAttribute("mapCabeceras");

    for(Map.Entry<String>,<String>cabecera: cabeceras.entrySet()) {
      out.println("<p>"+ cabecera.getKey()+" "+ cabecera.getValue()+ "</p>") ;
    }

  %>



</body>
</html>
