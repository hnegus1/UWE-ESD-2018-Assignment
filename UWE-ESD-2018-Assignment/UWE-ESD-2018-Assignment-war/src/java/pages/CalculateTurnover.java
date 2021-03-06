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
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import model.Database;
import ws.AlphaCabWS_Service;

/**
 *
 * @author Nikolas
 */
@WebServlet(name = "Turnover", urlPatterns = {"/Turnover"})
public class CalculateTurnover extends HttpServlet {

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
        Database db = (Database) getServletContext().getAttribute("db");// CONNECTS TO THE DATABASE
        String [] query = new String[2]; // create a string queries for the 2 dates you wanna check if u were paid
        query[0] = (String)request.getParameter("StartDate"); // takes the first date input 
        query[1] = (String)request.getParameter("EndDate"); /// takes the second date inout
        
        String qry=String.format("SELECT SUM(PRICE) FROM JOURNEY WHERE  DEPARTUREDATE BETWEEN DATE('%s') AND DATE('%s') AND PAID=1", query[0],query[1]);
        //The SUM() function returns the total sum of a numeric column. So we choose the price column from the Journey databsae
        //where the Date is between the admins choice and where they were actually paid 
        double turnover = Double.parseDouble(String.valueOf(db.executeQuery(qry).get(0).get(0)));
        qry=String.format("SELECT COUNT(ID) FROM JOURNEY WHERE  DEPARTUREDATE BETWEEN DATE('%s') AND DATE('%s') AND PAID=1", query[0],query[1]);
        int numberOfJourneys = Integer.parseInt(String.valueOf(db.executeQuery(qry).get(0).get(0)));
        String journeyTable = addList(String.format("SELECT * FROM JOURNEY WHERE DEPARTUREDATE BETWEEN DATE('%s') AND DATE('%s') AND PAID=1", query[0],query[1]), "STATIC");
        
        HttpSession session = request.getSession(true);
        session.setAttribute("startDate", query[0]);
        session.setAttribute("endDate", query[1]);
        session.setAttribute("turnover", turnover);
        session.setAttribute("numberOfJourneys", numberOfJourneys);
        session.setAttribute("table", journeyTable);
        
        request.getRequestDispatcher("ShowReport.jsp").forward(request, response);
        //dont do this
        //do the other things. 
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");               // when the admin presses calculate the new page pops
//            out.println("<title>Welcome screen</title>");   //        out with the total SUM within those dates
//            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
//            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Turnover</h1>");
//            out.println("<p>Turnover was " + turnover + "</p>");
//            out.println("<p>Number of Journeys was " + numberOfJourneys + "</p>");
//            out.println("</body>");
//            out.println("</html>");
//        }
        /// the code below no longer works BUT it was the original idea of choosing everything and adding them
//        String qry = String.format("SELECT PRICE FROM JOURNEY WHERE PAID='1'");//slect price from journey table where they did pay
//        ArrayList<ArrayList> results = db.executeQuery(qry);//gets the results  as an array
//        int counter=0; // a variable used for  counting the solution
//        double sum=0.0;
//        for (counter=0;counter<results.size();counter++){ //loop al long as there solution  in the results
//            sum+= Double.parseDouble((String)results.get(counter).get(0));// and add ther values to sum once u convert em to double
//          
//             }//end of for 
        
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

    private String addList(java.lang.String sql, java.lang.String type) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.AlphaCabWS port = service.getAlphaCabWSPort();
        return port.addList(sql, type);
    }

}


 