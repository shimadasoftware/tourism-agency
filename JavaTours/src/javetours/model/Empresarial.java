package javetours.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Tour empresarial.
 * 
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */
public class Empresarial extends Tour {
    private String nombreEmpresa;
    private boolean viajeroFrecuente;
    private TipoEmpresa tipo;

    /**
     * Constructor por defecto.
     */
    public Empresarial() {
        super();
        this.nombreEmpresa = "";
        this.viajeroFrecuente = false;
        this.tipo = null;
    }

    /**
     * Constructor con parámetros.
     * @param nombreEmpresa Nombre de la empresa.
     * @param viajeroFrecuente Si es viajero frecuente.
     * @param tipo Tipo de Empresa (Tecnología, turismo, medios de comunicacón).
     * @param codigoIdentificacion Código de identificación del tour.
     * @param nombreComercial Nombre comercial del tour.
     * @param lugarPartida Lugar de partida.
     * @param destino Destino del tour.
     * @param fechaSalida Fecha de salida.
     * @param fechaRegreso Fecha de regreso.
     * @param precio Precio del tour.
     * @param rutaImagen Ruta del archivo de la imagen del tour.
     */
    public Empresarial(String nombreEmpresa, boolean viajeroFrecuente, 
            TipoEmpresa tipo, long codigoIdentificacion, 
            String nombreComercial, String lugarPartida, String destino, 
            Date fechaSalida, Date fechaRegreso, double precio, String rutaImagen
    ) {
        super(codigoIdentificacion, nombreComercial, lugarPartida, destino,
                fechaSalida, fechaRegreso, precio, rutaImagen
        );
        
        this.nombreEmpresa = nombreEmpresa;
        this.viajeroFrecuente = viajeroFrecuente;
        this.tipo = tipo;
    }
    
    /**
     * Constructor con parámetros.
     * @param nombreEmpresa Nombre de la empresa.
     * @param viajeroFrecuente Si es viajero frecuente.
     * @param tipo Tipo de Empresa (Tecnología, turismo, medios de comunicacón).
     * @param codigoIdentificacion Código de identificación del tour.
     * @param nombreComercial Nombre comercial del tour.
     * @param lugarPartida Lugar de partida.
     * @param fechaSalida Fecha de salida.
     * @param fechaRegreso Fecha de regreso.
     * @param precio Precio del tour.
     */
    public Empresarial(String nombreEmpresa, boolean viajeroFrecuente, TipoEmpresa tipo,
            long codigoIdentificacion, String nombreComercial, String lugarPartida, Date fechaSalida, 
            Date fechaRegreso, double precio) {
        
        super(codigoIdentificacion, nombreComercial, lugarPartida, fechaSalida, fechaRegreso, precio);
        
        this.nombreEmpresa = nombreEmpresa;
        this.viajeroFrecuente = viajeroFrecuente;
        this.tipo = tipo;
    }
    
    /**
     * Obtiene el nombre de empresa.
     * @return El nombre de empresa.
     */
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    /**
     * Cambia el nombre de empresa.
     * @param nombreEmpresa El nombre de empresa.
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * Obtiene si es viajero frecuente.
     * @return Si es viajero frecuente.
     */
    public boolean isViajeroFrecuente() {
        return this.viajeroFrecuente;
    }

    /**
     * Cambia si es viajero frecuente.
     * @param viajeroFrecuente Si es viajero frecuente.
     */
    public void setViajeroFrecuente(boolean viajeroFrecuente) {
        this.viajeroFrecuente = viajeroFrecuente;
    }

    /**
     * Obtiene el tipo de la empresa.
     * @return El tipo de la empresa.
     */
    public TipoEmpresa getTipo() {
        return this.tipo;
    }

    /**
     * Cambia el tipo de la empresa.
     * @param tipo El tipo de la empresa.
     */
    public void setTipo(TipoEmpresa tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Calcula el precio del tour empresarial.
     * 
     * Finalmente, en la clase Empresarial, para calcular el precio,
     *  se debe revisar el tipo de empresa usando la enumeración TipoEmpresa.
     *
     * Las empresas de Turismo y Medios de Comunicación tienen un descuento de 10% del valor.
     * El cálculo de la estadía es igual al de Tour.
     * 
     * @return El precio del tour empresarial.
     */
    @Override
    public double calcularPrecio() {
        int descuento = 0;
        
        if (this.getTipo() != TipoEmpresa.TECNOLOGIA) {
            descuento = (int)(this.calcularEstadia() * this.getPrecio() * 0.1);
        }
        
        return (this.getPrecio() * this.calcularEstadia()) - descuento;
    }
    
    /**
     * Crea la cadena con los datos del tour.
     * 
     * @return La cadena con los datos del tour.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return (
                "\n" +
                "Codigo tour:      " + this.getCodigoIdentificacion()              + "\n" +
                "Nombre Comercial: " + this.getNombreComercial()                   + "\n" +
                "Lugar de salida:  " + this.getLugarPartida()                      + "\n" +
                "Fecha de salida:  " + sdf.format(this.getFechaSalida())           + "\n" +
                "Fecha de regreso: " + sdf.format(this.getFechaRegreso())          + "\n" +
                "Precio:           " + String.format("$ %(,.0f", this.getPrecio()) + "\n" +
                "Estadía (días):   " + this.calcularEstadia()                      + "\n" +
                "Costo:            " + String.format("$ %(,.0f", this.calcularPrecio()) + "\n" +
                "Nombre empresa:   " + this.getNombreEmpresa()                     + "\n" +
                "Tipo de empresa:  " + this.getTipo()                              + "\n" +
                "Viajero frecuente:" + (this.isViajeroFrecuente() ? "Si\n" : "No\n")
        );
    }
}

