package model;

import java.util.HashMap;
import java.util.Map;

import utils.Crypt;

public class Usuario {
	private String nombre;
	private int id;
	private double monedas;
	private int tiempo;
	private TipoAtraccion preferencia;
	private String contrasenia;
	private boolean admin;
	private HashMap<String, String> errors;
	private String imagen;
	
	
	public Usuario (int id, String nombre, double monedas,int tiempo , TipoAtraccion preferencia, String contrasenia, boolean admin , String imagen) {
		this.id=id;
		this.nombre=nombre;
		this.monedas=monedas;
		this.tiempo=tiempo;
		this.preferencia=preferencia;
		this.contrasenia= contrasenia;
		this.admin = admin;
        this.imagen= imagen;
		
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public Usuario(String nombre, double monedas, int tiempo, TipoAtraccion preferencia, String contrasenia,String imagen) {
		super();
		this.nombre = nombre;
		this.monedas = monedas;
		this.tiempo = tiempo;
		this.preferencia = preferencia;
		this.contrasenia = contrasenia;
		this.imagen= imagen;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	public void validate() {
		errors = new HashMap<String, String>();
		

		if (monedas < 0) {
			errors.put("monedas", "No debe ser negativo");
		}
		if (tiempo < 0) {
			errors.put("tiempo", "No debe ser negativo");
		}
		//if(contrasenia.length()> 4) {
	//		errors.put(contrasenia,"No debe tener menos de 4 caracteres");
	//	}
	}


	public Map<String, String> getErrors() {
		return errors;
	}
	

	
	public boolean checkPassword(String contrasenia) {
		// this.password en realidad es el hash del password
		return Crypt.match(contrasenia, this.contrasenia);
	}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getId() {
		return id;
	}
	
	public boolean isNull() {
		return false;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}



	public double getMonedas() {
		return monedas;
	}



	public void setMonedas(double monedas) {
		this.monedas = monedas;
	}



	public Integer getTiempo() {
		return tiempo;
	}



	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}



	public TipoAtraccion getPreferencia() {
		return preferencia;
	}



	public void setPreferencia(TipoAtraccion preferencia) {
		this.preferencia = preferencia;
	}



	public String getContrasenia() {
		return contrasenia;
	}



	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public boolean isAdmin(){
		return this.admin ;
	}
	public void addToItinerary(Atraccion atraccion) {
		this.monedas -= atraccion.getCosto();
		this.tiempo -= atraccion.getTiempo();
		// TODO agregar a su lista
	}
	public void addToItinerary(Promocion promocion) {
		this.monedas -= promocion.getCosto();
		this.tiempo-= promocion.getDuracion();
		// TODO agregar a su lista
	}

	public boolean canAfford(Atraccion atraccion) {
		return atraccion.getCosto() <= this.monedas;
	}

	public boolean canAttend(Atraccion atraccion) {
		return atraccion.getTiempo() <= this.tiempo;

}

	public boolean canAffordPromo(Promocion Promocion) {
		return Promocion.getCosto() <= this.monedas;
	}

	public boolean canAttendPromo(Promocion Promocion) {
		return Promocion.getDuracion() <= this.tiempo;
	}
	@Override
	public String toString() {
		return "Usuario nombre=" + nombre + ", id=" + id + ", monedas=" + monedas + ", tiempo=" + tiempo
				+ ", preferencia=" + preferencia + ", contrasenia=" + "****"+ ", admin=" + admin + " " +imagen;
	}
	
}