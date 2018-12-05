<%-- 
    Document   : Admin
    Created on : 12-Nov-2018, 12:37:39
    Author     : Tom Pugh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
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
                <form method="POST"
                    action="ASTJ.do">
                    <button class="btn" name="button" type="submit" value="Assign Driver">Assign Driver</button>
                </form>
                <br>
                <form method="POST"
                    action="DriverRegister.jsp">
                          <button class="btn"  name="button" type="submit" value="New Driver">New Driver</button>
                </form>
                <br>
                <form method="POST"
                    action="DisplayUsers.jsp">
                          <button class="btn"  name="button" type="submit" value="Update Details">Update User Details</button>
                </form>
                <br>
                <form method="POST"
                    action="TurnOver.jsp">
                          <button class="btn"  name="button" type="submit" value="CalculateTurnOver">Calculate Turnover</button>
                </form>
                <br>
                <br>
                <form method="POST"
                      action="MainMenu.jsp">
                          <button class="btn"  name="button" type="submit" value="Logout">Logout</button>
                </form>
            </div>
        </div>
    </body>
</html>
