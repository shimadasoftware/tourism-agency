package javetours.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Tour ecológico.
 * 
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */
public class Ecologico extends Tour {
    private boolean vacunacionRequerida;
    private double impuestoLocal;
    private boolean dificilAcceso;

    /**
     * Constructor por defecto.
     */
    public Ecologico() {
        this.vacunacionRequerida = false;
        this.impuestoLocal = 0;
        this.dificilAcceso = false;
    }

    /**
     * Constructor con parámetros.
     * @param vacunacionRequerida Se requiere vacunación?
     * @param impuestoLocal Impuesto local en porcentaje.
     * @param dificilAcceso Es de difícil acceso?
     * @param codigoIdentificacion Código de identificación del tour.
     * @param nombreComercial Nombre comercial del tour.
     * @param lugarPartida Lugar de partida.
     * @param destino Destino del tour.
     * @param fechaSalida Fecha de salida.
     * @param fechaRegreso Fecha de regreso.
     * @param precio Precio del tour.
     * @param rutaImagen Ruta del archivo de la imagen del tour.
     */
    public Ecologico(boolean vacunacionRequerida, double impuestoLocal,
            boolean dificilAcceso, long codigoIdentificacion, String nombreComercial,
            String lugarPartida, String destino, 
            Date fechaSalida, Date fechaRegreso, 
            double precio, String rutaImagen
    ) {
        super(codigoIdentificacion, nombreComercial, lugarPartida, destino, 
                fechaSalida, fechaRegreso, precio, rutaImagen);
        
        this.vacunacionRequerida = vacunacionRequerida;
        this.impuestoLocal = impuestoLocal;
        this.dificilAcceso = dificilAcceso;
    }

    /**
     * Constructor con parámetros.
     * @param vacunacionRequerida Se requiere vacunación?
     * @param impuestoLocal Impuesto local en porcentaje.
     * @param dificilAcceso Es de difícil acceso?
     * @param codigoIdentificacion Código de identificación del tour.
     * @param nombreComercial Nombre comercial del tour.
     * @param lugarPartida Lugar de partida.
     * @param fechaSalida Fecha de salida.
     * @param fechaRegreso Fecha de regreso.
     * @param precio Precio del tour.
     */
    public Ecologico(boolean vacunacionRequerida, double impuestoLocal,
            boolean dificilAcceso, long codigoIdentificacion, String nombreComercial,
            String lugarPartida, Date fechaSalida, Date fechaRegreso, double precio) {
        
        super(codigoIdentificacion, nombreComercial, lugarPartida, fechaSalida, 
                fechaRegreso, precio);
        
        this.vacunacionRequerida = vacunacionRequerida;
        this.impuestoLocal = impuestoLocal;
        this.dificilAcceso = dificilAcceso;
    }
    
    /**
     * Obtiene si se requiere vacunación.
     * @return Si se requiere vacunación.
     */
    public boolean isVacunacionRequerida() {
        return this.vacunacionRequerida;
    }

    /**
     * Cambia si se requiere vacunación.
     * @param vacunacionRequerida Si se requiere vacunación.
     */
    public void setVacunacionRequerida(boolean vacunacionRequerida) {
        this.vacunacionRequerida = vacunacionRequerida;
    }

    /**
     * Obtiene el impuesto local.
     * @return El impuesto local.
     */
    public double getImpuestoLocal() {
        return this.impuestoLocal;
    }

    /**
     * Cambia el impuesto local.
     * @param impuestoLocal El impuesto local.
     */
    public void setImpuestoLocal(double impuestoLocal) {
        this.impuestoLocal = impuestoLocal;
    }

    /**
     * Obtiene si es de difícil acceso.
     * @return Si es de difícil acceso.
     */
    public boolean isDificilAcceso() {
        return this.dificilAcceso;
    }

    /**
     * Cambia si es de difícil acceso.
     * @param dificilAcceso Si es de difícil acceso.
     */
    public void setDificilAcceso(boolean dificilAcceso) {
        this.dificilAcceso = dificilAcceso;
    }

    /**
     * Calcula el precio del tour.
     * 
     * Adicionalmente, para calcular el precio, se debe realizar lo mismo que en tour,
     *  pero agregar el porcentaje de impuesto local.
     * 
     * @return El precio del tour.
     */
    @Override
    public double calcularPrecio() {
        return super.calcularPrecio() * (1 + this.getImpuestoLocal() / 100);
    }
    
    /**
     * Calcula la estadía del tour.
     * 
     * En la clase Ecológico, para el cálculo de la estadía,
     *  si el tour es de dificil acceso, se deben sumar dos días a la estadía.
     * 
     * @return La estadía del tour.
     */
    @Override
    public int calcularEstadia() {
        if (this.isDificilAcceso()) {
            return super.calcularEstadia() + 2;
        }
        else {
            return super.calcularEstadia();
        }
    }
    
    /**
     * Crea la cadena con los datos del tour ecológico.
     * @return La cadena con los datos del tour ecológico.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return(
                "\n" +
                "Codigo tour:      " + this.getCodigoIdentificacion()              + "\n" +
                "Nombre Comercial: " + this.getNombreComercial()                   + "\n" +
                "Lugar de salida:  " + this.getLugarPartida()                      + "\n" +
                "Fecha de salida:  " + sdf.format(this.getFechaSalida())           + "\n" +
                "Fecha de regreso: " + sdf.format(this.getFechaRegreso())          + "\n" +
                "Precio:           " + String.format("$ %(,.0f", this.getPrecio()) + "\n" +
                "Estadía (días):   " + this.calcularEstadia()                      + "\n" +
                "Impuesto:         " + this.getImpuestoLocal()                     + "%\n" +
                "Costo:            " + String.format("$ %(,.0f", this.calcularPrecio()) + "\n" +
                "Vacunación:       " + (this.isVacunacionRequerida() ? "Si\n" : "No\n") +
                "Difícil Acceso:   " + (this.isDificilAcceso() ? "Si\n" : "No\n")
        );
    }
}
