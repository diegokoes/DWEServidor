package es.daw.web.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import es.daw.web.models.Producto;
import java.util.ArrayList;
import es.daw.web.models.Producto;

public class DaoProducto implements Dao<Producto> {

  private Connection con;

  @Override
  public Producto select(int id) throws SQLException {
    throw new UnsupportedOperationException("Unimplemented method 'select'");
  }

  @Override
  public List<Producto> selectAll() throws SQLException {
    List<Producto> productosTodos = new ArrayList<>();
    try (PreparedStatement ps = con.prepareStatement("SELECT * FROM producto");
        ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        Producto p = new Producto();
        p.setCodigo(rs.getInt("codigo"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getFloat("precio"));
        p.setCodigo_fabricante(rs.getInt("codigo_fabricante"));
        productosTodos.add(p);
      }
      productosTodos.sort(Comparator.comparingInt(Producto::getCodigo).reversed());
      return productosTodos;

    }
  }

  @Override
  public void insert(Producto t) throws SQLException {
    throw new UnsupportedOperationException("Unimplemented method 'insert'");
  }

  @Override
  public void update(Producto t) throws SQLException {
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Producto t) throws SQLException {
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public void delete(int id) throws SQLException {
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

}