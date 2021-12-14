package model;

import java.util.ArrayList;
import java.util.List;


public class PromoPorcentual extends Promocion {
	private double porcentaje;
	private List<Atraccion> atracciones;
	private String tipoPromocion;
	
	

	public PromoPorcentual(int idPromocion, List<Atraccion> atracciones, double Porcent, String nombre,
			TipoAtraccion tipoAtraccion) {
	    super(idPromocion, nombre, atracciones, tipoAtraccion);
		this.atracciones = atracciones;
		this.setPorcentaje(Porcent);
		this.tipoPromocion = "Porcentual";
		
		
	}
	
		
	

	public PromoPorcentual(List<Atraccion> lista, int dependeDeLapromo, String nombre, TipoAtraccion tipoAtraccion) {
		super( nombre, lista, tipoAtraccion);
		this.atracciones = atracciones;
		this.setPorcentaje(dependeDeLapromo);
		this.tipoPromocion = "Porcentual";
	}




	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public double getPrecio() {
		return Math.round(super.getPrecio() * ((100 - (this.porcentaje))/100));
	}

	/*@Override
	public String toString() {
		return super.getNombre() + "--" + " " + "precio:" + " " + this.getPrecio() + "tiempo:" + " " + this.getTiempoPromocion()
				+ " " + "cupo:" + this.getCupo() + " " + atracciones + " " + " este valor tuvo un descuento de:"
				+ porcentaje;
	}*/

	@Override
	public String tipoPromocion() {
		return "Porcentual";
	}

	@Override
	public String toString() {
		return  super.idPromocion +" "+ super.getCosto() + "  " + super.nombre + "  " + this.atracciones + 
				"  " + super.tipoAtraccion +"  "; 
	}


	@Override
	public double getTiempoPromocion() {
		return super.getTiempoPromocion();
	}

	@Override
	protected String visitaGratis() {
		return "";
	}
	
}