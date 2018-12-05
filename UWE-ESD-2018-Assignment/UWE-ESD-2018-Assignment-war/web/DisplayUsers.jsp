<%-- 
    Document   : DisplayUsers
    Created on : 23-Nov-2018, 19:47:03
    Author     : Tom Pugh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Database"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">           
                    <h1>Edit Users</h1>
                </div>
            </div>
        </nav> 
        <form method="post" action="DisplayUser.do">
            <table class="table">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>User Name</td>
                    <td>Password</td>
                    <td>User Type</td>
                    <td>Select</td>
                </tr>
                </thead>
                <% 
                    Database db = (Database) getServletContext().getAttribute("db");
                    ResultSet results = db.getResultSet("SELECT * FROM USERS");
                    
                    while(results.next()) {
                %>
                <tr>
                    <td><%=results.getInt("ID") %></td>
                    <td><%=results.getString("USERNAME") %></td>
                    <td><%=results.getString("PASSWORD") %></td>
                    <td><%=results.getString("USERTYPE") %></td>
                    <td><input type="radio" name="setval" CHECKED value="<%=results.getString("ID")%>"></td>
                </tr>
                <%
                    }
                    results.close();
                %>
            </table>
            <button class="btn" type="submit" value="Edit User">Edit User</button>
        </form>
    </body>
</html>
