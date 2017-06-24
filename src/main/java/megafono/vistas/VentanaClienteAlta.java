package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalLayout;

import megafono.services.ClienteServices;

public class VentanaClienteAlta extends HorizontalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "altaCliente";

	private ClienteServices clienteService = ClienteServices.getClienteServices();

	public VentanaClienteAlta() {
		setSizeFull();
		

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
