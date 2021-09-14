package javetours.model;

/**
 * Servicio adicional de transporte.
 * 
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */
public class Transporte extends ServicioAdicional {
    private double         distancia;
    private TipoTransporte tipo;
    private int            numeroPasajeros;

    /**
     * Constructor por defecto.
     */
    public Transporte() {
        super();
        this.distancia       = 0;
        this.tipo            = null;
        this.numeroPasajeros = 0;
    }

    /**
     * Constructor con parámetros.
     * @param distancia Distancia recorrida en kilómetros.
     * @param tipo Tipo de transporte (Taxi, minivan, particular).
     * @param numeroPasajeros Número de pasajeros.
     * @param codigoServicio Código del servicio adicional de transporte..
     * @param nombreServicio Nombre del servicio adicional de transporte..
     * @param precio Precio del servicio adicional de transporte.
     */
    public Transporte(double distancia, TipoTransporte tipo, int numeroPasajeros,
            long codigoServicio, String nombreServicio, double precio) {

        super(codigoServicio, nombreServicio, precio);

        this.distancia       = distancia;
        this.tipo            = tipo;
        this.numeroPasajeros = numeroPasajeros;
    }

    /**
     * Obtiene la distancia del recorrido en kilómetros.
     * @return La distancia del recorrido en kilómetros.
     */
    public double getDistancia() {
        return this.distancia;
    }

    /**
     * Cambia la distancia del recorrido en kilómetros.
     * @param distancia La distancia del recorrido en kilómetros.
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * Obtiene el tipo de transporte.
     * @return El tipo de transporte.
     */
    public TipoTransporte getTipo() {
        return this.tipo;
    }

    /**
     * Cambia el tipo de transporte.
     * @param tipo El tipo de transporte.
     */
    public void setTipo(TipoTransporte tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el número de pasajeros.
     * @return El número de pasajeros.
     */
    public int getNumeroPasajeros() {
        return this.numeroPasajeros;
    }

    /**
     * Cambia el número de pasajeros.
     * @param numeroPasajeros El número de pasajeros.
     */
    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }
    
    /**
     * Calcula el precio del servicio adicional de transporte.
     * 
     * En Transporte, el método calcularPrecio debe verificar el tipo de transporte.
     * Si es un taxi, el precio no se modifica.
     * Una minivan vale 50% más mientras que en el caso del carro particular,
     *  el recargo es del 25%.
     * Este valor se debe multiplicar por la distancia en kilometros del atributo de la clase.
     * Finalmente, en el caso del taxi o del carro partícular, sólo caben 4 pasajeros.
     * En la minivan caben 6. Si el número de pasajeros es mayor a estos límites, se debe contratar 
     *  dos o más vehiculos del mismo tipo, lo que se debe ver reflejado en el costo final.
     * No es posible combinar tipos de transporte (e.g. dos pasajeros en minivan y cuatro en taxi).
     * 
     * @return El precio del servicio adicional de transporte.
     */
    @Override
    public double calcularPrecio() {
        int cantidadVehiculos;
        double precio = this.getPrecio();
        
        if (this.getTipo() == TipoTransporte.MINIVAN) {
            cantidadVehiculos = (this.getNumeroPasajeros() - 1) / 6 + 1;
            precio = this.getPrecio() * 1.5; // 0.5 + 1
        }
        else {
            cantidadVehiculos = (this.getNumeroPasajeros() - 1) / 4 + 1;
            if (this.getTipo() == TipoTransporte.PARTICULAR) {
                precio = this.getPrecio() * 1.25;
            }
        }
        
        return cantidadVehiculos * precio * this.getDistancia();
    }

    /**
     * Crea la cadena con los datos del servicio adicional de transporte.
     * @return La cadena con los datos del servicio adicional de transporte.
     */
    @Override 
    public String toString() {
        return (
                "\n" +
                "Tipo de transporte:   " + this.getTipo()                              + "\n" + 
                "Distancia (km):       " + this.getDistancia()                         + "\n" +
                "Número de pasajeros:  " + this.getNumeroPasajeros()                   + "\n" +
                "Código del servicio:  " + this.getCodigoServicio()                    + "\n" +
                "Nombre del servicio:  " + this.getNombreServicio()                    + "\n" +
                "Precio:               " + String.format("$ %(,.0f", this.getPrecio()) + "\n" +
                "Costo:                " + String.format("$ %(,.0f", this.calcularPrecio()) + "\n"
        );
    }    
}
