package megafono.services;


public class pruebaEnvioMain {
	public static void main(String[] args) {
		
		//ejemplo de cuerpo a crear
		String direccion="darivas1978@gmail.com";
		String contrasena="benjamino";
		String destinatario="ezzemontoya@outlook.com";//rdatop@yahoo.com.ar, vgomez1990@live.com.ar, ezzemontoya@outlook.com//flor_grochowski@hotmail.com
//		String [] destinatarios={"pereyramef@yahoo.com.ar" }; //"flor_grochowski@hotmail.com", "rdatop@yahoo.com.ar", "vgomez1990@live.com.ar", "ezzemontoya@outlook.com", "pablosrecagno88@gmail.com"
		String asunto="mensaje de prueba desde maven/jenkins, ahora comittteo";
		String texto="Hola prueba";
//		String archivo="Paragua helicoptero.amr";
		String archivo="Envio eMails.zipp";
		
		//envio de un solo destinatario
		EmailSenderService meilTx= new EmailSenderService();
		meilTx.enviarEmail(direccion, contrasena, destinatario, texto, asunto, archivo);
		
//		//envio de muchos destinatarios
//		EmailSenderService meilTx= new EmailSenderService();
//		meilTx.enviarEmailDestinatarios(direccion, contrasena, destinatarios, texto, asunto, archivo);
		
		
		//recepcion en si
//		EmailReceiverService meilRx=new EmailReceiverService();
//		meilRx.recibirEmail(direccion, contrasena);
		
	}
}
