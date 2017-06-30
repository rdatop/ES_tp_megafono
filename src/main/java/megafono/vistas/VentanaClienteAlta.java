package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import megafono.services.ClienteServices;

public class VentanaClienteAlta extends HorizontalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "alta Cliente";

	private ClienteServices clienteService = ClienteServices.getClienteServices();

	public VentanaClienteAlta() {
		setSizeFull();

		VerticalLayout columna = new VerticalLayout();
		addComponent(columna);
		final TextField nombreCliente = new TextField("Ingrese su nombre");
		nombreCliente.setIcon(FontAwesome.USER);
		nombreCliente.setRequired(true);
		columna.addComponent(nombreCliente);
		final TextField usuarioCliente = new TextField("Ingrese su usuario");
		usuarioCliente.setIcon(FontAwesome.USER_MD);
		usuarioCliente.setRequired(true);
		columna.addComponent(usuarioCliente);
		final TextField correoCliente = new TextField("Ingrese su correo");
		correoCliente.setIcon(FontAwesome.ENVELOPE);
		correoCliente.setRequired(true);
		columna.addComponent(correoCliente);
		final PasswordField claveCliente = new PasswordField("Ingrese su clave");
		claveCliente.setIcon(FontAwesome.KEY);
		claveCliente.setRequired(true);
		columna.addComponent(claveCliente);

		Button guardarCliente = new Button("Guardar");
		guardarCliente.setIcon(FontAwesome.SAVE);
		guardarCliente.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				clienteService.gestionarAltas(nombreCliente, usuarioCliente, claveCliente, correoCliente);
			}
		});
		addComponent(guardarCliente);

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
