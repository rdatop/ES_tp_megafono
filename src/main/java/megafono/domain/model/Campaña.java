package megafono.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Campaña implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cliente generador;
	private ArrayList<Tag> Tags;
	private ArrayList<AccionPublicitariaPersonalizada> AccionesPublicitarias;
	
	
}
