/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import model.Database;
import ws.AlphaCabWS_Service;

/**
 *
 * @author George Pavlou
 */
@WebServlet(name = "Availability", urlPatterns = {"/Availability"})
public class Availability extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Database db = (Database) getServletContext().getAttribute("db");
        
        java.sql.Date startDate = java.sql.Date.valueOf(request.getParameter("sdate"));
        java.sql.Date endDate = java.sql.Date.valueOf(request.getParameter("edate"));
        int userID = -1;
        
        Cookie[] cookies = request.getCookies();
        
        if(cookies != null)
            {
                for(Cookie cookie : cookies)
                {
                    if(cookie.getName().equals("user")) 
                    {
                        userID = Integer.parseInt(cookie.getValue());
                    }
       
                }
            }
        
        String url = request.getHeader("referer");
        
   
        //check if availability exists
        if (db.executeQuery(String.format("SELECT * FROM AVAILABILITY WHERE DRIVERID=%s", getForeignID(userID, "DRIVER"))).isEmpty()) {
            String str = String.format("INSERT INTO AVAILABILITY(STARTDATE, ENDDATE, DRIVERID) VALUES(DATE('%s'), DATE('%s'), %s)", startDate, endDate, getForeignID(userID, "DRIVER"));
            db.executeUpdate(str);
        }else{
            String str = String.format("UPDATE AVAILABILITY SET STARTDATE=DATE('%s'), ENDDATE=DATE('%s') WHERE DRIVERID = %s", startDate, endDate, getForeignID(userID, "DRIVER"));
            db.executeUpdate(str);
        }
            
            
            
            //int userid = db.getID(String.format("SELECT ID FROM USERS WHERE USERNAME='%s' AND PASSWORD='%s'", query[0], query[1]));
            //db.executeUpdate(String.format("INSERT INTO CUSTOMER(DRIVERID) VALUES (%d)", userid));
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Availability</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Availability Updated" + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

    private Integer getForeignID(int userID, java.lang.String table) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.AlphaCabWS port = service.getAlphaCabWSPort();
        return port.getForeignID(userID, table);
    }

}
