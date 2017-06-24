package megafono.dao.implementacion;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import megafono.dao.DAO;

public class DAONeodatis<T> implements DAO<T> {

	@Override
	public void guardar(T t) {
		ODB odb = ODBFactory.open("mibase");
		odb.store(t);
		odb.close();
	}

	@Override
	public void eliminar(T t) {
		ODB odb = ODBFactory.open("mibase");
		odb.store(t);
		odb.close();
	}

}
