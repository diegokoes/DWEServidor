package es.daw.jakarta.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import es.daw.jakarta.models.Producto;

public class ProductServiceImpl implements ProductService{


    private static List<Producto> productos;

    @Override
    public List<Producto> listar() {

        // FORMA 1
        // return Arrays.asList(new Producto(1L, "notebook", "informática", 175000),
        // new Producto(2L, "mesa escritorio", "oficina", 10000000),
        // new Producto(3L, "teclado", "informatica", 400000));

        // FORMA 2
        if (productos == null){
            productos = new ArrayList<>();
            productos.add(new Producto(1L, "notebook", "informática", 175000));
            productos.add(new Producto(2L, "mesa escritorio", "oficina", 10000000));
            productos.add(new Producto(3L, "teclado", "informatica", 400000));
        }

        // Esto devuelve una copia profunda o superficial? demostrármelo!!!!
        // Profundo implica que los objetos de la lista también son copias (clonados)
        return new ArrayList<>(productos);
        

    }

    @Override
    public Optional<Producto> buscarProducto(String nombre) {

        // Forma API Stream

        Optional<Producto> encontrado = listar().stream()
            .filter( p -> p.getNombre().contains(nombre)).findFirst();

        return encontrado;
    }

    @Override
    public Producto buscarProducto2(String name) {
        // Forma 1: tradicional
        // Obtener la lista de productos (listar())
        // Recorrer lista
        // Voy producto a producto llamando a getName()
        // Comparo el getName con el name pasado como parámetro
        // Si coinciden devuelvo el objeto
        // Si no coinciden devuelvo null
        
        return null;
    }
    
}
