package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalLayout;

import megafono.services.CamapañaServices;

public class VentanaCampañaAlta extends HorizontalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "alta Campaña";

	private CamapañaServices campañaService = CamapañaServices.getCampañaServices();

	public VentanaCampañaAlta() {
		setSizeFull();
		

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
