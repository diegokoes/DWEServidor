package es.daw.model;

public class Arco extends Arma {

  private float distancia;


  public Arco(String nombre, int damage, float distancia) {
    super(nombre, damage);
    this.distancia = distancia;
  }
  

  public Arco(String nombre, int damage) {
    super(nombre, damage);
  }


  @Override
  public String toString() {
    return super.toString() + "Arco [distancia=" + distancia + "]";
  }

}
