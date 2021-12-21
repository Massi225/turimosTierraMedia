package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.TipoAtraccion;
import model.Usuario;
import model.nullobjects.NullUsuario;

import persistence.UsuarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class UsuarioDAOImpl implements UsuarioDAO {

	public int insert(Usuario user) {
		try {
			String sql = "INSERT INTO USUARIOS (NOMBRE, MONEDAS, TIEMPO, PREFERENCIA, CONTRASENIA , IMAGEN ,ADMIN) VALUES (?, ?, ?, ?, ? ,?,?)";
			Connection conn = ConnectionProvider.getConnection();

			int tipo = 0;
if (user.getPreferencia()==(TipoAtraccion.AVENTURA)) {
	tipo = 1;
}
if (user.getPreferencia()==(TipoAtraccion.PAISAJE)) {
	tipo = 2;
}
if (user.getPreferencia()==(TipoAtraccion.DEGUSTACION)) {
	tipo = 3;
}
  int admin=0;
if(user.getAdmin() == true) {
	admin=1;
}
		
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getNombre());
			statement.setDouble(2, user.getMonedas());
			statement.setDouble(3, user.getTiempo());
			statement.setInt(4, tipo);
			statement.setString(5, user.getContrasenia());
			statement.setString(6, user.getImagen());
			statement.setDouble(7, admin);
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Usuario user) {
		try {
			String sql = "UPDATE USUARIOS SET MONEDAS = ?, TIEMPO = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, user.getMonedas());
			statement.setDouble(2, user.getTiempo());
			statement.setDouble(3, user.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(Usuario user) {
		try {
			String sql = "DELETE FROM USUARIOS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, user.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Usuario findByNombre(String nombre) {
		try {
			String sql = "SELECT * FROM USUARIOS WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUsuario.build();

			if (resultados.next()) {
				user = toUser(resultados);
			}

			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MissingDataException(e);
		}
	}

	public Usuario find(Integer id) {
		try {
			String sql = "SELECT * FROM USUARIOS WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUsuario.build();

			if (resultados.next()) {
				user = toUser(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM USUARIOS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM USUARIOS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUser(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUser(ResultSet userRegister) throws SQLException {
		 int tipoAtraccion = userRegister.getInt(5);
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
		
		return new Usuario(userRegister.getInt(1), userRegister.getString(2), userRegister.getDouble(3),
				userRegister.getInt(4),tipoAtraccionString, userRegister.getString(6), userRegister.getBoolean(7), userRegister.getString(8));
	}

}
