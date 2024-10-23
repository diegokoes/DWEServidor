package es.daw.web.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import es.daw.web.bd.DaoProducto;
import es.daw.web.bd.Dao;
import es.daw.web.bd.DaoFabricante;
import es.daw.web.models.Fabricante;
import es.daw.web.models.Producto;
import es.daw.web.util.Utils;

@WebServlet("/productos/ver")
public class ListarProductosServlet extends HttpServlet {

    private String pathProperties = "";

    @Override
    public void init() {
        pathProperties = getServletContext().getRealPath("/JDBC.properties");
        System.out.println("pathProperties:" + pathProperties);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Dao daoP, daoF;
        List<Producto> productos = null;
        List<Fabricante> fabricantes = null;

        try {
            daoP = new DaoProducto(pathProperties);
            daoF = new DaoFabricante(pathProperties);

            productos = daoP.selectAll();
            fabricantes = daoF.selectAll();
            productos.forEach(System.out::println);

        } catch (SQLException error) {
            error.printStackTrace();
            System.err.println(error.getMessage());
            System.err.println(error.getErrorCode());
        }

        // ------------ SALIDA ------------
        response.setContentType("text/html;charset=UTF=8");

        StringBuilder sb = new StringBuilder();

        for (Producto producto : productos) {
            sb.append("<tr><td>" + producto.getCodigo() + "</td><td>" + producto.getNombre()
                    + "</td><td>" + producto.getPrecio() + "</td>");

            String nombreFabricante = Utils.obtenerNombreFabricante(fabricantes, producto.getCodigo_fabricante());
            sb.append("<td>" + nombreFabricante + "</td></tr>");
        }

        request.setAttribute("filas", sb.toString());
        getServletContext().getRequestDispatcher("/informe.jsp").forward(request, response);

    }

    @Override
    public void destroy() {
    }

    /**
     * @return String return the pathProperties
     */
    public String getPathProperties() {
        return pathProperties;
    }

    /**
     * @param pathProperties the pathProperties to set
     */
    public void setPathProperties(String pathProperties) {
        this.pathProperties = pathProperties;
    }

}