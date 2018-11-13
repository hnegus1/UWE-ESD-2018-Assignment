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
        <title>Register</title>
    </head>
    <body>
        <h1>User Registration</h1>
        <form method="POST"
            action="Register.do">
            Name: <input type="text" name="NAME" required="required" maxlength="20"/><br/>
            Password: <input type="password" name="PASSWORD" required="required" maxlength="20"/><br/>
            Address: <input type="text" name="ADDRESS" required="required" maxlength="60"/><br/>
            
           <input type="submit" value="Register"/>
        </form>
    </body>
</html>
