package model;

import java.util.ArrayList;
import java.util.List;

public class PromocionAbsoluta extends Promocion {
	
	private String tipoPromocion;
	private List<Atraccion> atracciones;
	
	

	public PromocionAbsoluta(int idPromo, List<Atraccion> atracciones, Double valorPaquete, String nombre,
			TipoAtraccion tipoAtraccion) {
		super(idPromo, nombre, atracciones, tipoAtraccion);
		this.setPrecio(valorPaquete);
		this.atracciones = atracciones;
		this.tipoPromocion = "Absoluta";
		
	}
	public PromocionAbsoluta( List<Atraccion> atracciones, Double valorPaquete, String nombre,
			TipoAtraccion tipoAtraccion) {
		super( nombre, atracciones, tipoAtraccion);
		this.setPrecio(valorPaquete);
		this.atracciones = atracciones;
		this.tipoPromocion = "Absoluta";
           this.setCupo(atracciones);
		
	}
	@Override
	public double getPrecio() {
		return this.costo;
	}
    
	public int getIdPromocion() {
		return super.getIdPromocion();
	}

	private void setPrecio(Double precio) {
		this.costo = precio;
	}

	//@Override
	/*public String toString() {
		return nombre + "--" + " " + "costo:" + valorPaquete + " " + "tiempo" + " " + this.getTiempoPromocion() + " "
				+ "cupo:" + " " + this.getCupo() + atracciones;
	}*/

	public String tipoPromocion() {
		return "Absoluta";
	}

	@Override
	public String toString() {
		return   super.idPromocion + "" + super.nombre + "" + super.atracciones + 
				"" + super.tipoAtraccion +"" ; 
	}

	@Override
	public double getTiempoPromocion() {
		return super.getTiempoPromocion();
	}

	
	
	public void SetCosto(Double valorPaquete) {
		this.costo=valorPaquete;
		
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
	
}
