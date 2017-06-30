package megafono.services;

import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSenderService {

	private String usuario = "megafonomarketingdigital@gmail.com";
	private String contraseña = "megafonoES2017";

	// Envia un email a partir de una propiertie
	// de configuracion con y verificacion de envio

	public void enviarMultiMail(ArrayList<String> destinatarios, String mensaje, String asunto, String archivo) {
		for (String s : destinatarios) {
				this.enviarEmail(s, mensaje, asunto, archivo);
			}
	}

	public boolean enviarEmail(String destinatario, String mensaje, String asunto, String archivo) {
		boolean enviado = false;
		try {
			Session session = Session.getInstance(propiedades(this.usuario, this.contraseña), null);

			// se compone la parte del texto
			BodyPart texto = new MimeBodyPart();
			texto.setText(mensaje);

			// se compone el adjunto
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));// d:/futbol.gif
			adjunto.setFileName(archivo);

			// se crea una MultiParte para agrupar texto e imagen
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			multiParte.addBodyPart(adjunto);

			// se compone el correo
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(this.usuario));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			message.setSubject(asunto);
			message.setContent(multiParte);

			// se envia el email
			Transport transport = session.getTransport("smtp");
			transport.connect(this.usuario, this.contraseña);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			enviado = true;

			// TODO verificacion consola (borrarlo)
			System.out.print("\nMensaje enviado a " + destinatario + " " + enviado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enviado;
	}

	// Almacenar y entrega las propiedades de la conexion
	private Properties propiedades(String direccion, String contrasena) {
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", direccion);
		properties.put("mail.smtp.password", contrasena);
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.auth", "true");

		return properties;
	}
}
