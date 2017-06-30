package megafono.dao.implementacion;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import megafono.dao.UsuarioDAO;
import megafono.domain.model.Usuario;

public class UsuarioDAONeodatis extends DAONeodatis<Usuario> implements UsuarioDAO {
	private static final String bd = "usuario";

	public void guardar(Usuario usuario) {
		ODB odb = null;
		try {
			odb = ODBFactory.open(bd);
			odb.store(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	public void borrar(Usuario usuario) {
		ODB odb = null;
		try {
			odb = ODBFactory.open(bd);
			IQuery query = new CriteriaQuery(Usuario.class, Where.like("nombre", usuario.getNombre()));
			org.neodatis.odb.Objects<Usuario> usuario1 = odb.getObjects(query);
			odb.delete(usuario1.getFirst());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	public Usuario obtenerUsuario(String nombre) {
		ODB odb = null;
		Usuario ret = null;
		try {
			odb = ODBFactory.open(bd);
			IQuery query = new CriteriaQuery(Usuario.class, Where.like("nombre", nombre));
			Objects<Usuario> usuario = odb.getObjects(query);
			ret = usuario.getFirst();
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
