package megafono.domain.model;

import java.io.Serializable;

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String password;

	/**
	 * Constructor vacio
	 */
	public Usuario() {
		this.nombre = "";
		this.password = "";
	}

	public Usuario(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getNombre() {
		return nombre;
	}

}
