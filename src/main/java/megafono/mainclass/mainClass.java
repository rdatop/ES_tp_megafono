package megafono.mainclass;

import java.util.ArrayList;

import megafono.domain.model.Tag;
import megafono.services.TagServices;

public class mainClass {

//	 public static void main(String[] args) {
//	 Tag t = new Tag("Futbol");
//	 Tag b = new Tag("Tenis");
//	 Tag d = new Tag("Deporte");
//	 d.agregarTagHijo(t);
//	 d.agregarTagHijo(b);
//	 TagServices ts = TagServices.getTagService();
//	 ts.guardar(d);
//	 }

	public static void main(String[] args) {
		TagServices ts = TagServices.getTagService();
		ts.borrar(new Tag ("Futbol"));
		ArrayList<Tag> tags = ts.obtenerTags();
		for (Tag t : tags){
			System.out.println(t.toString());	
		}
	}

}
