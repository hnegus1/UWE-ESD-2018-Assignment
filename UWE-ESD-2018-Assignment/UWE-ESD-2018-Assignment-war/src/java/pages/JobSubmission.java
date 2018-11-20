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
import model.Database;

/**
 *
 * @author Owner
 */
public class JobSubmission extends HttpServlet {

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
        
        String [] query = new String[3];
        
        query[0] = ((String)request.getParameter("sdate"));
        query[1] = ((String)request.getParameter("edate"));
        
        String url = request.getHeader("referer");
        
        if (url.equals("http://localhost:8080/UWE-ESD-2018-Assignment-war/Availability.jsp")){
            
            String str = String.format("UPDATE AVAILABILITY(STARTDATE, ENDDATE) VALUES ('%s','%s')", query[0], query[1], "customer");
            db.executeUpdate(str);
            int userid = db.getID(String.format("SELECT ID FROM USERS WHERE USERNAME='%s' AND PASSWORD='%s'", query[0], query[1]));
            db.executeUpdate(String.format("INSERT INTO CUSTOMER(DRIVERID) VALUES (%d)", userid));
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JobSubmission</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println(addlist("SELECT * FROM USERS * STATIC"));
            out.println("<h1>Servlet JobSubmission at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
