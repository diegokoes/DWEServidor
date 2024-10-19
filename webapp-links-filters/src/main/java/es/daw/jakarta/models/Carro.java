package es.daw.jakarta.models;

import java.util.ArrayList;
import java.util.List;

public class Carro {

  private List<ItemCarro> items; // new ArrayList...
  // lO DE INICIALIZAR SOLO EN CONSTRUCTOR

  public Carro(List<ItemCarro> items) {
    this.items = new ArrayList<>();
    // private List<Item
  }
  

  public Carro() {
    this.items = new ArrayList<>();
  }


  public List<ItemCarro> getItems() {
    return items;
  }

  public void addItemCarro(ItemCarro itemCarro) {
    // hay que controlar si existe ya previamente el item en el carro
    if (items.contains(itemCarro)) {
      // si existe incremento la cantidad en 1
      int pos = items.indexOf(itemCarro);
      ItemCarro item = items.get(pos);
      item.setCantidad(item.getCantidad() + 1);
    } else {
      // si no existe añado el item del Carro
      items.add(itemCarro);
    }
  }

  public int getTotal() {
    // FORMA IMPERATIVA
    // recorrer los items del carro
    // coger el preico de cada item
    // sumatorio del precio
    // devolver el total
    // int precioTotal = 0;

    // for(ItemCarro itemCarro : items) {
    // precioTotal+= itemCarro.getImporte();
    // }
    // return precioTotal;

    // FORMA API STREAM (FUNCIONAL)
    // dame el sumatorio de todos los precios de la lista
    return items.stream().mapToInt(i -> i.getImporte()).sum();
    // interfaces de un solo metodo abstracto? aclararlo
    //return items.stream().mapToInt(ItemCarro::getImporte).sum();


  }
}
