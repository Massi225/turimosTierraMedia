package persistence.impl;
import java.sql.SQLException;

import persistence.commons.DAOFactory;
import services.UserService;
import persistence.impl.PromocionDAOImpl;
import model.Promocion;
public class prueba {

	public static void main(String[] args) throws SQLException {
		//System.out.println(1);
		//DAOFactory.getPromocionDAO().findAll();
		//System.out.println(DAOFactory.getPromocionDAO().findAll());
		System.out.println(DAOFactory.getPromocionDAO().findAll());
		//System.out.println(DAOFactory.getAtraccionesDAO().findByName("Erebor"));
		//System.out.println(DAOFactory.getAtraccionesDAO().findAll());
		//Promocion.getPreferenciaPromo2(1);
		//System.out.println(Promocion.getPreferenciaPromo2(1));
	
		}
	
		
	}


