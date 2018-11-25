/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import model.Database;
import ws.AlphaCabWS_Service;

/**
 *
 * @author Nikolas
 */
public class ShowAvailableDrivers extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AlphaCabWS/AlphaCabWS.wsdl")
    private AlphaCabWS_Service service;

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
        Database db = (Database) getServletContext().getAttribute("db");// CONNECTS TO THE DATABASE
        String [] query = new String[1]; 
        query[0] = (String)request.getParameter("ID");
        
        String departureDate=String.valueOf(db.executeQuery(String.format("SELECT DEPARTUREDATE FROM JOURNEY WHERE ID=%s",query[0])).get(0).get(0));
        System.out.println("");
        
        
        //String qry=String.format("SELECT DRIVERID FROM AVAILABILITY WHERE %s BETWEEN STARTDATE AND ENDDATE ", departureDate);
        HttpSession session = request.getSession(true);
        session.setAttribute("table",addList(String.format("SELECT DRIVERID FROM AVAILABILITY WHERE STARTDATE<Date(%s) AND ENDDATE>DATE(%s)",departureDate),"RADIO"));
        response.sendRedirect("DriverSelection.jsp");//those re send to the jsp to be displayed there
      
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

    private String addList(java.lang.String sql, java.lang.String type) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.AlphaCabWS port = service.getAlphaCabWSPort();
        return port.addList(sql, type);
    }

}
