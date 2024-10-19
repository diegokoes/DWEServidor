package es.daw.model;
public class EspadaHielo extends Espada{

  public EspadaHielo(String nombre, int damage, boolean afilada) {
    super(nombre, damage, afilada);
  }

  @Override
  public void cortar() {
    System.out.println("Soy de hielo y solo corto en invierno");
  }

  



}
