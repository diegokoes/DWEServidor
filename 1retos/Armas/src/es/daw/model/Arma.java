package es.daw.model;

public abstract class Arma {
  private String nombre;
  private int damage;
  private static int contador; // comun para todos los objetos de la misma clase

  public Arma(String nombre, int damage) {
    this.damage = damage;
    this.nombre = nombre;
    contador++;
  }

  // setters y getters
  public void setDamage(int damage) {
    this.damage = damage;
  }

  public String getNombre() {
    return nombre;
  }

  public int getDamage() {
    return damage;
  }

  public static int getContador() {
    return contador;
  }

  @Override
  public String toString() {
    return "Arma [nombre=" + nombre + ", damage=" + damage + "]";
  }

}
