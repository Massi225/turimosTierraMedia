package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Comparator;

import java.util.HashMap;
import java.util.Map;

public class Atraccion  {
	private int idAtraccion;
	private String nombre;
	private TipoAtraccion tipo;
	private double precio;
	private double duracion;
	private int cupoPersonas;

	public Atraccion(int idAtraccion, String nombre, double precio, double duracion, int cupoPersonas,
			TipoAtraccion tipo) {
		this.idAtraccion = idAtraccion;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.duracion = duracion;
		this.cupoPersonas = cupoPersonas;
	}

	public int getIdAtraccion() {
		return idAtraccion;
	}
	

	public List<TipoAtraccion> getListaTiposAtraccion() {
		List<TipoAtraccion> listaTipoAtraccion = new ArrayList<TipoAtraccion>();
		listaTipoAtraccion.add(tipo);
		return listaTipoAtraccion;
	}
	

	public boolean canHost(int i) {
		return cupoPersonas >= i;
	}

	public void host(int i) {
		this.cupoPersonas -= i;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public double getDuracion() {
		return duracion;
	}

	public Double getPrecioObj() {
		return precio;
	}

	public Double getDuracionOj() {
		return duracion;
	}

	public int getCupoPersonas() {
		return cupoPersonas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(TipoAtraccion tipo) {
		this.tipo = tipo;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public void setCupoPersonas() {
		this.cupoPersonas -= 1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cupoPersonas, duracion, nombre, precio, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return cupoPersonas == other.cupoPersonas
				&& Double.doubleToLongBits(duracion) == Double.doubleToLongBits(other.duracion)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && tipo == other.tipo;
	}

	@Override
	public String toString() {
		return nombre + " " + tipo + " " + "costo:" + " " + precio + " " + "duracion:" + " " + duracion + "hs" + " "
				+ "cuposdisponibles:" + " " + cupoPersonas;
	}

	public int compareTo(Atraccion o2) {
		int resultado = 0;
		if (this.getPrecio() > o2.getPrecio()
				|| this.getPrecio() == o2.getPrecio() && this.getDuracion() > o2.getDuracion())
			resultado = 1;
		else if (this.getPrecio() < o2.getPrecio())
			resultado = -1;
		return resultado;
	}
	
}