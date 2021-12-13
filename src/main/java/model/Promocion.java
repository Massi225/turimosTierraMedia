package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Promocion  {
	protected int idPromocion;
	protected String nombre;
	protected List<Atraccion> atracciones;
	protected TipoAtraccion tipoAtraccion;
	protected Double costo;
	protected Double tiempo;

	private Map<String, String> errors;
	
		
	public TipoAtraccion getTipoAtraccion() {
		return tipoAtraccion;
	}

	public Double getCosto() {
		return costo;
	}

	public Double getTiempo() {
		return tiempo;
	}

	
	public Promocion( String nombre, List<Atraccion> atracciones, TipoAtraccion tipoAtraccion) {
		super();
		this.nombre = nombre;
		this.setCosto(atracciones);
		this.setTiempo(atracciones);
		this.tipoAtraccion = tipoAtraccion;
	}
	public Promocion(int idPromocion, String nombre, List<Atraccion> atracciones, TipoAtraccion tipoAtraccion) {
		this.idPromocion = idPromocion;
		this.nombre = nombre;
		this.setCosto(atracciones);
		this.setTiempo(atracciones);
		this.tipoAtraccion = tipoAtraccion;
	//	private Map<String, String> errors;
	}
/*
	public Promocion(int idProducto, double costo, double tiempo, String nombreAtraccion,
			TipoAtraccion tipoDeAtraccion) {
		this.idPromocion = idProducto;
		this.nombre = nombreAtraccion;
		this.costo = costo;
		this.tiempo = tiempo;
		this.tipoAtraccion = tipoDeAtraccion;
	}

	public Promocion (int idProducto, double costo, double tiempo, String nombreAtraccion){
this.idPromocion = idProducto;
this.nombre = nombreAtraccion;
this.costo = costo;
this.tiempo = tiempo;
	}
	
	
	public Promocion(String nombre , double costo , double tiempo , List<Atraccion> atracciones, TipoAtraccion tipo) {
		this.nombre = nombre;
		this.getPrecio();
		this.tiempo = tiempo;
		this.tipoAtraccion = tipo;
		this.atracciones = atracciones;
		
	}
	*/
	/*
public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	/*public void validate() {
		errors = new HashMap<String, String>();

		if ( costo<= 0) {
			errors.put("costo", "Debe ser positivo");
		}
		if (tiempo <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
		if (tiempo > 60) {
			errors.put("tiempo", "Excede el tiempo máximo");
		}
		if (capacity <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}*/
	
	public void setTiempo(List<Atraccion> atrIncluidas) {
		double tiempo = 0;
		for (int i = 0; i < atrIncluidas.size(); i++) {
			tiempo += atrIncluidas.get(i).getDuracion();
		}
		this.tiempo = tiempo;
	}

	public Promocion(int idPromocion, String nombre, List<Atraccion> atracciones) {
		super();
		this.idPromocion = idPromocion;
		this.nombre = nombre;
		this.atracciones = atracciones;
	}

	public void setCosto(List<Atraccion> atrIncluidas) {
		double costo = 0;
		for (int i = 0; i < atrIncluidas.size(); i++) {
			costo += atrIncluidas.get(i).getPrecio();
		}
		this.costo = costo;
	}

	public double getPrecio() {
		double costoTotal = 0.0;
		for (Atraccion atraccion : this.atracciones) {
			costoTotal += atraccion.getPrecio();
		}
		return costoTotal;
	}

	public boolean isNull() {
		return false;
	}
	public String getNombre() {
		return this.nombre;
	}

	public List<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	public String getLugares() {
		String lugares = " ";
		for (Atraccion i : this.atracciones) {
			lugares = lugares + i.getNombre();
		}
		return lugares;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCupo() {
		int cupo = 0;
		for (Atraccion i : this.getAtracciones()) {
			if (cupo == 0) {
				cupo = i.getCupoPersonas();
			}
			if (cupo > i.getCupoPersonas()) {
				cupo = i.getCupoPersonas();
			}
		}
		return cupo;
	}

	public void setCupo() {
		for (Atraccion i : this.atracciones)
			i.setCupoPersonas();
	}

	public boolean hayCupo() {
		boolean resultado = true;
		for (Atraccion i : this.getAtracciones()) {
			if (i.getCupoPersonas() == 0) {
				resultado = false;
				break;
			}
		}
		return resultado;
	}

	public double getTiempoPromocion() {
		double tiempo = 0.0;
		for (Atraccion atraccionesEnPromo : atracciones) {
			tiempo += atraccionesEnPromo.getDuracion();
		}
		return tiempo;
	}

	@Override
	public String toString() {
		return " nombre +  atracciones ";
	}

	public TipoAtraccion getPreferenciaPromo() {
		TipoAtraccion preferencia = null;
		for (Atraccion atraccionesEnPromo : atracciones) {
			preferencia = atraccionesEnPromo.getTipo();
		}
		return preferencia;
	}
	public static TipoAtraccion getPreferenciaPromo2(int n) {
		TipoAtraccion preferencia = null;
		switch(n) {
		  case 1:
			  preferencia = TipoAtraccion.PAISAJE;
			  break;
		  case 2:
			  preferencia = TipoAtraccion.AVENTURA;
			  break;
		  case 3:
			  preferencia = TipoAtraccion.DEGUSTACION;
			  break;
			  default :
				  break;
		}
		return preferencia;
	}
	public int getIdPromocion() {
		return idPromocion;
	}


	protected abstract String tipoPromocion();

	protected abstract String visitaGratis();
	}