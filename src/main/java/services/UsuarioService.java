package services;

import java.util.List;

import model.Atraccion;
import model.TipoAtraccion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class UsuarioService {

	public List<Usuario> list() {
		return DAOFactory.getUsuarioDAO().findAll();
	}

	public Usuario create(String nombre, double monedas, int tiempo, TipoAtraccion tipoAtraccion, String contrasenia, boolean admin , String imagen ) {
		Usuario usuario = new Usuario(-1, nombre, monedas, tiempo, tipoAtraccion, contrasenia, admin, imagen);
		usuario.setContrasenia(contrasenia);

		if (usuario.isValid()) {
			DAOFactory.getUsuarioDAO().insert(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return usuario;
	}
	
	public void delete(int id) {
		Usuario usuario = new Usuario(id, " ", 0.0, 0, null , " " , false ," ");
		
		
	
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.delete(usuario);
	}

	public Usuario find(Integer id) {
		return DAOFactory.getUsuarioDAO().find(id);
	}

}

