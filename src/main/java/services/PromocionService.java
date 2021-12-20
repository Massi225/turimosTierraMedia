package services;


	import java.util.ArrayList;
import java.util.List;
import model.Atraccion;
import model.Promocion;
import model.TipoAtraccion;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;


public class PromocionService {

		public List<Promocion> list() {
			return DAOFactory.getPromocionDAO().findAll();
		}

		
		
		public Promocion create( String nombre, String tipo_promocion ,double bonificacion, List<Atraccion> attracciones) {
			
	  
	      Promocion  promocion= new Promocion (nombre , tipo_promocion, bonificacion , attracciones);
	          
	       if (promocion.isValid()) {
				PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
				promocionDAO.insert(promocion);
				// XXX: si no devuelve "1", es que hubo más errores
			}

			return promocion;
		}

		public Promocion update(int id,String nombre, String tipo_promocion ,double bonificacion, List<Atraccion> atracciones) {

			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			Promocion promocion = promocionDAO.find(id);

			promocion.setNombre(nombre);
			promocion.setTipo_promocion(tipo_promocion);
			promocion.setBonificacion(bonificacion);
			promocion.setAtracciones(atracciones);
		    promocion.setCosto();
		    promocion.setCupos();
		    promocion.setDuracion();
			
		    
			if (promocion.isValid()) {
				promocionDAO.update(promocion);
				// XXX: si no devuelve "1", es que hubo más errores
			}

			return promocion;
		}

public void delete(Integer id) {
	
	
	
			Promocion promocion = new Promocion(id, " ", null, 0.0, null);

			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.delete(promocion);
		}

		public Promocion find(Integer id) {
			return DAOFactory.getPromocionDAO().find(id);
		}

		
	}

