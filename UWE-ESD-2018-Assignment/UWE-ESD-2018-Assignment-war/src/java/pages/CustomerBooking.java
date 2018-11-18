/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import model.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
/**
 *
 * @author Isaac
 */
public class CustomerBooking extends HttpServlet {
    
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
        int one = 2;
        double price = 10.0;
        int complete = 0;
        int paid = 0;
        String date = new String("2019-05-01");
        String time = new String("15.33.00");
        
        String [] query = new String[7];
        query[0] = (String)request.getParameter("Name");
        query[1] = (String)request.getParameter("OriginPostcode");
        query[2] = (String)request.getParameter("DestinationPostcode");
        query[3] = (String)request.getParameter("Date");
        query[4] = (String)request.getParameter("Time");
        query[5] = (String)request.getParameter("username");
        query[6] = (String)request.getParameter("password");
        //query[7] = query[3] + " " + query[4];
        
        String qry = String.format("SELECT username, password, usertype FROM USERS WHERE username='%s' AND password='%s'",query[5], query[6]);
        
        //check if the user name and the password are correct by taking values.. going to database and check for results
        ArrayList<ArrayList> results = db.executeQuery(qry);//gets the results 
        if (results.isEmpty()) { // if they re empty Or wrong you will go into a fail log in page
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");          
            out.println("<head>");
            out.println("<title>Connection error screen</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Incorrect username/password!" + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        } else {
            int userID = db.getID(String.format("SELECT ID FROM USERS WHERE USERNAME='%s' AND PASSWORD='%s'", query[0], query[1]));
            //java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 11:10:10.0");
            
            String str = String.format("INSERT INTO JOURNEY(ORIGIN, DESTINATION, CUSTOMERID, PRICE, COMPLETED, PAID, DEPARTURETIME, DEPARTUREDATE) VALUES ('%s','%s',%d,%f,%d,%d,'%s','%s')", query[1], query[2], userID, price, complete, paid, date, time);
            db.executeUpdate(str);

            request.getRequestDispatcher("BookingConfirm.jsp").forward(request, response);
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
