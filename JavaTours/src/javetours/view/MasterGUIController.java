package javetours.view;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javetours.controller.Agencia;
import javetours.controller.AgenciaSingleton;
import javetours.model.Cliente;
import javetours.model.Ecologico;
import javetours.model.Empresarial;
import javetours.model.Reserva;
import javetours.model.ServicioAdicional;
import javetours.model.Tour;


/**
 * FXML Controller class
 *
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */
public class MasterGUIController implements Initializable {
    private final ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    private Agencia servicios=AgenciaSingleton.getSingletonInstance(new Agencia()).getAgencia();
    private int tourIndex;
    private final ObservableList<Tour> Tours = FXCollections.observableArrayList();
     private final ObservableList<Cliente> Clientes = FXCollections.observableArrayList();
     private final ObservableList<String> sa2List = FXCollections.observableArrayList();
    @FXML
    private Button reporteButton;
    @FXML
    private CheckBox Pagar;
    
    @FXML
    private AnchorPane tourPane;

    @FXML
    private ImageView tourImageView;

    @FXML
    private Label tourLabel;

    @FXML
    private Button PrimeroButton;

    @FXML
    private Button previoButton;

    @FXML
    private Button siguienteButton;

    @FXML
    private Button ultimoButton;

    @FXML
    private Button buscarButton;

    @FXML
    private Button nuevoButton;

    @FXML
    private Button modificarButton;

    @FXML
    private Button borrarButton;


    @FXML
    private TextField precioTextField;

    @FXML
    private DatePicker llegadaDatePicker;

    @FXML
    private TextField destinoTextField;

    @FXML
    private TextField origenTextField;

    @FXML
    private DatePicker salidaDatePicker;

    @FXML
    private RadioButton normalRadioButton;

    @FXML
    private ToggleGroup tipoTourGroup;

    @FXML
    private ComboBox serviciosComboBox;

    @FXML
    private RadioButton empresarialRadioButton;

    @FXML
    private RadioButton ecologicoRadioButton;

    @FXML
    private Button serviciosAddButton;

    @FXML
    private Label otroLabel1;

    @FXML
    private Label otroLabel2;

    @FXML
    private Label otroLabel3;

    @FXML
    private TextField otroTextField1;

    @FXML
    private TextField otroTextField2;

    @FXML
    private TextField otroTextField3;
    
    @FXML
    private AnchorPane clientesPane;

    @FXML
    private TableView<Cliente> listaClientes;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private TableColumn<Cliente, Long> colCedula;

    @FXML
    private TableColumn<Cliente, String> colTelefono;

    @FXML
    private TextField nombreCliente;

    @FXML
    private TextField cedulaCrearC;

    @FXML
    private TextField telefonoCrearC;

    @FXML
    private Button crear;

    @FXML
    private ImageView mostrarImagen;

    @FXML
    private Label mostrarNombre;

    @FXML
    private TextField cedulaInfoC;

    @FXML
    private TextField telefonoInfoC;

    @FXML
    private Button eliminar;

    @FXML
    private Button codificar;

    @FXML
    private CheckBox checkBoxModificar;
    
    @FXML
    private TableView<Tour> ListaTours;

    @FXML
    private TableColumn<Tour, Long> ColCodigo;

    @FXML
    private TableColumn<Tour,String> ColNombre;

    @FXML
    private TableColumn<Tour, String> ColDestino;

    @FXML
    private TableColumn<Tour, Date> CodSalida;

    @FXML
    private TableColumn<Tour, Date> CodLlegada;

    @FXML
    private TableColumn<Tour, Double> CodPrecio;
    
    @FXML
    private TextField NombreTour;

    @FXML
    private TextField CantidadAcompañantes;
    
    @FXML
    private DatePicker FechaReserva;
    
    @FXML
    private TextField Cedula;

    @FXML
    private TextField Costo;
    
    @FXML
    private ComboBox<String> ServiciosAdicionales;
    
    @FXML
    private TextField CodigoReserva;
    
    @FXML
    void serviciosHandler(ActionEvent event) {
        
    }
    
     @FXML
    void PrimeroHandler(ActionEvent event) {
        this.setTourIndex(0);
        this.mostrarDatos();
    }

    @FXML
    void borrarHandler(ActionEvent event) {

    }

    @FXML
    void buscarHandler(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("Tour");
        dialog.setTitle("Buscar Tour");
        dialog.setHeaderText("Nombre comercial del Tour");
        dialog.setContentText("Por favor digite el nombre del Tour:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            int indice = this.buscarTour(result.get());
            if (indice > -1) {
                this.setTourIndex(indice);
                this.mostrarDatos();
            }
        }
    }

    @FXML
    void ecologicoHandler(ActionEvent event) {

    }

    @FXML
    void empresarialHandler(ActionEvent event) {

    }

    @FXML
    void modificarHandler(ActionEvent event) {

    }

    @FXML
    void normalHandler(ActionEvent event) {

    }

    @FXML
    void nuevoHandler(ActionEvent event) {

    }

    @FXML
    void previoHandler(ActionEvent event) {
        if (this.getTourIndex() > 0) {
            this.setTourIndex(this.getTourIndex() - 1);
            this.mostrarDatos();
        }
    }

    @FXML
    void reporteHandler(ActionEvent event) {

    }

    @FXML
    void serviciosAddHandler(ActionEvent event) {

    }

    @FXML
    void serviciosReservasHandler(ActionEvent event) {
    }

    /**
     * Botón siguiente tour.
     * @param event Evento.
     */
    @FXML
    void siguienteHandler(ActionEvent event) {
        if (this.getTourIndex() < AgenciaSingleton
                .getSingletonInstance(new Agencia())
                .getAgencia()
                .getListaTours()
                .size() - 1
        ) {
            this.setTourIndex(this.getTourIndex() + 1);
            this.mostrarDatos();
        }
    }

    @FXML
    void tourImageHandler(MouseEvent event) {

    }

   @FXML
    void ultimoHandler(ActionEvent event) {
        this.setTourIndex(AgenciaSingleton
                .getSingletonInstance(new Agencia())
                .getAgencia()
                .getListaTours()
                .size() - 1
        );
        this.mostrarDatos();
    }
 
    
    /**
     * Initializes the controller class.
     * 
     * @param url URL.
     * @param rb ResourceBundle.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AgenciaSingleton
                .getSingletonInstance(new Agencia())
                .getAgencia()
                .llenarTours();
        AgenciaSingleton
                .getSingletonInstance(new Agencia())
                .getAgencia()
                .llenarClientes();
        AgenciaSingleton
                .getSingletonInstance(new Agencia())
                .getAgencia().llenarReservas();
        configureTableCliente();
        clientes.setAll(servicios.getarregloClientes());        
        listaClientes.setItems(clientes);
        listaClientes.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> mostrarDatosCliente(newValue));
        
        configureTable();
        Tours.setAll(AgenciaSingleton
                .getSingletonInstance(new Agencia())
                .getAgencia().getArregloTours());
        
        
        ListaTours.setItems(Tours);
        ListaTours.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> mostrarDatosTour(newValue));
                
        this.ServiciosAdicionales.setItems(sa2List);
        this.setTourIndex(0);
        this.mostrarDatos();    
    }
    
    private void configureTable(){
        ColNombre.setCellValueFactory(new PropertyValueFactory<Tour,String>("NombreComercial"));
        ColCodigo.setCellValueFactory(new PropertyValueFactory<Tour,Long>("CodigoIdentificacion"));
        ColDestino.setCellValueFactory(new PropertyValueFactory<Tour,String>("Destino"));
        CodPrecio.setCellValueFactory(new PropertyValueFactory<Tour,Double>("Precio"));
        CodSalida.setCellValueFactory(new PropertyValueFactory<Tour,Date>("fechaSalida"));
        CodLlegada.setCellValueFactory(new PropertyValueFactory<Tour,Date>("fechaRegreso"));
 
    }
    
    private void mostrarDatosTour(Tour tour){
        if (tour != null){
            NombreTour.setText(String.valueOf(tour.getNombreComercial()));
           
            if (tour.getServiciosAdicionales().size() > 0) {
                for (ServicioAdicional sa : tour.getServiciosAdicionales()) {
                    sa2List.add(sa +sa.getNombreServicio() + " (" 
                            + String.format("$ %,.0f", sa.getPrecio()) + ")"
                    );
                }
                this.ServiciosAdicionales.setItems(sa2List);
                this.ServiciosAdicionales.getSelectionModel().select(0);
            }

        }
        else {
            NombreTour.setText("");
        }
    }

    /**
     * Obtine el indice del mapa de Tours.
     * @return El indice del mapa de Tours.
     */
    public int getTourIndex() {
        return this.tourIndex;
    }

    /**
     * Cambia el indice del mapa de Tours.
     * @param tourIndex El indice del mapa de Tours.
     */
    public void setTourIndex(int tourIndex) {
        this.tourIndex = tourIndex;
    }
    
    /**
     * Muestra los datos en la forma de toures.
     */
    private void mostrarDatos() {
        if (AgenciaSingleton
                .getSingletonInstance(new Agencia())
                .getAgencia()
                .getListaTours()
                .size() > 0
        ) {
            Collection<Tour> tourValues = AgenciaSingleton
                    .getSingletonInstance(new Agencia())
                    .getAgencia()
                    .getListaTours()
                    .values();
            
            ArrayList<Tour> listTourValues = new ArrayList<>(tourValues);
            Tour tour = listTourValues.get(this.getTourIndex());
            
            this.tourLabel.setText(tour.getNombreComercial());

            Image image;
            if (tour.getRutaImagen().isEmpty()) {
                image = new Image("images/landscape.png");
            }
            else {
                image = new Image(tour.getRutaImagen());
            }
            this.tourImageView.setImage(image);
            this.tourImageView.setFitHeight(this.tourPane.getHeight());
            this.tourImageView.setFitWidth(this.tourPane.getWidth());
            
            this.origenTextField.setText(
                    tour.getLugarPartida() + " - " + tour.getDestino()
            );
            this.salidaDatePicker.setValue(tour
                    .getFechaSalida()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate()
            );
            this.destinoTextField.setText(
                    tour.getDestino() + " - " + tour.getLugarPartida()
            );
            this.llegadaDatePicker.setValue(tour
                    .getFechaRegreso()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate()
            );
            this.precioTextField.setText(String.format("$ %,.0f", tour.getPrecio()));
            
            this.otroLabel1.setVisible(true);
            this.otroLabel2.setVisible(true);
            this.otroLabel3.setVisible(true);
            this.otroTextField1.setVisible(true);
            this.otroTextField2.setVisible(true);
            this.otroTextField3.setVisible(true);
            
            if (tour.getClass().getName().contains("Ecologico")) {
                this.ecologicoRadioButton.setSelected(true);
                this.otroLabel1.setText("Vacunación");
                this.otroLabel2.setText("Difícil acceso");
                this.otroLabel3.setText("Impuesto local");
                
                Ecologico ecologico = (Ecologico)tour;
                this.otroTextField1.setText(
                        ecologico.isVacunacionRequerida() ? "Si" : "No"
                );
                this.otroTextField2.setText(
                        ecologico.isDificilAcceso() ? "Si" : "No"
                );
                this.otroTextField3.setText(
                        String.valueOf(ecologico.getImpuestoLocal())
                );
            }
            else if (tour.getClass().getName().contains("Empresarial")) {
                this.empresarialRadioButton.setSelected(true);
                this.otroLabel1.setText("Empresa");
                this.otroLabel2.setText("Viajero frecuente");
                this.otroLabel3.setText("Tipo");
                
                Empresarial empresarial = (Empresarial)tour;
                this.otroTextField1.setText(empresarial.getNombreEmpresa());
                this.otroTextField2.setText(
                        empresarial.isViajeroFrecuente() ? "Si" : "No"
                );
                this.otroTextField3.setText(empresarial.getTipo().toString());
            }
            else {
                this.normalRadioButton.setSelected(true);
                this.otroLabel1.setVisible(false);
                this.otroLabel2.setVisible(false);
                this.otroLabel3.setVisible(false);
                this.otroTextField1.setVisible(false);
                this.otroTextField2.setVisible(false);
                this.otroTextField3.setVisible(false);
            }

            ObservableList<String> saList = FXCollections.observableArrayList();            
            this.serviciosComboBox.setItems(saList);
            if (tour.getServiciosAdicionales().size() > 0) {
                for (ServicioAdicional sa : tour.getServiciosAdicionales()) {
                    saList.add(
                            sa.getNombreServicio() + " (" 
                            + String.format("$ %,.0f", sa.getPrecio()) + ")"
                    );
                }
                this.serviciosComboBox.setItems(saList);
                this.serviciosComboBox.getSelectionModel().select(0);
            }
        }
    }

    /**
     * Busca el indice de un Tour.
     * @param nombre Nombre del Tour.
     * @return Indice del Tour encontrado (-1 sino encontró).
     */
    private int buscarTour(String nombre) {
        int indice = 0;
        if (AgenciaSingleton
                .getSingletonInstance(new Agencia())
                .getAgencia()
                .getListaTours()
                .size() > 0
        ) {
            Collection<Tour> tourValues = AgenciaSingleton
                    .getSingletonInstance(new Agencia())
                    .getAgencia()
                    .getListaTours()
                    .values();
            ArrayList<Tour> listTourValues = new ArrayList<>(tourValues);
            
            for (Tour tour : listTourValues) {
                if (tour.getNombreComercial().toLowerCase().contains(nombre.toLowerCase())) {
                    return indice;
                }
                indice++;
            }
        }
        return -1;
    }
    
    /**
     * Crea al cliente
     * @param event El evento
     */
    @FXML
    void crearCliente(ActionEvent event) {
        if (nombreCliente.getText().equals("") || cedulaCrearC.getText().equals("")
                || telefonoCrearC.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Error en la entrada de datos");
            alert.setContentText("Digite los datos nuevamente");
            alert.showAndWait();
        } 
        else {
            try {
                long cedula = Long.parseLong(cedulaCrearC.getText());
                if(servicios.getListaClientes().containsKey(cedula)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Información");
                    alert.setHeaderText("Error en la entrada de datos");
                    alert.setContentText("El cliente ya existe.");
                    alert.showAndWait();
                }
                else {
                    String nombre = nombreCliente.getText();
                    String telefono = telefonoCrearC.getText();
                    AgenciaSingleton.getSingletonInstance(new Agencia()).getAgencia().insertarCliente(cedula, nombre, telefono);
                    clientes.setAll(servicios.getarregloClientes());
                    nombreCliente.setText("");
                    telefonoCrearC.setText("");
                    cedulaCrearC.setText(nombre);
                }  
            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Error en la entrada de datos");
                alert.setContentText("Por favor, verifique los datos.");
                alert.showAndWait();
            }
        }
    }
    
    /**
     * Modifica al cliente
     * @param event El evento
     */
    @FXML
    void modificarCliente(ActionEvent event) {
        int indice = listaClientes.getSelectionModel().selectedIndexProperty().get(); 
        if ((indice == -1) || (checkBoxModificar.isSelected() == false) || 
                telefonoInfoC.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Error al seleccionar el cliente");
            alert.setContentText("Para modificar, usted debe seleccionar un cliente de la lista.\n Por favor revise la entrada de datos. ");
            alert.showAndWait(); 
        }
        else {
            try {
                long ncedula= Long.parseLong(cedulaInfoC.getText());
                String ncelular = telefonoInfoC.getText();
                ArrayList<Cliente> m = servicios.getarregloClientes();
                if (m.get(indice).getNumeroIdentificacion() == ncedula) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Información");
                    alert.setHeaderText("Error al modificar el cliente");
                    alert.setContentText("Para modificar ,usted debe digitar un numero de indentificación distinto al establecido.");
                    alert.showAndWait();   
                }
                else {
                    if (servicios.getListaClientes().containsKey(ncedula)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Información");
                        alert.setHeaderText("Error al modificar el cliente");
                        alert.setContentText("Para modificar, usted debe digitar un numero de indentificación no existen en la lista.");
                        alert.showAndWait();  
                    } 
                    else {
                        m.get(indice).setNumeroIdentificacion(ncedula);
                        m.get(indice).setTelefonoContacto(ncelular); 
                        servicios.setarregloClientes(m);
                        clientes.setAll(servicios.getarregloClientes());
                        mostrarDatosCliente(null);    

                        checkBoxModificar.setSelected(false);
                        cedulaInfoC.setEditable(false);
                        telefonoInfoC.setEditable(false); 
                    }
                } 
            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Error en la entrada de datos");
                alert.setContentText("Por favor verifique los datos.");
                alert.showAndWait();  
            }
       }
    }
    
    /**
     * Elimina al cliente
     * @param event El evento
     */
    @FXML
    void eliminarCliente(ActionEvent event) {
        int indice = listaClientes.getSelectionModel().selectedIndexProperty().get(); 
        if ((indice == -1)){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Error al seleccionar el cliente");
            alert.setContentText("Para eliminar, usted debe seleccionar un cliente de la lista");
            alert.showAndWait(); 
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación de eliminar cuenta");
            alert.setHeaderText("Eliminar una cuenta");
            alert.setContentText("¿Está seguro que desea eliminar la cuenta?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                 // ... user chose OK
                Cliente aborrar = servicios.getListaClientes().get(indice);
                 
                ArrayList<Cliente> m = servicios.getarregloClientes();
                m.remove(indice);
                servicios.setarregloClientes(m);
                clientes.setAll(servicios.getarregloClientes());
                mostrarDatosCliente(null);
            } 
            else {
                mostrarDatosCliente(null);
            }
        }
    }
    
    @FXML
    void checkBox(ActionEvent event) {
        if (checkBoxModificar.isSelected() == true){
            cedulaInfoC.setEditable(true);
            telefonoInfoC.setEditable(true);
        }
        else {
            cedulaInfoC.setEditable(false);
            telefonoInfoC.setEditable(false); 
        }
    }
   
    @FXML
    void serviciosAdicionalesHandler(ActionEvent event) {
    }
 
    @FXML
    void volverHandler(ActionEvent event) {
    }
    
    @FXML
    void ReservarHandler(ActionEvent event) {
        Agencia servicios = AgenciaSingleton.getSingletonInstance(new Agencia()).getAgencia();
        if (NombreTour.getText().equals("")||Cedula.getText().equals("")
                ||(FechaReserva.getValue() == null)||CantidadAcompañantes.getText().equals("")) {
            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Error en la entrada de datos");
                alert.setContentText("por favor, verifique la entrada de datos");
                alert.showAndWait();  
            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Error en la entrada de datos");
                alert.setContentText("por favor, verifique la entrada de datos ");
                alert.showAndWait(); 
            }
        }
        else {
            String nombreTour = NombreTour.getText();
            long cedula = Long.parseLong(Cedula.getText());
            LocalDate fecha1 = FechaReserva.getValue();
            Date date = Date.from(fecha1.atStartOfDay(ZoneId.systemDefault()).toInstant());
            int acompañantes=Integer.parseInt(CantidadAcompañantes.getText());
            int indice = ListaTours.getSelectionModel().selectedIndexProperty().get(); 
            if (indice!=-1) {
                ArrayList<Tour> tour=servicios.getArregloTours();
                Tour actualt=tour.get(indice);
                Cliente actualc = servicios.getListaClientes().get(cedula);
                boolean pagado = false;
                if (Pagar.isSelected() == true) {
                    pagado = true;
                }
                if (Pagar.isSelected() == false) {
                    pagado = false;
                }
                if ((actualt != null)&&(actualc != null)) {
                    long codigoReserva=servicios.reservarTour(actualc, actualt, date, pagado, acompañantes);
                    
                    if (codigoReserva == -1) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Información");
                        alert.setHeaderText("Error");
                        alert.setContentText("Error, no se puede reservar dos veces");
                        alert.showAndWait(); 
                        CodigoReserva.setText("");
                    }
                    else {
                        String codigoR = Long.toString(codigoReserva);
                        CodigoReserva.setText(codigoR);
                        Reserva r=servicios.getReserva(codigoReserva);
                        String costo= Double.toString(r.calcularPrecio());
                        Costo.setText(costo);
                    }
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Información");
                    alert.setHeaderText("Error en la entrada de datos");
                    alert.setContentText("La cedula especificada no se encuentra resgistrada en la base de datos");
                    alert.showAndWait(); 
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Error al seleccionar el Tour");
                alert.setContentText("Para Rerservar, usted debe seleccionar un cTour de la lista");
                alert.showAndWait(); 
            }
        }
    }
    
   private void configureTableCliente(){
        PropertyValueFactory<Cliente,String> nombreProperty = new PropertyValueFactory<Cliente,String>("nombreCompleto");
        colNombre.setCellValueFactory(nombreProperty);
        
        PropertyValueFactory<Cliente, Long> cedulaProperty = new PropertyValueFactory<Cliente, Long>("numeroIdentificacion");
        colCedula.setCellValueFactory(cedulaProperty);
        
        PropertyValueFactory<Cliente,String> celularProperty = new PropertyValueFactory<Cliente,String>("telefonoContacto");
        colTelefono.setCellValueFactory(celularProperty);
            
    }
    private void mostrarDatosCliente(Cliente cliente){
        if (cliente != null) {
            cedulaInfoC.setText(String.valueOf(cliente.getNumeroIdentificacion()));
            telefonoInfoC.setText(String.valueOf(cliente.getTelefonoContacto()));
        }
        else {
            cedulaInfoC.setText("");
            telefonoInfoC.setText("");
            listaClientes.getSelectionModel().clearSelection();
        }
    }     
    
    @FXML
    void verReporte(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReporteReservas.fxml"));
            Parent root1 = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Reporte Reservas");
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            Stage stage1 = (Stage) reporteButton.getScene().getWindow();
            stage1.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }   
}
