package es.daw.jakarta.models;

public class Producto {
  private Long id;
  private String nombre;
  private String tipo;
  private int precio;

  public Producto(Long id, String nombre, String tipo, int precio) {
    this.id = id;
    this.nombre = nombre;
    this.tipo = tipo;
    this.precio = precio;
  }

	public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public int getPrecio() {
    return precio;
  }

  public void setPrecio(int precio) {
    this.precio = precio;
  }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
    
	}

}