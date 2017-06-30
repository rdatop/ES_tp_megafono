package megafono.domain.model;

import java.util.ArrayList;

public enum Periodicidad {

	Hora, Diario, Semanal, Mensual, Semestral;
	
	public void sarasa(){
		
	}

	public static ArrayList<String> getItems() {
		ArrayList<String> ret = new ArrayList<String>();
		ret.add(Periodicidad.Hora.toString());
		ret.add(Periodicidad.Diario.toString());
		ret.add(Periodicidad.Semanal.toString());
		ret.add(Periodicidad.Mensual.toString());
		ret.add(Periodicidad.Semestral.toString());
		return ret;
	}
}
