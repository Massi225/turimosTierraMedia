package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Promocion  {
	protected int idPromocion;
	protected String nombre;
	protected List<Atraccion> atracciones;
	protected TipoAtraccion tipoAtraccion;
	protected Double costo;
	protected Double tiempo;

	public Promocion(int idPromocion, String nombre, ArrayList<Atraccion> atracciones, TipoAtraccion tipoAtraccion) {
		this.idPromocion = idPromocion;
		this.nombre = nombre;
		this.setCosto(atracciones);
		this.setTiempo(atracciones);
		this.tipoAtraccion = tipoAtraccion;
	}

	public Promocion(int idProducto, double costo, double tiempo, String nombreAtraccion,
			TipoAtraccion tipoDeAtraccion) {
		this.idPromocion = idProducto;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.tipoAtraccion = tipoDeAtraccion;
	}

	public void setTiempo(ArrayList<Atraccion> atrIncluidas) {
		double tiempo = 0;
		for (int i = 0; i < atrIncluidas.size(); i++) {
			tiempo += atrIncluidas.get(i).getDuracion();
		}
		this.tiempo = tiempo;
	}

	public void setCosto(ArrayList<Atraccion> atrIncluidas) {
		double costo = 0;
		for (int i = 0; i < atrIncluidas.size(); i++) {
			costo += atrIncluidas.get(i).getPrecio();
		}
		this.costo = costo;
	}

	public double getPrecio() {
		double costoTotal = 0.0;
		for (Atraccion atraccion : atracciones) {
			costoTotal += atraccion.getPrecio();
		}
		return costoTotal;
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

	public int getIdPromocion() {
		return idPromocion;
	}


	protected abstract String tipoPromocion();

	protected abstract String visitaGratis();
	}