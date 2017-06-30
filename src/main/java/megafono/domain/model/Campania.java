package megafono.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Campania implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Cliente generador;
	private ArrayList<Tag> tags;
	private ArrayList<AccionPublicitariaPersonalizada> accionesPublicitarias;
	private Date fechaInicio;
	private Date fechaFin;
	// private static SimpleDateFormat formato = new
	// SimpleDateFormat("dd-MM-yyyy");
	private Duracion duracion;
	private Periodicidad periodicidad;
	private String nombre;
	private String mensaje;
	private ArrayList<String> destinatarios;
	// private String destinatario;

	// TODO - falta agregar que guarde la imagen junto con el mensaje de la
	// camapaña para enviarlo en la accion publicitaria

	public Campania(Cliente cliente, Date fechaInicio) {
		this.generador = cliente;
		this.tags = new ArrayList<Tag>();
		this.accionesPublicitarias = new ArrayList<AccionPublicitariaPersonalizada>();
		this.destinatarios = new ArrayList<String>();
		// this.destinatario="";
		this.duracion = null;
		this.periodicidad = null;
		this.nombre = "";
		this.mensaje = "";
		this.fechaInicio = fechaInicio;
		this.fechaFin = new Date(); // TODO - calcular la fecha fin en base a la
									// fecha de inicio mas la duracion.
	}

	public Campania(Cliente cliente, String nombre, String mensaje, Date fechaInicio, ArrayList<Tag> tags,
			ArrayList<String> destinatarios, Duracion duracion, Periodicidad periodicidad) {
		this.generador = cliente;
		this.tags = tags;
		this.accionesPublicitarias = new ArrayList<AccionPublicitariaPersonalizada>();
		this.destinatarios = destinatarios;
		this.duracion = duracion;
		this.periodicidad = periodicidad;
		this.nombre = nombre;
		this.mensaje = mensaje;
		this.fechaInicio = fechaInicio;
		this.fechaFin = new Date(); // TODO - calcular la fecha fin en base a la
									// fecha de inicio mas la duracion.
	}

	public ArrayList<AccionPublicitariaPersonalizada> getAccionesPublicitarias() {
		return accionesPublicitarias;
	}

	public void setAccionesPublicitarias(ArrayList<AccionPublicitariaPersonalizada> accionesPublicitarias) {
		this.accionesPublicitarias = accionesPublicitarias;
	}

	public Duracion getDuracion() {
		return duracion;
	}

	public void setDuracion(Duracion duracion) {
		this.duracion = duracion;
	}

	public Periodicidad getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(Periodicidad periodicidad) {
		this.periodicidad = periodicidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ArrayList<String> getDestinatarios() {
		return this.destinatarios;
	}

	public Cliente getGenerador() {
		return generador;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public boolean estaVigente() {
		Date hoy = new Date();
		if (this.fechaFin.after(hoy)) {
			return true;
		} else {
			return false;
		}
	}

}
