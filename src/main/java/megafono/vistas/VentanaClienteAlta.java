package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;

import megafono.domain.model.Cliente;
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
		columna.addComponent(nombreCliente);
		final TextField usuarioCliente = new TextField("Ingrese su usuario");
		columna.addComponent(usuarioCliente);
		final TextField correoCliente = new TextField("Ingrese su correo");
		columna.addComponent(correoCliente);
		final PasswordField claveCliente = new PasswordField("Ingrese su clave");
		columna.addComponent(claveCliente);

		VerticalLayout botones = new VerticalLayout();
		addComponent(botones);

		Button guardarCliente = new Button("Guardar");
		guardarCliente.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				Cliente myCliente = new Cliente(nombreCliente.getValue(), usuarioCliente.getValue(),
						claveCliente.getValue(), correoCliente.getValue());
				clienteService.guardar(myCliente);
				Notification.show("Ha generado su usuario satisfactoriamente", Type.TRAY_NOTIFICATION);

			}
		});
		botones.addComponent(guardarCliente);

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
