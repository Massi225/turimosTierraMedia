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
	import model.PromoPorcentual;
	import model.PromocionAbsoluta;
	import model.PromocionAxB;
	import model.Promocion;
	import model.TipoAtraccion;
import model.User;
import model.Usuario;

import model.nullobjects.NullUser;
import persistence.impl.AtraccionesDao;

	public class PromocionDAOImpl implements PromocionDAO {
		
		public List<Promocion> findAll() {
			List<Promocion> promociones = new ArrayList<Promocion>();
			try {
			
			Connection connection = ConnectionProvider.getConnection();
			String query = "SELECT * FROM promociones JOIN tipo_atraccion ON tipo_atraccion.id_tipo = promociones.tipo_atraccion ";
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
			String tipoPromocion = String.valueOf(resultSet.getString("tipo_promocion"));

			String nombrePromo = String.valueOf(resultSet.getString("nombre"));

			TipoAtraccion tipoAtraccion = TipoAtraccion.valueOf(resultSet.getString("tipo"));

			AtraccionesDao atr = DAOFactory.getAtraccionesDAO();

			List<Atraccion> atracIncluidas = new ArrayList<Atraccion>();

			;
			
			if (resultSet.getString(3) != null) {
				atracIncluidas.add( atr.findByName2(resultSet.getString(3)));
			}
			if (resultSet.getString(4) != null) {
				atracIncluidas.add(atr.findByName2(resultSet.getString(4)));
			}
			Promocion promocion = null;
			
		if (tipoPromocion.equalsIgnoreCase("porcentual")) {

	          promocion = new PromoPorcentual(resultSet.getInt("id_promocion"), atracIncluidas, resultSet.getDouble(6),
						nombrePromo, tipoAtraccion);
						
			} else if (tipoPromocion.equalsIgnoreCase("AxB")) {

				Atraccion ataxb =  atr.findByName2(resultSet.getString(9));
				 promocion = new PromocionAxB(resultSet.getInt("id_promocion"), atracIncluidas, ataxb, nombrePromo,
						tipoAtraccion);
			} else if (tipoPromocion.equalsIgnoreCase("Absoluta")) {

				promocion = new PromocionAbsoluta(resultSet.getInt("id_promocion"), atracIncluidas, resultSet.getDouble(7),
						nombrePromo, tipoAtraccion);
		}
			return promocion;
		}


		public List<Promocion> findByName(String nombre)  {
			
			try{
				List<Promocion> promociones = new ArrayList<Promocion>();
			
			Connection connection = ConnectionProvider.getConnection();
			String query = "SELECT * FROM promociones "
					+ "JOIN tipo_atraccion ON tipo_atraccion.id_tipo = promociones.tipo_atraccion WHERE promociones.nombre LIKE ? ";
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
		
		public Promocion find(Integer id_promocion) {
			try {
				String sql = "SELECT * FROM PROMOCIONES JOIN tipo_atraccion ON tipo_atraccion.id_tipo = promociones.tipo_atraccion WHERE id_promocion = ? ";
				Connection conn = ConnectionProvider.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, id_promocion);
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