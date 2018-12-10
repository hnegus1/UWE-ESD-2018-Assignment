package pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Database;

/**
 *
 * @author Tom Pugh
 */
public class RegisterUser extends HttpServlet {

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
        query[0] = (String)request.getParameter("NAME");
        query[1] = (String)request.getParameter("PASSWORD");
        query[2] = (String)request.getParameter("ADDRESS");
        
//        String url = new String();
        String url = request.getHeader("referer");
       
        if (url.equals("http://localhost:8080/UWE-ESD-2018-Assignment-war/Register.jsp")){
            String str = String.format("INSERT INTO USERS(USERNAME, PASSWORD, USERTYPE) VALUES ('%s','%s','%s')", query[0], query[1], "customer");
            db.executeUpdate(str);
            int userid = db.getID(String.format("SELECT ID FROM USERS WHERE USERNAME='%s' AND PASSWORD='%s'", query[0], query[1]));
            db.executeUpdate(String.format("INSERT INTO CUSTOMER(ADDRESS, USERID) VALUES ('%s',%d)", query[2], userid));
            HttpSession session = request.getSession(true);
            session.setAttribute("message", "Thank you for registering");
            request.getRequestDispatcher("MainMenu.jsp").forward(request, response);
        }
        else if (url.equals("http://localhost:8080/UWE-ESD-2018-Assignment-war/DriverRegister.jsp")) {
            String str = String.format("INSERT INTO USERS(USERNAME, PASSWORD, USERTYPE) VALUES ('%s','%s','%s')", query[0], query[1], "driver");
            db.executeUpdate(str);
            int userid = db.getID(String.format("SELECT ID FROM USERS WHERE USERNAME='%s' AND PASSWORD='%s'", query[0], query[1]));
            db.executeUpdate(String.format("INSERT INTO DRIVER(REGISTRATION, USERID) VALUES ('%s',%d)", query[2], userid));
            request.getRequestDispatcher("Admin.jsp").forward(request, response);
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
