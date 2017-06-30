package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import megafono.domain.model.Duracion;
import megafono.domain.model.Periodicidad;
import megafono.services.CamapañaServices;
import megafono.services.TagServices;

public class VentanaCampañaAlta extends HorizontalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "alta Campaña";

	private CamapañaServices campañaService = CamapañaServices.getCampañaServices();
	private TagServices tagServices = TagServices.getTagService();
	
	public VentanaCampañaAlta() {
		setSizeFull();
		

		VerticalLayout izquierda = new VerticalLayout();
		addComponent(izquierda);
		VerticalLayout derecha = new VerticalLayout();
		addComponent(derecha);
		
		final TextField nombreCamapaña = new TextField("Nombre de campaña");
		izquierda.addComponent(nombreCamapaña);
		
		final DateField fechaCampaña = new DateField("Fecha de Inicio de campaña");
		izquierda.addComponent(fechaCampaña);
		
		HorizontalLayout contenedorTags = new HorizontalLayout();
		izquierda.addComponent(contenedorTags);
		tagServices.agregarTagsAlCheckbox(contenedorTags);
		ComboBox periodicidad = new ComboBox("Seleccione la periodicidad de la campaña");
		periodicidad.addItems(Periodicidad.getItems());
		izquierda.addComponent(periodicidad);
		ComboBox duracion = new ComboBox("Seleccione la duracion de la campaña");
		duracion.addItems(Duracion.getItems());
		izquierda.addComponent(duracion);
		
		final TextArea mensajeCampaña = new TextArea("Mensaje de la campaña");
		derecha.addComponent(mensajeCampaña);
		
		final TextArea destinatarios = new TextArea("Ingrese los mails de los destinatarios, separados por ';' ");
		derecha.addComponent(destinatarios);
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
