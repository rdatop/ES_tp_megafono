package megafono.mainclass;

import megafono.services.CamapaniaServices;

public class mainClass {

	public static void main(String[] args) {
//		Usuario user = new Usuario("admin", "admin");
//		UsuarioServices us = UsuarioServices.getusuarioServices();
//		us.guardar(user);

		CamapaniaServices cs = CamapaniaServices.getCampañaServices();
		cs.ejecutar();
	}
	
}
