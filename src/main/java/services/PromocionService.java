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
			Promocion TipoAtraccion=null;
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
				promocionDAO.insert(promocion);
				// XXX: si no devuelve "1", es que hubo más errores
			}

			return promocion;
		}
/*
		public Promocion update(Integer idPromocion, String atraccion1,String atraccion2,String dependeDeLapromo, String nombre,
				TipoAtraccion tipoAtraccion , String tipoPromocion) {

			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			Promocion promocion = promocionDAO.find(idPromocion);
            if ()
			Promocion.setNombre(nombre);
			Promocion;
			Promocion.setDuration(duration);
			Promocion.setCapacity(capacity);

			if (Promocion.isValid()) {
				promocionDAO.update(promocion);
				// XXX: si no devuelve "1", es que hubo más errores
			}

			return attraction;
		}*/

public void delete(Integer id , String tipoPromocion) {
	
	
	
			Promocion promocion = new Promocion(id, null, null, null, null, null,null , null);

			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.delete(promocion);
		}

		public Promocion find(Integer id) {
			return DAOFactory.getPromocionDAO().find(id);
		}

		
	}

