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
    </head>
    <body>
        <h1>Welcome ${name}</h1>
        <form method="POST"
            action="Availability.jsp">
                  <input name="button" type="submit" value="Availability"/>
        </form>
        <form method="POST"
            action="JobList">
                  <input name="button" type="submit" value="Transport"/>
        </form>
        <br/>
        <form method="POST"
              action="login.jsp">
                  <input name="button" type="submit" value="Logout"/>
        </form>
    </body>
</html>
