package megafono.vistas;



import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
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
		
		Accordion opciones = new Accordion();
		opciones.setSizeFull();
		
		Label facebook = new Label("FACEBOOK");		
		Label twitter = new Label("TWITTER");		
		Label instagram = new Label("INSTAGRAM");	
		
		VerticalLayout correo = new VerticalLayout();
		TextField destinatario = new TextField("PARA: ");
		correo.addComponent(destinatario);
		TextArea mensaje = new TextArea("MENSAJE: ");
		correo.addComponent(mensaje);
		Upload upload = new Upload();
		correo.addComponent(upload);
				
		opciones.addTab(facebook, "FACEBOOK", FontAwesome.FACEBOOK);
		opciones.addTab(twitter, "TWITTER", FontAwesome.TWITTER);
		opciones.addTab(instagram, "INSTAGRAM", FontAwesome.INSTAGRAM);
		opciones.addTab(correo, "CORREO", FontAwesome.INBOX);
		
		Panel panel = new Panel("Acciones personalizadas");
//		panel.setWidth("50%");
//		panel.setHeight("100%");
		panel.setContent(opciones);
		vl.addComponent(panel);
			
		
		
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
