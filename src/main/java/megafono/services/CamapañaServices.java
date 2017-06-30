package megafono.services;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import megafono.dao.implementacion.CampañaDAONeodatis;
import megafono.domain.model.Campaña;
import megafono.domain.model.Cliente;
import megafono.domain.model.Duracion;
import megafono.domain.model.Periodicidad;

public class CamapañaServices {

	private CampañaDAONeodatis campañaDAO;
	private static CamapañaServices CampañaService;
	
	private CamapañaServices(){
		campañaDAO = new CampañaDAONeodatis();
	}
	
	public static CamapañaServices getCampañaServices(){
		if(CampañaService == null){
			CampañaService = new CamapañaServices();
		}
		return CampañaService;
	}
	
	public void guardar (Campaña campaña){
		campañaDAO.guardar(campaña);
	}
	
	public void borrar (Campaña campaña){
		campañaDAO.borrar(campaña);
	}

	public void gestionarAlta(Cliente cliente, TextField nombreCamapaña, TextArea mensajeCampaña, 
			DateField fechaCampaña, Object seleccionados, ComboBox duracion, ComboBox periodicidad) {
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
		Campaña myCampaña = new Campaña(cliente, nombreCamapaña.getValue(), 
				mensajeCampaña.getValue(), fechaCampaña.getValue(), null, null, Duracion.Hora, Periodicidad.Hora);
		
		nombreCamapaña.setValue("");
		mensajeCampaña.setValue("");
		fechaCampaña.clear();
		duracion.clear();
		periodicidad.clear();
		
		
		Notification.show("La campaña ha sigo guardada", Type.TRAY_NOTIFICATION);
		campañaDAO.guardar(myCampaña);
		
	}
}

