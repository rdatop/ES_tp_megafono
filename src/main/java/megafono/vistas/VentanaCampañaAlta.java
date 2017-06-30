package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import megafono.domain.model.Duracion;
import megafono.domain.model.Periodicidad;
import megafono.services.CamapañaServices;
import megafono.services.ClienteServices;
import megafono.services.TagServices;

public class VentanaCampañaAlta extends HorizontalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "alta Campaña";

	private CamapañaServices campañaService = CamapañaServices.getCampañaServices();
	private TagServices tagServices = TagServices.getTagService();
	private ClienteServices clienteService = ClienteServices.getClienteServices();

	public VentanaCampañaAlta() {
		setSizeFull();

		VerticalLayout izquierda = new VerticalLayout();
		addComponent(izquierda);
		VerticalLayout derecha = new VerticalLayout();
		addComponent(derecha);

		final TextField nombreCampaña = new TextField("Nombre de campaña");
		nombreCampaña.setIcon(FontAwesome.SUN_O);
		nombreCampaña.setRequired(true);
		izquierda.addComponent(nombreCampaña);

		final DateField fechaCampaña = new DateField("Fecha de Inicio de campaña");
		fechaCampaña.setIcon(FontAwesome.CALENDAR);
		fechaCampaña.setRequired(true);
		izquierda.addComponent(fechaCampaña);

		HorizontalLayout contenedorTags = new HorizontalLayout();
		derecha.addComponent(contenedorTags);
		tagServices.agregarTagsAlCheckbox(contenedorTags);
		
		final ComboBox periodicidad = new ComboBox("Seleccione la periodicidad de la campaña");
		periodicidad.setIcon(FontAwesome.CLOCK_O);
		periodicidad.setRequired(true);
		periodicidad.addItems(Periodicidad.getItems());
		izquierda.addComponent(periodicidad);
		
		final ComboBox duracion = new ComboBox("Seleccione la duracion de la campaña");
		duracion.setIcon(FontAwesome.CLOCK_O);
		duracion.setRequired(true);
		duracion.addItems(Duracion.getItems());
		izquierda.addComponent(duracion);

		final TextArea mensajeCampaña = new TextArea("Mensaje de la campaña");
		mensajeCampaña.setIcon(FontAwesome.FILE_TEXT);
		mensajeCampaña.setRequired(true);
		derecha.addComponent(mensajeCampaña);

		final TextArea destinatarios = new TextArea("Ingrese los mails de los destinatarios, separados por ';' ");
		destinatarios.setIcon(FontAwesome.USERS);
		destinatarios.setRequired(true);
		derecha.addComponent(destinatarios);

		Button guardarCampaña = new Button("Guardar");
		guardarCampaña.setIcon(FontAwesome.SAVE);
		guardarCampaña.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO agregar acciones publicitarias personalizadas
				campañaService.gestionarAlta(clienteService.getCliente(), nombreCampaña, mensajeCampaña, fechaCampaña,
						tagServices.getSeleccionados(), duracion, periodicidad);
			}
		});
		derecha.addComponent(guardarCampaña);

		Button home = new Button("HOME");
		home.setIcon(FontAwesome.HOME);
		home.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VentanaPrincipal.NAME);
			}
		});
		addComponent(home);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
