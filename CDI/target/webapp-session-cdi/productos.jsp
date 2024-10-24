<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Optional"%>
<%@page import="es.daw.jakarta.models.Producto"%>
<%@page import="es.daw.jakarta.services.*"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de productos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #5a67d8;
        }
        h2 {
            margin-top: 20px;
            color: #2d3748;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #5a67d8;
            color: white;
        }
        td {
            background-color: #f8f9fa;
        }
        a {
            text-decoration: none;
            color: #3182ce;
        }
        a:hover {
            text-decoration: underline;
        }
        .welcome-message {
            background-color: #e2e8f0;
            padding: 10px;
            border-radius: 8px;
            display: inline-block;
        }
    </style>
</head>
<body>
    <h1>Listado de productos</h1>
    <h2>
        <%
            LoginService auth = new LoginServiceImpl();

            Optional<String> sessionOpt = auth.getUserName(request);
            if (sessionOpt.isPresent()) {
        %>
            <span class="welcome-message">Hola <%= sessionOpt.get() %>, bienvenido!!!!!</span>
        <%
            } else {
        %>
            <span class="welcome-message">NO REGISTRADO!!!</span>
        <%
            }
        %>
    </h2>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>TIPO</th>
                <% if (sessionOpt.isPresent()) { %>
                    <th>PRECIO</th>
                    <th>AGREGAR</th>
                <% } %>
            </tr>
        </thead>
        <tbody>
            <%
                List<Producto> productos = (List<Producto>)request.getAttribute("productos");

                for (Producto p : productos) {
            %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getNombre() %></td>
                    <td><%= p.getTipo() %></td>

                    <% if (sessionOpt.isPresent()) { %>
                        <td><%= p.getPrecio() %></td>
                        <td><a href='carro/agregar?id=<%= p.getId() %>'>Agregar producto</a></td>
                    <% } %>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <p><strong>Request attribute:</strong> <%= (String)request.getAttribute("mensaje") %></p>
    <p><strong>Context attribute:</strong> <%= (String)application.getAttribute("mensaje") %></p>
</body>
</html>
