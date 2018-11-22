/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Harry
 */
public class ExampleData extends HttpServlet {
    
    ArrayList<ArrayList> customerData = new ArrayList();
    ArrayList<ArrayList> driverData = new ArrayList();
    ArrayList<ArrayList> journeyData = new ArrayList();
    
    

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
        
        //Delete all the data first.
        db.executeUpdate("DELETE FROM AVAILABILITY");
        db.executeUpdate("DELETE FROM JOURNEY");
        db.executeUpdate("DELETE FROM CUSTOMER");
        db.executeUpdate("DELETE FROM DRIVER");
        db.executeUpdate("DELETE FROM USERS WHERE USERTYPE='customer' OR USERTYPE='driver'");
        
        //
        // RETRIEVE AND STORE THE DATA
        //
        InputStream is_customers = ExampleData.class.getResourceAsStream("customers.txt");
        Scanner s_customers = new Scanner(is_customers);
        int customerData_index = -1;
        s_customers.useDelimiter(";");
        
        while(s_customers.hasNextLine()){
            customerData.add(new ArrayList());
            customerData_index++;
            String line = s_customers.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(";");
            while(lineScanner.hasNext()){
                customerData.get(customerData_index).add(lineScanner.next());
            }
            lineScanner.close();
        }
        s_customers.close();
        
        InputStream is_drivers = ExampleData.class.getResourceAsStream("drivers.txt");
        Scanner s_drivers = new Scanner(is_drivers);
        int driverData_index = -1;
        s_drivers.useDelimiter(";");
        
        while(s_drivers.hasNextLine()){
            driverData.add(new ArrayList());
            driverData_index++;
            String line = s_drivers.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(";");
            while(lineScanner.hasNext()){
                driverData.get(driverData_index).add(lineScanner.next());
            }
            lineScanner.close();
        }
        s_drivers.close();
        
        InputStream is_journeys = ExampleData.class.getResourceAsStream("journeys.txt");
        Scanner s_journeys = new Scanner(is_journeys);
        int journeyData_index = -1;
        s_drivers.useDelimiter(";");
        
        while(s_journeys.hasNextLine()){
            journeyData.add(new ArrayList());
            journeyData_index++;
            String line = s_journeys.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(";");
            while(lineScanner.hasNext()){
                journeyData.get(journeyData_index).add(lineScanner.next());
            }
            lineScanner.close();
        }
        s_journeys.close();
        
        //add customers
        for (int i = 0; i < customerData.size(); i++) {
            String username = (String)customerData.get(i).get(0);
            String password = (String)customerData.get(i).get(1);
            String address = (String)customerData.get(i).get(2);
            db.executeUpdate("INSERT INTO USERS(USERNAME, PASSWORD, USERTYPE) VALUES('" + username + "','"  + password + "', 'customer')");
            int userid = db.getID("SELECT ID FROM USERS WHERE USERNAME='" + username + "' AND PASSWORD='" + password + "'");
            db.executeUpdate("INSERT INTO CUSTOMER(ADDRESS, USERID) VALUES('" + address + "'," + (int)userid + ")");
        }
        //add drivers
        for (int i = 0; i < driverData.size(); i++) {
            String username = (String)driverData.get(i).get(0);
            String password = (String)driverData.get(i).get(1);
            String registration = (String)driverData.get(i).get(2);
            db.executeUpdate("INSERT INTO USERS(USERNAME, PASSWORD, USERTYPE) VALUES('" + username + "','"  + password + "', 'driver')");
            int userid = db.getID("SELECT ID FROM USERS WHERE USERNAME='" + username + "' AND PASSWORD='" + password + "'");
            db.executeUpdate("INSERT INTO DRIVER(REGISTRATION, USERID) VALUES('" + registration + "'," + (int)userid + ")");
        }
        //add journeys
        for (int i = 0; i < journeyData.size()-1; i++) {
            String destination = (String)journeyData.get(i).get(0);
            String origin = (String)journeyData.get(i).get(1);
            int customerID = db.getID("SELECT ID FROM CUSTOMER WHERE USERID="+db.getID("SELECT ID FROM USERS WHERE USERNAME='" + (String)journeyData.get(i).get(2) + "'"));
            int driverID = db.getID("SELECT ID FROM DRIVER WHERE USERID="+db.getID("SELECT ID FROM USERS WHERE USERNAME='" + (String)journeyData.get(i).get(3) + "'"));        
            java.sql.Date date = java.sql.Date.valueOf((String)journeyData.get(i).get(4));
            java.sql.Time time = java.sql.Time.valueOf((String)journeyData.get(i).get(5));
            double price = Double.parseDouble((String)journeyData.get(i).get(6));
            double distance = Double.parseDouble((String)journeyData.get(i).get(7));
            int paid = Integer.parseInt((String)journeyData.get(i).get(8));
            String update = "INSERT INTO JOURNEY(DESTINATION, ORIGIN, CUSTOMERID, DRIVERID, DEPARTUREDATE, DEPARTURETIME, PRICE, DISTANCE, PAID) VALUES('" + destination + "','" + origin + "'," + customerID + "," + driverID + ", DATE('" + date + "'), TIME('" + time + "')," + price + "," + distance + "," + paid + ")";
            db.executeUpdate(update); 
            System.out.println("");
        }
        //add outstanding journey
        int usr = db.getID("SELECT ID FROM CUSTOMER WHERE USERID="+db.getID("SELECT ID FROM USERS WHERE USERNAME='" + (String)journeyData.get(journeyData.size()-1).get(2) + "'"));
        String qry = "INSERT INTO JOURNEY(DESTINATION, ORIGIN, CUSTOMERID, DEPARTUREDATE, DEPARTURETIME, PAID) VALUES('" + (String)journeyData.get(journeyData.size()-1).get(0) + "','" + (String)journeyData.get(journeyData.size()-1).get(1) + "'," + usr + ", DATE('" + journeyData.get(journeyData.size()-1).get(4) + "'), TIME('" + journeyData.get(journeyData.size()-1).get(5) + "'), 0)";
        qry = qry.replace("\\", "FOOBAR");
        db.executeUpdate(qry);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExampleData</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Success!</h1>");
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

}
