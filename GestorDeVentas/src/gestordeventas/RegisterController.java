package gestordeventas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author prodiegus
 */
public class RegisterController implements Initializable {
    @FXML private TextField usuario;
    @FXML private TextField clave;
    @FXML private Button registrar;

    @FXML private void handleRegistro(ActionEvent event) {
        Tienda tienda = new Tienda();
        tienda.addVendedor(usuario.getText().trim(), Integer.parseInt(clave.getText().trim()));
        Stage stage = (Stage) this.registrar.getScene().getWindow();
        stage.close();

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
