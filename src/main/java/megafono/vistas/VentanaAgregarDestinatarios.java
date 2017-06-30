package megafono.vistas;



import java.util.ArrayList;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class VentanaAgregarDestinatarios extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaAgregarDestinatarios(ArrayList<String> destinatarios) {
		setSizeFull();
		center();
		
		VerticalLayout vl = new VerticalLayout();
		vl.setMargin(true);
		vl.addComponent(new Label("Ingrese los destinatarios de la cmapaña"));
		
		
		TextField destinatario = new TextField();
		destinatario.setRequired(true);
		destinatario.setIcon(FontAwesome.USER);
		vl.addComponent(destinatario);
		
		
		
		Button guardar = new Button("Guardar");
		guardar.setIcon(FontAwesome.SAVE);
		guardar.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				destinatarios.add(destinatario.getValue());
				destinatario.clear();
				Notification.show("Guardado", Type.TRAY_NOTIFICATION);
			}
		});
		vl.addComponent(guardar);
		
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
