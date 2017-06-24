package megafono.services;

import megafono.dao.implementacion.ClienteDAONeodatis;
import megafono.domain.model.Cliente;

public class ClienteServices {

	private ClienteDAONeodatis clienteDAO;
	private static ClienteServices ClienteService;
	
	private ClienteServices(){
		clienteDAO = new ClienteDAONeodatis();
	}
	
	public static ClienteServices getClienteServices(){
		if(ClienteService == null){
			ClienteService = new ClienteServices();
		}
		return ClienteService;
	}
	
	public void guardar (Cliente cliente){
		clienteDAO.guardar(cliente);
	}
	
	public void borrar (Cliente cliente){
		clienteDAO.borrar(cliente);
	}
}
