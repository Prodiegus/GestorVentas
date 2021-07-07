package gestordeventas;

import java.io.Serializable;

/**
 *
 * @author prodiegus
 */

public class Producto implements Serializable{
    //atrivutos de un producto
    private final String nombre;
    private int id=1000;
    private float precio;

    //constructores
    public Producto(String nombre, int id, float precio) {
        this.nombre = nombre;
        this.id = id++;
        this.precio = precio;
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

    //setters
    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
