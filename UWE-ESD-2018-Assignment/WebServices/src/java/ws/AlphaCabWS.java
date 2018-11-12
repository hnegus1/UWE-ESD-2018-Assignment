/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Harry
 */
@WebService(serviceName = "AlphaCabWS")
@Stateless()
public class AlphaCabWS {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet results = null;
    private static ResultSetMetaData rsmd = null;
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addList")
    public String addList(@WebParam(name = "sql") String sql, @WebParam(name = "type") String type) {
        StringBuilder sb = new StringBuilder();
        
        try{        
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/AlphaCab", "username", "password");
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        try{
            stmt = conn.createStatement();
            results = stmt.executeQuery(sql);
            rsmd = results.getMetaData();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
        switch(type){
            case "STATIC":
                try{
                    sb.append("<table>");
                    //get column names and add to the table
                    sb.append("<tr>");
                    for (int col = 1; col < rsmd.getColumnCount() + 1; col++) {
                        sb.append("<th>");
                        sb.append(rsmd.getColumnName(col));
                        sb.append("</th>");
                    }
                    sb.append("</tr>");
                    
                    while(results.next()){
                        sb.append("<tr>");
                        for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
                            sb.append("<th>");
                            sb.append(String.valueOf(results.getObject(i)));//adds a column
                            sb.append("</th>");
                        }
                        sb.append("</tr>");
                    }
                    sb.append("</table>");
                }                
                catch(SQLException e){
                    e.printStackTrace();
                }
                break;
            case "RADIO":
                try{
                    sb.append("<table>");
                    //get column names and add to the table
                    sb.append("<tr>");
                    for (int col = 1; col < rsmd.getColumnCount() + 1; col++) {
                        sb.append("<th>");
                        sb.append(rsmd.getColumnName(col));
                        sb.append("</th>");
                    }
                    sb.append("<th>SELECTED</th>");
                    sb.append("</tr>");
                    
                    while(results.next()){
                        int row = 0;
                        sb.append("<tr>");
                        for (int col = 1; col < rsmd.getColumnCount() + 1; col++) {
                            sb.append("<th>");
                            sb.append(String.valueOf(results.getObject(col)));//adds a column
                            sb.append("</th>");
                        }
                        sb.append("<th><input type='radio' value='"+row+"'></th>");
                        sb.append("</tr>");
                        row++;
                    }
                    sb.append("</table>");
                }                
                catch(SQLException e){
                    e.printStackTrace();
                }
                break;
                    
        }
        
        return sb.toString();
    }
}
