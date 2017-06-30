package megafono.mainclass;

import java.util.ArrayList;

import megafono.services.EmailSenderService;

public class pruebaEnvioMain {
	public static void main(String[] args) {

		ArrayList<String> destinatario= new ArrayList<String>();
		destinatario.add("ezzemontoya@outlook.com");
		destinatario.add("rdatop@yahoo.com.ar");
		
		String asunto="usuario hardcordeado";
		String texto="Hola prueba";
		String archivo="Envio eMails.zipp";
		
		//envio de un solo destinatario
		EmailSenderService meilTx= new EmailSenderService();
		meilTx.enviarMultiMail(destinatario, texto, asunto, archivo);	
	}
}
