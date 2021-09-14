package javetours.model;

/**
 * Servicio adicional de una reserva.
 * 
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */
public abstract class ServicioAdicional {
    protected long   codigoServicio;
    protected String nombreServicio;
    protected double precio;

    /**
     * Constructor por defecto.
     */
    public ServicioAdicional() {
        this.codigoServicio = 0;
        this.nombreServicio = "Sin nombre";
        this.precio = 0.0;
    }

    /**
     * Constructor con parámetros
     * @param codigoServicio Código del servicio adicional.
     * @param nombreServicio Nombre del servicio adicional
     * @param precio Precio del servicio adicional
     */
    public ServicioAdicional(long codigoServicio, String nombreServicio, double precio) {
        this.codigoServicio = codigoServicio;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
    }

    /**
     * Obtiene el código del servicio adicional.
     * @return El código del servicio adicional.
     */
    public long getCodigoServicio() {
        return this.codigoServicio;
    }

    /**
     * Cambia el código del servicio adicional.
     * @param codigoServicio El código del servicio adicional.
     */
    public void setCodigoServicio(long codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    /**
     * Obtiene el nombre del servicio adicional.
     * @return El nombre del servicio adicional.
     */
    public String getNombreServicio() {
        return this.nombreServicio;
    }

    /**
     * Cambia el nombre del servicio adicional.
     * @param nombreServicio El nombre del servicio adicional.
     */
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    /**
     * Obtiene el precio del servicio adicional.
     * @return El precio del servicio adicional.
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Cambia el precio del servicio adicional.
     * @param precio El precio del servicio adicional.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * Calcula el costo del servicio adicional.
     * @return El costo del servicio adicional.
     */
    public abstract double calcularPrecio();
}
