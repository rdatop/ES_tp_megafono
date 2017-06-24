package megafono.vistas;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

import megafono.services.TagServices;

public class VentanaTagsBorrar extends HorizontalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String NAME = "borrarTag";

	private TagServices tagService = TagServices.getTagService();

	public VentanaTagsBorrar() {
		setSizeFull();

		final Tree arbol = new Tree("Tags");
		addComponents(arbol);

		VerticalLayout textfiles = new VerticalLayout();
		addComponent(textfiles);
		final ComboBox aBorrar = new ComboBox("Seleccione Tag a borrar");
		textfiles.addComponent(aBorrar);

		tagService.procesarArbol(arbol, aBorrar);

		HorizontalLayout botones = new HorizontalLayout();
		addComponent(botones);

		Button borrarTag = new Button("Borrar");
		borrarTag.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				tagService.gestionarBajas(arbol, aBorrar);
			}
		});
		botones.addComponent(borrarTag);

		Button volver = new Button("Volver");
		volver.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().navigateTo(VentanaTagsAgregar.NAME);
			}
		});
		botones.addComponent(volver);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
