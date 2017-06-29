package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class VentanaExito extends VerticalLayout implements View{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "ventana exito";

	public VentanaExito(){
		setSizeFull();
	
		Label exito = new Label ("Exito");
		addComponent(exito);
		HorizontalLayout botones = new HorizontalLayout();
		addComponent(botones);
		Button volver = new Button("Volver");
		volver.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VentanaTagAlta.NAME);
			}
		});
		botones.addComponent(volver);
	}
	

	
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
