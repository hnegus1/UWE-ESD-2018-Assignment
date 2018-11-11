/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Harry
 */
@WebListener
public class Database implements ServletContextListener {
    
    //SQL connections and statements
    private static Connection conn = null;
    private static Statement stmt = null;

    public void contextInitialized(ServletContextEvent event) {
        // Do stuff during webapp's startup.
        
        //Connect to the SQL Database
        try{        
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/AlphaCab", "username", "password");
        }catch(Exception exception){
            exception.printStackTrace();
        }
        
        event.getServletContext().setAttribute("db", this);
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
    }
    
    
    //The purpose of the two methods below is to provide an interface
    //for the servlets. They don't have to worry about setting up SQL statments,
    //they can just enter the query and get the results. 
    
    //Mimics the functionality of executeQuery
    //Returns the results as an array list, each row of the table is its own array list
    //The results are always returned as a string, but this shouldn't be much of a problem, as the servlet is likely outputting the results as strings anyway
    public ArrayList<ArrayList> executeQuery(String sql){
        try{
            stmt = conn.createStatement();
            ArrayList<ArrayList> toReturn = new ArrayList();
            ResultSet results = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = results.getMetaData();
            
            //Loop through the result set and add it to the arraylist.
            while(results.next()){
                int index = 0;
                toReturn.add(new ArrayList<String>());//Adds a row
                for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
                    toReturn.get(index).add(String.valueOf(results.getObject(i)));//adds a column
                }
                index++;
            }
            return toReturn;
        }catch(SQLException exception){
            exception.printStackTrace();
            return null;
        }
    }
    
    //Mimics the functionality of executeUpdate
    public void executeUpdate(String sql){
        try{
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException exception){
            exception.printStackTrace();
        }
    }
    
    //Like execute query, but will only get first element of the first row
    //This is useful for matching into other tables.
    public int getID(String sql){
         try{
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(sql);
            results.next();
            return (int)results.getObject(0);
        }catch(Exception exception){
            exception.printStackTrace();
            return -1;//error
        }
    }

}
