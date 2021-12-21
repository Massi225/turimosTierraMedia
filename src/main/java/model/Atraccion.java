package model;

import java.util.HashMap;
import java.util.Map;

public class Atraccion {
	private int id;
	private String nombre;
	private double costo;
	private int tiempo;
	private int cupo;
	private TipoAtraccion tipo_atraccion;
	private String descripcion;
	private String imagen;

	private Map<String, String> errors;
	
	public Atraccion(int id, String nombre, double costo, int tiempo, int cupo, TipoAtraccion tipo_atraccion,
			String descripcion, String imagen) {
		
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo_atraccion = tipo_atraccion;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}


	

	public Atraccion(String nombre, double costo, int tiempo, int cupo, TipoAtraccion tipo_atraccion,
			String descripcion, String imagen) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo_atraccion = tipo_atraccion;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}



	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (costo <= 0) {
			errors.put("tiempo", "Debe ser positivo");
		}
		if (tiempo <= 0) {
			errors.put("tiempo", "Debe ser positivo");
		}
		if (tiempo > 60) {
			errors.put("tiempo", "Excede el tiempo máximo");
		}
		if (cupo <= 0) {
			errors.put("cupo", "Debe ser positivo");
		}
		//if(tipo_atraccion == TipoAtraccion.AVENTURA ||tipo_atraccion == TipoAtraccion.DEGUSTACION || tipo_atraccion == TipoAtraccion.PAISAJE ) {
			//errors.put("tipo_Atraccion", " Debe ser   Aventura ,  Paisaje   y/o Degustacion");
	//	}
	}

	public Map<String, String> getErrors() {
		return errors;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Atraccion [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", cupo="
				+ cupo + ", tipo_atraccion=" + tipo_atraccion 
				+ "]";
	}




	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getCosto() {
		return costo;
	}


	public void setCosto(double costo) {
		this.costo = costo;
	}


	public Integer getTiempo() {
		return tiempo;
	}


	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}


	public Integer getCupo() {
		return cupo;
	}


	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}


	public TipoAtraccion getTipo_atraccion() {
		return tipo_atraccion;
	}


	public void setTipo_atraccion(TipoAtraccion tipo_atraccion) {
		this.tipo_atraccion = tipo_atraccion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean canHost(int i) {
		return this.cupo >= i;
	}

	public void host(int i) {
		this.cupo -= i;
	}

	
	}


