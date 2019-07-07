

package modelos;
import java.util.*;

public class Cliente {
private String dni;
private String nombre;

public static ArrayList<Productos> productos = new ArrayList<Productos>();
//para un cliente se guarda cierto productos
public Cliente(){
    dni="";
    nombre="";
}

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }





}
