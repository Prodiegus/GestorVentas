package gestordeventas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/**
 *
 * @author prodiegus
 */
public class Serializador implements Serializable{

    /*
     *
     *  Caraga de datos a la memoria fisica
     * 
     */

    //clase para serializar el objeto Vendedor
    public Vendedor ingresarABD(Vendedor vendedor) throws IOException{
        FileOutputStream file = new FileOutputStream("DataBase/vendedores/"+vendedor.getNombre());
        ObjectOutputStream output = new ObjectOutputStream(file);
        if(output != null){
            output.writeObject(vendedor);

            output.close();

        }  
        file.close();
        return vendedor;
    }

    //clase para serializar el objeto Producto
    public Producto ingresarABD(Producto producto) throws IOException{
        FileOutputStream file = new FileOutputStream("DataBase/productos/"+producto.getId());
        ObjectOutputStream output = new ObjectOutputStream(file);
        if(output != null){
            output.writeObject(producto);

            output.close();

        }  
        file.close();
        return producto;
    }

    /*
     *
     *  Recuperacion de datos de la memoria fisica
     * 
     */

    //clase para recuperar objetos serializados tipo Vendedor
    public ArrayList<Vendedor> cargarDataBaseV() throws IOException{
        FileInputStream file;
        ObjectInputStream input;
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
        Vendedor vendedor = null;

        //try catch para recorrer carpeta DataBase y crear una lista con los objetos
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("DataBase/vendedores/"))){

            //utilizamos este foreach para recorrer la carpeta
            for (Path path : stream) {
                /*
                 * el nombre del archivo se puede obtener del objeto Path de java.nio
                 * y al obtener el nombre de este se usa para crear uno nuevo pero 
                 * de tipo FileInputStream de java.io 
                 * 
                 */
                file = new FileInputStream("DataBase/vendedores"+path.getFileName().toString());
                input = new ObjectInputStream(file);

                vendedor = (Vendedor)input.readObject();
                vendedores.add(vendedor);
                input.close();
                file.close();
            }
            stream.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return vendedores;
    }

    //clase para recuperar objetos serializados tipo Producto
    public ArrayList<Producto> cargarDataBaseP() throws IOException{
        FileInputStream file;
        ObjectInputStream input;
        ArrayList<Producto> productos = new ArrayList<Producto>();
        Producto producto = null;

        //try catch para recorrer carpeta DataBase y crear una lista con los objetos
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("DataBase/productos/"))){

            //utilizamos este foreach para recorrer la carpeta
            for (Path path : stream) {
                /*
                 * el nombre del archivo se puede obtener del objeto Path de java.nio
                 * y al obtener el nombre de este se usa para crear uno nuevo pero 
                 * de tipo FileInputStream de java.io 
                 * 
                 */
                file = new FileInputStream("DataBase/productos"+path.getFileName().toString());
                input = new ObjectInputStream(file);

                producto = (Producto)input.readObject();
                productos.add(producto);
                input.close();
                file.close();
            }
            stream.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return productos;
    }

    /*
     *
     *  Eliminacion de datos de la memoria fisica
     * 
     */

    //este metodo simplemente borra 1 cliente segun id
    public void borrar(String id) {
        File archivo = new File("DataBase/"+id);
        if(!archivo.exists() || !archivo.delete()){
            System.err.println("Error al borrar de DataBase");
        }
    }
}
