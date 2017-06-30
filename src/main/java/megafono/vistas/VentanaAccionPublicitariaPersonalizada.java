package megafono.vistas;



import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class VentanaAccionPublicitariaPersonalizada extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaAccionPublicitariaPersonalizada() {
		setSizeFull();
		center();
		
		VerticalLayout vl = new VerticalLayout();
		vl.setMargin(true);
		vl.addComponent(new Label("ventana"));
		
		setContent(vl);
		
		setClosable(false);
		
		Button ok = new Button("Listo");
		ok.setIcon(FontAwesome.CHECK);
		ok.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				close();				
			}
		});
		vl.addComponent(ok);

	}

}
