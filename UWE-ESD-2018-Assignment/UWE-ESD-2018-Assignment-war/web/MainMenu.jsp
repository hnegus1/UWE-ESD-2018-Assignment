<%-- 
    Document   : MainMenu
    Created on : 07-Nov-2018, 06:20:55
    Author     : Tom Pugh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Alpha Taxi</h1>
                </div>
            </div>
        </nav>
        
        <div class="container">       
            <div class="row">          
                <form method="POST" action="login.jsp">
                    <button name="button" type="submit" value="Login" class="btn">Log in</button>
                </form>
                <br/>
                <form method="POST" action="Register.jsp">
                    <button name="button" type="submit" value="Register" class="btn">Register</button>
                </form>
            </div>
        </div>
    </body>
</html>
