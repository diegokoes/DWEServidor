package es.daw.jakarta.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.daw.jakarta.models.Producto;

public class ProductServiceImpl {

  private List<Producto> productos;

  public ProductServiceImpl() {
    this.productos = new ArrayList<>();
    cargarProductosDesdeCSV();
  }

  private void cargarProductosDesdeCSV() {
    String archivoCSV = getServletContext().getRealPath("/productos.csv");
    String linea;
    String separador = ",";

    try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
      while ((linea = br.readLine()) != null) {
        String[] datos = linea.split(separador);

        Producto producto = new Producto(
            Integer.parseInt(datos[0]),
            datos[1],
            datos[2],
            Double.parseDouble(datos[3]));

        productos.add(producto);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<Producto> getProductos() {
    return productos;
  }
}
