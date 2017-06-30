package megafono.dao.implementacion;

import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import megafono.dao.CampaniaDAO;
import megafono.domain.model.Campania;
import megafono.domain.model.Cliente;

public class CampaniaDAONeodatis extends DAONeodatis<Campania> implements CampaniaDAO {

	private static final String bd = "campañas";

	public void guardar(Campania campaña) {
		ODB odb = null;
		try {
			odb = ODBFactory.open(bd);
			odb.store(campaña);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	public void borrar(Campania campaña) {
		ODB odb = null;
		try {
			odb = ODBFactory.open(bd);
			IQuery query = new CriteriaQuery(Cliente.class, Where.like("nombre", campaña.getNombre()));
			Objects<Cliente> clientes = odb.getObjects(query);
			odb.delete(clientes.getFirst());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	public ArrayList<Campania> getCampañas() {
		ArrayList<Campania> ret = new ArrayList<Campania>();
		ODB odb = null;
		try {
			odb = ODBFactory.open(bd);
			IQuery query = new CriteriaQuery(Campania.class);
			Objects<Campania> campañas = odb.getObjects(query);
			for (Campania c : campañas) {
				ret.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
		return ret;
	}
}
