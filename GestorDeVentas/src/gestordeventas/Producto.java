package gestordeventas;

import java.io.Serializable;
import java.text.DecimalFormat;

import jdk.jfr.Unsigned;

/**
 *
 * @author prodiegus
 */

public class Producto implements Serializable{
    //atrivutos de un producto
    private final String nombre;
    private int id=1000;
    private int stock;
    private float precio;
    private DecimalFormat formatea;

    //constructores
    public Producto(String nombre, int id, float precio) {
        this.nombre = nombre;
        this.id = id++;
        this.setStock(1);
        this.precio = precio;
        this.formatea = new DecimalFormat("###,###");
    }

    //getters
    public float getPrecio() {
        return precio;
    }
    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return id;
    }
    public int getStock() {
        return stock;
    }

    //setters
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return nombre+" ID: "+id+" Costo: $"+formatea.format(precio);
    }
}
