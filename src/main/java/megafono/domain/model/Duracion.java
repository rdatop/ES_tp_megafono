package megafono.domain.model;

import java.util.ArrayList;

public enum Duracion {

	Hora, Semana, Mes, Bimestre, Semestre;

	public static ArrayList<String> getItems() {
		ArrayList<String> ret = new ArrayList<String>();
		ret.add(Duracion.Hora.toString());
		ret.add(Duracion.Semana.toString());
		ret.add(Duracion.Mes.toString());
		ret.add(Duracion.Bimestre.toString());
		ret.add(Duracion.Semestre.toString());
		return ret;
	}
}
