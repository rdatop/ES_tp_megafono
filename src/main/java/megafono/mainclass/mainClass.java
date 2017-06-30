package megafono.mainclass;

import java.util.ArrayList;

import megafono.domain.model.Campania;
import megafono.services.CamapaniaServices;
import megafono.services.EmailSenderService;

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

	public static void main(String[] args) {
		CamapaniaServices cs = CamapaniaServices.getCampañaServices();
		for (Campania c : cs.getCamapañas()) {
			ArrayList<String> destinatario = c.getDestinatarios();
			String asunto = c.getNombre();
			String texto = c.getMensaje();
			String archivo = "Envio eMails.zipp";

			// envio de un solo destinatario
			EmailSenderService meilTx = new EmailSenderService();
			meilTx.enviarMultiMail(destinatario, texto, asunto, archivo);
		}

	}

}
