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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Database;

/**
 *
 * @author Nikolas
 */
@WebServlet(name = "Turnover", urlPatterns = {"/Turnover"})
public class Turnover extends HttpServlet {

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
        double sum=0.0;
        //String [] query = new String[1]; // create a string que for price
       // query[0] = (String)request.getParameter("username"); 
        //String qry = String.format("SELECT SUM(PRICE) FROM JOOURNEY WHERE PAID='1'",query[0]);
       
        String qry = String.format("SELECT PRICE FROM JOURNEY WHERE PAID='1'");//slect price from journey table where they did pay
        ArrayList<ArrayList> results = db.executeQuery(qry);//gets the results  as an array
        int counter=0; // a variable used for  counting the solution
        for (counter=0;counter<results.size();counter++){ //loop al long as there solution  in the results
            sum+= Double.parseDouble((String)results.get(counter).get(0));// and add ther values to sum once u convert em to double
          
             }//end of for 
        
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


 