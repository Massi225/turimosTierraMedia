package services;


import model.Usuario;
import model.nullobjects.NullUsuario;

import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class LoginService {

	public Usuario login(String nombre, String contrasenia) {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
    Usuario usuario = usuarioDAO.findByNombre(nombre);
    	
    	if (usuario.isNull() || !usuario.checkPassword(contrasenia)) {
    		usuario = NullUsuario.build();
    	}
    	return usuario;
	}
	
}
// me retorna un usuario o un usuario nulo!  si la ocntraseña es diferente o null tmb da usuario nulo!