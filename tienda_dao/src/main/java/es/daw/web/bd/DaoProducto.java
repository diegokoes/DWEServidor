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

  public DaoProducto(String dbSettingsPropsFilePath) throws SQLException {
    super();
    con = DBConnection.getConnection(dbSettingsPropsFilePath);
  }

  @Override
  public Producto select(int id) throws SQLException {
    return null;

  }

  @Override
  public List<Producto> selectAll() throws SQLException {
    List<Producto> productosTodos = new ArrayList<>();
    try (PreparedStatement ps = con.prepareStatement("SELECT * FROM producto");
        ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        Producto producto = new Producto();
        producto.setCodigo(rs.getInt("codigo"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecio(rs.getFloat("precio"));
        producto.setCodigo_fabricante(rs.getInt("codigo_fabricante"));
        productosTodos.add(producto);
      }

      // productosTodos.sort(Comparator.comparingInt(Producto::getCodigo).reversed());
      return productosTodos;
    }
  }

  @Override
  public void insert(Producto t) throws SQLException {

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