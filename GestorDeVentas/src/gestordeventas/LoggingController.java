package gestordeventas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    private TextField usuario;
    @FXML
    private PasswordField clave;
    @FXML
    private Button registrar;

    //Listeners
    @FXML
    private void handleIngresar(ActionEvent event) {
        Tienda tienda = new Tienda();
        if(tienda.log(usuario.getText().trim(), Integer.parseInt(clave.getText().trim()))){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Vendedores.fxml"));

            try {
                Parent root = loader.load();

                VendedoresController controller = loader.getController();

                controller.setVendedor(tienda.getVendedorLogged());
                controller.setProductos(tienda.getProductos());
                controller.setTienda(tienda);

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.initModality(Modality.WINDOW_MODAL);
                stage.setTitle("Menu de Ventas");
                stage.setScene(scene);
                close(event);
                stage.show();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "ERROR: 601\n"+e);
            }
        }
        
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

    //closer
    @FXML
    private void close(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public String getUser(){
        return usuario.getText().trim();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
