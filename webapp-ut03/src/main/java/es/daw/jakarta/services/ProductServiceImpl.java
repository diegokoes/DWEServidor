package es.daw.jakarta.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.daw.jakarta.models.Producto;

public class ProductServiceImpl {

  private List<Producto> productos;
  private String archivoCSV;

  public ProductServiceImpl(String archivoCSV) {
    this.productos = new ArrayList<>();
    this.archivoCSV = archivoCSV;
    cargarProductosDesdeCSV();
  }

  private void cargarProductosDesdeCSV() {
    String linea;
    String separador = ",";

    try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
      while ((linea = br.readLine()) != null) {
        String[] datos = linea.split(separador);

        Producto producto = new Producto(
            Long.parseLong(datos[0]),  
            datos[1],
            datos[2],
            Integer.parseInt(datos[3])); 

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
