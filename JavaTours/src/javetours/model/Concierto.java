package javetours.model;

/**
 * Servicio adicional de concierto.
 * 
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */
public class Concierto extends ServicioAdicional {
    private String artista;
    private String lugar;
    private String horaIngreso;

    /**
     * Constructor por defecto.
     */
    public Concierto() {
        super();
        this.artista     = "";
        this.lugar       = "";
        this.horaIngreso = "";
    }

    /**
     * Constructor con parámetros.
     * @param artista Artista del concierto.
     * @param lugar Lugar del concierto.
     * @param horaIngreso Hora de ingreso al concierto.
     * @param codigoServicio Código del servicio adicional de transporte..
     * @param nombreServicio Nombre del servicio adicional de transporte..
     * @param precio Precio del servicio adicional de transporte.
     */
    public Concierto(String artista, String lugar, String horaIngreso,
            long codigoServicio, String nombreServicio, double precio) {

        super(codigoServicio, nombreServicio, precio);

        this.artista     = artista;
        this.lugar       = lugar;
        this.horaIngreso = horaIngreso;
    }

    /**
     * Obtiene el artista del concierto.
     * @return El artista del concierto.
     */
    public String getArtista() {
        return this.artista;
    }

    /**
     * Cambia el artista del concierto.
     * @param artista El artista del concierto.
     */
    public void setArtista(String artista) {
        this.artista = artista;
    }

    /**
     * Obtiene el lugar del concierto.
     * @return El lugar del concierto.
     */
    public String getLugar() {
        return this.lugar;
    }

    /**
     * Cambia el lugar del concierto.
     * @param lugar El lugar del concierto.
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Obtiene la hora de ingreso al concierto.
     * @return La hora de ingreso al concierto.
     */
    public String getHoraIngreso() {
        return this.horaIngreso;
    }

    /**
     * Cambia la hora de ingreso al concierto.
     * @param horaIngreso La hora de ingreso al concierto.
     */
    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    /**
     * Calcula el precio del servicio adicional de concierto.
     * 
     * En la clase Concierto, el precio es igual al precio del atributo del servicio adicional.
     * Sólo se debe verificar si la hora de ingreso es entre 6pm y 6am,
     *  en cuyo caso el valor se incrementa un 10%.
     * 
     * @return El precio del servicio adicional de concierto.
     */
    @Override
    public double calcularPrecio() {
        int hora = Integer.parseInt(this.getHoraIngreso().split(":")[0]);
        if (hora < 6 || hora >= 18) {
            return this.getPrecio() * 1.10;
        }
        else {
            return this.getPrecio();
        }
    }

    /**
     * Crea la cadena con los datos del servicio adicional de concierto.
     * @return La cadena con los datos del servicio adicional de concierto.
     */
    @Override 
    public String toString() {
        return (
                "\n" +
                "Artista:             " + this.getArtista()                           + "\n" + 
                "Lugar:               " + this.getLugar()                             + "\n" +
                "Hora:                " + this.getHoraIngreso()                       + "\n" +
                "Código del servicio: " + this.getCodigoServicio()                    + "\n" +
                "Nombre del servicio: " + this.getNombreServicio()                    + "\n" +
                "Precio:              " + String.format("$ %(,.0f", this.getPrecio()) + "\n" +
                "Costo:               " + String.format("$ %(,.0f", this.calcularPrecio()) + "\n"
        );
    }
}
