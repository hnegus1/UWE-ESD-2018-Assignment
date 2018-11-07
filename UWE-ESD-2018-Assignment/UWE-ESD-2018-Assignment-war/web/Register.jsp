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
            Name: <input type="text" name="NAME" required="required"/><br/>
            Email: <input type="email" name="EMAIL" required="required"/><br/>
            Password: <input type="password" name="PASSWORD" required="required"/><br/>
            Phone: <input type="tel" name="PHONE" required="required" 
                          pattern="\d{3}[\-]\d{3}[\-]\d{4}" 
                          placeholder="xxx-xxx-xxxx"/><br/><br/>
            
           <input type="submit" value="Register"/>
    </body>
</html>
