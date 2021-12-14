package services;


	import java.util.ArrayList;
import java.util.List;

import model.Atraccion;
import model.Attraction;
import model.PromoPorcentual;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.TipoAtraccion;
import persistence.AttractionDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;
import persistence.impl.AtraccionesDao;

public class PromocionService {

		public List<Promocion> list() {
			return DAOFactory.getPromocionDAO().findAll();
		}

		public Promocion create(String atraccion1,String atraccion2,String dependeDeLapromo, String nombre,
				TipoAtraccion tipoAtraccion , String tipoPromocion) {
			Promocion promocion=null;
			AtraccionesDao atr = DAOFactory.getAtraccionesDAO();
	       List<Atraccion> lista = new ArrayList <Atraccion>();
	          lista.add( atr.findByName2(atraccion1));
	          lista.add( atr.findByName2(atraccion2));
	          
	       
	          if (tipoPromocion.equalsIgnoreCase("porcentual")) {
                   
		          promocion = new PromoPorcentual( lista, Integer.valueOf(dependeDeLapromo),
							nombre, tipoAtraccion);
							
				} else if (tipoPromocion.equalsIgnoreCase("AxB")) {

					Atraccion ataxb =  atr.findByName2(dependeDeLapromo);
					
					 promocion = new PromocionAxB( lista, ataxb, nombre,
							tipoAtraccion);
				
				} else if (tipoPromocion.equalsIgnoreCase("Absoluta")) {

					promocion = new PromocionAbsoluta( lista, Double.valueOf(dependeDeLapromo),
							nombre, tipoAtraccion);
			}
             
			if (promocion.isValid()) {
				PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
				promocionDAO.insert(attraction);
				// XXX: si no devuelve "1", es que hubo más errores
			}

			return promocion;
		}

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

