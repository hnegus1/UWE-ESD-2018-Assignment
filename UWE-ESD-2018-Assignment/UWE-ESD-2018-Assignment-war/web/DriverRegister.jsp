<%-- 
    Document   : DriverRegister
    Created on : 12-Nov-2018, 23:27:27
    Author     : Tom Pugh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Driver Registration</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">           
                    <h1>Driver Registration</h1>
                </div>
            </div>
        </nav> 
        <div class="container">       
            <div class="row"> 
                <form method="POST" action="Register.do">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input class="form-control" placeholder="Username" type="text" name="NAME" required="required" maxlength="20"/>
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input class="form-control" placeholder="Password" type="password" name="PASSWORD" required="required" maxlength="20"/>
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
                        <input class="form-control" type="text" name="ADDRESS" required="required" pattern="[A-Z]{2}[0-9]{2}[A-Z]{3}" placeholder="AB51 ABC"/>
                    </div>
                    <br>

                    <button class="btn" type="submit" value="Register">Register</button>
                </form>
                <br>
                <form method="POST" action="Admin.jsp">
                          <button class="btn" name="button" type="submit" value="Back">Back</button>
                </form>
            </div>
        </div>
    </body>
</html>
