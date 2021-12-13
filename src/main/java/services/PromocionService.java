package services;


	import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.Attraction;
import model.PromoPorcentual;
import model.Promocion;
import model.TipoAtraccion;
import persistence.AttractionDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;

public class PromocionService {

		public List<Promocion> list() {
			return DAOFactory.getPromocionDAO().findAll();
		}

		/*public Promocion create(String nombre, String atraccion1, String atraccion2, TipoAtraccion tipoatraccion, int numero) {
	
             if (numero == 1) {  
			Promocion promocion = new PromoPorcentual(nombre, atracciones, tipoatraccion);
             }
             if(numero==2)
            	 Promocion promocion = new PromoPorcentual(nombre, atracciones, tipoatraccion);
             if (numero ==3) {
            	 {
            		Promocion promocion = new PromoPorcentual(nombre, atracciones, tipoatraccion);
            	 }
             }
			if (promocion.isValid()) {
				PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
				promocionDAO.insert(attraction);
				// XXX: si no devuelve "1", es que hubo más errores
			}

			return attraction;
		}
*/
	/*	public Promocion update(Integer idPromocion, String nombre, ArrayList<Atraccion> atracciones, TipoAtraccion tipoAtraccion) {

			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			Promocion promocion = promocionDAO.find(idPromocion);

			Promocion.setName(name);
			Promocion.setCost(cost);
			Promocion.setDuration(duration);
			Promocion.setCapacity(capacity);

			if (attraction.isValid()) {
				attractionDAO.update(attraction);
				// XXX: si no devuelve "1", es que hubo más errores
			}

			return attraction;
		}
*/
/*public void delete(Integer id) {
			Promocion Promocion = new Promocion(id, null, null, null, null);

			AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
			attractionDAO.delete(attraction);
		}

		public Attraction find(Integer id) {
			return DAOFactory.getAttractionDAO().find(id);
		}
*/
	}

