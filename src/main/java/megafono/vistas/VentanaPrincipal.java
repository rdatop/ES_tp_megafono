package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;

public class VentanaPrincipal extends HorizontalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "home";


	public VentanaPrincipal() {
		setSizeFull();
		
		HorizontalLayout contenedorBotones = new HorizontalLayout();
		addComponent(contenedorBotones);
		
		Button altaCliente= new Button("Crear Cliente");
		altaCliente.setIcon(FontAwesome.USER);
		altaCliente.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VentanaClienteAlta.NAME);
			}
		});
		contenedorBotones.addComponent(altaCliente);
		

		Button altaCampaña= new Button("Crear Campaña");
		altaCampaña.setIcon(FontAwesome.SUN_O);
		altaCampaña.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VentanaCampañaAlta.NAME);
			}
		});
		contenedorBotones.addComponent(altaCampaña);
		
		Button altaTag= new Button("Crear Tag");
		altaTag.setIcon(FontAwesome.TAG);
		altaTag.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VentanaTagAlta.NAME);
			}
		});
		contenedorBotones.addComponent(altaTag);
		
		Button bajaTag= new Button("Borrar Tag");
		bajaTag.setIcon(FontAwesome.TAG);
		bajaTag.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VentanaTagBaja.NAME);
			}
		});
		contenedorBotones.addComponent(bajaTag);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
