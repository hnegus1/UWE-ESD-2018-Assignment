<%-- 
    Document   : JobSubmission
    Created on : 16-Nov-2018, 12:55:45
    Author     : George Pavlou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Job Submission</title>
    </head>
    <body>
        <form method="POST" name="JobForm" action="JobSubmission.do">    <!-- create a form  send the submitted -->                                                                      
            Job:<br>  <!-- Prints username om screen and make a new line  -->            
            <input type="text" name="username">   <!-- creates a text field for username -->  
            <br>                                                           <!-- Have  a fake userid on Backgound -->
            
            <input type="text" id="datetime24" data-format="DD-MM-YYYY HH:mm" 
             data-template="DD / MM / YYYY     HH : mm" name="datetime" value="21-12-2012 20:30">
                <script>
                    $(function(){
                        $('#datetime24').combodate();  
                    });
                </script>
            
            <button type=submit" name="submit" value="Submit">Submit/button> <!--Create button for the log in,type submit for the above form-->
        </form> 
    </body>
</html>
