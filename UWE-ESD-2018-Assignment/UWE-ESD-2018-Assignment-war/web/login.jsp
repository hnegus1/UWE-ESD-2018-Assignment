<%-- 
    Document   : login
    Created on : 30-Oct-2018, 16:41:26
    Author     : n2-chrysostomo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
       <h2>User Login</h2>  <!--creates the title of the form        -->
        <form action="LoginController" method="POST" id="LogInForm">    <!-- create a form  send the submitted -->               
     
        Username:<br>  <!-- Prints username om screen and make a new line  -->            
        <input type="text" name="username" placeholder="KillMeNow">   <!-- creates a text field for username -->  
        <br>       
        Password:<br><!--prints password and jumps a line  -->  
        <input type="password" name="password"><!--creates a field(for passwords)  -->  
        </form>            <!--exit form  --> 
 
    <a>
    <button type=submit" form="LogInForm" value="Submit">Log in</button> <!--Create button for the log in,type submit for the above form-->
    </a>
  <!--<br> Br is in case we want the 2nd button to be below the 1st button rather than next to it-->
    <a href="register.jsp">  <!-- Create a Button to link the register page from log in -->
    <button>Create New Account</button>
    </a>
  
 
 <!--  
   <p> Would you Like to Register?
  <a href="register.html">Register </a> <!--calling the other Html page of the register once clicked If they re in the same folder   -->  
    </body>  <!--End of Body  -->  
</html><!--end html  -->  

