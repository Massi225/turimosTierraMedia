package model;

import java.util.ArrayList;
import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private double valorPaquete;
	private String tipoPromocion;
	private ArrayList<Atraccion> atracciones;

	public PromocionAbsoluta(int idPromo, ArrayList<Atraccion> atracciones, Double valorPaquete, String nombre,
			TipoAtraccion tipoAtraccion) {
		super(idPromo, nombre, atracciones, tipoAtraccion);
		this.setPrecio(valorPaquete);
		this.atracciones = atracciones;
		this.tipoPromocion = "Absoluta";
	}

	@Override
	public double getPrecio() {
		return this.valorPaquete;
	}

	public int getIdPromocion() {
		return super.getIdPromocion();
	}

	private void setPrecio(Double precio) {
		this.valorPaquete = precio;
	}

	@Override
	public String toString() {
		return nombre + "--" + " " + "costo:" + valorPaquete + " " + "tiempo" + " " + this.getTiempoPromocion() + " "
				+ "cupo:" + " " + this.getCupo() + atracciones;
	}

	@Override
	public String tipoPromocion() {
		return "Absoluta";
	}

	@Override
	public double getTiempoPromocion() {
		return super.getTiempoPromocion();
	}

	@Override
	protected String visitaGratis() {
		return null;
	}
}
