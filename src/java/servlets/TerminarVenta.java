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

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "TerminarVenta", urlPatterns = {"/TerminarVenta"})
public class TerminarVenta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Boleta Detalle</title>");
            out.println("</head>");
            out.println("<body>");
            //capturar de names
            String ncliente = request.getParameter("ncliente");
            String dnicliente = request.getParameter("dnicliente");
            Cliente cliente = new Cliente();
            cliente.setNombre(ncliente);
            cliente.setDni(dnicliente);
            out.println("<table>");
            out.println("<tr>");
            out.println("<td><h1>DETALLE DE LA BOLETA</h1></td>");
            out.println("</tr>");
            out.println("</table>");
            for (Productos producto : Cliente.productos) {
                out.println("<table>");
                out.println("<tr>");
                out.println("<td>Id Productos :" + producto.getId() + "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Nombre Productos :" + producto.getNombre() + "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Tipo Productos :" + producto.getTipo() + "</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Precio Productos :" + producto.getPrecio() + "</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</br>");
            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Nombre Cliente"+cliente.getNombre()+"</td>");
            out.println("</tr>");
             out.println("<tr>");
            out.println("<td>Dni Cliente"+cliente.getDni()+"</td>");
            out.println("</tr>");
            out.println("</table>");    

        } catch (Exception e) {

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
