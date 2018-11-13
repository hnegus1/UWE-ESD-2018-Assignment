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
    </head>
    <body>
        <h1>Driver Registration</h1>
        <form method="POST"
            action="Register.do">
            Name: <input type="text" name="NAME" required="required" maxlength="20"/><br/>
            Password: <input type="password" name="PASSWORD" required="required" maxlength="20"/><br/>
            Registration: <input type="text" name="ADDRESS" required="required" 
                                 pattern="[A-Z]{2}[0-9]{2}[A-Z]{3}"
                                 placeholder="AB51 ABC"/><br/>
            
           <input type="submit" value="Register"/>
        </form>
    </body>
    </body>
</html>
