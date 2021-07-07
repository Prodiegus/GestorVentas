package gestordeventas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author prodiegus
 */
public class VendedoresController implements Initializable {
    private Tienda tienda = new Tienda();
    @FXML
    private Label label;
    @FXML
    private Label vendedor;

    @FXML
    private void handleAdd(ActionEvent event) {
        label.setText("agregado");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vendedor.setText(tienda.getVendedorLogged().getNombre());
    }    
    
}
