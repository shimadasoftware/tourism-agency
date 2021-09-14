package javetours.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javetours.controller.AgenciaSingleton;
import javetours.controller.Agencia;

/**
 * Clase inicial de la aplicación JaveTours.
 * 
 * @author Juana Valentina Mendoza Santamaría
 * @author Camilo Ordoñez García 
 * @author Abrahan Ignacio Ayala Acuña
 * @author Pablo Santander Alvarez 
 */
public class JaveTours extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MasterGUI.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("JaveTours");
        stage.show();
    }

    /**
     * Main de la Aplicación JaveTours.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AgenciaSingleton.getSingletonInstance(new Agencia());
        launch(args);
    }
}
