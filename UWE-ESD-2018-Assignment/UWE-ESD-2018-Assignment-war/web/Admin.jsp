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
    </head>
    <body>
        <h1>Welcome ${name}</h1>
        <form method="POST"
            action="placeholder">
                  <input name="button" type="submit" value="Assign Driver"/>
        </form>
        <form method="POST"
            action="DriverRegister.jsp">
                  <input name="button" type="submit" value="New Driver"/>
        </form>
        <form method="POST"
            action="placeholder">
                  <input name="button" type="submit" value="Update Details"/>
        </form>
        <form method="POST"
            action="placeholder">
                  <input name="button" type="submit" value="Journey"/>
        </form>
        <br/>
        <form method="POST"
              action="placeholder">
                  <input name="button" type="submit" value="Logout"/>
        </form>
        
        
        <p>Att : ${"name"}</p>
    </body>
</html>
