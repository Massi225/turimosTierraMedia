package services;

import java.util.List;

import model.Atraccion;
import model.TipoAtraccion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

public class AtraccionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionesDAO().findAll();
	}

	public Atraccion create(String nombre, double costo, int tiempo, int cupo,TipoAtraccion tipo,String descripcion,
            String imagen) {

		Atraccion atraccion = new Atraccion(nombre, costo, tiempo, cupo,tipo,descripcion, imagen);

		if (atraccion.isValid()) {
			AtraccionDAO attractionDAO = DAOFactory.getAtraccionesDAO();
			attractionDAO.insert(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public Atraccion update(Integer id, String nombre, double costo, int tiempo, int cupo,TipoAtraccion tipo,String descripcion,
            String imagen) {

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionesDAO();
		Atraccion atraccion = atraccionDAO.find(id);

		atraccion.setNombre(nombre);
		atraccion.setCosto(costo);
		atraccion.setTiempo(tiempo);
		atraccion.setCupo(cupo);
		atraccion.setTipo_atraccion(tipo);
		atraccion.setImagen(imagen);
		atraccion.setDescripcion(descripcion);

		if (atraccion.isValid()) {
			atraccionDAO.update(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

	public void delete(Integer id) {
		Atraccion atraccion = new Atraccion(id, " ", 0, 0, 0 , null ," ", " " );

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionesDAO();
		atraccionDAO.delete(atraccion);
	}

	public Atraccion find(Integer id) {
		return DAOFactory.getAtraccionesDAO().find(id);
	}

}
