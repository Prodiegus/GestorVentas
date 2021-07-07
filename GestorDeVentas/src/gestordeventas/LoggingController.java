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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author prodiegus
 */
public class LoggingController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    TextField usuario;
    @FXML
    PasswordField clave;
    @FXML
    private Button registrar;

    //Botones
    @FXML
    private void handleIngresar(ActionEvent event) {
        Tienda tienda = new Tienda();
        if(tienda.log(usuario.getText().trim(), Integer.parseInt(clave.getText().trim()))){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Vendedores.fxml"));

            try {
                Parent root = loader.load();

                VendedoresController controller = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.initModality(Modality.WINDOW_MODAL);
                stage.setTitle("Menu de Ventas");
                stage.setScene(scene);
                close();
                stage.show();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "ERROR: 601\n"+e);
            }


        }
        
    }

    //closer
    private void close() {

    }
    @FXML
    private void handleRegistrar(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
            
            Parent root = loader.load();//Aqui hay un Error

            RegisterController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Menu de Registro Vendedor");
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR: 604\n"+e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
