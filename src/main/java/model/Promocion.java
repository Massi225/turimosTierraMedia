package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Promocion {
	private int id;
	private String nombre;
	private double costo;
    private int duracion;
	private  int cupos;
	private String tipo_promocion;
	private  List<Atraccion> atracciones;
	private TipoAtraccion tipo_atraccion;
	private double bonificacion;
	private Map<String, String> errors;
	
	
	public Promocion(int id, String nombre, String tipo_promocion, double bonificacion,List<Atraccion> atracciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo_promocion= tipo_promocion;
		this.bonificacion= bonificacion;
		this.atracciones = atracciones;
		this.setCosto();
		this.setDuracion();
		this.setCupos();
		this.setTipoAtracciones();
	}

	public Promocion( String nombre, String tipo_promocion, double bonificacion,List<Atraccion> atracciones) {
		super();
		
		this.nombre = nombre;
		this.tipo_promocion= tipo_promocion;
		this.bonificacion= bonificacion;
		this.atracciones = atracciones;
		this.setCosto();
		this.setDuracion();
		this.setCupos();
		this.setTipoAtracciones();
	}
	public void setBonificacion(double bonificacion) {
		this.bonificacion = bonificacion;
	}


	public boolean isValid() {
	validate();
	return errors.isEmpty();
}

public void validate() {
	errors = new HashMap<String, String>();
	if ( costo<= 0) {
		errors.put("costo", "Debe ser positivo");
	}
	if (duracion <= 0) {
		errors.put("duration", "Debe ser positivo");
	}
	if (duracion > 60) {
		errors.put("tiempo", "Excede el tiempo máximo");
	}
	if (cupos <= 0) {
		errors.put("capacity", "Debe ser positivo");
	}
}

public Map<String, String> getErrors() {
	return errors;
}
  public void setCosto () {
	  String medida = this.tipo_promocion;
		double costo2 = 0;
		if(medida.equalsIgnoreCase("Porcentual")) {
			   for (int i =0 ; i < atracciones.size(); i++) {
					costo2 += atracciones.get(i).getCosto();
					
			   }
			   costo2=Math.round(costo2*(1-bonificacion));
			   
				this.costo= costo2  ;
			
		}
	   if(medida.equalsIgnoreCase("AxB")) {
		   for (int i =0 ; i < atracciones.size(); i++) {
				costo2 += atracciones.get(i).getCosto();
		   }
			this.costo= costo2  ;
			
	   }if(medida.equalsIgnoreCase("Absoluta")){
	   this.costo= bonificacion;
	   }
	    		
	}
  
	public List<Atraccion> getAtracciones() {
	return atracciones;
}

public void setAtracciones(List<Atraccion> atracciones) {
	this.atracciones = atracciones;
}

public TipoAtraccion getTipoAtracciones() {
	return tipo_atraccion;
}

public void setTipoAtracciones() {
	
	this.tipo_atraccion = this.atracciones.get(0).getTipo_atraccion();    // correguir q muestre el tipo de atracciones q tiene la promo
}

public void setDuracion() {
	int tiempo =0;   
	for (int i =0 ; i < atracciones.size(); i++) {
		 tiempo += atracciones.get(i).getTiempo();
	   }
		this.duracion= tiempo;  ;
}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getCosto() {
		return this.costo;
	}
      

	


	public double getDuracion() {
		return duracion;
	}





	public int getCupos() {
		return cupos;
	}


	public void setCupos() {
		int cupo = atracciones.get(0).getCupo();
		for (int i =1 ; i < atracciones.size(); i++) {
			if (cupo > atracciones.get(i).getCupo())
				cupo=atracciones.get(i).getCupo();
		}
			this.cupos= cupo;
	}

	public String getTipo_promocion() {
		return tipo_promocion;
	}

	public void setTipo_promocion(String tipo_promocion) {
		this.tipo_promocion = tipo_promocion;
	}


	@Override
	public String toString() {
		return "Promocion [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", duracion=" + duracion + ", cupos="
				+ cupos + ", tipo_promocion=" + tipo_promocion +" "+ "tipo_atraccion="
				+ tipo_atraccion + ", bonificacion=" + bonificacion + "]";
	}



	
}
