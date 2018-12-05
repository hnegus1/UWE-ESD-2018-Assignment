<%-- 
    Document   : login
    Created on : 30-Oct-2018, 16:41:26
    Author     : n2-chrysostomo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1 class="">User Login</h2>  <!--creates the title of the form        -->
                </div>
            </div>
        </nav>
        <div class="container">       
            <div class="row">          
                <form method="POST" name="LogInForm" action="Login.do">    <!-- create a form  send the submitted -->        
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" class="form-control" name="username" placeholder="Username">   <!-- creates a text field for username -->  
                    </div>
                    <br>                                                           <!-- Have  a fake userid on Backgound -->  
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" class="form-control" name="password" placeholder="Password"><!--creates a field(for passwords)  -->                 
                    </div>
                    <br>
                    <button type=submit" name="submit" value="Submit" class="btn">Log in</button> <!--Create button for the log in,type submit for the above form-->
                </form>            <!--exit form  -->
                <br>
          <!--<br> Br is in case we want the 2nd button to be below the 1st button rather than next to it-->
                <a href="Register.jsp">  <!-- Create a Button to link the register page from log in -->
                    <button type="button" class="btn">Create New Account</button>
            </div>
        </div>
    </a>
  
 
 <!--  
   <p> Would you Like to Register?
  <a href="register.html">Register </a> <!--calling the other Html page of the register once clicked If they re in the same folder   -->  
    </body>  <!--End of Body  -->  
</html><!--end html  -->  
