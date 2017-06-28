package megafono.dao.implementacion;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import megafono.dao.CampañaDAO;
import megafono.domain.model.Campaña;
import megafono.domain.model.Cliente;

public class CampañaDAONeodatis extends DAONeodatis<Campaña> implements CampañaDAO  {

	public void guardar(Campaña campaña) {
		ODB odb = null;
		try {
			odb = ODBFactory.open("campañas");
			odb.store(campaña);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}
	
	public void borrar(Campaña campaña) {
		ODB odb = null;
		try {
			odb = ODBFactory.open("campaña");
			IQuery query = new CriteriaQuery(Cliente.class, Where.like("nombre", campaña.getNombre()));
//			Objects<Cliente> clientes = odb.getObjects(query);
//			odb.delete(clientes.getFirsts());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}
}
