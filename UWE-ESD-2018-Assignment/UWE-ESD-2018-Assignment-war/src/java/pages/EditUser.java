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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Database;

/**
 *
 * @author Tom Pugh
 */
@WebServlet(name = "EditUser", urlPatterns = {"/EditUser.do"})
public class EditUser extends HttpServlet {

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
        
        // Sets up connection to the db. Takes the selected user ID and converts
        // it to an int. Also takes the selected users type for use in determining
        // which table to edit.
        Database db = (Database) getServletContext().getAttribute("db");
        String ID = request.getParameter("ID");
        int getIDValue = Integer.parseInt(ID);
        String userType = request.getParameter("TYPE");
        
        String [] newDetails = new String[3];
        newDetails[0] = (String)request.getParameter("NAME");
        newDetails[1] = (String)request.getParameter("PASSWORD");
        newDetails[2] = (String)request.getParameter("ADDRESS");
        
        String qry = String.format("UPDATE USERS SET username='%s', password='%s' "
             + "WHERE ID=%d", newDetails[0], newDetails[1], getIDValue);
        db.executeUpdate(qry);
        
        if (userType.equals("customer")) {
            qry = String.format("UPDATE customer SET address='%s' WHERE userid=%d"
                    , newDetails[2], getIDValue);
            db.executeUpdate(qry);
        }
        else if (userType.equals("driver")) {
            qry = String.format("UPDATE driver SET registration='%s' WHERE userid=%d"
                    , newDetails[2], getIDValue);
            db.executeUpdate(qry);
        }
        
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

}
