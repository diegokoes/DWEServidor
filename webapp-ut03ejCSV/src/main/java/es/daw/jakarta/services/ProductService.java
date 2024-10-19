package es.daw.jakarta.services;

import java.util.List;

import es.daw.jakarta.models.Producto;

public interface ProductService {
  // metodo abstracto, no es necesasrio poner la palabra reservada abstract
  public List<Producto> listar();
  

}