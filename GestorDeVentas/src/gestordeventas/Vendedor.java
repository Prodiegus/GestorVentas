package gestordeventas;

import java.io.Serializable;

/**
 *
 * @author prodiegus
 */
public class Vendedor implements Serializable{
    private final String nombre;
    private  int clave;

    //contructores
    public Vendedor(String nombre, int clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    //getters
    public String getNombre() {
        return nombre;
    }
    public int getClave() {
        return clave;
    }

    //setters
    public void setClave(int clave) {
        this.clave = clave;
    }
    
}
