package javetours.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javetours.model.Cliente;
import javetours.model.Concierto;
import javetours.model.Ecologico;
import javetours.model.Empresarial;
import javetours.model.Reserva;
import javetours.model.TipoEmpresa;
import javetours.model.TipoTransporte;
import javetours.model.Tour;
import javetours.model.Transporte;

/**
 * Controlador para la aplicación de gestión de tours turísticos.
 *
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */

public class Agencia {
    private Map<Long, Tour>    listaTours;
    private ArrayList<Reserva> reservas;
    private Map<Long, Cliente> listaClientes;
   
    /**
     * Constructor por defecto.
     */
    public Agencia() {
        this.listaTours     = new HashMap<>();
        this.listaClientes  = new HashMap<>();
        this.reservas       = new ArrayList<>();
    }

    /**
     * Constructor con parámetros.
     * @param listaTours Mapa de los tours (Key: código tour, Value: datos del tour).
     * @param reservas Lista de las reservas.
     * @param listaClientes Mapa de los clientes (Key: Código del cliente, Value: datos del cliente).
     */
    public Agencia(Map<Long, Tour> listaTours, ArrayList<Reserva> reservas,
            Map<Long, Cliente> listaClientes) {
        this.listaTours    = listaTours;
        this.reservas      = reservas;
        this.listaClientes = listaClientes;
    }

    /**
     * Obtiene el mapa de los toures.
     * @return El mapa de los toures.
     */
    public Map<Long, Tour> getListaTours() {
        return this.listaTours;
    }
    
    /**
     * Cambia la lista de toures.
     * @param listaTours Lista de los toures.
     */
    public void setArregloTours(ArrayList<Tour> actual) {
        Map<Long,Tour> nuevaLista = new HashMap<>();
        for (Tour t: actual) {
            if(t!= null) {
                nuevaLista.put(t.getCodigoIdentificacion(), t);
            }
        }
        listaTours = nuevaLista;
    }
    
    /**
     * Obtiene La lista de toures.
     * @return La lista de los toures.
     */
    public ArrayList<Tour> getArregloTours() {
        ArrayList<Tour>actual = new ArrayList<>();
        for (Map.Entry<Long,Tour> entry: listaTours.entrySet()) {
            if (entry.getValue()!= null) {
                actual.add(entry.getValue());
            }            
        }
        return actual;
    }

    /**
     * Cambia el mapa de los toures.
     * @param listaTours El mapa de los toures.
     */
    public void setListaTours(Map<Long, Tour> listaTours) {
        this.listaTours = listaTours;
    }
    
    /**
     * Obtiene la lista de reservas.
     * @return La lista de reservas.
     */
    public ArrayList<Reserva> getReservas() {
        return this.reservas;
    }

    /**
     * Cambia la lista de reservas.
     * @param reservas La lista de reservas.
     */
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Obtiene el mapa de clientes.
     * @return El mapa de clientes.
     */
    public Map<Long, Cliente> getListaClientes() {
        return this.listaClientes;
    }

    /**
     * Cambia el mapa de clientes.
     * @param listaClientes El mapa de clientes.
     */
    public void setListaClientes(Map<Long, Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    /**
     * Genera la lista de tours disponibles.
     * 
     * @return La lista de tours disponibles.
     */
    public String listarTours() {
        String cadena = "\n";
        
        for (Long codigoTour : this.getListaTours().keySet()) {
            Tour tour = this.getListaTours().get(codigoTour);
            cadena += tour.toString() + "\n";
        }

        return cadena;
    }
    
    /**
     * Crea un mapa de toures con datos de ejemplo.
     */
    public void llenarTours() {
        try {
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
            
            String fechaSalida  = "19/06/2019";
            String fechaLlegada = "30/06/2019";
            Tour tourSanAndres  = new Tour(
                    1000001,
                    "Islas de San Andrés y Providencia",
                    "Bogotá",
                    "San Andrés",
                    sd.parse(fechaSalida),
                    sd.parse(fechaLlegada),
                    2000000,
                    "images/sanandresprovidencia.jpg"
            );
            Transporte sa1 = new Transporte(
                    20,                         // Distancia (km)
                    TipoTransporte.MINIVAN,
                    3,                          // Pasajeros
                    1,                          // Código Servicio
                    "Transporte Hoyo Soplador",
                    1000                        // Precio por km
            );
            Concierto sa2 = new Concierto(
                    "Blue Moon",                // Artista
                    "Estadio San Andrés", 
                    "18:00",
                    2,                          // Código Servicio
                    "Concierto Reggae",         // Nombre Servicio
                    50000
            );
            tourSanAndres.getServiciosAdicionales().add(sa1);
            tourSanAndres.getServiciosAdicionales().add(sa2);
            this.getListaTours().put((long)1000001, tourSanAndres);

            fechaSalida    = "04/01/2019";
            fechaLlegada   = "15/01/2019";
            Tour tourVilla = new Tour(
                    1000002,
                    "Descubre a Villa de Leyva",                    
                    "Bogotá",
                    "Villa de Leyva",
                    sd.parse(fechaSalida),
                    sd.parse(fechaLlegada),
                    800000,
                    "images/villadeleyva.jpg"
            );
            Transporte sa9 = new Transporte(
                    3,                          // Distancia (km)
                    TipoTransporte.PARTICULAR,
                    3,                          // Pasajeros
                    9,                          // Código Servicio
                    "Transporte al Parque Dinosaurios",
                    2000
            );
            Concierto sa10 = new Concierto(
                    "Andres Cepeda",            // Artista
                    "Plaza principal Villa de Leyva", 
                    "20:00",
                    10,                         // Código Servicio
                    "Concierto de Andrés Cepeda",   // Nombre Servicio
                    10000
            );
            tourVilla.getServiciosAdicionales().add(sa9);
            tourVilla.getServiciosAdicionales().add(sa10);
            this.getListaTours().put((long)1000002, tourVilla); 

            fechaSalida        = "11/08/2019";
            fechaLlegada       = "15/09/2019";
            Tour tourCartagena = new Tour(
                    1000003,
                    "Vive la historia en Cartagena",
                    "Medellín",
                    "Cartagena",
                    sd.parse(fechaSalida),
                    sd.parse(fechaLlegada),
                    2300000,
                    "images/cartagena.jpg"
            );
            this.getListaTours().put((long)1000003, tourCartagena); 

            fechaSalida   = "12/03/2019";
            fechaLlegada  = "19/03/2019";
            Tour tourCali = new Tour(
                    1000004,
                    "Baila salsa en Cali",
                    "Bogotá",
                    "Cali",
                    sd.parse(fechaSalida),
                    sd.parse(fechaLlegada),
                    2150000,
                    "images/cali.jpg"
            );
            Transporte sa7 = new Transporte(
                    10,                         // Distancia (km)
                    TipoTransporte.TAXI,
                    3,                          // Pasajeros
                    7,                          // Código Servicio
                    "Transporte Pascual Guerrero",
                    2000                        // Por km
            );
            Concierto sa8 = new Concierto(
                    "Marc Anthony",             // Artista
                    "Estadio Pascual Guerrero", 
                    "20:00",
                    8,                          // Código Servicio
                    "Feria de Cali",            // Nombre Servicio
                    1800000
            );
            tourCali.getServiciosAdicionales().add(sa7);
            tourCali.getServiciosAdicionales().add(sa8);
            this.getListaTours().put((long)1000004, tourCali);

            fechaSalida       = "15/01/2019";
            fechaLlegada      = "24/01/2019";
            Tour tourAmazonas = new Tour(
                    1000005,
                    "Respira naturaleza en el Amazonas",
                    "Bogotá",
                    "Amazonas",
                    sd.parse(fechaSalida),
                    sd.parse(fechaLlegada),
                    2500000,
                    "images/amazonas.jpg"
            );
            this.getListaTours().put((long)1000005, tourAmazonas);
            
            fechaSalida           = "21/01/2019";
            fechaLlegada          = "23/01/2019";
            Empresarial tourPaipa = new Empresarial(
                    "Caracol",
                    true,               // viajero frecuente
                    TipoEmpresa.MEDIOS_COMUNICACION,
                    1000006,
                    "Cierra tus negocios en Paipa",
                    "Cali",
                    "Paipa", 
                    sd.parse(fechaSalida),
                    sd.parse(fechaLlegada),
                    1800000,
                    "images/paipa.jpg"
            );
            Transporte sa3 = new Transporte(
                    10,                         // Distancia (km)
                    TipoTransporte.PARTICULAR,
                    100,                        // Pasajeros
                    3,                          // Código Servicio
                    "Transporte Paipa Centro convenciones",
                    1000                        // Por km
            );
            Concierto sa4 = new Concierto(
                    "Banda Municipal Paipa",    // Artista
                    "Paipa Centro Convenciones", 
                    "21:00",
                    4,                          // Código Servicio
                    "Concierto de bandas",      // Nombre Servicio
                    100000
            );
            tourPaipa.getServiciosAdicionales().add(sa3);
            tourPaipa.getServiciosAdicionales().add(sa4);
            this.getListaTours().put((long)1000006, tourPaipa);
            
            fechaSalida            = "21/08/2019";
            fechaLlegada           = "23/08/2019";
            Empresarial tourHilton = new Empresarial(
                    "Microsoft",
                    false,                      // Viajero frecuente
                    TipoEmpresa.TECNOLOGIA,
                    1000007,
                    "Innova en Medellín",
                    "Cartagena",
                    "Medellín", 
                    sd.parse(fechaSalida),
                    sd.parse(fechaLlegada),
                    1600000,
                    "images/medellin.jpg"
            );
            this.getListaTours().put((long)1000007, tourHilton);
            
            fechaSalida            = "10/06/2019";
            fechaLlegada           = "11/06/2019";
            Empresarial tourBogota = new Empresarial(
                    "Medimás",
                    false,                      // Viajero frecuente
                    TipoEmpresa.TURISMO,
                    1000008,
                    "Encuentro nacional de EPS",
                    "Cali",
                    "Bogotá", 
                    sd.parse(fechaSalida),
                    sd.parse(fechaLlegada),
                    1100000,
                    "images/bogotaparque.jpg"
            );
            this.getListaTours().put((long)1000008, tourBogota);
            
            fechaSalida           = "10/07/2019";
            fechaLlegada          = "20/07/2019";
            Ecologico tourRosario = new Ecologico(
                    false,                      // Vacunación Requerida
                    5,                          // Porcentaje impuesto Local
                    false,                      // Difícil Acceso
                    1000009,
                    "Relájate en las Islas del Rosario",
                    "Bogotá",
                    "Islas del Rosario",
                    sd.parse(fechaSalida),
                    sd.parse(fechaLlegada),
                    4700000,
                    "images/islarosario.jpg"
            );
            Transporte sa5 = new Transporte(
                    10,                         // Distancia (km)
                    TipoTransporte.PARTICULAR,
                    10,                         // Pasajeros
                    5,                          // Código Servicio
                    "Transporte Malecón Cartagena",
                    1000
            );
            Concierto sa6 = new Concierto(
                    "Don Omar",                 // Artista
                    "Islas del Rosario", 
                    "16:00",
                    6,                          // Código Servicio
                    "Concierto de champeta",    // Nombre Servicio
                    5000
            );
            tourRosario.getServiciosAdicionales().add(sa5);
            tourRosario.getServiciosAdicionales().add(sa6);
            this.getListaTours().put((long)1000009, tourRosario);
                    
            fechaSalida                = "10/07/2019";
            fechaLlegada               = "20/07/2019";
            Ecologico tourSierraNevada = new Ecologico(
                    true,                       // Vacunación Requerida
                    5,                          // Porcentaje impuesto Local
                    true,                       // Difícil Acceso
                    1000010,
                    "Cultura ancestral de la Sierra Nevada",
                    "Bogotá",
                    "Sierra Nevada",
                    sd.parse(fechaSalida),
                    sd.parse(fechaLlegada),
                    3800000,
                    "images/sierranevadasantamarta.jpg"                    
            );
            this.getListaTours().put((long)1000010, tourSierraNevada); 
            
            fechaSalida          = "10/07/2019";
            fechaLlegada         = "13/07/2019";
            Ecologico tourPurace = new Ecologico(
                    true,                       // Vacunación Requerida
                    8,                          // Porcentaje impuesto Local
                    true,                       // Difícil Acceso
                    1000011,
                    "Aventuras en el Volcán del Puracé",
                    "Bogotá",
                    "Popayán",
                    sd.parse(fechaSalida),
                    sd.parse(fechaLlegada),
                    2100000,
                    "images/volcanpurace.jpg"
            );
            this.getListaTours().put((long)1000011, tourPurace); 
        } catch (ParseException ex) {
        }
    }
    
    /**
     * Crea un mapa de clientes con datos ejemplo.
     */
    public void llenarClientes() {
        Cliente juana = new Cliente(100, "Juana Mendoza", "300-867-0719");
        this.getListaClientes().put((long)100, juana);
        
        Cliente camilo = new Cliente(101, "Camilo Ordoñez", "313-457-0719");
        this.getListaClientes().put((long)101, camilo);
        
        Cliente abrahan = new Cliente(102, "Abrahan", "313-898-0720");
        this.getListaClientes().put((long)102, abrahan);
        
        Cliente pablo = new Cliente(103, "Pablo", "310-887-0530");
        this.getListaClientes().put((long)103, pablo);
        
        Cliente anabel = new Cliente(104, "Anabel", "310-880-0530");
        this.getListaClientes().put((long)104, anabel);
    }    
      
    /**
     * Crea la lista de reservas con datos de ejemplo.
     */
    public void llenarReservas() {
        try {
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
            
            String fecha = "01/05/2018";
            Reserva r101 = new Reserva(
                    101,
                    sd.parse(fecha),
                    false,                              // Pagado
                    10,                                 // Cantidad Personas
                    this.getListaTours().get(1000001L),  // San Andrés
                    this.getListaClientes().get(100L)    // Juana
            );
            Transporte sa1 = new Transporte(
                    20,                         // Distancia (km)
                    TipoTransporte.MINIVAN,
                    3,                          // Pasajeros
                    1,                          // Código Servicio
                    "Transporte Hoyo Soplador",
                    1000
            );
            Concierto sa2 = new Concierto(
                    "Blue Moon",                // Artista
                    "Estadio San Andrés", 
                    "18:00",
                    2,                          // Código Servicio
                    "Concierto Reggae",         // Nombre Servicio
                    50000
            );
            r101.getServiciosAdicionales().add(sa1);
            r101.getServiciosAdicionales().add(sa2);
            this.getReservas().add(r101);
            
            fecha = "15/12/2017";
            Reserva r102 = new Reserva(
                    102,
                    sd.parse(fecha),
                    true,                               // Pagado
                    100,                                // Cantidad Personas
                    this.getListaTours().get(1000006L),  // Paipa
                    this.getListaClientes().get(102L)    // Abrahan
            );
            Transporte sa3 = new Transporte(
                    10,                         // Distancia (km)
                    TipoTransporte.PARTICULAR,
                    100,                        // Pasajeros
                    3,                          // Código Servicio
                    "Transporte Paipa Centro convenciones",
                    2000
            );
            Concierto sa4 = new Concierto(
                    "Banda Municipal Paipa",    // Artista
                    "Paipa centro convenciones", 
                    "21:00",
                    4,                          // Código Servicio
                    "Concierto de bandas",      // Nombre Servicio
                    1000000
            );
            r102.getServiciosAdicionales().add(sa3);
            r102.getServiciosAdicionales().add(sa4);
            this.getReservas().add(r102);
            
            fecha = "15/06/2018";
            Reserva r103 = new Reserva(
                    103,
                    sd.parse(fecha),
                    true,                               // Pagado
                    10,                                 // Cantidad Personas
                    this.getListaTours().get(1000009L),  // Islas del Rosario
                    this.getListaClientes().get(101L)    // Camilo
            );
            Transporte sa5 = new Transporte(
                    10,                         // Distancia (km)
                    TipoTransporte.PARTICULAR,
                    10,                         // Pasajeros
                    5,                          // Código Servicio
                    "Transporte Malecón Cartagena - Isla del Rosario",
                    1000
            );
            Concierto sa6 = new Concierto(
                    "Don Omar",                 // Artista
                    "Islas del Rosario", 
                    "16:00",
                    6,                          // Código Servicio
                    "Concierto de champeta",    // Nombre Servicio
                    5000
            );
            r103.getServiciosAdicionales().add(sa5);
            r103.getServiciosAdicionales().add(sa6);
            this.getReservas().add(r103);
            
            fecha = "15/01/2019";
            Reserva r104 = new Reserva(
                    104,
                    sd.parse(fecha),
                    false,                              // Pagado
                    3,                                  // Cantidad Personas
                    this.getListaTours().get(1000004L),  // Cali
                    this.getListaClientes().get(103L)    // Pablo
            );
            Transporte sa7 = new Transporte(
                    10,                         // Distancia (km)
                    TipoTransporte.TAXI,
                    3,                          // Pasajeros
                    7,                          // Código Servicio
                    "Transporte Movistar Arena",
                    2000
            );
            Concierto sa8 = new Concierto(
                    "Metallica",                // Artista
                    "Movistar Arena", 
                    "20:00",
                    8,                          // Código Servicio
                    "Concierto de Metallica",   // Nombre Servicio
                    6000000
            );
            r104.getServiciosAdicionales().add(sa7);
            r104.getServiciosAdicionales().add(sa8);
            this.getReservas().add(r104);
            
            fecha = "15/12/2018";
            Reserva r105 = new Reserva(
                    105,
                    sd.parse(fecha),
                    true,                               // Pagado
                    3,                                  // Cantidad Personas
                    this.getListaTours().get(1000002L),  // Villa de Leyva
                    this.getListaClientes().get(104L)    // Anabel
            );
            Transporte sa9 = new Transporte(
                    3,                          // Distancia (km)
                    TipoTransporte.PARTICULAR,
                    3,                          // Pasajeros
                    9,                          // Código Servicio
                    "Transporte Cabalgata al fosil",
                    2000
            );
            Concierto sa10 = new Concierto(
                    "Andres Cepeda",            // Artista
                    "Plaza principal Villa de Leyva", 
                    "20:00",
                    10,                         // Código Servicio
                    "Concierto de Andrés Cepeda",   // Nombre Servicio
                    10000
            );
            r105.getServiciosAdicionales().add(sa9);
            r105.getServiciosAdicionales().add(sa10);
            this.getReservas().add(r105);
        } catch (ParseException ex) {
        }
    }
    
    /**
     * Verifica si el tour tiene reservas.
     * @param codigoTour Código del tour.
     * @return True si el tour tiene reservas.
     */
    public boolean tourTieneReservas(Long codigoTour) {
        for (Reserva reserva : this.getReservas()) {
            if (reserva.getTourReservado().getCodigoIdentificacion() == codigoTour) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Obtener la lista de clientes actuales en el sistema.
     * @return La lista de clientes actuales en el sistema.
     */
    public String listarClientes() {
        String cadena = "\n";
        for (Long codigoCliente : this.getListaClientes().keySet()) {
            Cliente cliente = this.getListaClientes().get(codigoCliente);
            cadena += cliente.toString() + "\n";
        }
        return cadena;
    }
    
    /**
     * Verifica si el cliente tiene reservas.
     * @param codigo Codigo del cliente.
     * @return True si el cliente tiene reservas.
     */
    public boolean clienteTieneReservas(Long codigo) {
        for (Reserva reserva : this.getReservas()) {
            if (reserva.getClienteReserva().getNumeroIdentificacion() == codigo) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Reservar un tour.
     * @param cliente Cliente reservado.
     * @param tour Tour reservado.
     * @param fecha Fecha de la reserva.
     * @param pagado Se pagó la reserva?
     * @param personas Cantidad de personas de la reserva.
     * @return Número de la reserva proceso exitoso, de lo contrario un valor negativo.
     */
    public long reservarTour(Cliente cliente, Tour tour, Date fecha, boolean pagado, int personas) {
        if (existeReserva(cliente.getNumeroIdentificacion(), tour.getCodigoIdentificacion(), fecha)) {
            return -1;
        }
        
        Date pasadoManiana = new Date();
        pasadoManiana = this.addDays(pasadoManiana, 2);
        if (fecha.before(pasadoManiana)) {
            return -2;
        }
        
        long numeroReserva = this.generarNumeroReserva();
        Reserva reserva = new Reserva(numeroReserva, fecha, pagado, personas, tour, cliente);
        this.getReservas().add(reserva);
        return reserva.getNumeroReserva();
    }
    
    /**
     * Determina si existe una reserva para un cliente, un tour y en una fecha.
     * @param codigoCliente Código del cliente
     * @param codigoTour Código del tour
     * @param fecha Fecha.
     * @return True - Existe la reserva con estos parámetros.
     */
    public boolean existeReserva(long codigoCliente, long codigoTour, Date fecha) {
        for (Reserva reserva : this.getReservas()) {
            if (
                reserva.getClienteReserva().getNumeroIdentificacion() == codigoCliente &&
                reserva.getTourReservado().getCodigoIdentificacion() == codigoTour &&
                reserva.getFecha().equals(fecha)
            ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona una cantidad de días a una fecha.
     * @param date Fecha.
     * @param days Días a adicionar.
     * @return La nueva fecha con los días adicionados.
     */
    public Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * Generar un número de reserva.
     * 
     * @return Nuevo número de reserva.
     */
    public long generarNumeroReserva() {
        long mayor = 0;
        for (Reserva reserva : this.getReservas()) {
            if (reserva.getNumeroReserva() > mayor) {
                mayor = reserva.getNumeroReserva();
            }
        }
        return mayor + 1;
    }

    /**
     * Obtiene una reserva de acuerdo con el código de reserva.
     * @param codigoReserva El código de reserva.
     * @return Reserva buscada.
     */
    public Reserva getReserva(long codigoReserva) {
        for (Reserva reserva : this.getReservas()) {
            if (reserva.getNumeroReserva() == codigoReserva) {
                return reserva;
            }
        }
        return null;
    }
    
    /**
     * Listar las reservas existentes.
     * @return Cadena con los datos de las reservas existentes.
     */
    public String listarReservas() {
        String cadena = "\n";
        for (Reserva reserva : this.getReservas()) {
            cadena += reserva.toString();
        }
        return cadena;
    }
    
    /**
     * Obtener los toures de tipo ecológico.
     * 
     * Defina un método en la clase Agencia que retorne todos 
       los tours de tipo ecológico.
     * 
     * @return Los toures de tipo ecológico.
     */
    public Map<Long, Tour> toursEcologico() {
        Map<Long, Tour> tours = new HashMap<>();
        for (Long codigoTour : this.getListaTours().keySet()) {
            Tour tour = this.getListaTours().get(codigoTour);
            if (tour.getClass().getName().contains("Ecologico")) {
                tours.put(codigoTour, tour);
            }
        }
        return tours;
    }
    
    /**
     * Obtiene las reservas de tipo empresarial.
     * 
     * Defina un método en la clase Agencia que permita filtrar
        todas las reservas que esten asociadas a tours de tipo empresarial. 
     * 
     * @return Las reservas de tipo empresarial.
     */
    public ArrayList<Reserva> reservasEmpresariales() {
        ArrayList<Reserva> listaReservas = new ArrayList();
        for (Reserva reserva : this.getReservas()) {
            if (reserva.getTourReservado().getClass().getName().contains("Empresarial")) {
                listaReservas.add(reserva);
            }
        }
        return listaReservas;
    }
    
    /**
     * Calcula el precio total de las reservas de tipo ecológico.
     * 
     * Defina un método que permita calcular el precio total de todas las reservas 
     *  de tipo ecólogico para un rango de fechas que se recibe como parámetro.
     * 
     * @param fechaInicio Fecha inicial del rango a buscar.
     * @param fechaFinal Fecha final del rango a buscar.
     * @return El precio total de las reservas de tipo ecológico.
     */
    public double precioReservasToursEcologicosPorFecha(Date fechaInicio, Date fechaFinal) {
        double precio = 0;
        for (Reserva reserva : this.getReservas()) {
            if (reserva.getTourReservado().getClass().getName().contains("Ecologico")) {
                if (reserva.getFecha().after(fechaInicio) && reserva.getFecha().before(fechaFinal)) {
                    precio += reserva.calcularPrecio();
                }
            }
        }
        return precio;
    }
    
    /**
     * Obtiene la lista de clientes
     * @return Retorna el cliente 
     */
    public ArrayList<Cliente> getarregloClientes() {
        ArrayList<Cliente> actual = new ArrayList<>();
        for (Map.Entry<Long, Cliente> entry : listaClientes.entrySet()) {
           if (entry.getValue()!= null) {
            actual.add(entry.getValue());  
           }
        }
        return actual;
    }
    
    /**
     * Modifica al cliente
     * @param actual El cliente actual de la lista de clientes
     */
    public void setarregloClientes(ArrayList<Cliente> actual) {
        Map<Long, Cliente> nuevalista = new HashMap<>();
        for (Cliente cliente : actual) {
            if (cliente != null) {
                nuevalista.put(cliente.getNumeroIdentificacion(), cliente);
            }
        }
        listaClientes = nuevalista;
    }
    
    /**
     * Agrega el cliente 
     * @param codigo Codigo del cliente
     * @param nombre nombre del cliente
     * @param telefono telefono del cliente
     */
    public void insertarCliente(long codigo, String nombre, String telefono) {
        Cliente cliente = new Cliente(codigo, nombre, telefono);
        listaClientes.put(codigo, cliente);
    }
}
