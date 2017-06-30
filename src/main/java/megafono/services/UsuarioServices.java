package megafono.services;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;

import megafono.dao.implementacion.UsuarioDAONeodatis;
import megafono.domain.model.Usuario;

public class UsuarioServices {

	private UsuarioDAONeodatis usuarioDAO;
	private static UsuarioServices UsuarioService;

	private UsuarioServices() {
		usuarioDAO = new UsuarioDAONeodatis();
	}

	public static UsuarioServices getusuarioServices() {
		if (UsuarioService == null) {
			UsuarioService = new UsuarioServices();
		}
		return UsuarioService;
	}

	public void guardar(Usuario usuario) {
		usuarioDAO.guardar(usuario);
	}

	public void borrar(Usuario usuario) {
		usuarioDAO.borrar(usuario);
	}

	public void gestionarAltas(TextField nombreusuario, PasswordField claveusuario) {

		if (nombreusuario.isEmpty()) {
			Notification.show("Complete su nombre", Type.TRAY_NOTIFICATION);
			return;
		}
		if (claveusuario.isEmpty()) {
			Notification.show("Complete su clave", Type.TRAY_NOTIFICATION);
			return;
		}

		Usuario myusuario = new Usuario(nombreusuario.getValue(), claveusuario.getValue());
		this.guardar(myusuario);
		
		nombreusuario.setValue("");
		claveusuario.setValue("");
		
		Notification.show("Ha generado su usuario satisfactoriamente", Type.TRAY_NOTIFICATION);

	}

	public Usuario getusuario(String nombre) {
		return usuarioDAO.obtenerUsuario(nombre);
	}

}
