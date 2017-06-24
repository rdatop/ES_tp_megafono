package megafono.dao.implementacion;

import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import megafono.dao.TagDAO;
import megafono.domain.model.Tag;

public class TagDAONeodatis extends DAONeodatis<Tag> implements TagDAO {

	public void guardar(Tag tag) {
		ODB odb = null;
		try {
			odb = ODBFactory.open("tags");
			odb.store(tag);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	public void borrar(Tag tag) {
		ODB odb = null;
		try {
			odb = ODBFactory.open("tags");
			IQuery query = new CriteriaQuery(Tag.class, Where.like("nombre", tag.getNombre()));
			Objects<Tag> tags = odb.getObjects(query);
			odb.delete(tags.getFirst());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	public ArrayList<Tag> obtenerTags() {
		ODB odb = null;
		ArrayList<Tag> guardados = new ArrayList<Tag>();
		try {
			odb = ODBFactory.open("tags");
			Objects<Tag> tags = odb.getObjects(Tag.class);
			for (Tag t : tags) {
				guardados.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
		return guardados;
	}

	public Tag obtenerTag(String nombre) {
		ODB odb = null;
		Tag ret = null;
		try {
			odb = ODBFactory.open("tags");
			IQuery query = new CriteriaQuery(Tag.class, Where.like("nombre", nombre));
			Objects<Tag> tags = odb.getObjects(query);
			ret = tags.getFirst();
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
