package gestordeventas;
/**
 *
 * @author prodiegus
 */

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tienda {
    //atributos de una tienda
    private Serializador serializador;
    private ArrayList<Producto> productos;
    private ArrayList<Vendedor> vendedores;
    Vendedor vendedorLogged = new Vendedor("Vendedor Desconosido", 0000);

    //constructores
    public Tienda() {
        this.serializador = new Serializador();
        this.productos = new ArrayList<Producto>();
        this.vendedores = new ArrayList<Vendedor>();
    }

    //metodos de verifado
    public boolean log(String nombre, int clave) {
        leerDisco();
        for (Vendedor vendedor : vendedores) {
            if(vendedor.getNombre().equals(nombre) && vendedor.getClave() == clave){
                vendedorLogged = vendedor;
                return true;
            }
        }
        return false;
    }

    //metodos de manejo de memoria
    private void leerDisco() {
        try {
            vendedores.addAll(serializador.cargarDataBaseV());
            productos.addAll(serializador.cargarDataBaseP());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: 720\n"+e);
        }
        
    }

    // metodos de agregado y borrado
    public boolean addVendedor(String nombre, int clave){
        try {
            vendedores.add(serializador.ingresarABD(new Vendedor(nombre, clave)));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR: 812"+e);
            return false;
        }
        return true;
    }
    public boolean addProducto(String nombre, Float precio){
        try {
            productos.add(serializador.ingresarABD(new Producto(nombre, productos.size()+1000,precio)));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR: 807"+e);
            return false;
        }
        return true;
    }

    //getters
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }
    public Vendedor getVendedorLogged() {
        return vendedorLogged;
    }

    //setters
    public void setVendedores(ArrayList<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    


    
}
