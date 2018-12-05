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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">           
                    <h1>Turnover</h1>  <!--creates the title of the form        -->
                </div>
            </div>
        </nav> 
       
       <!-- <form method="POST" name="LogInForm" action="Login.do">    <!-- create a form  send the submitted -->  
        <div class="container">       
            <div class="row"> 
                <form method="POST" name="TurnoverForm" action="Turnover.do">
                    <p>Insert the 1st Date:</p>  <!-- communication  line  -->   
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                        <input class="form-control" type="date" name="StartDate">   <!-- creates a date field for starting -->  
                    </div>
                    <br>                                                   
                    <p>Insert the 2nd Date:</p><!--2nd communication line  -->  
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                        <input class="form-control" type="date" name="EndDate"><!--creates a field(for 2ndDate)  -->  
                    </div>
                    <br>
                    <button class="btn" type=submit" name="submit" value="Submit">Calculate</button> <!--Create button for the log in,type submit for the above form-->
                </form>            <!--exit form  -->
		<!-- <SELECT SUM(PRICE) FROM JOIRNEY WHERE PAID='1' AND DEPARTURETIME BETWEEN StartDate AND EndDate-->
            </div>
        </div>
						
    </body>  <!--End of Body  -->  
</html><!--end html  -->  
