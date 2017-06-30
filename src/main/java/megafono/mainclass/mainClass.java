package megafono.mainclass;

import megafono.domain.model.Usuario;
import megafono.services.UsuarioServices;

public class mainClass {

	public static void main(String[] args) {
		Usuario user = new Usuario("admin", "admin");
		UsuarioServices us = UsuarioServices.getusuarioServices();
		us.guardar(user);
	}
	
}
