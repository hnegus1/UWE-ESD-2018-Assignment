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
        <h1>Job Overview</h1>
        <p>Here is a list of all of the jobs that you have been assigned. To complete the job, just mark on the right and submit</p>
        <form action="JobSubmission.do">
            ${table}
            <button type=submit" name="submit" value="Submit">Mark as complete</button>
        </form>

    </body>   
</html>

<%-- OLD CODE<form method="POST" name="JobForm" action="JobSubmission.do">    <!-- create a form  send the submitted -->                                                                      
            Job:<br>          
            <input type="text" name="username">   <!-- creates a text field for username -->  
            <br>                                                           <!-- Have  a fake userid on Backgound -->
            
            Date/Time<br>
            <input type="text" id="datetime24" data-format="DD-MM-YYYY HH:mm" 
             data-template="DD / MM / YYYY     HH : mm" name="datetime" value="DD/MM">
                <script>
                    $(function(){
                        $('#datetime24').combodate();  
                    });
                </script>
        </form>
               
        <form action="">
            <input type="radio" name="Select" value="male"> Select?<br>
            
            
            <button type=submit" name="submit" value="Submit">Submit/button> <!--Create button for the log in,type submit for the above form-->
        </form>--%>