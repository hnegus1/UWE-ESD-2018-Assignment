<%-- 
    Document   : register
    Created on : Nov 5, 2018, 12:18:53 PM
    Author     : Nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
       <h2>welcome</h2>  <!--creates the title of the form        -->
        <form action="LoginController" method="POST" id="LogInForm">    <!-- create a form  send the submitted -->               
     
        Username: <input type="text" name="username">   <!-- creates a text field for username -->  
        <br>       
        Password:<input type="password" name="password"><!--creates a field(for passwords)  -->  
        <br>
        ReEnter Password:<input type="password" name="password">
        <br>
        phone:<input type="text" name="phoneNum">
        <br>
        
        </form>            <!--exit form  --> 
 
 </body>  <!--End of Body  -->  
</html><!--end html  -->  

