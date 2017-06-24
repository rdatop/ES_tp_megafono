package megafono.domain.model;

import java.io.Serializable;

public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String usuario;
	private String password;
	private String correo;
	
	/**
	 * Constructor vacio
	 */
	public Cliente (){
		this.nombre="";
		this.usuario="";
		this.password="";
		this.correo="";
	}
	
	public Cliente (String nombre, String usuario, String password, String correo){
		this.nombre=nombre;
		this.usuario=usuario;
		this.password=password;
		this.correo=correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUsuario() {
		return usuario;
	}
	
	

}
