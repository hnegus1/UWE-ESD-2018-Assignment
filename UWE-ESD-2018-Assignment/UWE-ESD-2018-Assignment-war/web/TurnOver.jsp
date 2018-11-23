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
        <title>Turn over</title>
    </head>
    <body>
       <h2>TurnOver</h2>  <!--creates the title of the form        -->
       <!-- <form method="POST" name="LogInForm" action="Login.do">    <!-- create a form  send the submitted -->                                                                      
         <form method="POST" name="TurnoverForm" action="Turnover.do">
			Insert the 1st Date:<br>  <!-- communication  line  -->            
            <input type="date" name="StartDate">   <!-- creates a date field for starting -->  
            <br>                                                   
			instert the 2nd Date:<br><!--2nd communication line  -->  
            <input type="date" name="EndDate"><!--creates a field(for 2ndDate)  -->  
            <br>
           <<button type=submit" name="submit" value="Submit">Calculate</button> <!--Create button for the log in,type submit for the above form-->
        </form>            <!--exit form  -->
		<!-- <SELECT SUM(PRICE) FROM JOIRNEY WHERE PAID='1' AND DEPARTURETIME BETWEEN StartDate AND EndDate-->
  
						
    </body>  <!--End of Body  -->  
</html><!--end html  -->  
