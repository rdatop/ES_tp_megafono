package megafono.mainclass;

import megafono.domain.model.Usuario;
import megafono.services.UsuarioServices;

public class mainClass {

	// public static void main(String[] args) {
	// Tag t = new Tag("Futbol");
	// Tag b = new Tag("Tenis");
	// Tag d = new Tag("Deporte");
	// d.agregarTagHijo(t);
	// d.agregarTagHijo(b);
	// TagServices ts = TagServices.getTagService();
	// ts.guardar(d);
	// }

	// public static void main(String[] args) {
	// TagServices ts = TagServices.getTagService();
	// ts.borrar(new Tag ("Futbol"));
	// ArrayList<Tag> tags = ts.obtenerTags();
	// for (Tag t : tags){
	// System.out.println(t.toString());
	// }
	// }

	// public static void main(String[] args) {
	// Cliente cliente = new Cliente("prueba", "prueba1", "123456",
	// "ezzemontoya@gmail.com");
	// ClienteServices cs = ClienteServices.getClienteServices();
	// cs.guardar(cliente);
	// }

//	public static void main(String[] args) {
//		CamapaniaServices cs = CamapaniaServices.getCampañaServices();
//		cs.ejecutar();
//	}

	public static void main(String[] args) {
		Usuario user = new Usuario("admin", "admin");
		UsuarioServices us = UsuarioServices.getusuarioServices();
		us.guardar(user);
	}
	
}
