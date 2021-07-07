package gestordeventas;
/**
 *
 * @author prodiegus
 */

import java.util.ArrayList;

public class Tienda {
    //atributos de una tienda
    private ArrayList<Producto> productos;
    private ArrayList<Vendedor> vendedores;

    //constructores
    public Tienda() {
        this.productos = new ArrayList<Producto>();
        this.vendedores = new ArrayList<Vendedor>();
    }

    //getters
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    //setters
    public void setVendedores(ArrayList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    


    
}
