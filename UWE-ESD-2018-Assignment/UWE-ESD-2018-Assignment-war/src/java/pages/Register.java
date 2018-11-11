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
 * @author Tom Pugh
 */
public class Register extends HttpServlet {

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
        
        String [] query = new String[4];
        query[0] = (String)request.getParameter("NAME");
        //query[0] = (String)request.getParameter("EMAIL");
        query[1] = (String)request.getParameter("PASSWORD");
        query[2] = (String)request.getParameter("ADDRESS");
        //query[0] = (String)request.getParameter("PHONE");
        String str = String.format("INSERT INTO USERS(USERNAME, PASSWORD, USERTYPE) VALUES ('%s','%s','%s')", query[0], query[1], "customer");
        db.executeUpdate(str);
        int userid = db.getID(String.format("SELECT ID USERS WHERE USERNAME = '%s' AND PASSWORD = '%s'", query[0], query[1]));
        db.executeUpdate(String.format("INSERT INTO CUSTOMERS(ADDRESS, USERID) VALUES ('%s',%d)", query[2], userid));
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");               //  if thet re correct you go into a welcome screen by takin your
            out.println("<title>Welcome screen</title>");   //inputs  get from user get the person with the right inputs        
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Thank you for registering!</h1>");
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
