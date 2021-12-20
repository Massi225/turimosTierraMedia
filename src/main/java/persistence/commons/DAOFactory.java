package persistence.commons;


import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.UsuarioDAO;
import persistence.impl.AtraccionDAOImpl;

import persistence.impl.PromocionDAOImpl;
import persistence.impl.UsuarioDAOImpl;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static PromocionDAO getPromocionDAO() {
		return new PromocionDAOImpl();
}
	public static AtraccionDAO getAtraccionesDAO() {
		return new AtraccionDAOImpl();
}
	
	
	}