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
		  this.setCupo(atracciones,atrGratis);
	}
	public PromocionAxB(List<Atraccion> atracciones, Atraccion atrGratis, String nombre,
			TipoAtraccion tipoAtraccion) {
		super(nombre, atracciones,tipoAtraccion);
		this.atrGratis = atrGratis;
		this.atracciones = atracciones;
		this.atracciones.add(atrGratis);
		this.tipoPromocion = "AxB";
		this.setCosto(atracciones);
		 this.setCupo(atracciones ,atrGratis);
	}
	 public boolean isAbsoluta(){
			return tipoPromocion.equals("absoluta");
	 }
	@Override
	public double getPrecio() {
		double valor = 0;
		for (int x = 0; x < atracciones.size() - 1; x++) {
			valor += atracciones.get(x).getPrecio();
		}
		return valor;
	}

	
	public String visitaGratis() {
		return atracciones.get(atracciones.size() - 1).getNombre();
	}

	/*@Override
	public String toString() {
		return nombre + "--" + " " + "precio:" + this.getPrecio() + " " + "tiempo:" + " " + this.getTiempoPromocion()
				+ " " + "cupo:" + this.getCupo() + " " + atracciones + " " + "Tendra gratis:" + this.visitaGratis();
	}*/
	

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
	
	public void setCosto (List<Atraccion> atracciones) {
		
			double valor = 0;
			for (int x = 0; x < atracciones.size(); x++) {
				valor += atracciones.get(x).getPrecio();
			}
			this.costo=valor;
}
	public void setCupo(List<Atraccion> atracciones, Atraccion art){
		double cupo = 0;
		for (int i = 0; i < atracciones.size(); i++) {
			if (cupo == 0) {
				cupo = atracciones.get(i).getCupoPersonas();
			}
			if (cupo >  atracciones.get(i).getCupoPersonas()) {
				cupo =  atracciones.get(i).getCupoPersonas();
	}
			if(cupo > art.getCupoPersonas())
			{
				cupo = art.getCupoPersonas();
						}			
		}
		this.cupo=cupo;
		}
}