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
    </head>
    <body>     
            <form action="Availability.do">
            Start Date:
            <input type="date" name="sdate">
            <br>
            
            End Date:
            <input type="date" name="edate">
            <br>
            
            <button type=submit" name="submit" value="Submit">Submit</button> <!--Create button for the log in,type submit for the above form-->
            <br>
            
            <a href="DriverView.jsp"> <!-- Create a Button to link back to Driver View page -->
            <button>Back</button>
            </a>
            </form>  
    </body>
</html>
