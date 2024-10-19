package es.daw.jakarta.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import es.daw.jakarta.models.Carro;
import es.daw.jakarta.models.ItemCarro;
import es.daw.jakarta.models.Producto;
import es.daw.jakarta.services.ProductService;
import es.daw.jakarta.services.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // RECOGER LOS PARAMETROS DE LA PETICION URL
        Long id = Long.parseLong(request.getParameter("id"));
        // LOGICA DE NEGOCIO
        // comprobar si existe el producto, lo busco por id
        ProductService service = new ProductServiceImpl();

        Optional<Producto> producto = service.buscarPorId(id);

        if (producto.isPresent()) {
            ItemCarro item = new ItemCarro(1, producto.get());
            HttpSession session = request.getSession();

            Carro carro;

            // FASE 1 SIN LISTENER
            // // controlar si ya eviste el objeto carro en la sesion
            // if (session.getAttribute("carro") == null) {
            // carro = new Carro(); // guardarlo en el mismo objeto o solo se guardará el
            // ultimo
            // session.setAttribute("carro", carro);
            // } else {
            // carro = (Carro) session.getAttribute("carro");
            // }

            carro = (Carro) session.getAttribute("carro");
            carro.addItemCarro(item);

        }
        // GENERAR UNA SALIDA DE RESPUESTA
        // PENDIENTE !!!!!!!! REDIRIGIR AL SERVLET VER CARRO
        // response.sendRedirect("carro/ver"); //! esto no funciona con llamadas entre
        // ! jsp y servlet, necesitamos el contexto /
        // !dominio
        // response.sendRedirect(getServletContext().getContextPath() + "/carro/ver");
        response.sendRedirect(request.getContextPath() + "/carro/ver");

        // getServletContext().getRequestDispatcher("/carro/ver").forward(request,
        // response); // ! con la barra siempre

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}