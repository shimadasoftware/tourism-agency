package javetours.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javetours.controller.Agencia;
import javetours.controller.AgenciaSingleton;
import javetours.model.*;

/**
 * FXML Controller class
 *
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */

public class ReporteReservasController implements Initializable {
    Agencia servicios=AgenciaSingleton.getSingletonInstance(new Agencia()).getAgencia();
    private final ObservableList<ServicioAdicional> Adicionales = FXCollections.observableArrayList();
    private final ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    private final ObservableList<Tour> tours = FXCollections.observableArrayList();
    private final ObservableList<Reserva> reservas = FXCollections.observableArrayList();

    @FXML
    private Button mostrar;

    @FXML
    private Button volver;
    
    @FXML
    private TableView<Tour> tablatour;

    @FXML
    private TableColumn<Tour,Long> colcodigot;

    @FXML
    private TableColumn<Tour, String> colnombret;

    @FXML
    private TableView<Cliente> tablacliente;

    @FXML
    private TableColumn<Cliente, Long> colnumeroidentificacion;

    @FXML
    private TableColumn<Cliente, String> colnombrec;

    @FXML
    private TableView<ServicioAdicional> tablaservicioadicional;

    @FXML
    private TableColumn<ServicioAdicional,Long> colcodigoser;

    @FXML
    private TableColumn<ServicioAdicional, String> colnombreser;

    @FXML
    private TableColumn<ServicioAdicional,Double> colprecioser;

    @FXML
    private TableView<Reserva> tablareservas;

    @FXML
    private TableColumn<Reserva, Long> colnumero;

    @FXML
    private TableColumn<Reserva, Date> colfecha;

    @FXML
    private TableColumn<Reserva, Boolean> colpagado;

    @FXML
    private TableColumn<Reserva, Integer> colcantiper;

    @FXML
    void mostarAction(ActionEvent event) {
        
        int index1 = tablareservas.getSelectionModel().selectedIndexProperty().get();
        if (index1 != -1) {
            ArrayList<ServicioAdicional> cedu= servicios.getReservas().get(index1).getServiciosAdicionales();
            configureTableservicios();
            Adicionales.setAll(cedu);        
            tablaservicioadicional.setItems(Adicionales);
            Cliente actualc = servicios.getReservas().get(index1).getClienteReserva();
            ArrayList<Cliente> fail = new ArrayList<>();
            fail.add(actualc);
            configureTableCliente();
            clientes.setAll(fail);
            tablacliente.setItems(clientes);
            Tour actualt=servicios.getReservas().get(index1).getTourReservado();
            ArrayList<Tour> fail2= new ArrayList<>();
            fail2.add(actualt);
            configureTableTour();
            tours.setAll(fail2);
            tablatour.setItems(tours);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText("Error ");
            alert.setContentText("Seleccione una reserva");
            alert.showAndWait(); 
        }
    }

    @FXML
    void volverAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MasterGUI.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("");
            stage.setScene(new Scene(root1));
            stage.show();
            Stage stage1 = (Stage) volver.getScene().getWindow();
                stage1.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configureTableReserva();
        reservas.setAll(servicios.getReservas());        
        tablareservas.setItems(reservas);
    } 
    
    private void configureTableCliente() {
        PropertyValueFactory<Cliente,String> nombreProperty = new PropertyValueFactory<Cliente,String>("nombreCompleto");
        colnombrec.setCellValueFactory(nombreProperty);
        
        PropertyValueFactory<Cliente, Long> cedulaProperty = new PropertyValueFactory<Cliente, Long>("numeroIdentificacion");
        colnumeroidentificacion.setCellValueFactory(cedulaProperty);
    }
    
    private void configureTableTour() {
        colnombret.setCellValueFactory(new PropertyValueFactory<Tour,String>("NombreComercial"));
        colcodigot.setCellValueFactory(new PropertyValueFactory<Tour,Long>("CodigoIdentificacion"));
       
    }
    
    private void configureTableReserva() {
        colnumero.setCellValueFactory(new PropertyValueFactory<Reserva,Long>("numeroReserva"));      
        colpagado.setCellValueFactory(new PropertyValueFactory<Reserva,Boolean>("pagado"));
        colfecha.setCellValueFactory(new PropertyValueFactory<Reserva,Date>("fecha"));
        colcantiper.setCellValueFactory(new PropertyValueFactory<Reserva,Integer>("cantidadPersonas"));
 
    }
    
    private void configureTableservicios(){
        colcodigoser.setCellValueFactory(new PropertyValueFactory<ServicioAdicional,Long>("codigoServicio"));      
        colnombreser.setCellValueFactory(new PropertyValueFactory<ServicioAdicional,String>("nombreServicio"));
        colprecioser.setCellValueFactory(new PropertyValueFactory<ServicioAdicional,Double>("precio"));
    }
}
