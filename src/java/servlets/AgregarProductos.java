package servlets;

import datos.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.*;


@WebServlet(name = "AgregarProductos", urlPatterns = {"/AgregarProductos"})
public class AgregarProductos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Agregando...</title>");
            out.println("</head>");
            out.println("<body>");
            //capturar de names
            int id = Integer.valueOf(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String tipo = request.getParameter("tipo");
            int precio = Integer.valueOf(request.getParameter("precio"));
            Conexion con = new Conexion();
            Productos producto = new Productos();
            producto.setId(id);
            producto.setNombre(nombre);
            producto.setTipo(tipo);
            producto.setPrecio(precio);
            /*cada vez que se presione agregar se iran agregando un elemnto dentro
            de ese cliente en especial 
            Se puede tener muchos clientes con sus respectivas 
            listas de compras */
            Cliente.productos.add(producto);
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            out.print("<script type=text/javascript>");
            out.print("alert('SELECCIONE UNA OPCION DISTINTA DE PRODUCTO');");
            out.print("location.href='index.jsp';");
            out.print("</script>");
        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
