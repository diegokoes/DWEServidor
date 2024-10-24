package es.daw.jakarta.models;

import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

// 1 para convertir carro en un java bean y utilizar en cdi
//! OBLIGATORIO INDICAR EL SCOPE @...
@SessionScoped
// @Named("miCarro") para especificar el 'ALIAS'
@Named // la referencia sera por 'carro' mismo nombre que la clase, pero primera letra
       // en minuscula

// 2. Obligatorio implementar serializable 

public class Carro implements Serializable {
    // private List<ItemCarro> items = new ArrayList<>();
    private List<ItemCarro> items;
    // 3. OBLIGATORIO QUE TENG AUN CONSTRUCTOR VACÍO (SIN PARAMETROS)
    public Carro() {
        items = new ArrayList<>();
    }

    public List<ItemCarro> getItems() {
        return items;
    }

    public void addItemCarro(ItemCarro itemCarro) {
        // Hay que controlar si existe ya previamente el item en el carro
        if (items.contains(itemCarro)) {
            // Si existe incremento la cantidad en 1
            int pos = items.indexOf(itemCarro);
            ItemCarro item = items.get(pos);
            item.setCantidad(item.getCantidad() + 1);
        } else {
            // Si no existe añado el item del Carro
            items.add(itemCarro);
        }
    }

    public int getTotal() {
        // FORMA IMPERATIVA
        // Recorrer los items del carro
        // Coger el precio de cada item
        // sumatorio del precio
        // devolver el total

        // int precioTotal = 0;

        // for (ItemCarro itemCarro : items) {
        // precioTotal += itemCarro.getImporte();
        // }

        // return precioTotal;

        // FORMA API STREAM (FUNCIONAL)
        // Dame el sumatorio de todos los precios de los productos de la lista
        // return items.stream().mapToInt(i -> i.getImporte()).sum();
        return items.stream().mapToInt(ItemCarro::getImporte).sum();

    }

}