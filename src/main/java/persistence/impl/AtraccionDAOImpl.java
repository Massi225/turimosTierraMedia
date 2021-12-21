package persistence.impl;

import model.TipoAtraccion;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import persistence.AtraccionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import model.Atraccion;

	public class AtraccionDAOImpl implements AtraccionDAO {
		
		
		
		public List<Atraccion> findAll()  {
		try {
			List<Atraccion> atracciones = new ArrayList<Atraccion>();
			Connection connection = ConnectionProvider.getConnection();
			String query = "SELECT * FROM ATRACCIONES "
	;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Atraccion atraccion = toAtraccion(resultSet);
				atracciones.add(atraccion);
			}
			
			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		}
		
		public Atraccion find1(String nombre)  {

			String sql = "SELECT * FROM ATRACCIONES WHERE NOMBRE LIKE ?";
			try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();
			Atraccion atraccion = null;
			if (resultados.next()) {
				atraccion = toAtraccion(resultados);
			}
			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		}

		
		public Atraccion toAtraccion (ResultSet resultados) throws SQLException {
			int id = resultados.getInt("id");
			String nombre = resultados.getString("nombre");
			double costo =resultados.getDouble("costo");
			int tiempo = resultados.getInt("tiempo");
			int cupo =resultados.getInt("cupo");
			int tipoAtraccion =resultados.getInt(resultados.getInt("tipo_atraccion"));
			   String descripcion = resultados.getString("descripcion");
			String imagen= resultados.getString("imagen");
			TipoAtraccion tipoAtraccionString= null;
			if (tipoAtraccion == 1) {
				tipoAtraccionString = TipoAtraccion.AVENTURA;
		 }
			if (tipoAtraccion == 2) {
				tipoAtraccionString = TipoAtraccion.PAISAJE;
		 }
			if (tipoAtraccion == 3) {
				tipoAtraccionString= TipoAtraccion.DEGUSTACION;
		 }
			return new Atraccion (id,nombre,costo,tiempo,cupo,tipoAtraccionString,descripcion, imagen);
		}


		

		public List<Atraccion> findByName(String nombre) throws SQLException {
			List<Atraccion> atracciones = new ArrayList<Atraccion>();
			Connection connection = ConnectionProvider.getConnection();
			String query = "SELECT * " + "FROM atracciones "
					+ "JOIN tipo_atraccion ON tipo_atraccion.id_tipo = atracciones.tipo "
					+ "WHERE atracciones.nombre LIKE ? ";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, nombre);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Atraccion atraccion = toAtraccion(resultSet);
				atracciones.add(atraccion);
			}
			return atracciones;
		}
		public Atraccion findByName2(String nombre) {
			try {
				String sql = "SELECT * " + "FROM atracciones "
						+ "JOIN tipo_atraccion ON tipo_atraccion.id_tipo = atracciones.tipo "
						+ "WHERE atracciones.nombre LIKE ? ";
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, nombre);
				
				ResultSet resultados = statement.executeQuery();

				Atraccion atraccion = null;
				if (resultados.next()) {
					atraccion = toAtraccion(resultados);
				}

				return atraccion;
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
		}
		@Override
		public Atraccion find(Integer id) {
			String sql = "SELECT * FROM ATRACCIONES WHERE ID = ?";
			try {
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();
			Atraccion atraccion = null;
			if (resultados.next()) {
				atraccion = toAtraccion(resultados);
			}
			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		}
		
		@Override
		public int countAll() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public int insert(Atraccion atraccion)  {
			try{
				String sqlQuery = "INSERT INTO atracciones (nombre,costo,tiempo,cupo,tipo_atraccion) " + "VALUES (?,?,?,?,?)";
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			int tipo = 0;
if (atraccion.getTipo_atraccion()==(TipoAtraccion.AVENTURA)) {
	tipo = 1;
}
if (atraccion.getTipo_atraccion()==(TipoAtraccion.PAISAJE)) {
	tipo = 2;
}
if (atraccion.getTipo_atraccion()==(TipoAtraccion.DEGUSTACION)) {
	tipo = 3;
}
			statement.setString(1, atraccion.getNombre());
			statement.setDouble(2, atraccion.getCosto());
			statement.setDouble(3, atraccion.getTiempo());
			statement.setInt(4, atraccion.getCupo());
			statement.setInt(5, tipo);
			


			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated;
		}catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
		
		@Override
		


		public int update(Atraccion atraccion)  {
		
			try {
				String sqlQuery = "UPDATE atraccion" + "WHERE id = ?" + "SET nombre = ?, " + "COSTO = ?, " + "tiempo = ?,"
					+ "CUPO = ?"+ "tipo_atraccion = ?" + " descripcion = ?";
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			int tipo = 0;
if (atraccion.getTipo_atraccion()==(TipoAtraccion.AVENTURA)) {
	tipo = 1;
}
if (atraccion.getTipo_atraccion()==(TipoAtraccion.PAISAJE)) {
	tipo = 2;
}
if (atraccion.getTipo_atraccion()==(TipoAtraccion.DEGUSTACION)) {
	tipo = 3;
}
			
			statement.setInt(1, atraccion.getId());
			
			statement.setString(2, atraccion.getNombre());
			statement.setDouble(3, atraccion.getCosto());
			statement.setDouble(4, atraccion.getTiempo());
			statement.setInt(5, atraccion.getCupo());
			statement.setInt(6, tipo);
			statement.setString(7, atraccion.getDescripcion());
			int rowsUpdate = statement.executeUpdate();
			return rowsUpdate;
			}catch (Exception e) {
			throw new MissingDataException(e);
		}	

		}
		@Override
		public int delete(Atraccion atraccion) {
			try {
			String sqlDeleteQuery = "DELETE FROM atracciones WHERE ID = ? ";
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlDeleteQuery);
			statement.setInt(1, atraccion.getId());
			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated;
		}catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	}
		
/*


		public int countAll() throws SQLException {
			String sqlQuery = "SELECT COUNT() AS total " + "FROM atracciones ";
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			int total = resultSet.getInt("total");
			return total;
		}
	*/
	


