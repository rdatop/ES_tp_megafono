package megafono.services;

import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Notification.Type;

import megafono.dao.implementacion.ClienteDAONeodatis;
import megafono.domain.model.Cliente;

public class ClienteServices {

	private ClienteDAONeodatis clienteDAO;
	private static ClienteServices ClienteService;

	private ClienteServices() {
		clienteDAO = new ClienteDAONeodatis();
	}

	public static ClienteServices getClienteServices() {
		if (ClienteService == null) {
			ClienteService = new ClienteServices();
		}
		return ClienteService;
	}

	public void guardar(Cliente cliente) {
		clienteDAO.guardar(cliente);
	}

	public void borrar(Cliente cliente) {
		clienteDAO.borrar(cliente);
	}

	public void gestionarAltas(TextField nombreCliente, TextField usuarioCliente, PasswordField claveCliente,
			TextField correoCliente) {

		if (nombreCliente.isEmpty()) {
			Notification.show("Complete su nombre", Type.TRAY_NOTIFICATION);
			return;
		}
		if (usuarioCliente.isEmpty()) {
			Notification.show("Complete su usuario", Type.TRAY_NOTIFICATION);
			return;
		}
		if (correoCliente.isEmpty()) {
			Notification.show("Complete su correo electronico", Type.TRAY_NOTIFICATION);
			return;
		}
		if (claveCliente.isEmpty()) {
			Notification.show("Complete su clave", Type.TRAY_NOTIFICATION);
			return;
		}

		Cliente myCliente = new Cliente(nombreCliente.getValue(), usuarioCliente.getValue(), claveCliente.getValue(),
				correoCliente.getValue());
		this.guardar(myCliente);
		Notification.show("Ha generado su usuario satisfactoriamente", Type.TRAY_NOTIFICATION);

	}

	public Cliente getCliente() {
		return clienteDAO.obtenerCliente();
	}

}
