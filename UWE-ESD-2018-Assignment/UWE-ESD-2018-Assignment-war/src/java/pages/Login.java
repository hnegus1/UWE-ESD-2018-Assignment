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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nikolas
 */
public class Login extends HttpServlet {

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
        String [] query = new String[2]; // create a string queries for username and pass
        query[0] = (String)request.getParameter("username"); // takes the username input 
        query[1] = (String)request.getParameter("password"); /// takes the password inout
        String qry = String.format("SELECT username, password, usertype FROM USERS WHERE username='%s' AND password='%s'",query[0], query[1]);
        
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
            String userName = new String();
            userName = "" + results.get(0).get(0);
            
            int userid = db.getID(String.format("SELECT ID FROM USERS WHERE USERNAME='%s' AND PASSWORD='%s'", query[0], query[1]));
            Cookie loginCookie = new Cookie("user", String.valueOf(userid));
            response.addCookie(loginCookie);
            
            if (results.get(0).get(2).equals("admin")) {
                response.setContentType("text/html;charset=UTF-8");
                request.setAttribute("name", userName);
                request.setAttribute("id", userid);
                request.getRequestDispatcher("Admin.jsp").forward(request, response);
            }
            else if (results.get(0).get(2).equals("driver")) {
                response.setContentType("text/html;charset=UTF-8");
                request.setAttribute("name", userName);
                request.setAttribute("id", userid);
                request.getRequestDispatcher("Driver.jsp").forward(request, response);
            }
            else if (results.get(0).get(2).equals("customer")) {
                response.setContentType("text/html;charset=UTF-8");
                request.setAttribute("name", userName);
                request.setAttribute("id", userid);
                request.getRequestDispatcher("ChooseCustomerBooking.jsp").forward(request, response);
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

}
