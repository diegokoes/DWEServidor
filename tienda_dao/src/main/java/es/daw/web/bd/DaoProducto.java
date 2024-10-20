package es.daw.web.bd;

import java.sql.SQLException;
import java.util.List;

import es.daw.web.models.Producto;

public class DaoProducto implements Dao<Producto> {

  @Override
  public Producto select(int id) throws SQLException {
    throw new UnsupportedOperationException("Unimplemented method 'select'");
  }

  @Override
  public List<Producto> selectAll() throws SQLException {
    throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
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