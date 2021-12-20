package persistence;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Atraccion> {
	public Atraccion find1(String Nombre);

}
