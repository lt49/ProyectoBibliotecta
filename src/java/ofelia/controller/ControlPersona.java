/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ofelia.model.dao.PersonaDAO;
import ofelia.model.dao.impl.PersonaDaoImpl;
import ofelia.model.entity.Persona;

/**
 *
 * @author Alexander_BV
 */
public class ControlPersona extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombreAlumno = request.getParameter("nombreAlumno");
        String apellidoAlumno = request.getParameter("apellidoAlumno");
        String generoAlumno = request.getParameter("generoAlumno");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String dniAlumno = request.getParameter("dniAlumno");
        String nivelAlumno = request.getParameter("nivelAlumno");
        String gradoAlumno = request.getParameter("gradoAlumno");
        String seccionAlumno = request.getParameter("seccionAlumno");
        String direccionAlumno = request.getParameter("direccionAlumno");
        String turnoAlumno = request.getParameter("turnoAlumno");

        String acciones = request.getParameter("accion");
        Persona p = new Persona();
        PersonaDAO pdao = new PersonaDaoImpl();
        switch (acciones) {
            case "REGISTRAR":
                p.setNombres(nombreAlumno);
                p.setApellidos(apellidoAlumno);
                p.setGenero(generoAlumno);
                p.setFecha_nac(fechaNacimiento);
                p.setNro_doc(dniAlumno);
                p.setNivel(nivelAlumno);
                p.setGrado(gradoAlumno);
                p.setSeccion(seccionAlumno);
                p.setDireccion(direccionAlumno);
                p.setTurno(turnoAlumno);
                if (pdao.agregarPersona(p)) {
                    
                    request.getRequestDispatcher("alumno.jsp").forward(request, response);
                    
                } else {
                }

                break;

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
