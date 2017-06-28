package megafono.domain.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Campaña implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Cliente generador;
	private ArrayList<Tag> tags;
	private ArrayList<AccionPublicitariaPersonalizada> accionesPublicitarias;
	private String fechaInicio;
	private String fechaFin;
	private static SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
	private Duracion duracion;
	private Periodicidad periodicidad;
	private String nombre;
	private String mensaje;
	private ArrayList<Destinatario> destinatarios;

	// TODO - falta agregar que guarde la imagen junto con el mensaje de la
	// camapaña para enviarlo en la accion publicitaria

	public Campaña(Cliente cliente) {
		this.generador = cliente;
		this.tags = new ArrayList<Tag>();
		this.accionesPublicitarias = new ArrayList<AccionPublicitariaPersonalizada>();
		this.destinatarios = new ArrayList<Destinatario>();
		this.duracion = null;
		this.periodicidad = null;
		this.nombre = "";
		this.mensaje = "";
		this.fechaInicio = formato.format(new Date());
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

	public ArrayList<Destinatario> getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(ArrayList<Destinatario> destinatarios) {
		this.destinatarios = destinatarios;
	}

	public Cliente getGenerador() {
		return generador;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

}
