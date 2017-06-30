package megafono.mainclass;

import megafono.services.CampaniaServices;

public class mainClass {

	public static void main(String[] args) {
//		Usuario user = new Usuario("admin", "admin");
//		UsuarioServices us = UsuarioServices.getusuarioServices();
//		us.guardar(user);

		CampaniaServices cs = CampaniaServices.getCampañaServices();
		cs.ejecutar();
	}
	
}
