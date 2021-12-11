package model;

public enum TipoAtraccion {

	PAISAJE, AVENTURA, DEGUSTACION;

	public int toInt() {
		int posicion = 0;
		if (this == PAISAJE)
			posicion = 1;
		if (this == AVENTURA)
			posicion = 2;
		if (this == DEGUSTACION)
			posicion = 3;
		return posicion;
	}
}