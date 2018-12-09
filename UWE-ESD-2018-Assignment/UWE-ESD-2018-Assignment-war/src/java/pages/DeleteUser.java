package pages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import model.Database;
import ws.AlphaCabWS_Service;

/**
 *
 * @author Tom Pugh
 */
public class DeleteUser extends HttpServlet {

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
        
        // Takes user ID from previous page and uses it to delete the user from
        // relevant tables. 
        
        Database db = (Database) getServletContext().getAttribute("db");
        String id = request.getParameter("ID");
        int foreignID;
        int getIDValue = Integer.parseInt(id);
        String userType = request.getParameter("TYPE");
        
        String idType;
        if (userType == "customer"){
            idType = "customerID";
            foreignID = getForeignID(getIDValue, "CUSTOMER");
        }else{
            idType = "driverID";
            foreignID = getForeignID(getIDValue, "DRIVER");
        }
            
        //To avoid foreign key conflicts, the records that reference the user ID must also be removed
        //To prevent this from happening, a system that was not created literally before I was born could be used.
        String qry = String.format("DELETE FROM JOURNEY WHERE %s=%s", idType, foreignID);
        db.executeUpdate(qry);
        qry = String.format("DELETE FROM %s WHERE userid=%s", userType, getIDValue);
        db.executeUpdate(qry);
        qry = String.format("DELETE FROM USERS WHERE ID=%s", getIDValue);
        db.executeUpdate(qry);
        
        
        request.getRequestDispatcher("DisplayUsers.jsp").forward(request, response); 
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
