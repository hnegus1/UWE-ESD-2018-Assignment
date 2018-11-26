<%-- 
    Document   : EditUser
    Created on : 25-Nov-2018, 19:08:37
    Author     : Tom Pugh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>
    </head>
    <body>
        <h1>${name}</h1>
        <form method="POST"
            action="EditUser.do">
            <input type="hidden" name="ID" value=${id} />
            <input type="hidden" name="TYPE" value=${type} />
            User name: <input type="text" name="NAME" required="required" maxlength="20"
                       placeholder="${name}"/><br/>
            Password: <input type="password" name="PASSWORD" required="required" maxlength="20"
                        placeholder="${password}"/><br/>
            ${unique}: <input type="text" name="ADDRESS" required="required" maxlength="60"
                        placeholder="${attribute}"/>
                       <br/>
            
           <input type="submit" value="Edit"  
                  onclick="return confirm('Are you sure you want to edit this user?')" />
        </form>
        <form method="POST"
            action ="DeleteUser.do">
            <input type="hidden" name="ID" value=${id} />
            <input type="hidden" name="TYPE" value=${type} />
            <input type="submit" value="Delete"
                   onclick="return confirm('Are you sure you want to delete this user?')"/>    
        </form>
    </body>
</html>
