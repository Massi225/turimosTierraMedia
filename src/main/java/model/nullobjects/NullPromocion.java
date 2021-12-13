package model.nullobjects;

import model.Promocion;
import model.User;

public class NullPromocion extends Promocion {

	public static Promocion build() {
		return new NullPromocion();
}
	public NullPromocion(){
		super(0,0 ,0 ,"");
		
}
	@Override
	protected String tipoPromocion() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String visitaGratis() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
