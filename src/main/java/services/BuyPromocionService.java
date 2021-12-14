package services;

import java.util.HashMap;
import java.util.Map;
import model.Promocion;
import model.Attraction;
import model.User;
import persistence.PromocionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class BuyPromocionService {
	
	PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	UserDAO userDAO = DAOFactory.getUserDAO();

	public Map<String, String> buy(Integer userId, Integer promocionId) {
		Map<String, String> errors = new HashMap<String, String>();

		User user = userDAO.find(userId);
		Promocion promocion = promocionDAO.find(promocionId);

		//if (!promocion.canHost(1)) {
		//	errors.put("attraction", "No hay cupo disponible");
		//}
		if (!user.canAffordPromo(promocion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.canAttendPromo(promocion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.addToItinerary(promocion);
			//promocion.host(1);

			promocionDAO.update(promocion);
			userDAO.update(user);
		}

		return errors;

	}

}



