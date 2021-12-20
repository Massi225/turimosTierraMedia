package services;

import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class BuyAtraccionService {

	AtraccionDAO atraccionDAO = DAOFactory.getAtraccionesDAO();
	UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();

	public Map<String, String> buy(int usuarioId, int atraccionId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario usuario = usuarioDAO.find(usuarioId);
		Atraccion atraccion = atraccionDAO.find(atraccionId);

		if (!atraccion.canHost(1)) {
			errors.put("atraccion", "No hay cupo disponible");
		}
		if (!usuario.canAfford(atraccion)) {
			errors.put("usuario", "No tienes dinero suficiente");
		}
		if (!usuario.canAttend(atraccion)) {
			errors.put("usuario", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			usuario.addToItinerary(atraccion);
			atraccion.host(1);

			atraccionDAO.update(atraccion);
			usuarioDAO.update(usuario);
		}

		return errors;

	}

}
