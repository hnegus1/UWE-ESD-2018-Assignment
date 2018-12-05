<%-- 
    Document   : Driver
    Created on : 12-Nov-2018, 12:37:55
    Author     : Tom Pugh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Driver Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Welcome ${name}</h1>
                </div>
            </div>
        </nav> 
        <div class="container">       
            <div class="row">       
                <form method="POST" action="Availability.jsp">
                    <button  class="btn"name="button" type="submit" value="Availability">Availability</button>
                </form>
                <br>
                <form method="POST" action="JobList">
                          <button class="btn" name="button" type="submit" value="Transport">Assigned Jobs</button>
                </form>
                <br/>
                <br>
                <form method="POST" action="login.jsp">
                          <button class="btn" name="button" type="submit" value="Logout">Logout</button>
                </form>
            </div>
        </div>               
    </body>
</html>
