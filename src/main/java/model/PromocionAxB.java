package model;

import java.util.ArrayList;
import java.util.List;

public class PromocionAxB extends Promocion {
	private Atraccion atrGratis;
	private List<Atraccion> atracciones;
	private String tipoPromocion;

	public PromocionAxB(int idPromo, List<Atraccion> atracciones, Atraccion atrGratis, String nombre,
			TipoAtraccion tipoAtraccion) {
		super(idPromo, nombre, atracciones, tipoAtraccion);
		this.atrGratis = atrGratis;
		this.atracciones = atracciones;
		this.atracciones.add(atrGratis);
		this.tipoPromocion = "AxB";
	}

	@Override
	public double getPrecio() {
		double valor = 0;
		for (int x = 0; x < atracciones.size() - 1; x++) {
			valor += atracciones.get(x).getPrecio();
		}
		return valor;
	}

	@Override
	public String visitaGratis() {
		return atracciones.get(atracciones.size() - 1).getNombre();
	}

	/*@Override
	public String toString() {
		return nombre + "--" + " " + "precio:" + this.getPrecio() + " " + "tiempo:" + " " + this.getTiempoPromocion()
				+ " " + "cupo:" + this.getCupo() + " " + atracciones + " " + "Tendra gratis:" + this.visitaGratis();
	}*/
	

	@Override
	public String tipoPromocion() {
		return "AxB";
	}

	@Override
	public String toString() {
		return "PromocionAxB [atrGratis=" + atrGratis + ", atracciones=" + atracciones + ", tipoPromocion="
				+ tipoPromocion + "]";
	}

	@Override
	public double getTiempoPromocion() {
		double tiempo = 0.0;
		for (Atraccion atraccionesEnPromo : atracciones) {
			tiempo += atraccionesEnPromo.getDuracion();
		}
		return tiempo;

	}
}