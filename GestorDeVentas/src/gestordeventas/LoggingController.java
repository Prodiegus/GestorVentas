package gestordeventas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author prodiegus
 */
public class LoggingController implements Initializable {
    
    @FXML
    private Label label;
    

    //Botones
    @FXML
    private void handleIngresar(ActionEvent event) {
        label.setText("Ingresar");
    }
    @FXML
    private void handleRegistrar(Stage event){
        GestorDeVentas gestor = new GestorDeVentas();
        gestor.registrar(event);
        label.setText("Registrar");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
