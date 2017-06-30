package megafono.vistas;

import java.util.ArrayList;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import megafono.domain.model.Duracion;
import megafono.domain.model.Periodicidad;
import megafono.services.CamapaniaServices;
import megafono.services.ClienteServices;
import megafono.services.TagServices;

public class VentanaCampañaAlta extends HorizontalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "alta Campaña";

	private CamapaniaServices campañaService = CamapaniaServices.getCampañaServices();
	private TagServices tagServices = TagServices.getTagService();
	private ClienteServices clienteService = ClienteServices.getClienteServices();
	private ArrayList<String> destinatarios = new ArrayList<String>();

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

		final Button agregarDestinatarios = new Button("Agregar Destinatarios");
		agregarDestinatarios.setIcon(FontAwesome.USERS);
		agregarDestinatarios.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().addWindow(new VentanaAgregarDestinatarios(destinatarios));
			}
		});
		derecha.addComponent(agregarDestinatarios);
		
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
						tagServices.getSeleccionados(), duracion, periodicidad, destinatarios);
			}
		});
		derecha.addComponent(guardarCampaña);

		final Button accionPublicitariaPersonalizada = new Button("Crear Accion Personalizada");
		accionPublicitariaPersonalizada.setIcon(FontAwesome.MAGIC);
		accionPublicitariaPersonalizada.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().addWindow(new VentanaAccionPublicitariaPersonalizada());
				
			}
		});
		izquierda.addComponent(accionPublicitariaPersonalizada);
		
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
