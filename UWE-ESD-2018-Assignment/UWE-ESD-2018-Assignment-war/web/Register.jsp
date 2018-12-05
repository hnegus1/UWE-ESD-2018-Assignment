<%-- 
    Document   : Register
    Created on : 06-Nov-2018, 23:14:38
    Author     : Tom Pugh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Register</title>
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>User Registration</h1>
                </div>
            </div>
        </nav>  
        <div class="container">       
            <div class="row"> 
                <form method="POST" action="Register.do">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input class="form-control" placeholder="Username" type="text" name="NAME" required="required" maxlength="20"/><br/>
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input class="form-control" placeholder="Password" type="password" name="PASSWORD" required="required" maxlength="20"/><br/>
                    </div>
                    <br>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                        <input class="form-control" placeholder="Address" type="text" name="ADDRESS" required="required" maxlength="60"/><br/>
                    </div>    
                    <br>

                    <button type="submit" value="Register" class="btn">Register</button>
                </form>
            </div>
        </div>
    </body>
</html>
