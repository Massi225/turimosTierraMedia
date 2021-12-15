package model;

import java.util.ArrayList;
import java.util.List;


public class PromoPorcentual extends Promocion {
	private double porcentaje;
	private List<Atraccion> atracciones;
	private String tipoPromocion;
	
	

	public PromoPorcentual(int idPromocion, List<Atraccion> atracciones, double porcent, String nombre,
			TipoAtraccion tipoAtraccion) {
	    super(idPromocion, nombre, atracciones, tipoAtraccion);
		this.atracciones = atracciones;
		this.setPorcentaje(porcent);
		this.tipoPromocion = "Porcentual";
		this.setCosto(porcent ,atracciones);
		this.setCupo(atracciones);
		
	}
	
		
	

	public PromoPorcentual(List<Atraccion> lista, Double porcentaje, String nombre, TipoAtraccion tipoAtraccion) {
		super( nombre, lista, tipoAtraccion);
		this.atracciones = lista;
		this.setPorcentaje(porcentaje);
		this.tipoPromocion = "Porcentual";
		this.setCosto(porcentaje, lista);
		  this.setCupo(lista);
		
	}

	



	public boolean isAbsoluta(){
			return tipoPromocion.equals("absoluta");
	 }

	public double getPorcentaje() {
		return porcentaje;
	}
	
	public void setCosto(Double porcentaje, List <Atraccion> atracciones) {
		double valor = 0;
		for (int x = 0; x < atracciones.size(); x++) {
			valor += atracciones.get(x).getPrecio();
		}
		valor = Math.round(valor *((100-porcentaje)/100));
		this.costo= valor;
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

	
	public String tipoPromocion() {
		return "Porcentual";
	}

	@Override
	public String toString() {
		return  super.idPromocion +" "+ " " + super.nombre + "  " + this.atracciones + 
				"  " + super.tipoAtraccion +"  "; 
	}


	public Double getCosto() {
		return costo;
	}




	public Double getCupo() {
		return cupo;
	}




	@Override
	public double getTiempoPromocion() {
		return super.getTiempoPromocion();
	}

	
	protected String visitaGratis() {
		return "";
	}
	public void setCupo(List<Atraccion> atracciones){
		double cupo = 0;
		for (int i = 0; i < atracciones.size(); i++) {
			if (cupo == 0) {
				cupo = atracciones.get(i).getCupoPersonas();
			}
			if (cupo >  atracciones.get(i).getCupoPersonas()) {
				cupo =  atracciones.get(i).getCupoPersonas();
	}
			
		}
		this.cupo=cupo;
		}

	public double setPrecio() {
		double valor = 0;
		for (int x = 0; x < atracciones.size(); x++) {
			valor += atracciones.get(x).getPrecio();
		}
		return valor * (100 - (this.porcentaje));
	}

	
	
}