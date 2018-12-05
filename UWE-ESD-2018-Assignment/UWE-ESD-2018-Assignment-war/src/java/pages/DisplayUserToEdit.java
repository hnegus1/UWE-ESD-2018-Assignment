/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Database;

/**
 *
 * @author Tom Pugh
 */
public class DisplayUserToEdit extends HttpServlet {

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
        Database db = (Database) getServletContext().getAttribute("db");
        
        String ID = request.getParameter("setval");
        int getIDValue = Integer.parseInt(ID);
        String qry = String.format("SELECT id, username, password, usertype FROM USERS WHERE id=%d", getIDValue);
        ArrayList<ArrayList> results = db.executeQuery(qry);
        
        if (results.get(0).get(3).equals("admin")) {
            try(PrintWriter out = response.getWriter()){
                out.println("Admins can't be edited");
            }
        }
        else {
            request.setAttribute("id", getIDValue);
            request.setAttribute("name", results.get(0).get(1));
            request.setAttribute("password", results.get(0).get(2));
            request.setAttribute("type", results.get(0).get(3));
            
            if (results.get(0).get(3).equals("customer")) {
                qry = String.format("SELECT address FROM CUSTOMER WHERE userid=%d", getIDValue);
                results = db.executeQuery(qry);
                request.setAttribute("unique", "Address");
                request.setAttribute("attribute", results.get(0).get(0));
            }
            else if (results.get(0).get(3).equals("driver")){
                qry = String.format("SELECT registration FROM DRIVER WHERE userid=%d", getIDValue);
                results = db.executeQuery(qry);
                request.setAttribute("unique", "Registration");
                request.setAttribute("attribute", results.get(0).get(0));
            }
        }
        request.getRequestDispatcher("EditUser.jsp").forward(request, response);
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
