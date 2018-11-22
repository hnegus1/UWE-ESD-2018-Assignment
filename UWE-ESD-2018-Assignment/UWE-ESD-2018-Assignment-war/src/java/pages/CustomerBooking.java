/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import model.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import javax.servlet.http.Cookie;
import javax.xml.ws.WebServiceRef;
import ws.AlphaCabWS_Service;
/**
 *
 * @author Isaac
 */
public class CustomerBooking extends HttpServlet {

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
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        Database db = (Database) getServletContext().getAttribute("db");
        Cookie[] cookies = request.getCookies();
        String origin = request.getParameter("Origin");
        String destination = request.getParameter("Destination");
        java.sql.Date date = java.sql.Date.valueOf(request.getParameter("Date"));
        java.sql.Time time = java.sql.Time.valueOf(request.getParameter("Time") + ":00");
        
        int userID = -1;
        
         
        
        //check if session is valid
        if (cookies != null) {
            Boolean usrFound = false;
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("user")) userID = Integer.parseInt(cookie.getValue()); usrFound = true;
            }
            if (!usrFound) {
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println(showError("Invalid Session! You've probably broken something. Please login and try again."));
                }
            }else{//session is valid
                int customerID = getForeignID(userID, "CUSTOMER");
                System.out.println(date);
                System.out.println(time);
                String update = "INSERT INTO JOURNEY(ORIGIN, DESTINATION, CUSTOMERID, DEPARTURETIME, DEPARTUREDATE) VALUES ('" + origin + "','" + destination + "'," + customerID + ",TIME('" + time + "'), DATE('" + date + "'))";  
                db.executeUpdate(update);
                request.getRequestDispatcher("BookingConfirm.jsp").forward(request, response);
            }
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

    private String showError(java.lang.String message) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.AlphaCabWS port = service.getAlphaCabWSPort();
        return port.showError(message);
    }

    private Integer getForeignID(int userID, java.lang.String table) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.AlphaCabWS port = service.getAlphaCabWSPort();
        return port.getForeignID(userID, table);
    }
}
