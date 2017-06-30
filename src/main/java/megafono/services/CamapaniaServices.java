package megafono.services;

import java.util.ArrayList;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import megafono.dao.implementacion.CampaniaDAONeodatis;
import megafono.domain.model.Campania;
import megafono.domain.model.Cliente;
import megafono.domain.model.Duracion;
import megafono.domain.model.Periodicidad;

public class CamapaniaServices {

	private CampaniaDAONeodatis campañaDAO;
	private static CamapaniaServices CampañaService;
	
	private CamapaniaServices(){
		campañaDAO = new CampaniaDAONeodatis();
	}
	
	public static CamapaniaServices getCampañaServices(){
		if(CampañaService == null){
			CampañaService = new CamapaniaServices();
		}
		return CampañaService;
	}
	
	public void guardar (Campania campaña){
		campañaDAO.guardar(campaña);
	}
	
	public void borrar (Campania campaña){
		campañaDAO.borrar(campaña);
	}

	public void gestionarAlta(Cliente cliente, TextField nombreCamapaña, TextArea mensajeCampaña, 
			DateField fechaCampaña, Object seleccionados, ComboBox duracion, ComboBox periodicidad, ArrayList<String> destinatarios) {
		if (nombreCamapaña.isEmpty()) {
			Notification.show("Complete el nombre de la camapaña", Type.TRAY_NOTIFICATION);
			return;
		}
		if (mensajeCampaña.isEmpty()) {
			Notification.show("Complete el mensaje que debe enviar la campaña", Type.TRAY_NOTIFICATION);
			return;
		}
		if (fechaCampaña.isEmpty()) {
			Notification.show("Indique la fecha de inicio de la camapaña", Type.TRAY_NOTIFICATION);
			return;
		}
		if (duracion.isEmpty()) {
			Notification.show("Seleccione cuanto dura la campaña", Type.TRAY_NOTIFICATION);
			return;
		}
		if (periodicidad.isEmpty()) {
			Notification.show("Seleccione la periodicidad de ejecicion de la campaña", Type.TRAY_NOTIFICATION);
			return;
		}
		Campania myCampaña = new Campania(cliente, nombreCamapaña.getValue(), 
				mensajeCampaña.getValue(), fechaCampaña.getValue(), null, destinatarios, Duracion.Hora, Periodicidad.Hora);
		
		nombreCamapaña.setValue("");
		mensajeCampaña.setValue("");
		fechaCampaña.clear();
		duracion.clear();
		periodicidad.clear();
		
		Notification.show("La campaña ha sigo guardada", Type.TRAY_NOTIFICATION);
		campañaDAO.guardar(myCampaña);
		
	}
	
	public ArrayList<Campania> getCamapañas() {
		return campañaDAO.getCampañas();			
	}
	
	public void ejecutar(){
		EmailSenderService meilTx= new EmailSenderService();
		for(Campania c : campañaDAO.getCampañas()){
			ArrayList<String> destinatario = c.getDestinatarios();
			String asunto = c.getNombre();
			String mensaje = c.getMensaje();
			meilTx.enviarMultiMail(destinatario, mensaje, asunto, "Envio eMails.zipp");
		}
	}
}

