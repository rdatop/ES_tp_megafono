package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import megafono.domain.model.Usuario;
import megafono.services.UsuarioServices;

public class VentanaLogin extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "";

	private UsuarioServices usuarioService = UsuarioServices.getusuarioServices();

	public VentanaLogin() {
		setSizeFull();

		HorizontalLayout user = new HorizontalLayout();
		addComponent(user);
		final TextField usuario = new TextField("USUARIO");
		usuario.setIcon(FontAwesome.USER);
		usuario.setRequired(true);
		user.addComponent(usuario);
		HorizontalLayout pass = new HorizontalLayout();
		addComponent(pass);
		final PasswordField contraseña = new PasswordField("CONTRASEÑA");
		contraseña.setIcon(FontAwesome.KEY);
		contraseña.setRequired(true);
		pass.addComponent(contraseña);

		Button iniciarSesion = new Button("Iniciar Sesion");
		iniciarSesion.setIcon(FontAwesome.CHECK);
		iniciarSesion.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				Usuario guardado = usuarioService.getusuario(usuario.getValue());
				String clave = contraseña.getValue();
				if(guardado.getPassword().equals(clave)){
					usuario.clear();
					contraseña.clear();
					getUI().getNavigator().navigateTo(VentanaPrincipal.NAME);
				}else{
					Notification.show("usuario y/o contraseña no validos", Type.TRAY_NOTIFICATION);
					usuario.clear();
					contraseña.clear();
				}
			}
		});
		addComponent(iniciarSesion);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
