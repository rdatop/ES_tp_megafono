package megafono.mainclass;

import megafono.services.EmailSenderService;

public class pruebaEnvioMain {
	public static void main(String[] args) {

		String destinatario="ezzemontoya@outlook.com";
		String asunto="usuario hardcordeado";
		String texto="Hola prueba";
		String archivo="Envio eMails.zipp";
		
		//envio de un solo destinatario
		EmailSenderService meilTx= new EmailSenderService();
		meilTx.enviarEmail(destinatario, texto, asunto, archivo);	
	}
}
