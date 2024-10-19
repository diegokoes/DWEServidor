package es.daw.jakarta.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import es.daw.jakarta.services.ProductServiceImpl;
import es.daw.jakarta.models.Producto;
import es.daw.jakarta.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/productos.xsl", "/productos.html","productos" })
public class ProductXslServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // PENDIENTE METER CHICHA!!

        // Obtener un objeto de la lista de productos
        ProductService service = new ProductServiceImpl();
        // Obtener la lista de productos
        List<Producto> productos = service.listar();

        if (request.getServletPath().endsWith(".xsl")) {
            // Poner el mime type adecuado
            // preparando a que el responde va a devolver el excel, pero falta decir cuales
            // son los datos
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=products.xsl");

        }
        // Generar tabla HTML a partir d euna JSP
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("/productos.jsp").forward(request,response);

        

        // response.getWriter().append("Served at: ").append(request.getContextPath());
        // response.setContentType("text/html");
        // try(PrintWriter out = response.getWriter()){
        // out.println("<!DOCTYPE html>");
        // out.println("<html>");
        // out.println("<head>");
        // out.println("<title>MyServlet</title>");
        // out.println("</title>");
        // out.println(" <body>");
        // out.println(" <h1>MyServlet!</h1>");
        // out.println(" </body>");
        // out.println("</html>");
        // }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO: implement POST request handling
        doGet(request, response);
    }
}