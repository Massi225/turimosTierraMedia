package persistence.impl;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.PromocionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.GenericDAO;
import persistence.commons.MissingDataException;
import model.Atraccion;
import model.Promocion;
import model.TipoAtraccion;
import model.Usuario;
import model.nullobjects.NullUsuario;
import persistence.AtraccionDAO;

	public class PromocionDAOImpl implements PromocionDAO {
		
		public List<Promocion> findAll() {
			List<Promocion> promociones = new ArrayList<Promocion>();
			try {
			
			Connection connection = ConnectionProvider.getConnection();
			String query = "SELECT * FROM promociones  ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				promociones.add(toPromocion(resultSet));
			}
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		}

		private Promocion toPromocion(ResultSet resultSet) throws SQLException {
			int id = resultSet.getInt("id");
			String nombrePromo = String.valueOf(resultSet.getString("nombre"));
			String atraccion1 = String.valueOf(resultSet.getString("atraccion1"));
			String atraccion2 = String.valueOf(resultSet.getString("atraccion2"));
			// int tipo_atraccion =Integer.valueOf(resultSet.getString("tipo_atracciones"));
			double bonificacion =resultSet.getDouble("bonificacion");
			String atraccionGratis = resultSet.getString("atraccionGratis");
			String tipo_promocion = resultSet.getString("tipo_promocion");
		/*	TipoAtraccion tipoAtraccionString= null;
			if (tipo_atraccion == 1) {
				tipoAtraccionString = TipoAtraccion.AVENTURA;
		 }
			if (tipo_atraccion == 2) {
				tipoAtraccionString = TipoAtraccion.PAISAJE;
		 }
			if (tipo_atraccion == 3) {
				tipoAtraccionString= TipoAtraccion.DEGUSTACION;
			}
			*/
			
			AtraccionDAO atr = DAOFactory.getAtraccionesDAO();

			List<Atraccion> atracIncluidas = new ArrayList<Atraccion>();

			;
			
			if (atraccion1 != null) {
				atracIncluidas.add( atr.find1(resultSet.getString("atraccion1")));
			}
			if (atraccion2 != null) {
				atracIncluidas.add(atr.find1(resultSet.getString("atraccion2")));
			}
		    if (atraccionGratis != null) {
				atracIncluidas.add(atr.find1(resultSet.getString("atraccionGratis")));
			}
			
		    Promocion promocion = new Promocion(id,nombrePromo,tipo_promocion , bonificacion ,atracIncluidas);
			
		
			return promocion;
		}


		public List<Promocion> findByName(String nombre)  {
			
			try{
				List<Promocion> promociones = new ArrayList<Promocion>();
			
			Connection connection = ConnectionProvider.getConnection();
			String query = "SELECT * FROM promociones  WHERE promociones.nombre LIKE ? ";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, nombre);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Promocion promocion = toPromocion(resultSet);
				promociones.add(promocion);
			}
			return promociones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		}

		public int delete(Promocion promocion) {
			String sqlDeleteQuery = "DELETE FROM promociones WHERE promociones.nombre LIKE ? ";
			Connection connection;
			try {
				connection = ConnectionProvider.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlDeleteQuery);
			statement.setString(1, promocion.getNombre());
			int rowsUpdated = statement.executeUpdate();
			
			return rowsUpdated;
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
		}

		public int countAll() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int insert(Promocion t) {
			// TODO Auto-generated method stub
			return 0;
		}

		public int update(Promocion t)  {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public Promocion find(Integer id) {
			try {
				String sql = "SELECT * FROM PROMOCIONES  WHERE id = ? ";
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, id);
				ResultSet resultados = statement.executeQuery();

				Promocion promocion = null;

				if (resultados.next()) {
					promocion = toPromocion(resultados);
				}

				return promocion;
			} catch (Exception e) {
				throw new MissingDataException(e);
			}
		}

		
	}