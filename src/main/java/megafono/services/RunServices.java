package megafono.services;

import java.util.ArrayList;

import megafono.domain.model.Campania;

public class RunServices {
	
	private static CamapaniaServices camapaniaServices = CamapaniaServices.getCampañaServices();
	
	
	public static void ejecutarCamapanias(){
		ArrayList<Campania> campañas = camapaniaServices.getCamapañas();
		for(Campania c : campañas){
			if(c.estaVigente()){
				c.ejecutar();
			}
		}
	}
	

}
