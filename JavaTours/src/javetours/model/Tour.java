package javetours.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Tour turístico.
 * 
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez
 */
public class Tour {
    protected long                         codigoIdentificacion;
    protected String                       nombreComercial;
    protected String                       lugarPartida;
    protected String                       destino;
    protected Date                         fechaSalida;
    protected Date                         fechaRegreso;
    protected double                       precio;
    protected String                       rutaImagen;
    private   ArrayList<ServicioAdicional> serviciosAdicionales;

    /**
     * Constructor por defecto.
     */
    public Tour() {
        this.codigoIdentificacion = 0;
        this.nombreComercial      = "";
        this.lugarPartida         = "";
        this.destino              = "";
        this.fechaRegreso         = new Date();
        this.fechaSalida          = new Date();
        this.precio               = 0.0;
        this.rutaImagen           = "";
        this.serviciosAdicionales = new ArrayList<>();
    }

    /**
     * Constructor con parámetros.
     * @param codigoIdentificacion Código del tour.
     * @param nombreComercial Nombre comercial del tour-
     * @param lugarPartida Lugar de partida del tour.
     * @param destino Destino del tour.
     * @param fechaSalida Fecha de salida del tour.
     * @param fechaRegreso Fecha de regreso del tour.
     * @param precio Costo del tour.
     * @param rutaImagen Ruta del archivo de la imagen del tour.
     */
    public Tour(long codigoIdentificacion, String nombreComercial, 
            String lugarPartida, String destino,
            Date fechaSalida, Date fechaRegreso, double precio,
            String rutaImagen
    ) {
        this.codigoIdentificacion = codigoIdentificacion;
        this.nombreComercial      = nombreComercial;
        this.lugarPartida         = lugarPartida;
        this.destino              = destino;
        this.fechaSalida          = fechaSalida;
        this.fechaRegreso         = fechaRegreso;
        this.precio               = precio;
        this.rutaImagen           = rutaImagen;
        this.serviciosAdicionales = new ArrayList<>();
    }
    
    /**
     * Constructor con parámetros.
     * @param codigoIdentificacion Código del tour.
     * @param nombreComercial Nombre comercial del tour-
     * @param lugarPartida Lugar de partida del tour.
     * @param fechaSalida Fecha de salida del tour.
     * @param fechaRegreso Fecha de regreso del tour.
     * @param precio Costo del tour.
     */
    public Tour(long codigoIdentificacion, String nombreComercial, String lugarPartida,
            Date fechaSalida, Date fechaRegreso, double precio) {
        this.codigoIdentificacion = codigoIdentificacion;
        this.nombreComercial      = nombreComercial;
        this.lugarPartida         = lugarPartida;
        this.destino              = "";
        this.fechaSalida          = fechaSalida;
        this.fechaRegreso         = fechaRegreso;
        this.precio               = precio;
        this.rutaImagen           = "";
        this.serviciosAdicionales = new ArrayList<>();
    }

    /**
     * Obtiene el código de identificación del tour.
     * @return El código de identificación del tour.
     */
    public long getCodigoIdentificacion() {
        return this.codigoIdentificacion;
    }

    /**
     * Cambia el código de identificación del tour.
     * @param codigoIdentificacion El código de identificación del tour.
     */
    public void setCodigoIdentificacion(long codigoIdentificacion) {
        this.codigoIdentificacion = codigoIdentificacion;
    }

    /**
     * Obtiene el nombre comercial del tour.
     * @return El nombre comercial del tour.
     */
    public String getNombreComercial() {
        return this.nombreComercial;
    }

    /**
     * Cambia el nombre comercial del tour.
     * @param nombreComercial El nombre comercial del tour.
     */
    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    /**
     * Obtiene el lugar de partida del tour.
     * @return El lugar de partida del tour.
     */
    public String getLugarPartida() {
        return this.lugarPartida;
    }

    /**
     * Cambia el lugar de partida del tour.
     * @param lugarPartida El lugar de partida del tour.
     */
    public void setLugarPartida(String lugarPartida) {
        this.lugarPartida = lugarPartida;
    }

    /**
     * Obtiene el lugar de llegada del tour.
     * @return El lugar de llegada del tour.
     */
    public String getDestino() {
        return this.destino;
    }

    /**
     * Cambia el lugar de llegada del tour.
     * @param destino El lugar de llegada del tour.
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Obtiene la fecha de salida del tour.
     * @return La fecha de salida del tour.
     */
    public Date getFechaSalida() {
        return this.fechaSalida;
    }

    /**
     * Cambia la fecha de salida del tour.
     * @param fechaSalida La fecha de salida del tour.
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Obtiene la fecha de regreso del tour.
     * @return La fecha de regreso del tour.
     */
    public Date getFechaRegreso() {
        return this.fechaRegreso;
    }

    /**
     * Cambia la fecha de regreso del tour.
     * @param fechaRegreso La fecha de regreso del tour.
     */
    public void setFechaRegreso(Date fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }
    
    /**
     * Obtiene el costo del tour.
     * @return El costo del tour.
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Cambia el costo del tour.
     * @param precio El costo del tour.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la ruta de la imagen del tour.
     * @return La ruta de la imagen del tour.
     */
    public String getRutaImagen() {
        return this.rutaImagen;
    }

    /**
     * Cambia la ruta de la imagen del tour.
     * @param rutaImagen La ruta de la imagen del tour.
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    /**
     * Obtiene la lista de servicios adicionales del tour.
     * @return La lista de servicios adicionales del tour.
     */
    public ArrayList<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    /**
     * Cambia la lista de servicios adicionales del tour.
     * @param serviciosAdicionales La lista de servicios adicionales del tour.
     */
    public void setServiciosAdicionales(ArrayList<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }
    
    /**
     * Calcula el costo del tour.
     * 
     * El cálculo del precio corresponde al atributo precio por el número
     *  de días de la estadía.
     * 
     * @return El costo del tour.
     */
    public double calcularPrecio() {
        return this.getPrecio() * this.calcularEstadia();
    }
    
    /**
     * Calcula el número de días del rango de fechas.
     * 
     * En Tour, el método calcularEstadia debe calcular el número de días
     *  transcurridos entre la fecha de partida y la fecha de regreso.
     * 
     * @return El número de días del rango de fechas.
     */
    public int calcularEstadia() {
        return (int)(
                (this.getFechaRegreso().getTime() 
                - this.getFechaSalida().getTime())
                / (24 * 60 * 60 * 1000) - 1   
            // milisegundos a días
        );
    }
    
    /**
     * Crea la cadena con los datos del tour.
     * @return La cadena con los datos del tour.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String cadena = "\n";
        cadena += "\n";
        cadena += "Codigo tour:      " + this.getCodigoIdentificacion()     + "\n";
        cadena += "Nombre Comercial: " + this.getNombreComercial()          + "\n";
        cadena += "Lugar de salida:  " + this.getLugarPartida()             + "\n";
        cadena += "Fecha de salida:  " + sdf.format(this.getFechaSalida())  + "\n";
        cadena += "Fecha de regreso: " + sdf.format(this.getFechaRegreso()) + "\n";
        cadena += "Precio:           ";
        cadena += String.format("$ %(,.0f", this.getPrecio()) + "\n";
        
        return cadena;
    }
}
