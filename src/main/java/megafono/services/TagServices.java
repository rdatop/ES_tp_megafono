package megafono.services;

import java.util.ArrayList;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Tree;

import megafono.dao.implementacion.TagDAONeodatis;
import megafono.domain.model.Tag;

public class TagServices {

	private TagDAONeodatis tagDAO;
	private static TagServices tagService;

	private TagServices() {
		tagDAO = new TagDAONeodatis();
	}

	public static TagServices getTagService() {
		if (tagService == null) {
			tagService = new TagServices();
		}
		return tagService;
	}

	public void guardar(Tag tag) {
		tagDAO.guardar(tag);
	}

	public void borrar(Tag tag) {
		tagDAO.borrar(tag);
	}

	public ArrayList<Tag> obtenerTags() {
		return tagDAO.obtenerTags();
	}

	public Tag obtenerTag(String nombre) {
		return tagDAO.obtenerTag(nombre);
	}

	public void procesarArbol(Tree arbol, ComboBox cb) {
		ArrayList<Tag> tags = this.obtenerTags();
		agregarTagsEn(arbol, cb, tags);
		acomodarSuperiores(arbol, tags);
	}

	private void agregarTagsEn(Tree arbol, ComboBox cb, ArrayList<Tag> tags) {
		for (Tag t : tags) {
			arbol.addItem(t.getNombre());
			cb.addItem(t.getNombre());
		}
	}

	private void acomodarSuperiores(Tree arbol, ArrayList<Tag> tags) {
		for (Tag t : tags) {
			if (t.getSuperior() != null) {
				arbol.setParent(t.getNombre(), t.getNombreSuperior());
			}
		}
	}

	public void gestionarAltas(Tree arbol, String tag, ComboBox cb) {
		String superior = "";
		try {
			superior = cb.getValue().toString();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		/** No se ingresa ningun tag **/
		if (tag == ""){
			Notification.show("Debe ingresar un tag para poder guardar", Type.TRAY_NOTIFICATION);
			return;
		}
		/** No se ingresa ningun tag **/
		if (superior == "" && tag != "") {
			this.guardar(new Tag(tag));
			Notification.show("Se guardo el tag: " + tag, Type.TRAY_NOTIFICATION);
		}
		if (superior != "" && tag != "") {
			this.guardar(new Tag(tag, this.obtenerTag(superior)));
			Notification.show("Se guardo el tag: " + tag + " en: " + superior, Type.TRAY_NOTIFICATION);
		}
		this.procesarArbol(arbol, cb);
	}

	public void gestionarBajas(Tree arbol, ComboBox cb) {
		if (cb.getValue().toString() == "") {
			Notification.show("Debe ingresar un tag para poder guardar", Type.TRAY_NOTIFICATION);
			return;
		}
		System.out.println(cb.getValue().toString());
		String aBorrar = cb.getValue().toString();
		this.borrar(this.obtenerTag(aBorrar));
		Notification.show("Se borr� el tag: " + aBorrar, Type.TRAY_NOTIFICATION);
		this.procesarArbol(arbol, cb);
	}

}
