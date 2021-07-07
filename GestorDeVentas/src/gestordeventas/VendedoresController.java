package gestordeventas;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author prodiegus
 */
public class VendedoresController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private Label vendedor;
    @FXML
    private TextField nombreProducto;
    @FXML
    private TextField precioProducto;
    @FXML
    private ComboBox<Producto> boxProdutos;
    @FXML
    private Tienda tienda;


    //listeners
    @FXML
    private void handleAdd(ActionEvent event) {
        label.setText("agregado");
    }
    @FXML
    private void handleAddProducto(ActionEvent event){
        tienda.addProducto(nombreProducto.getText().trim(), Float.parseFloat(precioProducto.getText().trim()));
        nombreProducto.setText("");
        precioProducto.setText("");
        setProductos(tienda.getProductos());
    }
    @FXML
    private void handleSendSell(ActionEvent event) {
        //fandle the facts
    }

    //setter
    @FXML
    public void setVendedor(Vendedor vendedor){
        this.vendedor.setText(vendedor.getNombre());
    }
    @FXML
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
    public void setProductos(ArrayList<Producto> productos){
        if(!productos.isEmpty() && boxProdutos != null){
            boxProdutos.getItems().removeAll(boxProdutos.getItems());
            boxProdutos.getItems().addAll(productos);
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
