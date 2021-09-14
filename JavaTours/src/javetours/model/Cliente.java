package javetours.model;

import java.awt.Image;

/**
 * Cliente del sistema de gestión de reservas turísticas.
 * 
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */

public class Cliente {
    private long numeroIdentificacion;
    private String nombreCompleto;
    private String telefonoContacto;
    
    /**
     * Constructor sin parámetros.
     */
    public Cliente() {
        this.numeroIdentificacion = 0;
        this.nombreCompleto = "Sin nombre";
        this.telefonoContacto = "000-000-0000";
    }

    /**
     * Constructor con parámetros.
     * @param numeroIdentificacion
     * @param nombreCompleto
     * @param telefonoContacto 
     */
    public Cliente(long numeroIdentificacion, String nombreCompleto, String telefonoContacto) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreCompleto = nombreCompleto;
        this.telefonoContacto = telefonoContacto;
    }

    /**
     * Obtiene el número de identificación del cliente.
     * @return El número de identificación del cliente.
     */
    public long getNumeroIdentificacion() {
        return this.numeroIdentificacion;
    }

    /**
     * Cambia el número de identificación del cliente.
     * @param numeroIdentificacion El número de identificación del cliente.
     */
    public void setNumeroIdentificacion(long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    /**
     * Cambia el nombre del cliente.
     * @param nombreCompleto El nombre del cliente.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el teléfono de contacto del cliente.
     * @return El teléfono de contacto del cliente.
     */
    public String getTelefonoContacto() {
        return this.telefonoContacto;
    }

    /**
     * Cambia el teléfono de contacto del cliente.
     * @param telefonoContacto El teléfono de contacto del cliente.
     */
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    
    /**
     * Crea la cadena con los datos del cliente.
     * @return La cadena con los datos del cliente.
     */
    @Override
    public String toString() {
        return (
                "\n" +
                "Codigo del cliente: " + this.getNumeroIdentificacion() + "\n" +
                "Nombre del cliente: " + this.getNombreCompleto()       + "\n" +
                "Teléfono contacto : " + this.getTelefonoContacto()     + "\n"
        );
    }
}
