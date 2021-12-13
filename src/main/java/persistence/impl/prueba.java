package persistence.impl;
import java.sql.SQLException;

import persistence.commons.DAOFactory;
import services.UserService;
import persistence.impl.PromocionDAOImpl;

public class prueba {

	public static void main(String[] args) throws SQLException {
		//System.out.println(1);
		//DAOFactory.getPromocionDAO().findAll();
		System.out.println(DAOFactory.getPromocionDAO().find(2));
		//DAOFactory.getAtraccionesDAO().findByName("Erebor");
		//System.out.println(DAOFactory.getAtraccionesDAO().findByName("Erebor"));
		}
	
		
	}


