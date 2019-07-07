
<%@page import="servlets.BuscarProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Productos"%>
<%@page import="datos.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simulacion Carrito</title>
    </head>
    <body>
        <form action="BuscarProducto" method="post">
            <table>
                <tr>
                    <td>
                        <select name="buscar" id="buscar"> 
                            <option value="Seleccione">Seleccione Producto...</option>
                            <%//se mostrara en el select los´productos
                                Conexion con=new Conexion();
                                ArrayList<Productos> productos = con.mostrarProductos();
                                for(Productos producto: productos){
                                    //recorremos el array y se coloca en 
                                //    la etiqueta opcion
                            %>
                            <option value="<%out.print(producto.getNombre());%>"><%out.print(producto.getNombre());%></option>
                            <%} %>
                        </select>
                        <input type="submit" value="Buscar"/>
                            
                    </td>
                </tr>
            </table>
        </form>
<br>
<br>

<form action="AgregarProductos" method="post">
    <table border="0">
        <%
        BuscarProducto buscar= new BuscarProducto();
        ArrayList<Productos> productoRetornado = buscar.getRetorno();
        for(Productos producto:productoRetornado){
        %>
        <tr>
            <td>Identificacion Producto</td>
            <td><input type="text" name="id" readonly value="<%out.print(producto.getId());%>"/></td>
        </tr>
        <tr>
            <td>Nombre Producto</td>
            <td><input type="text" name="nombre" readonly value="<%out.print(producto.getNombre());%>"/></td>
        </tr>
        <tr>
            <td>Tipo Producto</td>
            <td><input type="text" name="tipo" readonly value="<%out.print(producto.getTipo());%>"/></td>
        </tr>
        <tr>
            <td>Precio Producto</td>
            <td><input type="text" name="precio" readonly value="<%out.print(producto.getPrecio());%>"/></td>
        </tr>
        <tr>
            <td></td>
            <td>+<input type="submit"  value="Agregar"/></td>
        </tr>
        <%}%>
   </table>
   </form>
        
 <form action="TerminarVenta" method="post">       
    <table border="0">    
         <tr>
            <td></td>
            <td><h4>Datos Personales</h4></td>
        </tr>
        <tr>
            <td>Nombre Cliente</td>
            <td><input type="text" name="ncliente" /></td>
        </tr>
        <tr>
            <td>DNI Cliente</td>
            <td><input type="text" name="dnicliente" /></td>
        </tr>
         <tr>
             <td></td>
            <td><input type="submit"  value="Terminar Compra"/></td>
        </tr>
    </table>
</form>

    </body>
</html>
