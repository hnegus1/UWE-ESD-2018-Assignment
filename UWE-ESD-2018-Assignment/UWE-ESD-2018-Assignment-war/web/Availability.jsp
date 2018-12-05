<%-- 
    Document   : Availability
    Created on : 16-Nov-2018, 13:09:33
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Availability</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body> 
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Set Availability</h1>
                </div>
            </div>
        </nav> 
        <div class="container">       
            <div class="row">        
                <form action="Availability.do">
                    <p>Start Date:</p>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                        <input class="form-control" type="date" name="sdate">
                    </div>
                    <br>

                    <p>End Date:</p>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                        <input class="form-control" type="date" name="edate">
                    </div>
                    <br>

                    <button class="btn" type=submit" name="submit" value="Submit">Submit</button> <!--Create button for the log in,type submit for the above form-->
                    <br>                   
                </form> 
            </div>
        </div>
    
    </body>
</html>