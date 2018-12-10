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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">           
                    <h1>${name}</h1>
                </div>
            </div>
        </nav> 
        <div class="container">       
            <div class="row"> 
                <form method="POST"
                    action="EditUser.do">
                    <input type="hidden" name="ID" value=${id} />
                    <input type="hidden" name="TYPE" value=${type} />
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input class="form-control" type="text" name="NAME" required="required" maxlength="20" placeholder="${name}"/><br/>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input class="form-control" type="password" name="PASSWORD" required="required" maxlength="20" placeholder="${password}"/><br/>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">${unique}</span>
                        <input class="form-control" type="text" name="ADDRESS" required="required" maxlength="60" placeholder="${attribute}"/><br/>
                    </div>
                    <br>

                    <button class="btn" type="submit" value="Edit" onclick="return confirm('Are you sure you want to edit this user?')">Edit</button>
                </form>
                <br>
                <form method="POST"
                    action ="DeleteUser.do">
                    <input type="hidden" name="ID" value=${id} />
                    <input type="hidden" name="TYPE" value=${type} />
                    <button class="btn" type="submit" value="Delete"
                            onclick="return confirm('Are you sure you want to delete this user?')">Delete</button> 
                </form>
                <br>
                <form method="POST" action="Admin.jsp">
                          <button class="btn" name="button" type="submit" value="Back">Back</button>
                </form>
            </div>
        </div>
    </body>
</html>
