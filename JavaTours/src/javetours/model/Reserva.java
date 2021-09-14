package javetours.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Reserva de un tour turístico.
 * 
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */
public class Reserva {
    private long                         numeroReserva;
    private Date                         fecha;
    private boolean                      pagado;
    private int                          cantidadPersonas;
    private Tour                         tourReservado;
    private Cliente                      clienteReserva;
    private ArrayList<ServicioAdicional> serviciosAdicionales;
    
    /**
     * Constructor por defecto.
     */
    public Reserva() {
        this.numeroReserva        = 1;
        this.fecha                = null;
        this.pagado               = false;  // False = No ha sido pagado
        this.cantidadPersonas     = 1;
        this.tourReservado        = null;
        this.clienteReserva       = null;
        this.serviciosAdicionales = new ArrayList<>();
    } 

    /**
     * Constructor con parámetros.
     * @param numeroReserva Número de la reserva.
     * @param fecha Fecha de la reserva.
     * @param pagado Verifica si la reserva ha sido pagada.
     * @param cantidadPersonas Cantidad de personas.
     * @param tourReservado Tour reservado.
     * @param clienteReserva Cliente reservado.
     */
    public Reserva(long numeroReserva, Date fecha, boolean pagado, int cantidadPersonas,
            Tour tourReservado, Cliente clienteReserva) {
        
        this.numeroReserva        = numeroReserva;
        this.fecha                = fecha;
        this.pagado               = pagado;
        this.cantidadPersonas     = cantidadPersonas;
        this.tourReservado        = tourReservado;
        this.clienteReserva       = clienteReserva;
        this.serviciosAdicionales = new ArrayList<>();
    }
    
    /**
     * Constructor con parámetros - incluye servicios adicionales.
     * @param numeroReserva Número de la reserva.
     * @param fecha Fecha de la reserva.
     * @param pagado Verifica si la reserva ha sido pagada.
     * @param cantidadPersonas Cantidad de personas.
     * @param tourReservado Tour reservado.
     * @param clienteReserva Cliente reservado.
     * @param serviciosAdicionales Servicios adicionales de la reserva.
     */
    public Reserva(long numeroReserva, Date fecha, boolean pagado, int cantidadPersonas, 
            Tour tourReservado, Cliente clienteReserva, 
            ArrayList<ServicioAdicional> serviciosAdicionales) {
        
        this.numeroReserva        = numeroReserva;
        this.fecha                = fecha;
        this.pagado               = pagado;
        this.cantidadPersonas     = cantidadPersonas;
        this.tourReservado        = tourReservado;
        this.clienteReserva       = clienteReserva;
        this.serviciosAdicionales = serviciosAdicionales;
    }

    /**
     * Obtiene el número de reserva.
     * @return El número de reserva.
     */
    public long getNumeroReserva() {
        return this.numeroReserva;
    }

    /**
     * Cambia el número de reserva.
     * @param numeroReserva El número de reserva.
     */
    public void setNumeroReserva(long numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    /**
     * Obtiene la fecha de reserva.
     * @return La fecha de reserva.
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * Cambia la fecha de reserva.
     * @param fecha La fecha de reserva.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene si la reserva se pagó.
     * @return Si la reserva se pagó.
     */
    public boolean isPagado() {
        return this.pagado;
    }

    /**
     * Cambia si la reserva se pagó.
     * @param pagado Si la reserva se pagó.
     */
    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    /**
     * Obtiene la cantidad de personas de la reserva.
     * @return La cantidad de personas de la reserva.
     */
    public int getCantidadPersonas() {
        return this.cantidadPersonas;
    }

    /**
     * Cambia la cantidad de personas de la reserva.
     * @param cantidadPersonas La cantidad de personas de la reserva.
     */
    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    /**
     * Obtiene el tour reservado.
     * @return El tour reservado.
     */
    public Tour getTourReservado() {
        return this.tourReservado;
    }

    /**
     * Cambia el tour reservado.
     * @param tourReservado El tour reservado.
     */
    public void setTourReservado(Tour tourReservado) {
        this.tourReservado = tourReservado;
    }

    /**
     * Obtiene el cliente reservado.
     * @return El cliente reservado.
     */
    public Cliente getClienteReserva() {
        return this.clienteReserva;
    }

    /**
     * Cambia el cliente reservado.
     * @param clienteReserva El cliente reservado.
     */
    public void setClienteReserva(Cliente clienteReserva) {
        this.clienteReserva = clienteReserva;
    }

    /**
     * Obtiene los servicios adiconales de la reserva.
     * @return Los servicios adiconales de la reserva.
     */
    public ArrayList<ServicioAdicional> getServiciosAdicionales() {
        return this.serviciosAdicionales;
    }

    /**
     * Cambia los servicios adiconales de la reserva.
     * @param serviciosAdicionales Los servicios adiconales de la reserva.
     */
    public void setServiciosAdicionales(ArrayList<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }
    
    /**
     * Consulta los servicios adicionales de una reserva de carro particular.
     * 
     * Defina un método en la clase Reserva que permita consultar todos los
     *  servicios adicionales de transporte asociados a un carro particular.
     * Muestre toda la información del servicio por pantalla desde la clase de interfaz.
     * 
     * @return Los servicios adicionales de una reserva de carro particular.
     */
    public ArrayList<Transporte> serviciosParticular() {
        ArrayList<Transporte> servicios = new ArrayList<>();
        for (ServicioAdicional servicio : this.getServiciosAdicionales()) {
            if (servicio.getClass().getName().contains("Transporte")) {
                Transporte transporte = (Transporte)servicio;
                if (transporte.getTipo() == TipoTransporte.PARTICULAR) {
                    servicios.add(transporte);
                }
            }
        }
        return servicios;
    }
    
    /**
     * Calcula el precio de la reserva.
     * @return El precio de la reserva.
     */
    public double calcularPrecio() {
       double total      = 0;       
       double precioTour = this.getTourReservado().getPrecio();

       total += this.getTourReservado().calcularPrecio();
       total += this.getTourReservado().calcularEstadia();
       
        if (this.getCantidadPersonas() > 1) {
            double personasAdicionales = (this.getCantidadPersonas() - 1) 
                    * precioTour * 1.25;
            total += personasAdicionales;
        }
       
       for (ServicioAdicional sa : this.getServiciosAdicionales()) {
           total += sa.calcularPrecio();
       }
       
       return total;
    }

    /**
     * Muestra el precio total de la reserva en forma detallada.
     * @return Cadena con el precio total de la reserva en forma detallada.
     */
    public String mostrarPrecioTotalReserva() {
        String cadena = "\nCostos de la reserva " + this.getNumeroReserva() + "\n";

        double precioReserva = 0;

        cadena += String.format(
                "%50s $ %(,12.0f\n",
                "Costo Tour:", 
                this.getTourReservado().calcularPrecio()
        );
        precioReserva += this.getTourReservado().calcularPrecio();

        cadena += String.format(
                "%50s $ %(,12d\n",
                "Estadía (días):", 
                this.getTourReservado().calcularEstadia()
        );
        
        if (this.getCantidadPersonas() > 1) {
            double personasAdicionales = (this.getCantidadPersonas() - 1) 
                    * this.getTourReservado().getPrecio() * 1.25;
            cadena += String.format(
                    "%50s $ %(,12.0f\n", 
                    "Personas Adicionales (" + (this.getCantidadPersonas() - 1) + "):", 
                    personasAdicionales
            );
            precioReserva += personasAdicionales;
        }
        
        cadena += String.format("%50s $ %(,12.0f\n", "Precio reserva:", precioReserva);
        
        cadena += "Servicios Adicionales:\n";
        double precioServicios = 0;
        for (ServicioAdicional servicio : this.getServiciosAdicionales()) {
            cadena += String.format(
                    "%50s $ %(,12.0f\n",
                    (servicio.getCodigoServicio() + " - " + 
                     servicio.getNombreServicio()),
                    servicio.calcularPrecio()
            );
            precioServicios += servicio.calcularPrecio();
        }
        
        cadena += String.format(
                "%50s $ %(,12.0f\n", "Servicios Adicionales", precioServicios
        );
        
        cadena += String.format(
                "%50s $ %(,12.0f\n",
                ("PRECIO TOTAL RESERVA " + this.getNumeroReserva()),
                (precioReserva + precioServicios)
        );
        
        return cadena;
    }
    
    /**
     * Crea la cadena con los datos de la reserva del tour.
     * @return La cadena con los datos de la reserva del tour.
     */
    @Override 
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String servicios = "\n";
        for (ServicioAdicional sa : this.getServiciosAdicionales()) {
            servicios += 
                    " " + sa.getNombreServicio() 
                    + " (" + String.format("$ %(,.0f", sa.calcularPrecio())
                    + ")\n";
        }
        
        return (
                "\n *** Inicio de la reserva ***\n" +
                "Número de la reserva: " + this.getNumeroReserva()     + "\n" + 
                "Fecha de la reserva:  " + sdf.format(this.getFecha()) + "\n" +
                "Reserva pagada?:      " + (this.isPagado() ? "Si\n": "No\n") +
                "Cantidad de personas: " + this.getCantidadPersonas()  + "\n" +
                "Tour reservado:       " + this.getTourReservado().getNombreComercial() + "\n" +
                "Cliente reserva:      " + this.getClienteReserva().getNombreCompleto() + "\n" +
                "Servicios adicionales:" + servicios +
                "Costo de la reserva:  " + String.format("$ %(,.0f", this.calcularPrecio()) + "\n" +
                "*** Fin de la reserva ***\n\n"
        );
    }
}