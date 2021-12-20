package services;

import java.util.HashMap;
import java.util.Map;
import model.Promocion;
import model.Atraccion;
import model.Usuario;
import persistence.PromocionDAO;

import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class BuyPromocionService {
	
	PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();

	public Map<String, String> buy(Integer userId, Integer promocionId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = usuarioDAO.find(userId);
		Promocion promocion = promocionDAO.find(promocionId);

		if (!promocion.canHost(1)) {
			errors.put("atraccion", "No hay cupo disponible");
		}
		if (!user.canAffordPromo(promocion)) {
			errors.put("usuario", "No tienes dinero suficiente");
		}
		if (!user.canAttendPromo(promocion)) {
			errors.put("usuario", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.addToItinerary(promocion);
			promocion.host(1);

			promocionDAO.update(promocion);
			usuarioDAO.update(user);
		}

		return errors;

	}

}



