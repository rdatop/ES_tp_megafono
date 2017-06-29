package megafono.dao.implementacion;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import megafono.dao.ClienteDAO;
import megafono.domain.model.Cliente;

public class ClienteDAONeodatis extends DAONeodatis<Cliente> implements ClienteDAO  {

	public void guardar(Cliente cliente) {
		ODB odb = null;
		try {
			odb = ODBFactory.open("clientes");
			odb.store(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}
	
	public void borrar(Cliente cliente) {
		ODB odb = null;
		try {
			odb = ODBFactory.open("clientes");
			IQuery query = new CriteriaQuery(Cliente.class, Where.like("nombre", cliente.getNombre()));
			org.neodatis.odb.Objects<Cliente> clientes = odb.getObjects(query);
			odb.delete(clientes.getFirst());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}
}
