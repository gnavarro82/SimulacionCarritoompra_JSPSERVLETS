package datos;

import java.sql.*;
import modelos.*;
import java.util.*;


public class Conexion {

    protected Connection con;
    protected Statement stmt;
    protected String serverName = "localhost";
    protected String portNumber = "3306";
    protected String databaseName = "proyecto_jsp";
     protected String url = "jdbc:mysql://localhost:3306/proyecto_jsp";
    protected String userName = "root";
    protected String password = "navarro";
    protected String errString;

    public Conexion() {
    }

    public void Conexion() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//fin de Conexion

  
   public ArrayList<Productos> buscarProductos(String nombre) throws Exception {
        Conexion();
        ArrayList<Productos> productos = new ArrayList<Productos>();
        ResultSet rs = stmt.executeQuery("SELECT * FROM product WHERE nombre='"+ nombre +"'");
        while (rs.next()) {
            Productos producto = new Productos();
            producto.setId((Integer) rs.getObject(1));
            producto.setNombre((String) rs.getObject(2));
            producto.setTipo((String) rs.getObject(3));
            producto.setPrecio((Integer) rs.getObject(4));
            productos.add(producto);
        }
        return productos;
    }
     public ArrayList<Productos> mostrarProductos() throws Exception {
        Conexion();
        ArrayList<Productos> productos = new ArrayList<Productos>();
        ResultSet rs = stmt.executeQuery("SELECT * FROM product");
        while (rs.next()) {
            Productos producto = new Productos();
            producto.setId((Integer) rs.getObject(1));
            producto.setNombre((String) rs.getObject(2));
            producto.setTipo((String) rs.getObject(3));
            producto.setPrecio((Integer) rs.getObject(4));
            productos.add(producto);
        }
        return productos;
    }
    

}// fin de clase Conexion
